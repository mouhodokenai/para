public class M4 {

    public static void main(String[] args) {
// TODO Автоматически сгенерированный метод stub
        GuruThread3 threadguru1 = new GuruThread3("guru1");
        threadguru1.start();
        GuruThread3 threadguru2 = new GuruThread3("guru2");
        threadguru2.start();
    }
}
class GuruThread3 implements Runnable {
    Thread guruthread;
    private final String guruname;
    GuruThread3(String name) {
        guruname = name;
    }
    @Override
    public void run() {
        System.out.println("Thread running" + guruname);
        for (int i = 0; i < 4; i++) {
            System.out.println(i);
            System.out.println(guruname);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Thread has been interrupted");
            }
        }
    }
    public void start() {
        System.out.println("Thread started");
        if (guruthread == null) {
            guruthread = new Thread(this, guruname);
            guruthread.start();
        }

    }
}