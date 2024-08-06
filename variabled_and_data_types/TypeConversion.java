public class TypeConversion{
    public static void main(String args[]){
        // here we will convert int to float
        int a = 12;
        float b = (float) a;
        System.out.println("Conversion from int into float: " + b);

        // here we will convert float to int
        float c = 12.034f;
        int d = (int) c;
        System.out.println("Conversion from float to int: " + d);

        // here we convert from ch to int
        char ch = 'a';
        int e = ch;
        System.out.println(e);
    }
}