import java.util.HashSet;
import java.util.Iterator;
public class Hashset {
    public static void main(String args[]){
        HashSet<String>cities = new HashSet();

        // here we will add some cities name in set
        cities.add("Delhi");
        cities.add("Mumbai");
        cities.add("Lucknow");

        System.out.println(cities);

        // here we perform contains
        if(cities.contains("Delhi")){
            System.out.println("Citi is present In our set");
        }else{
            System.out.println("Citie is Not present in our Set");
        }

        // here we will perform remove
        cities.remove("Mumbai");

        // here we will use check set is Empty
        System.out.println(cities.isEmpty());

        // here we will delete every thing from set
        cities.clear();

        // here we will use check set is Empty
        System.out.println(cities.isEmpty());


        // here we will add some cities name in set
        cities.add("Delhi");
        cities.add("Mumbai");
        cities.add("Lucknow");
        cities.add("Noida");


        // here we will using itreator to itreate on set
        Iterator setItreator = cities.iterator();

        // here we will use while loop
        while (setItreator.hasNext()) {
            System.out.print(setItreator.next() + " ,");
        }

        System.out.println();

        // here we will use enhance for loop
        for(String citi: cities){
            System.out.print(citi + ", ");
        }


    }
}
