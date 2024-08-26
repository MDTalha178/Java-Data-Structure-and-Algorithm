import java.util.*;;
public class UnionAndIntersetionCount {
    public static int getUnionCount(int arr1[], int arr2[]){

        // here we will define our HastSet
        HashSet<Integer>unionSet = new HashSet<>();

        for(int i=0; i<arr1.length; i++){
            unionSet.add(arr1[i]);
        }

        for(int i=0; i<arr2.length; i++){
            unionSet.add(arr2[i]);
        }

        return unionSet.size();

    }

    public static int getIntersectionCount(int arr1[], int arr2[]){
        // here we will define our HastSet
        HashSet<Integer>unionSet = new HashSet<>();

        int intersectionCount = 0;
        for(int i=0; i<arr1.length; i++){
            unionSet.add(arr1[i]);
        }

        for(int j=0; j<arr2.length; j++){

            if(unionSet.contains(arr2[j])){
                intersectionCount++;
                unionSet.remove(arr2[j]);
            }
        }
        return intersectionCount;

    }
    public static void main(String args[]){
        int arr1[] = {7,3,9};
        int arr2[] = {6,3,9,2,9,4};

        // here we will calculate union count
        int unionCount = getUnionCount(arr1, arr2);

        // here we will calculate intersection  count
        int intersectionCount = getIntersectionCount(arr1, arr2);

        System.out.println("Union Count is " + unionCount);

        System.out.println("Intersection Count is "+ intersectionCount);
    }
}
