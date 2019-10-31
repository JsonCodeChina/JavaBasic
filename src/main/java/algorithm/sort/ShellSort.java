package algorithm.sort;

public class ShellSort {

    public static void main(String[] args) {
        int [] array = new int[]{1,4,7,3,2};
        shellSort(array);
    }

    public static void shellSort(int array[]){

        for(int gap = array.length/2;gap>0;gap/=2){
            for(int i = gap;i<array.length;i++){
                int j = i;
                int insertValue = array[i];
                if(array[j]<array[j-gap]){
                    while(j-gap>=0 && array[j-gap]>insertValue){
                        array[j] = array[j-gap];
                        j-=gap;
                    }
                    array[j] = insertValue;
                }

            }
        }

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+" ");
        }
    }
}
