public class ThreadDemo {
    public static void main(String[] args) {
        System.out.println("Главный поток запущен");

        // Создаем и запускаем 10 потоков
        for (int i = 0; i < 10; i++) {
            new NewThread("Поток " + i);
        }

        // Продолжаем выполнение главного потока
        for (int i = 100; i > 90; i--) {
            System.out.println(i);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.out.println("Главный поток прерван");
            }
        }
        System.out.println("Главный поток завершен");
    }
}

class NewThread implements Runnable {
    Thread thread;

    public NewThread(String threadName) {
        // Создание объекта потока с указанным именем
        thread = new Thread(this, threadName);
        // Запуск потока
        thread.start();
    }

    @Override
    public void run() {
        System.out.println(thread.getName() + " запущен");
        for (int i = 5; i > 0; i--) {
            System.out.println(thread.getName() + ": " + i);
            try {
                Thread.sleep(20000);
            } catch (InterruptedException e) {
                System.out.println(thread.getName() + " прерван");
            }
        }
        System.out.println(thread.getName() + " завершен");
    }
}
