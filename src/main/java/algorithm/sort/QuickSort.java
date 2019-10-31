package algorithm.sort;


import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int [] array = new int [] {7,3,4,5,8};

        quickSort(array,0,array.length-1);

        System.out.println(Arrays.toString(array));
    }

    public static void quickSort(int [] array, int left , int right)
    {
        if(right<left) return;
        int i = left;
        int j = right;
        int pivot = array[left];

        while(i<j){
            while(array[j]>=pivot && j>i){
                j--;
            }

            while(array[i]<=pivot && j>i){
                i++;
            }

            if(i<j){
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }


        array[left] = array[i];
        array[i] = pivot;

        quickSort(array,left,j-1);
        quickSort(array,j+1,right);

    }
}
