import java.util.Arrays;
import java.util.Comparator;

public class Indian_Coin {
    public static int getMinimumNotes(Integer notes[], int price){
        int minmumNote = 0;

        // firs we need to sort in decending order
        Arrays.sort(notes, Comparator.reverseOrder());
        for(int i =0; i<notes.length; i++){
            if(notes[i] <= price){
                while (notes[i] <= price) {
                    minmumNote++;
                    price-=notes[i];
                }
            }
        }
        return minmumNote;
    }
    public static void main(String args[]){
        Integer notes[] = {1,2,5,10,20,50,100,500,1000,2000};

        int minmumNotes = getMinimumNotes(notes, 590);

        System.out.println(minmumNotes);
    }
}
