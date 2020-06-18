import java.util.Scanner;

class Main{
    public static void main(String[] args) {
        Scanner s  = new Scanner(System.in);
        String str = s.nextLine();
        s.close();
        char[] chars = str.toCharArray();

        for (char c : chars) {
            if(Character.isUpperCase(c)||Character.isDigit(c)){
                System.out.print(c);
            }
        }
    }
}