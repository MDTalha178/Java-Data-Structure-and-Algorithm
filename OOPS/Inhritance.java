public class Inhritance {
    public static void main(String args[]){
        TataSafari ts = new TataSafari( "TATA", false, 12, 1780000, 2022, 2024, "White");
        ts.get_cardetails();
        
    }
}

class CarDetails{
    int manufacture_year;
    int model_year;
    String color;

    CarDetails(int manufacture_year, int model_year, String color){
        this.manufacture_year = manufacture_year;
        this.model_year = model_year;
        this.color = color;
    }

}

class TataSafari extends CarDetails{
    String company_name;
    Boolean is_sunroof;
    int engine_torque;
    int price;

    TataSafari(String company_name, Boolean is_sunroof, int engine_torque, int price, int manufacture_year, int model_year, String color){
        // calling base class constructor using super keyword
        super(manufacture_year, model_year, color);
        this.company_name = company_name;
        this.is_sunroof = is_sunroof;
        this.engine_torque = engine_torque;
        this.price = price;
    }

    void get_cardetails(){
        System.out.println("Car model is: " + this.model_year);
        System.out.println("Car Manufacrure year  is: " + this.manufacture_year);
        System.out.println("Car color is: " + this.color);
        System.out.println("Car name is: " + this.company_name);
        System.out.println("Car is having sunroof:" +  (this.is_sunroof ? "Yes" : "No"));
        System.out.println("Engine torque is: "+  this.engine_torque);
        System.out.println("Car Price is: "+ this.price);
    }

}
