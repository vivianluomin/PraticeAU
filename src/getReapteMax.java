import java.util.*;

public class getReapteMax {

    public static void main(String[] args){

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] num = new int[n];
        for(int i = 0;i<n;i++){
            num[i] = in.nextInt();
        }

        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i<n;i++){
            if(!map.containsKey(num[i])){
                map.put(num[i],1);

            }else {
                map.put(num[i],map.get(num[i])+1);
            }
        }

        Collection<Integer> count = map.values();
        int max = 0;
        for(Integer i:count){
            if(i>max){
                max = i;
            }
        }

        System.out.println(max);



    }
}
