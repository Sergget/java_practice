// 创建一个长度是8的字符串数组
// 使用8个长度是5的随机字符串初始化这个数组
// 对这个数组进行排序，按照每个字符串的首字母排序(无视大小写)

// 注1： 不能使用Arrays.sort() 要自己写
// 注2： 无视大小写，即 Axxxx 和 axxxxx 没有先后顺序

public class Main {
    public static void main(String[] args) {
        String[] strArray=new String[8];
        
        for(int i =0;i<strArray.length;i++){
            strArray[i]=randomString(5);
        }
        System.out.println("String array before:");
        printStrArray(strArray);
        sortStrArray(strArray);
        System.out.println("String array after:");
        printStrArray(strArray);

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

    static void printStrArray(String[] strArray){
        for (String string : strArray) {
            System.out.println(string);
        }
    }

    static void sortStrArray(String[] strArray){
        for(int i=0;i<strArray.length;i++){
            for (int j = i+1; j < strArray.length; j++) {
                if(Character.toLowerCase(strArray[i].charAt(0))>Character.toLowerCase(strArray[j].charAt(0))){
                    String temp = strArray[j];
                    strArray[j] = strArray[i];
                    strArray[i] = temp;
                }
            }
        }
    }
}