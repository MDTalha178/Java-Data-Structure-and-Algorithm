// find out all subset
// input "abc" output "a", "b", "c", "ab", "ac", "bc", "abc"

public class subset_of_string {
    public static void printSubet(String str, int i, String ans){
        if(i == str.length()){
            System.out.println(ans);
            return;
        }

        // recusive call
        printSubet(str, i+1, ans+str.charAt(i));
        printSubet(str, i+1, ans);

    }
    public static void main(String[] args) {

        String str = "abc";
        String ans = "";
        printSubet(str, 0, ans);
    }
}
