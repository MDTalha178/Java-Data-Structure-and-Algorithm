import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Maximum_ChainPair {
    public static int getMaximumChainPair(int arr[][]){
        int maximum_pair = 0;

        Arrays.sort(arr, Comparator.comparingDouble(o->o[1]));
        ArrayList<Integer>ans = new ArrayList<>();

        int last_pair = arr[0][1];
        ans.add(0);
        maximum_pair++;
        for(int i =1; i< arr.length; i++){
            if(arr[i][0] > last_pair){
                ans.add(i);
                maximum_pair++;
                last_pair = arr[i][1];
            }
        }
        return maximum_pair;
    }
    public static void main(String args[]){
        int pairs[][] = {{5,24}, {39,60}, {5,28}, {27,40}, {50, 90}};
        int maximumChainPair = getMaximumChainPair(pairs);

        System.out.println(maximumChainPair);

    }
}
