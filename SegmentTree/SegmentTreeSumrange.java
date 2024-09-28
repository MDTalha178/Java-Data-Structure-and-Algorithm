public class SegmentTreeSumrange{

    public static int constructSegmentTree(int arr[], int setgmentTree[], int segmentIdx, int start, int end){

        if(start >= end){
            setgmentTree[segmentIdx] = arr[start];
            return setgmentTree[segmentIdx];
        }

        int mid =(start + end) / 2;
        int left = constructSegmentTree(arr, setgmentTree, 2*segmentIdx+1, start, mid);
        int right = constructSegmentTree(arr, setgmentTree, 2*segmentIdx+2, mid+1, end);

       return  setgmentTree[segmentIdx] = left + right;
    }

    private static int getSumUtil(int arr[], int setgmentTree[], int i, int si, int sj, int qi, int qj){

        // check condition for non lapping or query not in range
        if(si > qj || sj < qi){
            return 0;
        }
        // lapping condtion
        else if(si >= qi && sj <= qj){
            return setgmentTree[i];
        }else{
            // partial lapping condition
            int mid = (si + sj) /2;
            int left = getSumUtil(arr, setgmentTree, 2*i+1, si, mid, qi, qj);
            int right = getSumUtil(arr, setgmentTree, 2*i+2, mid+1, sj, qi, qj);
            return setgmentTree[i] =  right + left;

        }
    }

    public static int getSum(int arr[], int setgmentTree[], int qi, int qj){

        int n = arr.length;
        return getSumUtil(arr, setgmentTree, 0, 0, n-1, qi, qj);
    }

    public static void updateUtils(int setgmentTree[], int i, int si, int sj, int idx, int diff){

        //  check is this out of ranage
        if(idx > sj || idx< si){
            return;
        }
        setgmentTree[i] += diff;
        if(si != sj){
            int mid = (si + sj)/2;
            updateUtils(setgmentTree, 2*i+1, si, mid, idx, diff);
            updateUtils(setgmentTree, 2*i+2, mid+1, sj, idx, diff);
        }

    }

    public static void updateQuery(int arr[], int setgmentTree[], int idx, int newVal){
        int n = arr.length;
        int diff = newVal - arr[idx];
        arr[idx] = newVal;
        updateUtils(setgmentTree, 0, 0, n-1, idx, diff);
    }

    public static void main(String args[]){
        int arr[] = {1,2,3,4,5,6,7,8};
        int n = arr.length;
        int setgmentTree[] = new int[n*4];

        constructSegmentTree(arr, setgmentTree, 0, 0, n-1);

        for(int i =0; i<setgmentTree.length; i++){
            System.out.print(setgmentTree[i] + " ");
        }

        System.out.println();

        int sum = getSum(arr, setgmentTree, 2,5);
        System.out.println(sum);
        updateQuery(arr, setgmentTree, 2, 2);

        for(int i =0; i<setgmentTree.length; i++){
            System.out.print(setgmentTree[i] + " ");
        }
        System.out.println();
        sum = getSum(arr, setgmentTree, 2,5);
        System.out.println(sum);
    }
}