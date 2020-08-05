// 英雄有可以放一个技能叫做: 波动拳-a du gen。
// 每隔一秒钟，可以发一次，但是只能连续发3次。
// 发完3次之后，需要充能5秒钟，充满，再继续发。

public class Main {
    public static void main(String[] args) {
        Thread t = new Thread() {
            public void run() {
                try {
                    while (true) {
                        int count = 3;
                        while (count > 0) {
                            count -= 1;
                            System.out.println("A~du gen !!!  remaining: " + count);
                            if (count == 0) {
                                System.out.println("Charging......");
                                sleep(5000);
                                break;
                            }
                            System.out.println("recovering...");
                            sleep(1000);
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        t.start();
    }
}