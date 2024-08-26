import java.util.*;
public class LinkedHashset {
    
    public static void main(String args[]){
        
        LinkedHashSet<String> cities = new LinkedHashSet<>();

        // here we will add operation
        cities.add("Delhi");
        cities.add("Mumbai");
        cities.add("Noida");

        // here we will perform  contains
        if(cities.contains("Delhi")){
            System.out.println("City is present");
        
        }
        // here we will perofrm remove
        cities.remove("Noida");

        // here we will size
        System.out.println(cities.size());

        // here we will perform is empty
        System.out.println(cities.isEmpty());
        
        // here we will perfrom  clear
        cities.clear();

         // here we will perform is empty
        System.out.println(cities.isEmpty());

        
         // here we will add operation
        cities.add("Delhi");
        cities.add("Mumbai");
        cities.add("Noida");


        // here we will be itreate using itreator
        Iterator citiItreator = cities.iterator();

        while(citiItreator.hasNext()){
            System.out.println(citiItreator.next());
        }

        // here we will used for loop
        for(String citi: cities){
            System.out.print(citi + ", ");
        }

    }
}
