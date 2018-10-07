import java.util.Scanner;

public class 解救小易 {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] hang = new int[n];
        int[] lei = new int[n];
        int[] result = new int[n];
        for(int i = 0;i<n;i++){
            hang[i] = in.nextInt();
        }

        for(int i = 0;i<n;i++){
            lei[i] = in.nextInt();
        }

        for(int i = 0;i<n;i++){
            if(hang[i] == 1){
                if(lei[i] == 1){
                    result[i] = 0;
                }else {
                    result[i] = lei[i]-1;
                }
            }else if(lei[i] == 1){
                result[i] = hang[i]-1;
            }else {
                result[i] = hang[i]-1+lei[i]-1;
            }
        }
        int min = result[0];
        for(int i = 1;i<n;i++){
            if(min>result[i]){
                min = result[i];
            }
        }
            System.out.println(min);
    }
}
