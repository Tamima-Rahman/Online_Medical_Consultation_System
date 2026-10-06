package thread;

public class LoadingThread extends Thread {

    public void run() {

        for(int i=1; i <=3; i++) {

            System.out.println("Loading...");

            try {
                Thread.sleep(500);

            } catch (InterruptedException e) {

                System.out.println("Error");
            }
        }
    }
}