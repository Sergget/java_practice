import java.util.ArrayList;
import java.util.List;

// 设计一个Hero二叉树，HeroNode.
// 可以向这个英雄二叉树插入不同的Hero对象，并且按照Hero的血量倒排序。
// 随机生成10个Hero对象，每个Hero对象都有不同的血量值，插入这个HeroNode后，把排序结果打印出来。

public class Main {
    public static void main(String[] args) {
        Hero[] heros = Hero.generateRandomHeros(10);
        HeroNode nodes = new HeroNode();
        for (Hero hero : heros) {
            nodes.add(hero);
        }
        for (Hero hero : nodes.sortedList()) {
            System.out.printf("Sorted hero name: %s, hp: %d\n", hero.name, hero.hp);
        }
    }
}

class HeroNode {
    public Hero value;
    public HeroNode left;
    public HeroNode right;

    public List<Hero> sortedList() {
        List<Hero> list = new ArrayList<>();

        if (left != null) {
            list.addAll(left.sortedList());
        }

        list.add(value);

        if (right != null) {
            list.addAll(right.sortedList());
        }
        return list;
    }

    public void add(Hero n) {
        if (value == null) {
            value = n;
        } else {
            if (n.hp < value.hp) {
                if (left == null)
                    left = new HeroNode();
                left.add(n);
            } else {
                if (right == null)
                    right = new HeroNode();
                right.add(n);
            }
        }
    }
}

class Hero {
    public String name;
    public int hp;

    public Hero(String name, int hp) {
        this.name = name;
        this.hp = hp;
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