import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

public class Fractional_Knapsack {
    public static int getMaxProfit(int price[], int weight[], int capacity){
        int maxProfit =0;
        double ratio[][] = new double[price.length][2];
        
        // here we will find our ratio
        for(int i = 0; i<price.length; i++){
            ratio[i][0] = i;
            ratio[i][1] = price[i]/(double) weight[i];
        }
        
        // here we will sort based on ratio
        Arrays.sort(ratio, Comparator.comparingDouble(o -> o[1])); 

        // here we will traverse from last
        for(int i = ratio.length-1; i>=0; i--){
            int idx = (int) ratio[i][0];
            if(capacity >= weight[idx]){
                maxProfit+=price[idx];
                capacity-=weight[idx];
            }else{
                maxProfit += (ratio[i][1] * capacity);
                capacity = 0;
                break;

            }
        }
        return maxProfit;
    }
    public static void main(String args[]){
        int price[] = {60,100,120};
        int weight[] = {10,20,30};

        int max_profit = getMaxProfit(price, weight, 50);
        System.out.println(max_profit);

    }
}
