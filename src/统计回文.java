import java.util.Scanner;

public class 统计回文 {

    public static void main(String[] args){

        Scanner in = new Scanner(System.in);
        String A = in.nextLine();
        String B = in.nextLine();
        int po = A.length()+1;
        int legth = A.length();
        int count = 0;
        for(int i =0;i<po;i++){
            String s = A.substring(0,i)+B+A.substring(i,legth);
            if(ifHuiWen(s)){
                count++;
            }
        }

        System.out.println(count);

    }

    public static boolean ifHuiWen(String s){
        char[] chars = s.toCharArray();
        for(int i = 0,j = s.length()-1;i<j;i++,j--){
            if(chars[i] != chars[j]){
                return false;
            }
        }

        return true;
    }
}
