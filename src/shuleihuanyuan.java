import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class shuleihuanyuan {

    public static int[] x;
    public static List<int[]> qp = new ArrayList<>();
    private static final String TAG = "shuleihuanyuan";

    public static void main(String[] args){

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int zeros = 0;
        int[] num = new int[n];
        for(int i = 0;i<n;i++){
            num[i] = in.nextInt();
            if(num[i] == 0){
                zeros++;
            }
        }

         x = new int[zeros];
        int p = 0;
        for(int i = 1;i<=n;i++){
            if(!contain(num,i)){
                x[p] = i;
                p++;
            }
        }
        quanpai(0,zeros);
        int count = 0;
        for(int i =0;i<qp.size();i++){

            if(getk(qp.get(i),num,k)){
                count++;
            }
        }

        System.out.println(count);
    }

    public static boolean contain(int[] num ,int k){
        for(int i = 0;i<num.length;i++){
            if(num[i] == k){
                return true;
            }
        }

        return false;
    }

    public static boolean getk(int[] q,int[] num,int k){
        int[] nn ;
        nn = Arrays.copyOf(num,num.length);
        int qi = 0;
        for(int i = 0;i<nn.length;i++){
            if(nn[i] == 0){
                nn[i] = q[qi];
                qi++;
            }
        }
        int kk = 0;

        for(int i = 0;i<nn.length;i++){

            for(int j = i+1;j<nn.length;j++){
                if(nn[i]<nn[j]){
                    kk++;
                }
            }
        }
        if(kk == k){
            return true;
        }

        return false;
    }

    public static void quanpai(int i,int n){

        int j;
        if(i<n){
            for(j = i;j<n;j++){
                Swap(i,j);
                quanpai(i+1,n);
                Swap(i,j);
            }
        }else {
            int[] tt = Arrays.copyOf(x,x.length);
            qp.add(tt);
        }
    }

    public static void Swap(int q,int p){
        int t = x[q];
        x[q] = x[p];
        x[p] = t;
    }
}
