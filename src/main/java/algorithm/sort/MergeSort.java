package algorithm.sort;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int [] array = new int[]{1,4,7,3,2};
        int [] temp = new int [array.length];
        mergeSort(array,0,array.length-1,temp);
        System.out.println(Arrays.toString(array));

    }

    public static void mergeSort(int[] arr, int left, int right, int[] temp){
        if(left < right) {
            int mid = (left + right) / 2;

            mergeSort(arr, left, mid, temp);

            mergeSort(arr, mid + 1, right, temp);

            merge(arr, left, mid, right, temp);
        }
    }

    public static void merge(int []array, int left, int mid, int right, int [] temp){

        int i = left;
        int j = mid+1;
        int t = 0;

        while(i<=mid&&j<=right){
            if(array[i]<= array[j]){
                temp[t] = array[i];
                t+=1;
                i+=1;

            }else{
                temp[t] = array[j];
                t+=1;
                j+=1;
            }
        }

        while(i<=mid){
            temp[t] = array[i];
            t+=1;
            i+=1;
        }

        while(j<=right){
            temp[t] = array[j];
            t+=1;
            j+=1;
        }

        t = 0;
        int tempLeft = left;

        while(tempLeft <= right) {
            array[tempLeft] = temp[t];
            t += 1;
            tempLeft += 1;
        }
    }


}
