import java.util.HashMap;

// 使用如下键值对，初始化一个HashMap：
// adc - 物理英雄
// apc - 魔法英雄
// t - 坦克

// 对这个HashMap进行反转，key变成value,value变成key
// 提示： keySet()可以获取所有的key, values()可以获取所有的value

public class Main {
    public static void main(String[] args) {
        HashMap<String, String> hs = new HashMap<>();
        hs.put("adc", "物理英雄");
        hs.put("apc", "魔法英雄");
        hs.put("t", "坦克");
        HashMap<String, String> reversedHs = new HashMap<>();
        for (String string : hs.keySet()) {
            reversedHs.put(hs.get(string), string);
        }
        for (String string : reversedHs.keySet()) {
            System.out.println(string+":"+reversedHs.get(string));
        }
    }
}