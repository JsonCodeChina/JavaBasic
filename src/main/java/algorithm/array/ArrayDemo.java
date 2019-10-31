package algorithm.array;


import java.util.Arrays;

class MyArray{
    private int [] array;
    private int size;

    public MyArray(int size) {
        this.array = new int[size];
        this.size = 0;
    }

    public void insert(int index, int element){
        if(index>size || index<0){
            throw new IndexOutOfBoundsException("超界！");
        }

        for(int i = size-1;i>=index;i--){
            array[i+1] = array[i];
        }
        array[index] = element;
        size++;
    }

    public void output(){
        System.out.println("size:"+size);
        for (int i = 0; i < size; i++) {
            System.out.println(array[i]);
        }
    }


}


public class ArrayDemo {



    public static void main(String[] args) {
//        MyArray array = new MyArray(5);
//        array.insert(0,1);
//        array.insert(1,4);
//        array.insert(2,3);
//        array.insert(3,2);
//        array.insert(4,5);
//        array.output();

        int[] arra = {1,2,3,4,5};

       // ArrayDemo.insert(3,7,arra);
       // ArrayDemo.delete(3,arra);
        ArrayDemo.delete2(3,arra);

    }

    public static void delete(int index, int [] array){
        if(index<0 || index>array.length){
            return;
        }

        for(int i = index-1;i<array.length-1;i++){
            array[i] = array[i+1];
        }

        array[array.length-1] = 0;

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+" ");
        }
    }

    public static void delete2(int index, int []array){
        if(index<0 || index>array.length){
            return;
        }

        array[index-1] = array[array.length-1];
        array[array.length-1] = 0;

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+" ");
        }

    }

    public static void insert(int index,int element, int [] array){
        if(index>array.length || index<0){
            return;
        }

        int [] copyarray = Arrays.copyOf(array,array.length+1);



        for (int i = 0; i < copyarray.length; i++) {
            System.out.print(copyarray[i]+" ");
        }

        for(int i = copyarray.length-1;i>=index;i--){
            copyarray[i] = copyarray[i-1];
        }
        copyarray[index] = element;

        System.out.println();

        for (int i = 0; i < copyarray.length; i++) {
            System.out.print(copyarray[i]+" ");
        }

    }
}
