import java.util.*;;
public class JourneyFromTickets {
    public static String getStartedPoint(HashMap<String, String>tickets){

        // here we store to from destination
        HashMap<String, String>tojourney =  new HashMap<>();

        for(String key: tickets.keySet()){
            tojourney.put(tickets.get(key), key);
        }

        // now here we need to check which destination not in hashmap
        for(String key: tickets.keySet()){
            if(!tojourney.containsKey(key)){
                return key;
            }
        }
        return null;
    }
    public static void getJourney(HashMap<String, String>ticket){

        // step 1-> we need to find the starting destination
        String startingDestination = getStartedPoint(ticket);
        System.out.print(startingDestination);
        if(startingDestination != null){
            for(String key: ticket.keySet()){
                System.out.print("-> "+ticket.get(startingDestination));
                startingDestination = ticket.get(startingDestination);
            }
        }else{
            System.out.println("There is no route for tickets ");
        }
    }
    public static void main(String args[]){

        HashMap<String, String> ticktes = new HashMap<>();

        // here we will add ticlets
        ticktes.put("Chennai", "Bengalore");
        ticktes.put("Mumbai", "Delhi");
        ticktes.put("Goa", "Chennai");
        ticktes.put("Delhi", "Goa");

        getJourney(ticktes);
    }
}
