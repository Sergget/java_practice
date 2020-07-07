import java.util.LinkedList;
import java.util.List;

// 根据前面学习的hashcode的原理和自定义hashcode, 设计一个MyHashMap

// MyHashMap内部由一个长度是2000的对象数组实现。

// 自定义一个简单的hashcode算法，计算任意字符串的hashcode
// 因为String类不能被重写，所以我们通过一个静态方法来返回一个String的hashcode
// public static int hashcode(String)
// 如果字符串长度是0，则返回0。
// 否则： 获取每一位字符，转换成数字后，相加，最后乘以23
// (s[0]+ s[1] + s[2] + s[3]+ s[n-1])*23.

// 如果值超过了1999，则取2000的余数，保证落在0-1999之间。
// 如果是负数，则取绝对值。

// 设计put(String key,Object value)方法
// 首先通过上一个自定义字符串的hashcode练习获取到该字符串的hashcode,然后把这个hashcode作为下标，定位到数组的指定位置。
// 如果该位置没有数据，则把字符串和对象组合成键值对Entry，再创建一个LinkedList，把键值对，放进LinkedList中，最后把LinkedList 保存在这个位置。
// 如果该位置有数据，一定是一个LinkedList,则把字符串和对象组合成键值对Entry，插入到LinkedList后面。

// 设计 Object get(String key) 方法
// 首先通过上一个自定义字符串的hashcode练习获取到该字符串的hashcode,然后把这个hashcode作为下标，定位到数组的指定位置。
// 如果这个位置没有数据，则返回空
// 如果这个位置有数据，则挨个比较其中键值对的键-字符串，是否equals，找到匹配的，把键值对的值，返回出去。找不到匹配的，就返回空

public class Main {
    public static void main(String[] args) {
        Hero[] heros = Hero.generateRandomHeros(100);
        MyHashMap hashmap = new MyHashMap();
        for (Hero hero : heros) {
            hashmap.put(hero.name, hero);
        }
        for (Hero hero : heros) {
            System.out.println(hashmap.get(hero.name));
        }
    }
}

class MyHashMap {
    private Object[] array = new Object[2000];

    // @SuppressWarnings("unchecked")
    public void put(String key, Object value) {
        int index = hashCode(key);
        Entry entry = new Entry(key, value);
        if (array[index] == null) {
            LinkedList<Entry> list = new LinkedList<>();
            list.add(entry);
            array[index] = (Object) list;
        } else {
            LinkedList<Entry> list = (LinkedList<Entry>) array[index];
            list.add(entry);
        }
    }

    // @SuppressWarnings("unchecked")
    public Object get(String key) {
        LinkedList<Entry> list = (LinkedList<Entry>) array[hashCode(key)];
        if (array[hashCode(key)] != null) {
            for (Entry entry : list) {
                if (entry.key.equals(key)) {
                    return entry.value;
                }
            }
        }
        return null;
    }

    public static int hashCode(String string) {
        int sum = 0;
        for (char c : string.toCharArray()) {
            sum += (byte) c;
        }
        sum *= 23;
        return sum%2000;
    }
}

class Entry {
    public Object key;
    public Object value;

    public Entry(Object key, Object value) {
        super();
        this.key = key;
        this.value = value;
    }

    @Override
    public String toString() {
        return "[key=" + key + ", value=" + value + "]";
    }
}

class Hero {
    public String name;
    public int hp;

    public Hero(String name, int hp) {
        this.name = name;
        this.hp = hp;
    }

    @Override
    public String toString() {
        return String.format("Hero name: %s, hero hp: %d", this.name, this.hp);
    }

    public static Hero[] generateRandomHeros(int numbers) {
        Hero[] heros = new Hero[numbers];
        for (int i = 0; i < numbers; i++) {
            heros[i] = new Hero("Hero" + i, (int) (Math.random() * 200) + 150);
            System.out.printf("Generating hero name: %s, hp: %d\n", heros[i].name, heros[i].hp);
        }
        return heros;
    }
}