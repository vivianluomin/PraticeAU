import java.util.Scanner;

/**
 * 这道题主要是利用深度搜索，得到所有的真子集。
 * 先将所有的排序，从第一个开始深度搜索。
 * 利用条件，如果加上这个数后的和比乘上这个数的积小的话，
 * 先判断这个数是否为1，因为有1的话，后面的数就有可能让和比积大，
 * 否则还原资源，也不用进行后面的深度搜索了，因为相同位数，小的都不满足，大的数更不会满足了
 * 然后根据题目要求，去重，相同数字，不用再次进行深度搜素
 */


public class 幸运的袋子 {

    public static void main(String[] args){

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] d = new int[n];
        for(int i = 0 ;i<n;i++){
            d[i] = in.nextInt();
        }

        paixu(d);

        System.out.println(dfs(d,0));
    }

    public static void paixu(int[] d){
        int n = d.length;
        boolean flag = false;
        for(int i =0;i<n;i++){
            for(int j = 0;j<n-1;j++){
                if(d[j]>d[j+1]){
                    int t = d[j];
                    d[j] = d[j+1];
                    d[j+1]  =t;

                }
            }

        }

    }
    public static int add = 0;
    static int ji = 1;
    public static int dfs(int[] d,int start){
        int res = 0;
        for(int i = start;i<d.length;i++){
         add+=d[i];
         ji*=d[i];
         if(add>ji){
             res+=1+dfs(d,i+1);
         }else if(d[i] == 1){
             res +=dfs(d,i+1);
         }else {
             add-=d[i];
             ji/=d[i];
             break;//因为排序了，所以再算后面的也没有用

         }
            add-=d[i];
            ji/=d[i];
            for(;i<d.length-1&&d[i]==d[i+1];i++);//去重
        }

        return res;
    }

}
