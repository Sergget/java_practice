public class Main {
    public static void main(String[] args) {
        System.out.println(randomString(5));;
    }

    static String randomString(int length){
        String temp = "";
        for(short i ='A';i<='Z';i++){
            temp+=(char) i;
        }
        for(short j='a';j<='z';j++){
            temp+=(char) j;
        }
        for(short k=0;k<=9;k++){
            temp+=k;
        }
        String result = "";
        for(int n=0;n<length;n++){
            result+=temp.charAt((int) (Math.random()*temp.length()));
        }
        return result;
    }
}