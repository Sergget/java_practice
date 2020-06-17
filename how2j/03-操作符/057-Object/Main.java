// 重写Item的 toString(), finalize()和equals()方法
// toString() 返回Item的name + price
// finalize() 输出当前对象正在被回收
// equals(Object o) 首先判断o是否是Item类型，然后比较两个Item的price是否相同
public class Main{
    public static void main(String[] args) {
        Item item1 = new Item("item1",120);
        Item item2 = new Item("item2",200);
        Item item3 = new Item("item1", 120);

        System.out.println("item1.equals(item3): "+item1.equals(item3));
        System.out.println(item2);
    }
}

class Item{
    public String name;
    public double price;
    
    public Item(String name,double price){
        this.name = name;
        this.price = price;
    }

    public String toString(){
        return this.name+" "+this.price;
    }

    //java14提示API已过时
    // public void finalize(){
    //     System.out.println(this.name+" destroyed");
    // }

    public boolean equals(Object o){
        if(o instanceof Item){
            Item temp = (Item) o;
            if(temp.name ==this.name && temp.price==this.price){
                return true;
            }
        }
        return false;
    }
}