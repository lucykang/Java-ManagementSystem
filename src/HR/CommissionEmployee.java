
package HR;

/**
 *
 * @author Hae Yeon Kang
 */
public class CommissionEmployee extends Employee {
    //variables
    private double commissionRate, grossSales, salesTarget;
    
    //constructors
    public CommissionEmployee(){}
    public CommissionEmployee(String firstName, String lastName, String position, int age, int year, int month, int day, double commissionRate, double grossSales, double salesTarget){
        super(firstName, lastName, position, age, year, month, day);
        setEmpID("C"+getEmpID());
        this.commissionRate = commissionRate;
        this.grossSales = grossSales;
        this.salesTarget = salesTarget;
    }
    
    //Methods
    //Accessor Methods
    public double getCommissionRate(){
        return this.commissionRate;
    }
    
    public double getGrossSales(){
        return this.grossSales;
    }
    
    public double getSalesTarget(){
        return this.salesTarget;
    }

    //Mutator Methods
    public boolean setCommissionRate(double commissionRate) {
        boolean success;
        if(commissionRate>0.0 && commissionRate<1.0){
            this.commissionRate = commissionRate;
            success = true;
        }else{
            System.out.print("\nThe value is not valid. The rate should be between 0.0 and 1.0.\n");
            success = false;
        }   
        return success;
    }

    public boolean setGrossSales(double grossSales) {
        boolean success;
        if(grossSales >= 0.0){
            this.grossSales = grossSales;
            success = true;
        }else{
            System.out.print("\nGross Sales cannot be under $0.00.\n");
            success = false;
        }
        return success;
    }

    public boolean setSalesTarget(double salesTarget) {
        boolean success;
        if(salesTarget >= 0.0){
            this.salesTarget = salesTarget;
            success = true;
        }else{
            System.out.print("\nSales Target cannot be under $0.00.\n");
            success = false;
        }
        return success;
    }
    
    public double calculateCommission(){
        return grossSales * commissionRate;
    }
    
    @Override
    public double earnings(){
        return calculateCommission();
    }
    
    @Override
    public String toString(){
        return super.toString()
        + "\nCommission Rate: \t" + getCommissionRate()
        + "\nGross Sales: \t\t" + getGrossSales()
        + "\nSales Target: \t\t" + getSalesTarget()
        + "\nTotal Earning: \t\t" + earnings();
    }
    
}
