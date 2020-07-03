import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

//准备一个长度是10，类型是Hero的数组，使用10个Hero对象初始化该数组
//然后把该数组序列化到一个文件heros.lol
//接着使用ObjectInputStream 读取该文件，并转换为Hero数组，验证该数组中的内容，是否和序列化之前一样

public class Main {
    public static void main(String[] args) {
        File dest = new File(".//dest.txt");
        Hero[] heros = new Hero[10];
        for (int i = 0; i < heros.length; i++) {
            heros[i] = new Hero();
            heros[i].name = "hero" + i;
            heros[i].hp = (int) (Math.random() * 200) + 200;
        }
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(dest))) {
            System.out.println("Hero initiate: ");
            for (Hero hero : heros) {
                oos.writeObject(hero);
                System.out.println(hero);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(dest))) {
            System.out.println("--------------------------");
            System.out.println("Hero read from local file:");
            while (true) {
                Hero h = (Hero) ois.readObject();
                System.out.println(h);
            }
        } catch (EOFException eof) {
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class Hero implements Serializable {
    // 表示这个类当前的版本，如果有了变化，比如新设计了属性，就应该修改这个版本号
    private static final long serialVersionUID = 1L;
    public String name;
    public float hp;

    public String toString() {
        return String.format("Hero name: %s, hp: %f", this.name, this.hp);
    }
}