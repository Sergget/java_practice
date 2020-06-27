import java.util.Calendar;

//找出下个月的倒数第3天是哪天
public class Main {
  public static void main(String[] args) {
      Calendar c = Calendar.getInstance();
      c.set(Calendar.DAY_OF_MONTH, 1);
      c.add(Calendar.MONTH,2);
      c.add(Calendar.DAY_OF_MONTH, -3);
      System.out.println(c.getTime());
  }  
}