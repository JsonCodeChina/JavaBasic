package algorithmForSort;

import java.util.Arrays;

public class GLGLSort {


    /**
     * K=[0,1,0,4,8,2]
     * =>
     * K=[0,0,1,2,4,8]
     * 可以采用冒泡，选择或者快速排序；
     * 本次采用快速排序 时间复杂度nlogn
     * @param args
     */

    public static void main(String[] args) {
        int[] k = {0, 1, 0, 4, 8, 2};
        GLGLSort.quickSort(k, 0, k.length - 1);
        GLGLSort.printArray(k);

    }

    /**
     * 选定一个基数 进行分区比较
     * @param array
     * @param l 左指针
     * @param r 右指针
     */
    public static void quickSort(int [] array, int l, int r){
        if(l>r) return;

        int i = l, j = r, temp = array[l];

        while (i<j){
            while(temp<=array[j]&&i<j){
                j--;
            }
            while(temp>=array[i]&&i<j){
                i++;
            }
            if(i<j){
                int t = array[i];
                array[i] = array[j];
                array[j] = t;
            }
        }

        array[l] = array[i];
        array[i] = temp;

        quickSort(array,l,j-1);
        quickSort(array,j+1,r);

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
}
