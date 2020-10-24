//package oldstudy.mobilelogger;
//
//public class mobileLogger {
//
//    public static void main(String[] args) throws Throwable {
//        Thread.setDefaultUncaughtExceptionHandler(new MyExceptionHandler());
//    }
//}
//
//    class MyExceptionHandler implements Thread.UncaughtExceptionHandler {
//        @Override
//        public void uncaughtException(Thread t, Throwable e) {
//            RaygunClient client = new RaygunClient("tBPI0ibASxLACySOcXMJMQ");
//            client.Send(e);
//        }
//}
