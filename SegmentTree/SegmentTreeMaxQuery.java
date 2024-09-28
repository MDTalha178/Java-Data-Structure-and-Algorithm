public class SegmentTreeMaxQuery {

    public static void buildSegmentTree(int arr[], int i, int segmentTree[] ,int start, int end){

        if(start >= end){
            segmentTree[i] = arr[start];
            return;
        }
        int mid = (start + end) / 2;
        buildSegmentTree(arr, 2*i+1,segmentTree, start, mid);
        buildSegmentTree(arr,2*i+2, segmentTree, mid+1, end);

        segmentTree[i] = Math.max(segmentTree[2*i+1], segmentTree[2*i+2]);
    }

    private static int getMaximumRangeUtils(int arr[], int segmentTree[], int idx, int si, int sj, int qi, int qj){

        // base check query in Range or not
        if(qi < si || qj > sj){
            return Integer.MIN_VALUE;
        }
        else if(qi >= si  && qj <=sj){
            return segmentTree[idx];
        }else{
            int mid = (si + sj)/2;
            int left = getMaximumRangeUtils(arr, segmentTree, 2*idx+1, si, mid, qi, qj);
            int right = getMaximumRangeUtils(arr, segmentTree,  2*idx+2, mid+1, sj, qi, qj);
            return Math.max(left, right);
        }
    }

    public static void  updateQueryUtils(int segmentTree[], int i, int si, int sj, int idx, int newVal){

        // check query In range or not
        if(idx < si || idx > sj){
            return;
        }
        segmentTree[i] = Math.max(segmentTree[i], newVal);
        if(si != sj){
            int mid = (si + sj)/2;
            updateQueryUtils(segmentTree, 2*i+1, si, mid, idx, newVal);
            updateQueryUtils(segmentTree, 2*i+2, mid+1, sj, idx, newVal);
    }
        }
        

    public static int getMaximumRange(int arr[], int segmentTree[], int qi, int qj){
        int n = arr.length;
        return getMaximumRangeUtils(arr, segmentTree, 0, 0, n-1, qi, qj);
    }

    private static void updateQuery(int arr[], int segmentTree[], int idx, int newVal){
        arr[idx] = newVal;
        updateQueryUtils(segmentTree, 0, 0, arr.length -1, idx, newVal);
    }
    
    public static void main(String args[]){
        int arr[] = {6, 8,-1,2,17,1,3,2,4};
        int n = arr.length;
        int segmentTree[] = new int[n * 4];

        buildSegmentTree(arr, 0,segmentTree, 0, n-1);

        int maxRangeQusery = getMaximumRange(arr, segmentTree, 2, 5);
        System.out.println(maxRangeQusery);
        updateQuery(arr, segmentTree, 2, 20);
        maxRangeQusery = getMaximumRange(arr, segmentTree, 2, 5);
        System.out.println(maxRangeQusery);
    }
}
