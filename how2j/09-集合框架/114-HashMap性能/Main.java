import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.lang.Math;

// 准备一个ArrayList其中存放3000000(三百万个)Hero对象，其名称是随机的,格式是hero-[4位随机数]
// hero-3229
// hero-6232
// hero-9365
// ...

// 因为总数很大，所以几乎每种都有重复，把名字叫做 hero-5555的所有对象找出来
// 要求使用两种办法来寻找
// 1. 不使用HashMap，直接使用for循环找出来，并统计花费的时间
// 2. 借助HashMap，找出结果，并统计花费的时间

public class Main {
    public static void main(String[] args) {
        String target = "Hero-5555";
        List<Hero> heros = Hero.generateRandomHeoros(1000000);

        //for cycle
        int counts = 0;
        Date before = new Date();
        for (Hero hero : heros) {
            if(hero.name.equals(target)){
                counts++;
            }
        }
        Date after = new Date();
        System.out.println(counts+"个重复的"+target);
        System.out.println("耗时："+(after.getTime()-before.getTime())+"ms");

        //hashmap 
        before = new Date();
        HashMap<String,List<Hero>> heroCategories = new HashMap<>();
        for (Hero hero : heros) {
            List<Hero> heroList = new ArrayList<>();
            if(heroCategories.containsKey(hero.name)){
                heroCategories.get(hero.name).add(hero);
            }else{
                heroList.add(hero);
                heroCategories.put(hero.name,heroList);
            }
        }
        
        after = new Date();
        System.out.println(heroCategories.get(target).size()+"个重复的"+target);
        System.out.println("耗时："+(after.getTime()-before.getTime())+"ms");
    }
}

class Hero{
    public String name;
    public Hero(String name){
        this.name = name;
    }
    public static List<Hero> generateRandomHeoros(int nums){
        List<Hero> heros = new ArrayList<>();

        for (int i = 0; i < nums; i++) {
            heros.add(new Hero("Hero-"+((int) (Math.random()*8999)+1000)));
        }
        return heros;
    }
}