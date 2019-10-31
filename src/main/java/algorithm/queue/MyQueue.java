package algorithm.queue;

public class MyQueue {

    private int array[];
    private int front;
    private int rear;

    public MyQueue(int size) {
        this.array = new int[size];
    }

    public void inQueue(int element) throws Exception {
        if((rear+1)%array.length==front){
            throw new Exception("队列已满");
        }

        array[rear] = element;
        rear = (rear+1)%array.length;
    }

    public int outQueue() throws Exception {
        if(rear == front){
            throw new Exception("队列已空");
        }

        int outQueueEle = array[front];
        front = (front+1)%array.length;
        return outQueueEle;
    }

    public void output(){
        for(int i = front;i!=rear;i=(i+1)%array.length){
            System.out.println(array[i]);
        }
    }


    public static void main(String[] args) throws Exception {
        MyQueue myQueue = new MyQueue(4);
        myQueue.inQueue(1);
        myQueue.inQueue(3);
        myQueue.inQueue(2);
        myQueue.output();
        myQueue.outQueue();
        myQueue.output();
    }
}
