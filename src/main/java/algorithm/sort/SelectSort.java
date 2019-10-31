package algorithm.sort;

public class SelectSort {

    public static void main(String[] args) {

        int [] array = new int[]{1,4,7,3,2};

        selectSort(array);
    }

    public static void selectSort(int [] array){

        int minNum = 0;
        int minIndex = 0;
        for(int i = 0; i<array.length-1;i++){
            minNum = array[i];
            minIndex = i;
            for(int j=i+1;j<array.length;j++){
                if(minNum>array[j]){
                    minNum = array[j];
                    minIndex = j;
                }
            }

            array[minIndex] = array[i];
            array[i] = minNum;
        }

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+" ");
        }
    }
}
