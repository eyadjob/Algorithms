package oldstudy;

public class Test2 {

    public static void main(String[] args) {
        String phoneNumber = "966-512225554";
        System.out.println(phoneNumber.substring(0, phoneNumber.indexOf("-")));
        String plateNumber = "x i c 20531";
        StringBuilder pnk = new StringBuilder(plateNumber);
        String re = pnk.insert(0, "%27").append("%27").toString().replaceAll(" ", "%2520");
        System.out.println(re);

    }
}

