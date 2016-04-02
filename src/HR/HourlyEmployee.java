
package HR;

/**
 *
 * @author Hae Yeon Kang
 */
public class HourlyEmployee extends Employee{
    //variables
    private double hourlyRate, numOfHour;
    
    //constructor
    public HourlyEmployee(){}
    public HourlyEmployee(String firstName, String lastName, String position, 
                    int age, int year, int month, int day, double hourlyRate, double numOfHour){
        super(firstName, lastName, position, age, year, month, day);
        setEmpID("H"+getEmpID());
        this.hourlyRate = hourlyRate;
        this.numOfHour = numOfHour;
    }
    
    //Accessor Methods
    public double getHourlyRate(){
        return this.hourlyRate;
    }
    public double getNumOfHour(){
        return this.numOfHour;
    }
    
    //Mutator Methods
    public boolean setHourlyRate(double hourlyRate){
        boolean success;
        if(hourlyRate >= 0.0){
            this.hourlyRate = hourlyRate;
            success = true;
        }else{
            System.out.print("\nHourly rate cannot be under $0.00.\n");
            success = false;
        }
        return success;
    }
    public boolean setNumOfHour(double numOfHour){
        boolean success;
        if(numOfHour >= 0.0){
            this.numOfHour = numOfHour;
            success = true;
        }else{
            System.out.print("\nNumber of hours worked cannot be negative value.\n");
            success = false;
        }
        return success;
        
    }
    
    public double calculateWages(){
        return hourlyRate * numOfHour;
    }
    
    @Override
    public double earnings(){
        return calculateWages();
    }

    @Override
    public String toString(){
        return super.toString()
        + "\nHourly Rate: \t\t" + getHourlyRate()
        + "\nNumber of Hours worked: \t\t" + getNumOfHour()
        + "\nTotal Earning: \t\t" + earnings();
    }
}
