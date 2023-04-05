package LexusVehicleSystem;

import java.io.*;
import java.util.*;

public class DAR2005477P3_VehicleSystem  {

    
    public static void main(String[] args) throws Exception {
        
        File inputfile =new File("input2.txt");
        Scanner input=new Scanner(inputfile);
        
        if(!inputfile.exists()){
            System.out.println("The File: "+inputfile.getName()+" does not exist");
            System.exit(0);}
        
        File outputfile=new File("output2.txt");
        PrintWriter output=new PrintWriter(outputfile);
        
        Vehicle[] v=new Vehicle[input.nextInt()];
        Customer[]c=new Customer[input.nextInt()];
        
        int vn=0,cn=0;
        String command;
        output.print("--------------- Welcome to Lexus ---------------\n");
        output.flush();
        int lindix=-1, idindix=-1; boolean ret1=false,ret2=false;
        
        
        do{
            
            command=input.next();
            
            if(command.equalsIgnoreCase("Add_Customer_Record")){
                output.print("\nCommand Add_Customer: ");
                c[cn]=addC(input);
                output.print(c[cn].toString());
                cn++; 
                output.flush();
             }
            
            if(command.equalsIgnoreCase("Add_Rental")){
                output.print("\n\nCommand "+command+": ");
                v[vn]=addR(input);
                output.print(v[vn].toString());
                 vn++;
                 output.flush();
            }
            
            if (command.equalsIgnoreCase("Add_Sale")){
                output.print("\nCommand "+command+": ");
                v[vn]=addS(input);
                 output.print(" Add a new new vehicles for sale in the System\n\n\tLicense # : "+v[vn].getLicenseNumber() +"\n\tVehicle Name : "+v[vn].getVehicleName() +
                "\n\tPrice : "+v[vn].price+ "\n\tDiscount rate	: "+ ((Sale)v[vn]).getRate()+"% \n\tSelling Price 	: "+ v[vn].calcPrice() +
                "\n--------------------------------------------------------------------------\n" );
                vn++;
                output.flush();
            }
            
            if(command.equalsIgnoreCase("Ass_Customer_to_Rent")){
                output.print("\nCommand: "+command+": A  Customer rent a vehicle ");
                
                String licence=input.next();
                int id=input.nextInt();
                int nd=input.nextInt();
                  
                int rentInd=searchLice(licence,v);
                int custInd= searchId( id,c);
                
                if(rentInd==-1){
                    output.println("\nVehicle Not found:  "+licence);
                    output.flush();
                  }
                
                else if(custInd==-1){
                    output.println("\nCustomer Not found: "+id);
                    output.flush();
                  }
                 
                else if(rentInd!=-1 && custInd!=-1){
                    int noc=(int)(((Rental)v[rentInd]).getCurrentCustomerNo());
                    int max=(int)((((Rental)v[rentInd]).getCustomer()).length);
                 
                        if(noc<max){
                             ((Rental)v[rentInd]).addCustomer(c[custInd],nd);
                             output.print("\nCustomer: "+c[custInd].getId()+"	Rents Vehicle :    "+v[rentInd].getLicenseNumber());
                             output.flush();
                        }
                  
                        else { 
                             output.println("\nThis vehicle reaches the max number of rent: "+licence);
                             output.flush();
                        }
                }
                
                  output.print("\n--------------------------------------------------------------------------"); 
                  output.flush();
                   
            }
            
           if (command.equalsIgnoreCase("Print_Rental")){
                 output.print("\nCommand: "+command+"\n\n==================================================================" );
                 output.flush();
                 String second=null;
                 String first=null,third=null;
                 
                 
                int finalIndex=searchNull(v);
                Arrays.sort(v,0,finalIndex);
                for(int i=0;i<v.length;i++){
                     if(v[i] instanceof Rental){
                        first= "\n\n\tLicense # : "+v[i].getLicenseNumber()+
                         "\n\tVehicle Name : " +v[i].getVehicleName()+
                         "\n\tPrice : "+v[i].price+"   Rate per day: "+((Rental)v[i]).getRPD()
                         +"\n--------------"+  "\n\n\tRented to: \n";
                         output.print(first);
                         output.flush();
                        int o=0;
                        for(int j=0;j<((Rental)v[i]).getCustomer().length;j++){
                             if(((Rental)v[i]).getCustomer()[j]!=null){
                                 second= "\n\tCustomer # "+ o + "   ID: "+((Rental)v[i]).getCustomer()[j].getId()+
                                "\tNumber of Days: "+((Rental)v[i]).getCustomer()[j].getRentalDays()+
                                "\tPrice: "+((Rental)v[i]).calcPrice();
                                output.print(second);
                                output.flush();
                     }
                    
                            else {
                             second= "\tNo body";
                             output.print(second);
                             output.flush();
                             break;
                    }
                
                 }
                    output.print("\n--------------------------------------------------------------------------------");
              }
                
                    output.flush();
           }
     }
                  
            if(command.equalsIgnoreCase("Print_Sale")){
                 output.print("\n\nCommand: "+command+"\n\n=================================================================="
                        ); 
                 output.flush();
                 int finalIndex=searchNull(v);
                 Arrays.sort(v,0,finalIndex);
                 for(int i=0;i<v.length;i++){
                      if(v[i] instanceof Sale)
                         output.print(v[i].toString());
                         output.flush();
            }
       }
            
           if (command.equalsIgnoreCase("Quit")){
                output.print("\n\nThank you for using Lexus System, Good Bye!");
                output.flush();
            }      
                  
            
        } while(input.hasNext());
        
        input.close();
        output.flush();
        output.close();
    }

    
//==============================================================================
    
    public static Customer addC(Scanner input){
                int id=input.nextInt();
                String name=input.next();
                String nationality=input.next();
                char gender=input.next().charAt(0);
                int phone=input.nextInt();
                
                Customer newc=new Customer(id,name,nationality,gender,phone);
                return newc;
    }

//==============================================================================
    
    public static Vehicle addR(Scanner input){
            String licence=input.next();
                String make=input.next();
                String model=input.next();
                double price=input.nextDouble();
                double rpd=input.nextDouble();
                int max=input.nextInt();
                
                Vehicle newr=new Rental(licence,make,model,price,rpd,max);
                return newr;
    }
    
//==============================================================================
    
    public static Vehicle addS(Scanner input){
        String licence=input.next();
                String make=input.next();
                String model=input.next();
                double price=input.nextDouble();
                double rate=input.nextDouble();
                Vehicle news=new Sale(licence,make,model,price,rate);
                return news;
    }
    
//==============================================================================
    
    public static int searchLice(String licence,Vehicle[]v){
        int index = -1;
        
        for (int i = 0; i < v.length; i++) {
            
            if (v[i]!=null){
                
                 if(v[i] instanceof Rental){
            
                     if (v[i].getLicenseNumber().equalsIgnoreCase(licence)) {
                         index= i;
                        }
                     }
               }
        }
        return index;
    }
    
//==============================================================================
    
        public static int searchId(int id,Customer []c){
        int index = -1;
        for (int i = 0; i < c.length; i++) {
            
            if (c[i]!=null){
                
                 if (c[i].getId()== id) {
                index= i;
                }
          
            }
        }
        return index;
    }
        
//==============================================================================
        
    public static int searchNull(Object []o)  {
        int index=0;
        for (int i=0;i<o.length;i++){
            if (o[i]==null){
                index=i;
                break;
            }
        }
        return index;
    }  
    
//==============================================================================
    
}


