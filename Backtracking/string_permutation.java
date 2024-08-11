public class string_permutation {
    public static void printpermutation(String str, String ans){
        
        // base case
        if(str.length() == 0){
            System.out.println(ans);
            return;
        }

        // recursive call
        for(int j =0; j< str.length(); j++){
            char cur = str.charAt(j);
            String new_sub_string = str.substring(0, j) + str.substring(j+1);
            printpermutation(new_sub_string, ans+cur);
        }
    }
    public static void main(String[] args) {
        String str = "bca";
        String ans = "";
        printpermutation(str, ans);
    }
}
