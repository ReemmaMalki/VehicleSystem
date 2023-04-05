package LexusVehicleSystem;

import LexusVehicleSystem.Customer;

public class Rental extends Vehicle{
    
    protected double rate_per_day;
    protected Customer []rentedTo;
    protected int currentCustomerNo=0;       
    
    public Rental(String license_number,String make,String model,double price,double rate_per_day,int max){
        super( license_number, make, model, price);
        this.rate_per_day=rate_per_day;
        rentedTo= new Customer[max];
     }
    
    public int getMax(){
        return rentedTo.length;
    }
  
    public Customer[] getCustomer(){
        
        return rentedTo;
    } 
    
    public double getRPD(){
       return rate_per_day;
    }
   
    public int getCurrentCustomerNo(){
        return currentCustomerNo;
    }
     
    @Override
    public double calcPrice() {
        double i=0;
        currentCustomerNo--;
        if(getCustomer()[currentCustomerNo]!=null){
             i=getCustomer()[currentCustomerNo].getRentalDays()*getRPD();
         }
     return i;
    }
    
    public String toString(){
        
       return "Add a new vehicles for rent in the System"+
                "\n\n\tlicense # : "+getLicenseNumber()+" \n\tVehicle Name : "+
                getVehicleName()+"\n\tPrice : "+price+"\t\tRate per day: " +getRPD()+"\n--------------------------------------------------------------------------";
                      
    }
    
    @Override
    public String getLicenseNumber() {
        return license_number;
    }

    @Override
    public int compareTo(Vehicle v) {
         return this.license_number.compareTo(v.license_number);
               }
    
    public void addCustomer(Customer c,int numOfDays){
        getCustomer()[currentCustomerNo]=c;
        c.setRentalDays(numOfDays);
        currentCustomerNo++;
    }
}
