package devon.oneday.guid.generator.server.listener;

import devon.oneday.guid.generator.server.storage.RandomStorage;
import devon.oneday.guid.generator.server.util.RandomUtil;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class DaemonListener implements ApplicationListener, Runnable {

    private Thread thread;
    private boolean isShutdown = false;

    public void run() {
        Thread currentThread = Thread.currentThread();
        while (currentThread == thread && !this.isShutdown) {
            try {
                RandomStorage storage = RandomStorage.getInstance();
                int size = storage.getSize();
                int max = storage.getMax();
                if (size < max) {
                    System.out.println("큐가 소진되어 최대값만큼 채워넣습니다.");
                    for (int idx = 0; idx < (max - size); idx++) {
                        storage.add(RandomUtil.getRandomString(4));
                    }
                }
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("== DaemonListener end. ==");
    }

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        if (thread == null) {
            thread = new Thread(this, "Daemon thread for background task");
        }
        if (!thread.isAlive()) {
            thread.start();
        }
    }
}
