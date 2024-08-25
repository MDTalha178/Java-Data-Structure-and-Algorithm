import java.util.*;;
public class ImplementationOfHaspMap {
    public static void main(String args[]){
        CustomHashMap hashMap = new CustomHashMap();

        // here we will add some value
        hashMap.put("India", 2300);
        hashMap.put("Butan", 23340);
        hashMap.put("Nepal", 13444);
        hashMap.put("china", 1234488);

        // here we will retrive a value with the help of key
        System.out.println(hashMap.get("India"));
        System.out.println(hashMap.get("Nepal"));
        System.out.println(hashMap.get("china"));

        // here we will get all keys
        System.out.println(hashMap.keySet());
        hashMap.remove("Nepal");
        ArrayList keys = hashMap.keySet();
        // here we can iterate on hashmap
        for(Object key: keys){
            System.out.print(key + ":" + hashMap.get(key) + " ");
        }
    }
}

// here we will create  a class for a Node
class Node <K, V>{
    K key;
    V value;

    // here we will cerate constructor
    Node(K key, V value){
        this.key = key;
        this.value = value;
    }
}

class CustomHashMap<K, V>{  //here K ans v are rpresents a generic means at point we have not decided what data type of key and value will be passed 
    
    public static int sizeOFNode;
    public static int sizeOFBuckets;
    private double lamdaThresHold = 2.0;
    private LinkedList<Node>buckets[];

    @SuppressWarnings("unchecked") //this annotation  are using to avoid warning about data types
    CustomHashMap(){
        this.sizeOFBuckets = 4;
        this.buckets = new LinkedList[4];

        // here we will cerate empty Linked list at every Index
        for(int i=0; i<sizeOFBuckets; i++){
            this.buckets[i] = new LinkedList<>();
        }
    }

    // this method is used to get a bucket Index
    private int getBucketIndex(K key){
        int hashIndex = key.hashCode();
        return Math.abs(hashIndex) % sizeOFBuckets;
    }

    // this method is used to get Index of Lined list node
    private int getNodeIndex(int bucketIndex, K key){

        LinkedList<Node>tempLinkedList = this.buckets[bucketIndex];

        int currIndex = 0;
        for(int i =0; i<tempLinkedList.size(); i++){
            if(tempLinkedList.get(i).key == key){
                return currIndex;
            }
            currIndex++;
        }
        return -1;
    }

    // this method is used to rehasing if threshold value cross
    private void rehasing(){

        // Step 1-> we need to store old data
        LinkedList<Node>tempBucket[] = this.buckets;

        // Step 2-> update the size of Bukcet
        this.buckets = new LinkedList[sizeOFBuckets * 2];
        this.sizeOFBuckets = buckets.length;

        // Step 3 create empty linked list at every Index
        for(int i=0; i<sizeOFBuckets; i++){
            this.buckets[i] = new LinkedList<>();
        }

        // Step 4-> copy all data back to updated buckets
        for(int i =0; i< sizeOFBuckets; i++){
            LinkedList<Node>temp = tempBucket[i];
            for(int j =0; j<temp.size(); j++){
                buckets[i].add(new Node(temp.get(i).key, temp.get(i).value));
            }
        }


    }

    // here we will create put method
    public  void put(K key, V value){

        // Step 1-> here we need to find a bucket index
        int bucketIndex = getBucketIndex(key);

        // Step 2-> here we we need to get node index with the help of bucket Index
        int nodeIndex = getNodeIndex(bucketIndex, key);

        // Step3 -> here we will check key is Already Exists or not

        // if key is Exists
        if(nodeIndex != -1){
            Node node = this.buckets[bucketIndex].get(nodeIndex);
            node.value = value;
        }else{
            this.buckets[bucketIndex].add(new Node(key, value));
            sizeOFNode++;
        }

        // is our Threshodl value is crossed if is corss we need to reshashing
        double lambda = (double) sizeOFNode / sizeOFBuckets;
        if (lambda >= lamdaThresHold) {
            rehasing();
        }
    }

    // here we will create method to value for a key
    public V get(K key){

        // Step 1 we need to get bucket Index
        int bucketIndex = getBucketIndex(key);
        int nodeIndex = getNodeIndex(bucketIndex, key);

        if(nodeIndex != -1){
            Node node = this.buckets[bucketIndex].get(nodeIndex);
            return (V) node.value;
        }else{
            return (V) null;
        }
    }

    // here we will create method to remove a key
    public V remove(K key){

        // Step1 -> we need to bucket index
        int bucketIndex = getBucketIndex(key);
        int nodeIndex = getNodeIndex(bucketIndex, key);

        if(nodeIndex != -1){
            Node node = this.buckets[bucketIndex].remove();
            return (V) node.value;
        }else{
            System.out.println("Key Not Exists");
            return (V) null;
        }
    }

    // here we will create a method is contains a key
    public boolean containsKey(K key){
        // Step1 -> we need to bucket index
        int bucketIndex = getBucketIndex(key);
        int nodeIndex = getNodeIndex(bucketIndex, key);

        if(nodeIndex != -1){
            return true;
        }else{
            return false;
        }
    }

    // here we will impelent a keySet
    public ArrayList<K> keySet(){
        ArrayList<K> keys = new ArrayList<>();

        for(int i=0; i<buckets.length; i++){
            LinkedList<Node>temp = buckets[i];
            for(int j=0; j<temp.size(); j++){
                keys.add((K) temp.get(j).key);
            }
        }
        return keys;
    }
}
