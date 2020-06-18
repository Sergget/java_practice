public class Main1{
    public static void main(String[] args) {
        Spider spider = new Spider();
        spider.eat();
        spider.walk();

        Cat cat = new Cat("Nancy");
        System.out.println(cat.getName());
        cat.play();
        cat.eat();
        cat.walk();

        Fish fish = new Fish("shazio");
        System.out.println(fish.getName());
        fish.play();
        fish.eat();
        fish.walk();
    }
}

// 1. 创建Animal类，它是所有动物的抽象父类。
// 2. 声明一个受保护的整数类型属性legs，它记录动物的腿的数目。
// 3. 定义一个受保护的构造器，用来初始化legs属性。
// 4. 声明抽象方法eat。
// 5. 声明具体方法walk来打印动物是如何行走的（包括腿的数目）。

abstract class Animal {
    protected int legs;

    protected Animal(int legNumber) {
        this.legs = legNumber;
    };

    abstract void eat();

    void walk() {
        System.out.println("walking using " + this.legs + " legs");
    }
}

// 1. Spider继承Animal类。
// 2. 定义默认构造器，它调用父类构造器来指明所有蜘蛛都是8条腿。
// 3. 实现eat方法
class Spider extends Animal {
    public Spider() {
        super(8);
    }

    public void eat() {
        System.out.println("Spider is eating");
    }
}

// 根据UML类创建pet（宠物）接口
// 1. 提供getName() 返回该宠物的名字
// 2. 提供setName(String name) 为该宠物命名
// 3. 提供 play()方法
interface pet {
    public String getName();

    public void setName(String name);

    public void play();
}

// 1. 该类必须包含String属性来存宠物的名字。
// 2. 定义一个构造器，它使用String参数指定猫的名字；该构造器必须调用超类构造器来指明所有的猫都是四条腿。
// 3. 另定义一个无参的构造器。该构造器调用前一个构造器（用this关键字）并传递一个空字符串作为参数
// 4. 实现Pet接口方法。
// 5. 实现eat方法。
class Cat extends Animal implements pet {
    protected String name;

    public Cat() {
        this("");
    }

    public Cat(String name) {
        super(4);
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void play(){
        System.out.println(this.name + " is playing");
    }

    @Override
    public void eat(){
        System.out.println("Cat "+this.name+" is eating");
    }
}

// 1. 创建Fish类，它继承Animal类
// 2. 重写Animal的walk方法以表明鱼不能走且没有腿。
// 3. 实现Pet接口
// 4. 无参构造方法
// 5. 提供一个private 的name属性

class Fish extends Animal implements pet {
    private String name;

    public Fish(){
        this("");
    }

    public Fish(String name){
        super(0);
        this.name = name;
    }

    @Override
    public void walk() {
        System.out.println("Fish cannot walk!");
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void play(){
        System.out.println("Fish " + this.name+" is playing");
    }

    @Override
    public void eat(){
        System.out.println("Fish "+this.name+" is eating");
    }
}