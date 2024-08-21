import java.util.ArrayList;
class Build_Heap{
    public static void main(String args[]){
        int nodes[] = {11,2,3,1,4,5,10};
        
        // object of Heap class
        Heap  hp = new Heap();

        // here we will insert data in my array
        for(int i=0; i<nodes.length; i++){
            hp.add(nodes[i]);
        }

        // here we will get our top element
        System.out.println("Top element of Heap "+  hp.peek());

        // here we will remove
        while (!hp.isEmpty()) {
            System.out.print(hp.peek() + " ");
            hp.remove();
        }   

    }
}

class Heap{

    // In this we store heap data
    ArrayList<Integer>heap_arr = new ArrayList<>();

    // here we will add data in heap
    public void add(int data){

        // first step -> add data at last Index
        heap_arr.add(data);

        // step 2-> fix the heap
        int childIndex = heap_arr.size() - 1;
        int parentIndex = (childIndex - 1) / 2;

        while (heap_arr.get(childIndex) < heap_arr.get(parentIndex)) {
            
            // third step -> we need to swap child and parent
            int temp = heap_arr.get(childIndex);
            heap_arr.set(childIndex, heap_arr.get(parentIndex));
            heap_arr.set(parentIndex, temp);

            childIndex = parentIndex;
            parentIndex = (childIndex -1) / 2;

        }
    }

    // this is heapify function which is responsible to fix our heap
    private void heapify(ArrayList<Integer>heap_arr, int i){

        // Step 1-> get left and right children
        int leftChildindex = (2 * i) + 1;
        int rightChildIndex = (2 * i) + 2;
        int minIdx = i;

        // step 2-> check for our left child data for making CBT property
        if(heap_arr.size() > leftChildindex && heap_arr.get(minIdx) > heap_arr.get(leftChildindex)){
            minIdx = leftChildindex;
        }

        // step 3-> check for our right child data for making CBT property
        if(heap_arr.size() > rightChildIndex && heap_arr.get(minIdx) > heap_arr.get(rightChildIndex)){
            minIdx = rightChildIndex;
        }

        // here we will check heap is not fix
        if(minIdx != i){

            // step 4 we need to swap from minIndx to i index
            int temp = heap_arr.get(minIdx);
            heap_arr.set(minIdx, heap_arr.get(i));
            heap_arr.set(i,  temp);

            heapify(heap_arr, minIdx);
        }
    }

    // here we will delete data from heap
    public int remove(){

        // here we will get our first index data
        int data = heap_arr.get(0);

        // step 1-> need to swap first element from last
        int temp = heap_arr.get(heap_arr.size()-1);
        heap_arr.set(heap_arr.size()-1, heap_arr.get(0));
        heap_arr.set(0, temp);

        //step->2  here we will remove data from last Index
        heap_arr.remove(heap_arr.size()-1);

        // step-3 here we need to call heapify function to fix our heap
        heapify(heap_arr, 0);

        return data;

    }

    // here get top or peek element
    public int peek(){
        if(heap_arr.isEmpty()){
            System.out.println("Heap is Empty");
            return -1;
        }else{
            return heap_arr.get(0);
        }
    }

    // here we will get our size
    public boolean isEmpty(){
        return heap_arr.size() == 0;
    }
}