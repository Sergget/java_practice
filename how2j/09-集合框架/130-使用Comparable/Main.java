import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

//借助Comparable接口，使Item具备按照价格从高到低排序。
//初始化10个Item,并且用Collections.sort进行排序，查看排序结果

public class Main {
    public static void main(String[] args) {
        List<Item> items = Item.generateRandomItems(10);
        Collections.sort(items);
        System.out.println(items);
    }
}

class Item implements Comparable<Item>{
    public String name;
    public int price;
    public Item(String name, int price){
        this.name = name;
        this.price = price;
    }

    @Override
    public int compareTo(Item o) {
        return o.price - this.price;
    }

    @Override
    public String toString() {
        return String.format("%s price:%3d\n", this.name,this.price);
    }

    static public List<Item> generateRandomItems(int quantity){
        List<Item> items = new ArrayList<>();

        for (int i = 0; i < quantity; i++) {
            items.add(new Item(String.format("item%02d", i), (int) (Math.random()*50+50)));
        }
        return items;
    }
}