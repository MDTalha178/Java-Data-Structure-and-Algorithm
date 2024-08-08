import java.util.Arrays;

public class Maximum_Absolute {
    public static int getMinimumDiff(int a[], int b[]){
        // first we need to sor this array
        Arrays.sort(a);
        Arrays.sort(b);

        int minDiffrence = 0;
        for(int i =0; i< a.length; i++){
            minDiffrence += Math.abs(a[i] - b[i]);
        }
        return minDiffrence;
    }
    public static void main(String args[]){
        int a[] = {1,2,3};
        int b[] = {2,3,3};

        int minDiffrence = getMinimumDiff(a, b);
        System.out.println(minDiffrence);
    }
}
