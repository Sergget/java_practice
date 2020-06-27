import java.util.Date;
import java.text.SimpleDateFormat;

//借助随机数，创建一个从1995.1.1 00:00:00 到 1995.12.31 23:59:59 之间的随机日期
public class Main {
  public static void main(String[] args) {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");

    try {
      String start = "1995.01.01 00:00:00";
      String end = "1995.12.31 23:59:59";
      Date startTime = sdf.parse(start);
      Date endTime = sdf.parse(end);

      long diff = endTime.getTime() - startTime.getTime();
      Date resultDate = new Date((long) (Math.random() * diff) + startTime.getTime());

      System.out.println(sdf.format(resultDate));

    } catch (Exception e) {
      // TODO: handle exception
      e.printStackTrace();
    }
  }
}