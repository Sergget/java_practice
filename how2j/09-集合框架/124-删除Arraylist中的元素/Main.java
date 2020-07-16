import java.util.ArrayList;
import java.util.List;

// 首先初始化一个Hero集合，里面放100个Hero对象，名称分别是从
// hero 0
// hero 1
// hero 2
// ...
// hero 99.

// 通过遍历的手段，删除掉名字编号是8的倍数的对象
public class Main {
    public static void main(String[] args) {
        List<Hero> heros = Hero.getHeros(100);
        List<Hero> result = new ArrayList<>();
        int index = 0;
        for (Hero hero : heros) {
            index = Integer.parseInt(hero.name.substring(4));
            if(index%8!=0){
                result.add(hero);
            }
        }
        for (Hero hero : result) {
            System.out.println(hero.name);
        }
    }
}

class Hero{
    public String name;

    public Hero(String name){
        this.name = name;
    }

    public static List<Hero> getHeros(int num){
        List<Hero> heros = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            heros.add(new Hero("hero"+i));
        }
        return heros;
    }
}