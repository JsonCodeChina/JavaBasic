package algorithm.sort;


import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {

        int [] array = new int[]{1,4,7,3,2};
        bubbleSort(array);
    }

    public static void bubbleSort(int [] array){

        boolean flag = false;

        for (int i = 0; i < array.length-1; i++) {
            for(int j = 0; j<array.length-1-i;j++){
                if(array[j]>array[j+1]){
                    flag = true;
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }

            System.out.println("第" + (i + 1) + "趟排序后的数组");
            System.out.println(Arrays.toString(array));

            if(!flag){
                break;
            }else{
                flag = false;
            }

        }

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+" ");
        }
    }
}
