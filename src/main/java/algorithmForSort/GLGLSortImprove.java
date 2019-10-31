package algorithmForSort;

public class GLGLSortImprove {

    public static void main(String[] args) {
        int[] k = {0, 1, 0, 4, 8, 2};
        //从小到大快速排序
        quickSort(k, 0, k.length-1);
        GLGLSortImprove.printArray(k);
    }

    /**
     * print array
     * @param array
     */
    public static void printArray(int [] array){
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+" ");
        }
    }

    private static void quickSort(int[] arr, int l, int r) {
        if(l >= r) return ;


        int temp = 8;
        if(r - l < temp) {
            InsertionSort(arr, l, r);
            return ;
        }

        int i = l;
        int j = r;

        int mid = l + ((r - l) >> 1);
        if(arr[l] > arr[mid]) swap(arr, l, mid);
        if(arr[l] > arr[r]) swap(arr, l, r);
        if(arr[mid] > arr[r]) swap(arr, mid, r);

        swap(arr, l, mid);
        int key = arr[l];


        int lLen = l;
        int rLen = r;

        while(i < j) {
            while(i < j && arr[j] >= key)
                j --;
            while(i < j && arr[i] <= key)
                i ++;
            if(i < j)
                swap(arr, i, j);


            if(arr[i] == key) {
                swap(arr, i, lLen);
                lLen ++;
            }
            if(arr[j] == key) {
                swap(arr, j, rLen);
                rLen --;
            }
        }

        swap(arr, i, l);


        for(int u=l; u<lLen; u++) {
            swap(arr, u, --i);
        }
        for(int v=r; v>rLen; v--) {
            swap(arr, v, --j);
        }

        quickSort(arr, l, i-1);
        quickSort(arr, i+1, r);
    }

    private static void InsertionSort(int[] arr, int l, int r) {
        for(int i=l+1; i<=r; i++) {
            for(int j=l; j<i; j++) {
                if(arr[i] < arr[j]) {
                    swap(arr, i, j);
                }
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
