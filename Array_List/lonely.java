import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;;
public class lonely {
    public static ArrayList find_lonely_number(ArrayList<Integer>arr){
        ArrayList<Integer>lonely = new ArrayList<>();
        Collections.sort(arr);
        for(int i =0; i< arr.size(); i++){
            if(i < arr.size()-1 && arr.get(i+1) == arr.get(i) +1 ){
                continue;
            }
            else if(i < arr.size()-1 && arr.get(i) == arr.get(i+1)){
                continue;
            }
            else if(i > 0 && arr.get(i) == arr.get(i-1)){
                continue;
            }
            else if(i > 0 && arr.get(i-1) == arr.get(i) -1){
                continue;
            }
            else{
                lonely.add(arr.get(i));
            }
        }
        return lonely;
    }
    public static void main(String args[]){
        ArrayList<Integer>list = new ArrayList<>();
        
        Scanner sc = new Scanner(System.in);
        int length_number = sc.nextInt();

        for(int i=0; i<length_number; i++){
            int cur = sc.nextInt();
            list.add(cur);
        }
        ArrayList lonely_numbers = find_lonely_number(list);
        System.out.println(lonely_numbers);
    }
}
