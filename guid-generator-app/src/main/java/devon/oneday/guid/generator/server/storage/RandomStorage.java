package devon.oneday.guid.generator.server.storage;

import devon.oneday.guid.generator.server.util.RandomUtil;

import java.util.concurrent.ConcurrentLinkedQueue;

public class RandomStorage {

    private static class InnerInstanceClazz {
        private static final RandomStorage instance = new RandomStorage();
    }

    public static RandomStorage getInstance() {
        return InnerInstanceClazz.instance;
    }

    private ConcurrentLinkedQueue<String> randomQueue;

    private int max;

    private RandomStorage() {
        this.randomQueue = new ConcurrentLinkedQueue<>();
        this.max = 1000000;
    }


    public ConcurrentLinkedQueue<String> getRandomQueue() {
        return randomQueue;
    }

    public void setRandomQueue(ConcurrentLinkedQueue<String> randomQueue) {
        this.randomQueue = randomQueue;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public void add(String str) {
        randomQueue.add(str);
    }

    public String poll() {
        if (randomQueue.size() == 0) {
            System.out.println("큐를 열심히 채우고 있지만 소진되는 속도가 너무 빠릅니다. ");
            randomQueue.add(RandomUtil.getRandomString(4));
        }
        return randomQueue.poll();
    }

    public int getSize() {
        return randomQueue.size();
    }
}
