import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

class Hashmap_Operation{
    public static void main(String args[]){

        // here we will create Hashmap
        HashMap<String, Integer>haspMap = new HashMap<>();

        // here we will perform put operation it will add key and value in my Hashmap
        Scanner sc = new Scanner(System.in);

        boolean isInsertionCompleted = false;

        while (!isInsertionCompleted) {

            // here we will take a input key from user
            System.out.print("Enter Key to be insert In Map ");
            String key = sc.next();

            // here we will take input value for key from user
            System.out.println("Enter a value for " + key);
            Integer value = sc.nextInt();

            haspMap.put(key, value);

            System.out.println("Want to add more key type 'Yes' else ''No ");
            String should_add_more_key = sc.next();
            System.out.println(should_add_more_key);
            if(should_add_more_key.equals("No")){
                System.out.println("Your key Added sucessfully! ");
                isInsertionCompleted = true;
            }

        }

        // here we will print our Hashmap
        System.out.println(haspMap);

        // here we will get value with the help of key
        System.out.println(haspMap.get("India"));

        // here we will check haspmap contains that key or not
        System.out.println(haspMap.containsKey("India"));
        System.out.println(haspMap.containsKey("Saudi"));

        // here we will remove  a key
        System.out.println(haspMap.remove("India"));
        System.out.println(haspMap.containsKey("India"));

        // here get all keys
        Set<String>keys = haspMap.keySet();
        
        // iteration on Hashmap
        for (String key : keys) {
            System.out.println(key + ":" + haspMap.get(key));
        }
    }
}