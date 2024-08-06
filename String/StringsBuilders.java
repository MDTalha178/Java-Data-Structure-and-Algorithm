public class StringsBuilders{
    public static void main(String args[]){
        StringBuilder sb = new StringBuilder("HELLO WORLD");
        System.out.println(sb);

        // generate a to z alphabet
        StringBuilder alpha = new StringBuilder();
        for(char i ='a'; i<='z'; i++){
            alpha.append(i);
        }
        System.out.println(alpha);
    }
}