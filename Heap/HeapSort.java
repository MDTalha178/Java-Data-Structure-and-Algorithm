public class HeapSort {

    /**
     * Main method to demonstrate the Heap Sort algorithm.
     *
     * @param args command line arguments
     */
    public static void main(String args[]){
        // The main method is intentionally left empty as the Heap Sort
        // functionality is not implemented yet.
        int nodes[] = {1,2,4,5,3};
        SortHeap sortHeap = new SortHeap();

        sortHeap.heapSort(nodes);

        for(int i =0; i<nodes.length; i++){
            System.out.print(nodes[i] + " ");
        }

    }

}

class SortHeap{

    public void heapSort(int arr[]){

        int n = arr.length;

        // step 1-> we need to create max heap
        for(int i =n/2; i>=0; i--){
            heapify(arr, i, n);
        }

        // step 2-> we need to swap firs index element to from last
        for(int i = n-1; i>=0; i--){

            // swap from first to last
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, 0, i);
        }
    }

    private static void heapify(int arr[], int i, int size){

        // step 1 -> get left and right children
        int leftChild = (2*i) + 1;
        int rightChild = (2*i) + 2;
        int minIdx = i;

        // step-2 -> check for left child for validating CBT property
        if(leftChild < size && arr[leftChild] > arr[minIdx]){
            minIdx = leftChild;
        }

        // step 2-> check for right child for validating a property CBT
        if(rightChild < size && arr[rightChild] > arr[minIdx]){
            minIdx = rightChild;
        } 

        // here we will check heap needs to be fixed or not
        if(minIdx != i){

            // swap our element
            int temp = arr[minIdx];
            arr[minIdx] = arr[i];
            arr[i] = temp;

            heapify(arr, minIdx, size);
        }
    }
}
