public class OddEvenTwoThreads {

    public static void main(String[] args){
        OddEvenTwoThreads a = new OddEvenTwoThreads();
        OddEvenTwoThreads.PrintEven o1 = new OddEvenTwoThreads.PrintEven();
        OddEvenTwoThreads.PrintOdd o2 = new OddEvenTwoThreads.PrintOdd();
        o1.start();
        o2.start();

    }

    private static class PrintEven extends Thread {

        public void run() {
           for(int i=0; i < 10; i=i+2){
               synchronized (OddEvenTwoThreads.class){
                   System.out.println(i);
                   try {
                       Thread.sleep(1000);
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
                   try {
                       OddEvenTwoThreads.class.wait();

                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
               }
               OddEvenTwoThreads.class.notify();
           }
        }
    }

    private static class PrintOdd extends Thread {

        public void run() {
            for(int i=1; i < 10; i=i+2){
                synchronized (OddEvenTwoThreads.class){
                    System.out.println(i);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    try {
                        OddEvenTwoThreads.class.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                OddEvenTwoThreads.class.notify();
            }
        }
    }
}
