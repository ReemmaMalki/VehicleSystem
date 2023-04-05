package LexusVehicleSystem;

public class Customer {
    
    private char gender;
    private String name, nationality;
    private int phone, rental_days;
    int id;
    
    public Customer(int id,String name,String nationality,char gender,int phone){
        this.id=id;
        this.name=name;
        this.nationality=nationality;
        this.gender=gender;
        this.phone=phone;
    }
    
    public String getName(){
        return name;
    }
    
    public void setName(String name){
        this.name=name;
    }
    
    public int getId(){
        return id;
    }
    
    public void setId(int id){
        this.id=id;
    }
    
    public String getNationality(){
        return nationality;
    }
    
    public void setNationality(String nationality){
        this.nationality=nationality;
    }
    
    public char getGender(){
        return gender;
    }
    
    public void setGender(char gender){
        this.gender=gender;
    }
    
    public int getRentalDays(){
        return rental_days;
    }
    
    public void setRentalDays(int rental_days){
        this.rental_days=rental_days;
    }
    
    public int getPhone(){
        return phone;
    }
    
    public void setPhone(int phone){
        this.phone=phone;
    }
    
    public String toString(){
        return 
               "Add a new Customer record in the System"+"\n\tID: "+getId()+"\n\tName: "+getName()+
                "\n\tNationality : "+getNationality()+"\n\tGender: "+getGender()
                +"\n\tPhone: "+getPhone()+
                "\n\n--------------------------------------------------------------------------";
    }
}
