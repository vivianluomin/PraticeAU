public class Search {


    public  static int spartSearch(int[] a,int key){

        int low = 0;
        int high = a.length-1;

        while (low<=high){
            int mid = (low+high)-1;
            if(a[mid] == key){
                return mid;
            }

            if(a[mid]>key){
                high = mid-1;
            }else {
                low = mid+1;
            }
        }

        return -1;
    }

    /*
     * 二分查找，找到数组中第一个等于该值的下标
     * 将情况分为三种，大于，小于，等于
     */

    public static int spartSearchFirst(int[] a,int key){

        int low = 0;
        int hight = a.length-1;

        while (low<=hight){
            int mid = (low+hight)/2;

            if(a[mid]>key){
                hight = mid-1;
            }else if(a[mid]<key){
                low = mid+1;
            }else {
                if(mid == 0||a[mid-1]!=key) return mid;
                hight = mid-1;
            }
        }

        return -1;
    }
    /*
     * 二分查找，找到数组中最后一个等于该key的下标
     */
    public static int spartSearchLast(int a[],int key){
        int low = 0;
        int high = a.length-1;

        while (low<=high){
            int mid = (low+high)/2;
            if(a[mid]>key){
                high = mid-1;
            }else if(a[mid] <key){
                low = mid+1;
            }else {
                if(mid == a.length-1||a[mid+1]!=key) return mid;

                low = mid+1;
            }
        }

        return -1;
    }

    /*
     * 找到第一个大于等于该给定值的元素
     */

    public static int spartSearchFistMore(int a[],int key){
        int low = 0;
        int high = a.length-1;
        while (low<=high){
            int mid = (low+high)/2;

            if(a[mid]<key){
                low = mid+1;
            }else if(a[mid] >=key){
                if(mid == 0||a[mid-1]<key) return mid;
                high = mid-1;
            }
        }

        return -1;
    }

    /*
     * 找到最后一个小于等于给定值的元素
     */

    public static int spartSearchLastLess(int[] a,int key){
        int low = 0;
        int high = a.length-1;
        while (low<=high){
            int mid = (low+high)/2;
            if(a[mid]>key){
                high = mid-1;
            }else {
                if(mid == a.length-1||a[mid+1]>key) return mid;
                low = mid+1;
            }
        }

        return -1;
    }

    public static void main(String[] args){
        int[] a = {1,1,2,2,3,5,5,7};
        System.out.println(spartSearchLastLess(a,4));
    }

}
