package LexusVehicleSystem;


public abstract class Vehicle implements Comparable<Vehicle>{
    
    protected String license_number,make,model;
    protected double price;
    
    public Vehicle(String license_number,String make,String model,double price){
        this.license_number=license_number;
        this.make=make;
        this.model=model;
        this.price=price;
     }
    
   public  String getVehicleName(){
        return make+" "+model; 
   }
   
   public abstract String getLicenseNumber();
   
   public abstract double calcPrice();
   
   public String toString(){
       return "\n\n\tlicense # : "+license_number+" \n\tVehicle Name : "+
               getVehicleName()+"\n\tPrice : "+price;
   }
}
