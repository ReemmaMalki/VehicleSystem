package LexusVehicleSystem;

public class Sale extends Vehicle{
    
    private double sell_price, discount,rate;
    
    public Sale(String license_number,String make,String model,double price, double rate){
        super( license_number, make, model, price);
        this.rate=rate;
    }
                
    public double calcPrice(){
        double p=price*(rate/100);
        return price-p;
    }
    
    public String getVehicleName(){
        return make+" "+model;
    }
    
   public  String getLicenseNumber(){
    return license_number;
   }

    public String toString(){
        return "\n\tLicense # : "+getLicenseNumber()+
                "\n\tVehicle Name : " +getVehicleName()+
                "\n\tPrice : "+price+
                "\n\tDiscount rate    :"+getRate()+"%"+
                "\n\tSelling Price    :"+calcPrice()
                +"\n-----------------------------------------------------";    
    }
  
    public double getRate(){
        return rate;
    }

    @Override
    public int compareTo(Vehicle v) {
        return this.license_number.compareTo(v.license_number);
    }
   

   
   
  
        
}
