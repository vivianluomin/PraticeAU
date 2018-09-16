import java.util.Scanner;

public class 颜色混合 {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] colors = new int[n];
        for(int i =0;i<n;i++){
            colors[i] = in.nextInt();
        }
        if(n == 1||n == 2){
            System.out.println(n);
        }else {
            for(int i = 0;i<n;i++) {
                paixu(colors,i,n-1);
                for(int j = i+1;j<n;j++){
                    int t = colors[i]^colors[j];
                    if(t<colors[j]){
                        colors[j] = t;
                    }
                }


                }
            int count = 0;
            for(int i = 0;i<n;i++){
                if(colors[i]!=0){
                    count++;
                }
            }
            System.out.println(count);
        }


    }

    public static void paixu(int[] color,int start,int end){
        int n = color.length;
        boolean flag = false;
        for(int i =start;i<=end;i++){
            for(int j = start;j<end;j++){
                if(color[j]<color[j+1]){
                    int t = color[j];
                    color[j] = color[j+1];
                    color[j+1]  =t;

                }
            }

        }

    }
}
