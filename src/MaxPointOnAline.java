import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

//以每一个点作为起始点，找到以它为起始点的最多点的线
public class MaxPointOnAline {

    public int maxPoints(Point[] points){
        int le = points.length;
        if(le<=0){
            return 0;
        }if(le == 1){
            return 1;
        }

        int max = Integer.MIN_VALUE;

        for(int i =0;i<le;i++){
            int same = 0;
            int vdiffer = 0;
            int reMax = 1;
            HashMap<Double,Integer> lines = new HashMap<>();
            for(int j =0;j<le;j++){
                if(i!=j){
                    double x1 = points[i].x-points[j].x;
                    double y1 = points[i].y-points[j].y;
                    if(x1 == 0&&y1 == 0){
                        same++;
                    }else if(x1 == 0){
                         if(vdiffer == 0){
                             vdiffer=2;
                         }else {
                             vdiffer ++;
                         }
                        reMax = Math.max(vdiffer,reMax);
                    }else {
                        double v = y1/x1; //通过同一个点且斜率相同
                        if(lines.containsKey(v)){
                            lines.put(v,lines.get(v)+1);
                        }else {
                            lines.put(v,2);
                        }

                        reMax = Math.max(reMax,lines.get(v));

                    }

                }
            }

            max = Math.max(max,reMax+same);

        }



        return max;
    }
}


class Point {
      int x;
      int y;
      Point() { x = 0; y = 0; }
      Point(int a, int b) { x = a; y = b; }
  }

