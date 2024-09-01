import java.util.*;
public class GrpupAanagram {
    public static void main(String args[]){

        String str[] = {"eat","tea","tan","ate","nat","bat"};
        HashMap<String, ArrayList<String>>haspMap = new HashMap<>();

        // Step 1 iterate over the string of array
        for(int i =0; i<str.length; i++){

            String currentString =  str[i];

            // step 2 -> break into a char of current string
            char charAaray[] = currentString.toCharArray();

            // step 3 -> sort this char array
            Arrays.sort(charAaray);

            // Step 4 -> convert into string of sorted char
            String sorted = new String(charAaray);

            // check this key is present in our map or not
            if(!haspMap.containsKey(sorted)){
                haspMap.put(sorted, new ArrayList<String>());
            }
            // add this key
            haspMap.get(sorted).add(str[i]);

        }
        System.out.println(haspMap.values());

    }
}
