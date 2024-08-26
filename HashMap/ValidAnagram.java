import java.util.HashMap;

public class ValidAnagram {
    public static boolean checkIsValidAnagram(String s1, String s2){

        HashMap<Character, Integer>freq_map = new HashMap<>();

        for(int i =0; i<s1.length(); i++){
            freq_map.put(s1.charAt(i), freq_map.getOrDefault(s1.charAt(i), 0) +1);
        }

        for(int i=0; i<s2.length(); i++){

            if(!freq_map.containsKey(s2.charAt(i))){
                return false;
            }

            if(freq_map.get(s2.charAt(i)) > 1){
                freq_map.put(s2.charAt(i), freq_map.get(s2.charAt(i)) - 1);
            }else{
                freq_map.remove(s2.charAt(i));
            }
        }

        if(freq_map.isEmpty()){
            return true;
        }

        return false;
    }
    public static void main(String args[]){

        // for valid input
        // String s1 = "race";
        // String s2 = "care";

        String s1 = "tulip";
        String s2 = "lipt";

        boolean isvalidAnagram = checkIsValidAnagram(s1, s2);
        System.out.println(isvalidAnagram);
    }
}
