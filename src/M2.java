public class M2 implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Thread: " + i);
            try {
                Thread.sleep(10000); // Sleep for 1 second
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Thread guruThread1 = new Thread(new M2()); // Pass an instance of M2 as the Runnable
        guruThread1.start();

        try {
            guruThread1.join(); // Wait for guruThread1 to finish before continuing
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        guruThread1.setPriority(1);
        int gurupriority = guruThread1.getPriority();

        System.out.println("Thread Priority: " + gurupriority);
        System.out.println("Main Thread Finished");
    }
}
