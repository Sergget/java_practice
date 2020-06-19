// 1. 生成一个长度是3的随机字符串，把这个字符串作为当做密码
// 2. 使用穷举法生成长度是3个字符串，匹配上述生成的密码
// 要求： 分别使用多层for循环 和 递归解决上述问题

public class Main {
    public static void main(String[] args) {
        String passwd = getRandomString(3);
        crackPasswd(passwd);
    }

    static String getRandomString(int length) {
        String temp = "";
        for (short i = 'A'; i <= 'Z'; i++) {
            temp += (char) i;
        }
        for (short j = 'a'; j <= 'z'; j++) {
            temp += (char) j;
        }
        for (short k = 0; k <= 9; k++) {
            temp += k;
        }
        String result = "";
        for (int n = 0; n < length; n++) {
            result += temp.charAt((int) (Math.random() * temp.length()));
        }
        return result;
    }

    static void crackPasswd(String passwd){
        String pool = "";
        for(short i ='A';i<='Z';i++){
            pool+=(char) i;
        }
        for(short j='a';j<='z';j++){
            pool+=(char) j;
        }
        for(short k=0;k<=9;k++){
            pool+=k;
        }

        for (char a : pool.toCharArray()) {
            for (char b : pool.toCharArray()) {
                for (char c : pool.toCharArray()) {
                    if(passwd.equals(""+a+b+c)){
                        System.out.println("trial:"+a+b+c+",Passwd:"+passwd);
                        break;
                    }
                }
            }
        }
    }
}