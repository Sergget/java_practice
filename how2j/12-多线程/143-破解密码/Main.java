import java.util.LinkedList;
import java.util.Queue;

// 1. 生成一个长度是3的随机字符串，把这个字符串当作 密码
// 2. 创建一个破解线程，使用穷举法，匹配这个密码
// 3. 创建一个日志线程，打印都用过哪些字符串去匹配，这个日志线程设计为守护线程
// 提示： 破解线程把穷举法生成的可能密码放在一个容器中，日志线程不断的从这个容器中拿出可能密码，并打印出来。 
//       如果发现容器是空的，就休息1秒，如果发现不是空的，就不停的取出，并打印。

public class Main {
    public static void main(String[] args) {
        Thread t1 = new Thread(new crackPasswd());
        Thread t2 = new Thread(new crackLog());
        t2.setDaemon(true);
        t1.start();
        t2.start();
    }
}

class crackPasswd implements Runnable {
    String passwd = genStr(3);
    public static Queue<String> tries = new LinkedList<>();
    String temp = "ABCDEFGHIJKLMNPOQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

    public void run() {
        for (int i = 0; i < temp.length(); i++) {
            for (int j = 0; j < temp.length(); j++) {
                for (int k = 0; k < temp.length(); k++) {
                    String tryPass = new String(new char[]{temp.charAt(i) ,temp.charAt(j) ,temp.charAt(k)});
                    if (tryPass.equals(passwd)) {
                        System.out.println("Password cracked: " + tryPass);
                        try {
                            Thread.sleep(2000);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        break;
                    } else {
                        tries.add(tryPass);
                    }
                }
            }
        }
    }

    public static String genStr(int length) {
        String temp = "ABCDEFGHIJKLMNPOQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        String result = "";
        for (int n = 0; n < length; n++) {
            result += temp.charAt((int) (Math.random() * temp.length()));
        }
        return result;
    }
}

class crackLog implements Runnable {
    public void run() {
        while (true) {
            if (crackPasswd.tries.isEmpty()) {
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
               String tried = crackPasswd.tries.remove();
               System.out.println("Tried passwd: "+ tried);
            }
        }
    }
}