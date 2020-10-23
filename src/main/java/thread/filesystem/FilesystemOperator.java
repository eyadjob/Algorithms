package thread.filesystem;

import net.smacke.jaydio.DirectRandomAccessFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

import static thread.filesystem.FilesystemOperator.INPUT_FILE_PATH;
import static thread.filesystem.FilesystemOperator.OUTPUT_FILE_PATH;


/**
 * @author Uriah Levy, Pluralsight
 * @since 25/11/2017.
 */
public class FilesystemOperator {
    static final String INPUT_FILE_PATH = "/home/read/1200kb.file";
    static final String OUTPUT_FILE_PATH = "/home/write/";

    public static void main(String[] args) {
        // Validate args
        if (args.length < 2) {
            throw new RuntimeException("Please specify the operation type (read/write), and number of workers");
        }

        // Submit tasks to execution
        int numberOfWorkers = Integer.parseInt(args[1]);
        ExecutorService executorService = Executors.newFixedThreadPool(numberOfWorkers);
        List<Future> futures = new ArrayList<>();
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < numberOfWorkers; i++) {
            // Submit read/write threads for execution
            if (args[0].equals("read")) {
                futures.add(executorService.submit(new DirectIoReaderCallable()));
            } else if (args[0].equals("write")) {
                futures.add(executorService.submit(new DirectIoWriterCallable()));
            }
        }

        System.out.printf("Number of threads submitted: " + String.valueOf(futures.size()) + "\n");

        // Wait for all worker threads to finish their task
        for (Future future : futures) {
            try {
                System.out.println(future.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

        // All tasks done
        long endTime = System.currentTimeMillis();
        long totalExecutionTime = endTime - startTime;
        System.out.printf("Total execution time was " + totalExecutionTime + " milliseconds.");

        // Shutdown and terminate
        try {
            executorService.shutdown();
            executorService.awaitTermination(5, TimeUnit.SECONDS);
            executorService.shutdownNow();
        } catch (InterruptedException e) {
            throw new RuntimeException("Could not await Executors termination", e);
        } finally {
            System.out.println("\n[" + Thread.currentThread().getName() + "]" + " | Terminating program...");
        }
    }
}

class DirectIoReaderCallable implements Callable {

    @Override
    public Object call() {
        int bufferSize = 1 << 20; // 1 MiB -> 1048576 bytes
        byte[] buf = new byte[bufferSize];
        File inputFile = new File(INPUT_FILE_PATH);
        long totalBytesRead = 0;
        try (DirectRandomAccessFile fin = new DirectRandomAccessFile(inputFile, "r", bufferSize)) {
            // Read in full
            while (fin.getFilePointer() < fin.length()) {
                int remaining = (int) Math.min(bufferSize, fin.length() - fin.getFilePointer());
                fin.read(buf, 0, remaining);
                totalBytesRead = totalBytesRead + remaining;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Thread.currentThread().getName() + " done reading " + totalBytesRead + " bytes";
    }
}

class DirectIoWriterCallable implements Callable {

    @Override
    public Object call() {
        int bufferSize = 1 << 20; // 1 MiB -> 1048576 bytes
        byte[] buf = new byte[bufferSize];
        File inputFile = new File(INPUT_FILE_PATH);
        File outputFile = new File(OUTPUT_FILE_PATH + Thread.currentThread().getName());
        long totalBytes = 0;
        try (DirectRandomAccessFile fin = new DirectRandomAccessFile(inputFile, "r", bufferSize);
             DirectRandomAccessFile fout = new DirectRandomAccessFile(outputFile, "rw", bufferSize)) {
            // Write in -> out
            while (fin.getFilePointer() < fin.length()) {
                int remaining = (int) Math.min(bufferSize, fin.length() - fin.getFilePointer());
                fin.read(buf, 0, remaining);
                fout.write(buf, 0, remaining);
                totalBytes = totalBytes + remaining;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Thread.currentThread().getName() + " done writing " + totalBytes + " bytes";
    }
}
