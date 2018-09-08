import java.util.Scanner;

public class zhufangzi {

    public static void main(String[] args){

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] nk = new int[n][2];
        for(int i = 0;i<n;i++){
            int nn = in.nextInt();
            int k = in.nextInt();
            nk[i][0] = nn;
            nk[i][1] = k;
        }

        for(int i= 0;i<n;i++){
            getMax(nk[i][0],nk[i][1]);
        }
    }

    public static void getMax(int n,int k){

        int m = k-1;
        int no = n-k;

        if(no<m){
            System.out.println("0"+" "+no);
        }else {
            if (m<0){
                m = 0;
            }
            System.out.println("0"+" "+m);
        }
    }
}
