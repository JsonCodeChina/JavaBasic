package algorithm.linked.advanceLinkList;

public class MySingleLinkedListDemo {

    public static void main(String[] args) {
        Node n1 = new Node(1,"宋江");
        Node n2 = new Node(2,"卢俊义");
        Node n3 = new Node(3,"吴用");
        Node n4 = new Node(4,"林冲");

        SingleLinkedList singleLinkedList = new SingleLinkedList();

//        singleLinkedList.add(n2);
//        singleLinkedList.add(n1);
//        singleLinkedList.add(n3);
//        singleLinkedList.add(n4);
//
//        singleLinkedList.list();

//        System.out.println("order:");

        singleLinkedList.addOrrder(n2);
        singleLinkedList.addOrrder(n1);
        singleLinkedList.addOrrder(n3);
        singleLinkedList.addOrrder(n4);

        singleLinkedList.list();

//        Node updateNode = new Node(1,"厉害了");
//        singleLinkedList.update(updateNode);
//        singleLinkedList.list();
//        singleLinkedList.del(3);
//        singleLinkedList.list();

        System.out.println("节点数："+SingleLinkedList.getLength(singleLinkedList.head));

        System.out.println(SingleLinkedList.findLastIndexNode(singleLinkedList.getHead(), 1));

        SingleLinkedList.reverseList(singleLinkedList.getHead());
        singleLinkedList.list();

    }
}

class SingleLinkedList{

    //step 1 init head node
    Node head = new Node(0,"");

    public Node getHead(){
        return  head;
    }

    //step 2 add node into linkedList
    public void add(Node addNode){
        Node temp = head;
        while (true) {
            if(temp.next == null){
                break;
            }
            temp = temp.next;
        }
        temp.next = addNode;
    }

    //step 3 show the linkedList
    public void list(){
        if(head.next == null) {
            System.out.println("linkedList is empty");
            return;
        }
        Node temp = head.next;
        while(true){
            if(temp==null){
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }
    }

    //step 4 add node into linkedList by order
    public void addOrrder(Node addNode){
        Node temp = head;
        boolean flag = false;
        while(true){
            if(temp.next == null){
                break;
            }
            if(temp.next.num == addNode.num ){
                flag = true;
                break;
            }else if(temp.next.num > addNode.num){
                break;
            }
            temp = temp.next;
        }

        if(flag){
            System.out.println("Can not add node:"+addNode.num+",cause node is exist!");
        }else{
            addNode.next = temp.next;
            temp.next = addNode;
        }
    }

    //step 5 update node
    public void update(Node updateNode){
        if(head.next == null){
            System.out.println("linkedList is empty");
            return;
        }

        Node temp = head.next;
        boolean flag =false;
        while (true){
            if(temp == null){
                break;
            }
            if(temp.num == updateNode.num){
                flag = true;
                break;
            }

            temp = temp.next;
        }

        if(flag){
            temp.name = updateNode.name;
        }else{
            System.out.println("do not find the node:"+updateNode.num);
        }
    }

    //step 6 delete node
    public void del(int num){
        Node temp = head;
        boolean flag =false;
        while (true){
            if(temp.next == null){
                break;
            }
            if(temp.next.num == num){
                flag = true;
                break;
            }

            temp = temp.next;
        }

        if(flag) {
            temp.next = temp.next.next;
        }else {
            System.out.printf("not find, can't delete node:"+num);
        }
    }

    //获得链表的结点个数
    public static int getLength(Node head){
        if(head.next == null){
            return 0;
        }
        int length = 0;
        Node temp = head.next;
        while(temp!=null){
            length++;
            temp = temp.next;
        }
        return  length;
    }

    //查找单链表中的倒数第k个结点
    public static Node findLastIndexNode(Node head,int index){
        if(head.next ==null){
            return null;
        }

        int size = getLength(head);

        if(index<0||index>size){
            return null;
        }

        Node temp = head.next;
        for(int i = 0;i<(size-index);i++){
            temp = temp.next;
        }

        return temp;

    }

    //链表反转
    public static void reverseList(Node head){
        //如果当前链表为空，或者只有一个节点，无需反转，直接返回
        if(head.next == null || head.next.next == null){
            return;
        }
        //定义一个辅助的指针(变量)，帮助我们遍历原来的链表
        Node current = head.next;
        Node next = null;
        Node newHead = new Node(0,"");

        //遍历原来的链表，每遍历一个节点，就将其取出，并放在新的链表reverseHead 的最前端
        while(current!=null){
            next = current.next;
            current.next = newHead.next;
            newHead.next = current;
            current = next;
        }
        head.next = newHead.next;
    }

}

class Node{
    public int num;
    public String name;
    Node next;

    public Node(int num, String name) {
        this.num = num;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Node{" +
                "num=" + num +
                ", name='" + name +
                '}';
    }
}
