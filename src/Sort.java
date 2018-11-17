public class Sort {

    public static void bubbleSort(int[] a){
        int n = a.length;
        boolean flag = false;
        for(int i = 0;i<n;i++){
            for(int j = i;j<n-1;j++){
                if(a[j]>a[j+1]){
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                    flag = true;
                }
            }
            if(!flag){
                break;
            }
        }
    }

    //插入排序

    public static void insertSort(int[] a){
        int n = a.length;
        if(n<=1){
            return;
        }
        for(int i = 1;i<n;i++){
            if(a[i]<a[i-1]){
               int temp = a[i];
               int j = i-1;
               for(;j>=0;j--){
                   if(a[j]>a[i]){
                       a[j+1] = a[j];
                   }else {
                       break;
                   }
               }
               a[j+1] = temp;
            }
        }
    }


    //选择排序
    public static void selectionSort(int[] a){
        int n = a.length;
        for(int i = 0;i<n;i++){
            int j = 0;
            int p = 0;
            int max = a[0];
            for(;j<n-i;j++){
                if(a[j]>max){
                    p = j;
                    max = a[j];
                }
            }
            a[p] = a[n-i-1];
            a[n-i-1] = max;
        }
    }


    //归并排序
    public static void MergeSort(int a[],int start,int end){
        if(start>=end){
            return;
        }
        int mid = (start+end)/2;
        MergeSort(a,start,mid);
        MergeSort(a,mid+1,end);
        int[] A = new int[mid-start+1];
        int[] B = new int[end-mid];
        int j = 0;
        for(int i = start;i<=mid;i++){
            A[j++] = a[i];
        }
        j = 0;
        for(int i = mid+1;i<=end;i++){
            B[j++] = a[i];
        }

        j = 0;
        int i = 0;
        int t = start;
        while (i<A.length||j<B.length){
            if(j == B.length ||(i<A.length&&A[i]<=B[j])){
                a[t] = A[i];
                t++;
                i++;
            }else {
                a[t] = B[j];
                t++;
                j++;
            }
        }
    }


    //快速排序
    public static void quickSort(int[] a,int left,int right){
        if (left<right){
            int p = getPo(a,left,right);
            quickSort(a,left,p-1);
            quickSort(a,p+1,right);
        }
    }

    public static int getPo(int[] a,int left,int right){
        int temp = a[left];
        int i = left+1;
        int j = left;
        for(;i<=right;i++){
            if(a[i]<=temp){
                int t = a[i];
                a[i] = a[j+1];
                a[j+1] = t;
                j++;
            }
        }

        int t = a[left];
        a[left] = a[j];
        a[j] = t;

        return j;
    }


    //计数排序
    public static void countingSort(int[] a){
        int n = a.length;
        int max = a[0];
        for(int i = 1;i<n;i++){
            if(a[i]>max){
                max = a[i];
            }
        }

        int[] R = new int[max+1];
        for(int i =0;i<max+1;i++){
            R[i] = 0;
        }
        for(int i =0;i<n;i++){
            R[a[i]]++;
        }
        for(int i = 1;i<max+1;i++){
            R[i] +=R[i-1];
        }

        int[] c = new int[n];
        for(int i = 0;i<n;i++){
            int t = a[i];
            c[--R[t]] = t;

        }

        for(int i = 0;i<n;i++){
            a[i] = c[i];
        }
    }


    public static void main(String[] args){
        int[] a = {3,2,5,8,4,7,5,9};
        countingSort(a);

        for(int i = 0;i<a.length;i++){
            System.out.println(a[i]);
        }
    }

}
