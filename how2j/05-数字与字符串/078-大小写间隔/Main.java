//把 lengendary 改成间隔大写小写模式，即 LeNgEnDaRy
public class Main {
  public static void main(String[] args) {
    String s = "lengendary";
    char[] ss = s.toCharArray();
    for (int i = 0; i < ss.length; i++) {
        if(Math.pow(-1, i+1)==-1){
            ss[i] = Character.toUpperCase(ss[i]);
        }else{
            ss[i]= Character.toLowerCase(ss[i]);
        }
    }
    System.out.println(new String(ss));
  }  
}