
package Inventory;

/**
 *
 * @author Hae Yeon Kang
 */
public class Manufacturer {
    //variabels
    private String manufacturerName, address, phoneNum, contact;
    
    public Manufacturer(){}
    //overload constructure
    public Manufacturer(String manufacturerName, String address, String phoneNum, String contact){
        this.manufacturerName = manufacturerName;
        this.address = address;
        this.phoneNum = phoneNum;
        this.contact = contact;
    }
    
    //Accessor Methods
    public String getManufacturerName(){
        return this.manufacturerName;
    }
    
    public String getAddress(){
        return this.address;
    }
    
    public String getPhoneNum(){
        return this.phoneNum;
    }
    
    public String getContact(){
        return this.contact;
    }
    
    //Mutator Methods
    public void setManufacturerName(String manufacturerName){
        this.manufacturerName = manufacturerName.toUpperCase();
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
    
    @Override
    public String toString(){
        String manufacturerInfo = " * * * * * * Manufacturer Information * * * * * *";
        
        manufacturerInfo += "\nName: \t\t" + getManufacturerName();
        manufacturerInfo += "\nAddress: \t" + getAddress();
        manufacturerInfo += "\nContact Number: " + getPhoneNum();
        manufacturerInfo += "\nContact Name: \t" + getContact() + "\n";
        
        return manufacturerInfo;
    }
}
