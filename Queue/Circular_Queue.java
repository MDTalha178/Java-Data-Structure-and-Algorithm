public class Circular_Queue {
    public static void main(String args[]){
        QueueCustom queue = new QueueCustom(5);

        // here we will add element
        queue.addElement(1);
        queue.addElement(2);
        queue.addElement(3);
        queue.addElement(4);
        queue.addElement(5);

        // here we will access front element or top
        System.out.println("Front or Top element of Queue is "+ queue.peek());

        // here wew will remove some element
        int val1 = queue.removeElement();
        System.out.println("Delete value is "+  val1);

        // here we will access front element or top
        System.out.println("Front or Top element of Queue is "+ queue.peek());


    }
}

class QueueCustom{
    int arr[];
    int front;
    int rear;

    QueueCustom(int n){
        this.arr = new int[n];
        this.front = -1;
        this.rear = -1;

    }

    // here we will check queue or array is Empty
    public boolean isEmpty(){
        return arr.length == 0;
    }

    // here we will check is Queue or stack is full
    public boolean isFull(){
        return (rear + 1) % arr.length == front;
    }

    // here we will get front or top element
    public int getFront(){
        if(isEmpty()){
            System.out.println("Queue is Empty");
            return -1;
        }
        return arr[front];
    }

    // here we will add element in Queue
    public void addElement(int data){
        if(isFull()){
            System.out.println("Queue is Full");
            return;
        }else{
            if(front == -1){
                rear = front = 1;
                arr[rear] = data;
            }else{
                rear = (rear +1) % arr.length;
                arr[rear] = data;
            }
        }

    }

    // here we will peform remove option
    public int removeElement(){
        if(isEmpty()){
            System.out.println("Queue is Empty");
            return -1;
        }else{
            int val = arr[front];
            if(front == rear){
                front = rear = -1;  
            }
            front = (front+1) % arr.length;
            return val;
        }
    }

    // here we will get top or peek element
    public int peek(){
        if(isEmpty()){
            System.out.println("Queue is Empty");
            return -1;
        }else{
            return arr[front];
        }
    }
}
