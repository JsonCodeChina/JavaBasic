package algorithm.sort;

public class InsertSort {

    public static void main(String[] args) {
        int [] array = new int[]{1,4,7,3,2};
        insertSort(array);
    }

    public static void insertSort(int [] array){

        for(int i = 0 ;i<array.length-1;i++){
            int insertValue = array[i+1];
            int insertIndex = i;

            while(insertIndex>=0&&insertValue<array[insertIndex]){
                array[insertIndex+1] = array[insertIndex];
                insertIndex--;
            }

            array[insertIndex+1] = insertValue;
//            if(insertIndex+1 != i){
//                array[insertIndex+1] = insertValue;
//            }

        }

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+" ");
        }
    }
}
