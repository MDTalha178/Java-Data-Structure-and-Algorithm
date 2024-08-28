import java.util.*;;
public class SortByFrequency {
    public static StringBuilder getInSortedOrder(String s1){

        TreeMap<Character, Integer>freq_count =  new TreeMap<>(Collections.reverseOrder());

        for(int i=0; i<s1.length(); i++){
            freq_count.put(s1.charAt(i), freq_count.getOrDefault(s1.charAt(i), 0) + 1);
        }

        PriorityQueue<Map.Entry<Character, Integer>>pq = new PriorityQueue<>(
            (a,b) -> a.getValue() == b.getValue() ? a.getKey() - b.getKey() : b.getValue() - a.getValue());
        
        for(Map.Entry<Character, Integer>e:freq_count.entrySet()) pq.add(e);


        StringBuilder ans = new StringBuilder();
        while (pq.size() !=0) {
            char ch = pq.poll().getKey();
            int val = freq_count.get(ch);

            while (val != 0) {
                ans.append(ch);
                val--;
            }
        }
        return ans;


    }
    public static void main(String args[]){
        String s1 = "aacccccb";

        StringBuilder ans  = getInSortedOrder(s1);
        System.out.println(ans);
    }
}
