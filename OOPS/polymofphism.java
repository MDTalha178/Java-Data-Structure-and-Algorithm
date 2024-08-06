public class polymofphism {
    public static void main(String args[]){
        TataAltroz t = new TataAltroz("TATA", true, 120, 123000, 2019, 2034);
        // it will call parent class method
        t.display();
        // now here it will call child class method because of method overloading and we have passed pin as paarameter
        t.display(12);
    }
}

class CarModel{
    int car_model;
    int car_year;
    int car_price;

    CarModel(int car_model, int car_year, int car_price){
        this.car_model = car_model;
        this.car_year = car_year;
        this.car_price = car_price;
    }

    int resell_value(){
        int year_diff = this.car_year - 2024;
        return this.car_price / year_diff;
    }


    public void display(){
        System.out.println("Car model is: " + this.car_model);
        System.out.println("Car Manufacrure year  is: " + this.car_year);
        System.out.println("Car Price is: " + this.car_price);
    }
}
class TataAltroz extends CarModel{
    String company_name;
    Boolean is_sunroof;
    int engine_torque;

    TataAltroz(String company_name, Boolean is_sunroof, int engine_torque, int price, int manufacture_year, int model_year){
        super(manufacture_year, manufacture_year, price);
        this.company_name = company_name;
        this.is_sunroof = is_sunroof;
        this.engine_torque = engine_torque;
    }
    // method over loading
    public void display(int pin){
        if(pin == 1234){
            System.out.println("Car company name is: " + this.company_name);
            System.out.println("Car is having sunroof:" +  (this.is_sunroof ? "Yes" : "No"));
        }else{
            System.out.println("Not Authorized");
        }
    }
}
