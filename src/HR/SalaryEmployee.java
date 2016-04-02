
package HR;

/**
 *
 * @author Hae Yeon Kang
 */
public class SalaryEmployee extends Employee{
    //variables
    private double salaryRate, bonus;
    
    
    //constructor
    public SalaryEmployee(){}
    public SalaryEmployee(String firstName, String lastName, String position, 
                    int age, int year, int month, int day, double salaryRate, double bonus){
        super(firstName, lastName, position, age, year, month, day);
        setEmpID("S"+getEmpID());
        this.salaryRate = salaryRate;
        this.bonus = bonus;
    }
    
    //methods
    //Accessor Methods
    public double getSalaryRate(){
        return this.salaryRate;
    }
    public double getBonus(){
        return this.bonus;
    }
    
    //Mutator Methods
    public boolean setSalaryRate(double salaryRate){
        boolean success;
        if(salaryRate >= 0.0){
            this.salaryRate = salaryRate;
            success = true;
        }else{
            System.out.print("\nSalary rate cannot be negative value.\n");
            success = false;
        }
        return success;
    }
    public boolean setBonus(double bonus){
        boolean success;
        if(bonus >= 0.0){
            this.bonus = bonus;
            success = true;
        }else{
            System.out.print("\nBonus cannot be negative value.\n");
            success = false;
        }
        return success;  
    }
    
    public double calculateTotalSalary(){
        return getSalaryRate()+getBonus();
    }
    
    @Override
    public double earnings(){
        return calculateTotalSalary();
    }
    
    @Override
    public String toString(){
        return super.toString()
        + "\nMonthly Salary: \t\t" + getSalaryRate()
        + "\nBonus: \t\t" + getBonus()
        + "\nTotal Earning: \t\t" + earnings();
    }
}
