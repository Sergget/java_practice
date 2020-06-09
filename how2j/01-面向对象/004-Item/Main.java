public class Main {
    public static void main(String[] args) {
        item item1 = new item("血瓶",50);
        item item2 = new item("草鞋",300);
        item item3 = new item("长剑",350);
        System.out.println("item name="+item1.name+", price = "+item1.price);
        System.out.println("item name="+item2.name+", price = "+item2.price);
        System.out.println("item name="+item3.name+", price = "+item3.price);
    }
}

class item{
    public String name;
    public int price;

    public item(String name, int price){
        this.name=name;
        this.price = price;
    }
}