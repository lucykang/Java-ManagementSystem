
package HR;

import java.util.*;
import General.ServiceClass;

/**
 *
 * @author Hae Yeon Kang
 */
public abstract class Employee {
    //variables
    private String empID, firstName, lastName, position, contactNum, address;
    private int age;
    private Date hireDate;
    private Calendar empCalendar;
    
    //constructors
    public Employee(){}
    public Employee(String firstName, String lastName, String position, int age, int year, int month, int day){
        this.firstName = firstName.toUpperCase();
        this.lastName = lastName.toUpperCase();
        this.position = position;
        this.empID = (ServiceClass.getEmpID()+"");
        this.age = age;
        this.hireDate = new GregorianCalendar(year, month, day).getTime();
    }
    
    //Accessor Methods
    public String getFirstName(){
        return this.firstName;
    }
    
    public String getLastName(){
        return this.lastName;
    }
    
    public int getAge() {
        return age;
    }
     
    public String getAddress() {
        return address;
    }
    
    public String getContactNum(){
        return this.contactNum;
    }
    
    public String getPosition(){
        return this.position;
    }
    
    public String getEmpID(){
        return this.empID;
    }
    
    public Date getHireDate(){
        return this.hireDate;
    }
    
    public abstract double earnings();
    
    //Mutator Methods
    public boolean setFirstName(String firstName){
        boolean success=true;
        this.firstName = firstName.toUpperCase();
        return success;
    }
    
    public void setLastName(String lastName){
        this.lastName = lastName.toUpperCase();
    }
    
    public boolean setAge(int age){
        boolean success;
        if(age < 18 || age > 65){
            System.out.print("\nThe age should be over 18 and below 65.\n");
            success = false;
        }else{
            this.age = age;
            success = true;
        }
        return success;
    }
    
    public void setAddress(String address){
        this.address = address;
    }
    
    public void setContactNum(String contactNum){
        this.contactNum = contactNum;
    }
    
    public void setPosition(String position){
        this.position = position;
    }
    
    public void setEmpID(String empID){
        this.empID = empID;
    }
    
    public boolean setHireDate(int year, int month, int day){
        boolean success;
        
        if(month<1 || month>12 || day>31 || day<1){
            System.out.print("\nThe month or/and date value is not valid. Please check the date again.\n");
            success = false;
        }else{
            this.empCalendar.set(year, month, day);
            this.hireDate = empCalendar.getTime();
            success = true;
        }
        return success;
    }
    
    @Override
    public String toString(){
        String employeeInfo = "";
        
        employeeInfo += "\nName: \t\t" + getFirstName() + " " + getLastName();
        employeeInfo += "\nID: \t\t" + getEmpID();
        employeeInfo += "\nEmployee Type: \t" + this.getClass().getSimpleName();
        employeeInfo += "\nAge: \t\t" + getAge();
        employeeInfo += "\nPosition: \t" + getPosition();
        employeeInfo += "\nHire-Date: \t" + getHireDate();
        
        return employeeInfo;
    }
    
}
