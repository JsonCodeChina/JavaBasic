package algorithm.linked;


public class MyLinkedArray {

    private static class Node{
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    private Node head;
    private Node last;
    private int size;

    public Node get(int index){
        if(index>size||index<0){
            throw  new IndexOutOfBoundsException("out of range");
        }

        Node temp = head;

        for(int i=0;i<index;i++){
            temp = temp.next;
        }
        return temp;
    }

    public void insert(int data,int index){
        if(index>size || index<0){
            return;
        }

        Node insertNode = new Node(data);

        if(size==0){
            head = insertNode;
            last = insertNode;
        }else if(index==0){
            insertNode.next = head;
            head = insertNode;
        }else if(index==size){
            last.next = insertNode;
            last = insertNode;
        }else{
            //寻找
            Node preNode = get(index-1);
            insertNode.next = preNode.next;
            preNode.next = insertNode;
        }

        size++;
    }

    public Node remove(int index){
        if(index<0||index>size) {
            throw new IndexOutOfBoundsException("out of range");
        }

        Node deleteNode = null;

        if(index == 0){
            deleteNode = head;
            head = head.next;
        }else if(index == (size-1)){
            deleteNode = last;
            last = get(index-1);
            last.next=null;
        }else{
            Node preNode = get(index-1);
            Node nextNode = preNode.next.next;
            deleteNode = preNode.next;
            preNode.next = nextNode;
        }
        size--;
        return deleteNode;
    }

    public void output(){
        Node temp = head;
        while(temp!=null){
            System.out.println(temp.data);
            temp = temp.next;
        }

    }

    public static void main(String[] args) {
        MyLinkedArray myLinkedArray = new MyLinkedArray();
        myLinkedArray.insert(1,0);
        myLinkedArray.insert(3,1);
        myLinkedArray.insert(2,2);
        myLinkedArray.insert(3,3);
        myLinkedArray.output();
        myLinkedArray.insert(4,2);
        myLinkedArray.output();
//        myLinkedArray.remove(3);
       System.out.println("ss"+myLinkedArray.get(2).data);
//        myLinkedArray.output();
    }
}
