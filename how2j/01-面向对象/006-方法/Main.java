public class Main {
    public static void main(String[] args) {
        Hero hero1 = new Hero("艾伦");
        System.out.println("Hero name = "+hero1.name+", Current HP = "+hero1.getHp());
        hero1.lengendary();
        hero1.recovery(50);
        System.out.println("Recoverying "+hero1.name+" for 50 HP, now HP = "+hero1.getHp());
    }
}

class Hero{
    public String name;
    private float HP=400;
    private float totalHP=500;

    public Hero(String name){
        this.name=name;
    }

    public void lengendary(){
        System.out.println(this.name+" is lengendary!");
    }

    public float getHp(){
        return this.HP;
    }

    public void recovery(float blood){
        if(this.HP+blood>=totalHP){
            this.HP = totalHP;
        }else if(blood>0){
            this.HP +=blood;
        }
    }
}