import java.util.Scanner;

public class ZCGGzixulie {

    public static  void main(String[] args){

        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String t = in.nextLine();
        int count = getS(s,t);
        if(count == t.length()){
            System.out.println("Yes");
        }else {
            System.out.println("No");
        }

    }

    public static int f(int t[],int n){
        if(n>0){
            return t[n-1]+f(t,n-1);
        }else {
            return 2;
        }
    }

    public static int getS(String s,String t){

        int[][] value = new int[s.length()+1][t.length()+1];
        for(int i = 0;i<s.length();i++){
            value[i][0] = 0;
        }

        for (int j = 0;j<t.length();j++){
            value[0][j] = 0;
        }
        for(int i =0;i<s.length();i++){
            for(int j = 0;j<t.length();j++){
                if(s.charAt(i) == t.charAt(j)){
                    value[i+1][j+1] = value[i][j]+1;
                }else {
                    value[i+1][j+1] = Math.max(value[i+1][j],value[i][j+1]);
                }
            }
        }

        return value[s.length()][t.length()];
    }

    public static int getMax(int a,int b,int c){
        int max = a;
        if(max<b){
            max = b;
        }

        if(max<c){
            max = c;
        }

        return max;
    }

}
