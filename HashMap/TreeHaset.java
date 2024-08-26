import java.util.*;
public class TreeHaset {

    public static void main(String args[]){
        TreeSet<String>cities = new TreeSet<>();

        // here we will perform add operation
        cities.add("Delhi");
        cities.add("Luckow");
        cities.add("Noida");
        cities.add("Grugram");


        // here we will perform contains
        if(cities.contains("Lucknow")){
            System.out.println("Citi is present in our Set");
        }

        // here we will perform  remove
        cities.remove("Noida");

        // here we will print
        System.out.println(cities);

        // here we wil use size
        System.out.println(cities.size());

        // here we will use clear function
        cities.clear();

        // here we will perform add operation
        cities.add("Delhi");
        cities.add("Luckow");
        cities.add("Noida");
        cities.add("Grugram");

        // here we will create itrator
        Iterator citiIterator = cities.iterator();

        while(citiIterator.hasNext()){
            System.out.println(citiIterator.next());
        }

    }
}
