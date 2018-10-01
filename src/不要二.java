import java.util.Scanner;

public class 不要二 {

    public static int dangao = 0;
    static int w;
    static int h;
    public static void main(String[] args){

        Scanner in = new Scanner(System.in);
         w = in.nextInt();
         h = in.nextInt();
        int[][] box = new int[h][w];
        for(int i = 0;i<h;i++){
            for(int j = 0;j<w;j++){
                box[i][j] = 0;
            }
        }
        int count = 0;
        int max = Integer.MIN_VALUE;
        for(int i = 0;i<h;i++){
            for(int j = 0;j<w;j++){
               if(box[i][j] !=-1&&box[i][j] == 0){
                   box[i][j] = 1;
                   count ++;
                   if(i+2<h){
                       box[i+2][j]=-1;
                   }
                  if(j+2<w){
                      box[i][j+2]= -1;
                  }

               }
            }
        }

        System.out.println(count);
    }

}
