import java.util.Queue;
import java.util.LinkedList;
public class FirstNon_RepeatingCharacter {
    public static StringBuilder firstNon_RepeatingCharacter(String str, StringBuilder ans){
        // here we define our Queue
        Queue<Character>queue = new LinkedList<>();
        char freq[] = new char[26];
        for(int i =0; i< str.length(); i++){
            // here we will add in our queue
            char currentCharcter = str.charAt(i);
            queue.add(currentCharcter);
            freq[currentCharcter - 'a']++;

            while (!queue.isEmpty()) {
                if(freq[queue.peek() - 'a'] == 1){
                    ans.append(queue.peek());
                    break;
                }
                queue.remove();

            }if(queue.isEmpty()){
                ans.append("-1");
            }
        }
        return ans;
    }
    public static void main(String args[]){
        String str = "aabccxb";
        StringBuilder ans = new StringBuilder();
        ans = firstNon_RepeatingCharacter(str, ans);
        System.out.println(ans);
    }
}
