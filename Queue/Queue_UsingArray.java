import java.util.ArrayList;

class Queue_UsingArray{
    public static void main(String args[]){
        Queue queue = new Queue();

        // here we will add
        queue.addElement(1);
        queue.addElement(2);
        queue.addElement(3);
        queue.addElement(4);

        // here we will get front
        System.out.println("Front element: " + queue.getFront());

        // here we will get our rear element
        System.out.println("Rear elemenet "+  queue.getRear());

        // here we will remove
        int value = queue.remove();
        System.out.println("Deleted value is "+ value);

        // here we will get front
        System.out.println("Front element: " + queue.getFront());

        // here we will get our rear element
        System.out.println("Rear elemenet "+  queue.getRear());


    }
}

class Queue{
    ArrayList<Integer>arr = new ArrayList<>();

    // check array or queue is empty
    public boolean isEmpty(){
        return this.arr.size() == 0;
    }

    // get front element
    public  int getFront(){
        if(isEmpty()){
            System.out.println("Queue is Empty");
            return -1;
        }
        return arr.get(0);
    }

    // get rear element
    public int getRear(){
        if(isEmpty()){
            System.out.println("Queue is Empty");
            return -1;
        }
        return arr.get(arr.size()-1);
    }

    // add element in Queue
    public void addElement(int data){
        if(isEmpty()){
            arr.add(data);
            return;
        }
        arr.add(data);
    }

    // remove element 
    public int remove(){
        if(isEmpty()){
            System.out.println("Queue is Empty");
            return -1;
        }
        int value = arr.get(0);
        arr.remove(0);
        return value;
    }

    
}