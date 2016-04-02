
package General;

import HR.*;
import Inventory.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 *
 * @author Hae Yeon Kang
 */
public class LKCompany {

    public static void main(String[] args) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Scanner scan = new Scanner(System.in);
        scan.useDelimiter("\\n");

        //for employee registration
        Calendar cal = new GregorianCalendar();
        ArrayList<Employee> employees = new ArrayList<>();
        
        //for product registration
        ArrayList<Product> products = new ArrayList<>();
        ArrayList<Manufacturer> manufacturers = new ArrayList<>();
        
        Boolean exit = true;
        while(exit){
            //main menu interface
            System.out.print(
                    "\n * * * * * * * * Main Menu * * * * * * * * * \n"
                    + "1.Employee Registration\n"
                    + "2.Product Registration\n"
                    + "3.Search Employee\n"
                    + "4.Search Product\n"
                    + "5.Exit\n"
                    + "\nYour selection: ");
            int selection = scan.nextInt();

            switch (selection) {
                case 1://1.Employee Registration
                    //variables
                    String firstName, lastName, position, hireDateString;
                    int age, year, month, day;
                    Date hireDate;

                    //ask user to choose what type of employee they want to register
                    System.out.print("\nPlease select an employee type.\n1.Commission\n2.Hourly\n3.Salary\n\nYour Selection: ");
                    int employeeTypeSelection = scan.nextInt();

                    System.out.print("\nPlease enter employee information.\nEmployee first name: ");
                    firstName = scan.next();

                    System.out.print("Employee last name: ");
                    lastName = scan.next();

                    System.out.print("Employee position: ");
                    position = scan.next();

                    do{ //validation. ask user until they put proper age.
                        System.out.print("Employee age: ");
                        age = scan.nextInt();

                        if(age < 18 || age > 65)
                            System.out.print("\nThe age should be over 18 and below 65.\n");
                    }while(age<18 || age > 65);
                    
                    boolean dateValidate = false;
                    year=0; //initialising before running try and catch
                    month=0;
                    day=0;
                    do{//validation for date
                        System.out.print("Employee hired date in yyyy-mm-dd format: ");
                        hireDateString = scan.next();
                        try{
                            dateFormat.setLenient(false);//enforce the date format
                            hireDate = dateFormat.parse(hireDateString.trim());
                            cal.setTime(hireDate);

                            year = cal.get(Calendar.YEAR);
                            month = cal.get(Calendar.MONTH);
                            day = cal.get(Calendar.DAY_OF_MONTH);

                            dateValidate = true;
                        }catch(ParseException pe){
                            System.out.print("\nThe month or/and date value is not valid. Please check the date again.\n");
                        }    
                    }while(!dateValidate);
                    
                    switch (employeeTypeSelection) {
                        case 1://Commission Employee
                            double commissionRate, grossSales, salesTarget;
                            
                            do{
                                System.out.print("Employee's commission rate (2 decimal precision): ");
                                commissionRate = scan.nextDouble();
                                
                                if(commissionRate<0.0 || commissionRate>1.0)
                                    System.out.print("\nThe value is not valid. The rate should be between 0.0 and 1.0.\n");
                            }while(commissionRate<0.0 || commissionRate>1.0);
                            
                            do{
                                System.out.print("Employee's gross sales: ");
                                grossSales = scan.nextDouble();
                                
                                if(grossSales < 0.0)
                                    System.out.print("\nGross Sales cannot be under $0.00.\n");
                            }while(grossSales < 0.0);
                            
                            do{
                                System.out.print("Employee's salestarget: ");
                                salesTarget = scan.nextDouble();
                                
                                if(salesTarget < 0.0)
                                    System.out.print("\nSales Target cannot be under $0.00.\n");
                            }while(salesTarget < 0.0);

                            //create new CommissionEmployee object and add it into the employees arraylist
                            employees.add(new CommissionEmployee(firstName, lastName, position, age, year, month, day, commissionRate, grossSales, salesTarget));

                            //show the employee who is just registered.
                            System.out.println(employees.get(employees.size()-1));

                            break;

                        case 2://Hourly Employee
                            double hourlyRate, numOfHour;
                            do{
                                System.out.print("Employee's hourly rate (2 decimal precision): ");
                                hourlyRate = scan.nextDouble();
                                
                                if(hourlyRate < 0.0)
                                    System.out.print("\nHourly rate cannot be under $0.00.\n");
                            }while(hourlyRate < 0.0);
                            
                            do{
                                System.out.print("Employee's number of hours worked: ");
                                numOfHour = scan.nextDouble();
                                
                                if(numOfHour < 0.0)
                                    System.out.print("\nNumber of hours worked cannot be negative value.\n");
                            }while(numOfHour < 0.0);
                            
                            //add new employee class
                            employees.add(new HourlyEmployee(firstName, lastName, position, age, year, month, day, hourlyRate, numOfHour));

                            //show the employee who is just registered.
                            System.out.println(employees.get(employees.size()-1));

                            break;

                        case 3://Salary Employee
                            double salaryRate, bonus;
                            
                            do{
                                System.out.print("Employee's salary rate: ");
                                salaryRate = scan.nextDouble();
                                
                                if(salaryRate < 0.0)
                                    System.out.print("\nSalary rate cannot be negative value.\n");
                            }while(salaryRate < 0.0);
                            
                            do{
                                System.out.print("Employee's bonus: ");
                                bonus = scan.nextDouble();
                                
                                if(bonus < 0.0)
                                    System.out.print("\nBonus cannot be negative value.\n");
                            }while(bonus < 0.0);

                            //create and print the latest registered employee information
                            employees.add(new SalaryEmployee(firstName, lastName, position, age, year, month, day, salaryRate, bonus));
                            System.out.println(employees.get(employees.size()-1));

                            break;
                    }
                break; //selection 1.employee registration break

                case 2: //2.Product Registration
                    //product variables
                    String productName, category, description, partNum;
                    double productCost, productPrice, productMarkup;
                    int minimumInventory;

                    //manufacturer variables
                    String manufacturerName, address, phoneNum, contact;

                    //asking product info
                    System.out.print("\nPlease enter product information. \nProduct Name: ");
                    productName = scan.next();

                    System.out.print("Category: ");
                    category = scan.next();

                    System.out.print("Product description: ");
                    description = scan.next();

                    System.out.print("Part Number: ");
                    partNum = scan.next();

                    do{
                        System.out.print("Product Cost: ");
                        productCost = scan.nextDouble();

                        if(productCost < 0.0)
                            System.out.print("\nProduct cost cannot be negative value.\n");
                    }while(productCost < 0.0);
                    
                    do{
                        System.out.print("Product Price: ");
                        productPrice = scan.nextDouble();

                        if(productPrice < 0.0 || productPrice <= productCost)
                            System.out.print("\nProduct price is either negative value or lower than product cost. Please enter proper product price.\n");
                    }while(productPrice < 0.0 || productPrice <= productCost);
                    
                    //calculate the markup from productPrice and productCost
                    productMarkup = (productPrice/productCost)-1;
                    
                    do{
                        System.out.print("Product Minimum Inventory: ");
                        minimumInventory = scan.nextInt();

                        if(minimumInventory < 0.0)
                            System.out.print("\nMinimum Inventory is negative value.\n");
                    }while(minimumInventory < 0.0);
                    
                    //asking manufacturer info
                    System.out.print("\nPlease enter manufacturer information. \nManufactuer Name: ");
                    manufacturerName = scan.next();

                    System.out.print("Address: ");
                    address = scan.next();

                    System.out.print("Contact Number: ");
                    phoneNum = scan.next();

                    System.out.print("Representative Name: ");
                    contact = scan.next();

                    //create manufacturer object first
                    manufacturers.add(new Manufacturer(manufacturerName, address, phoneNum, contact));

                    //create and print the latest registered product information
                    products.add(new Product(productName, category, description, partNum, productCost, productPrice, productMarkup, minimumInventory, manufacturers.get(manufacturers.size()-1)));
                    System.out.print("\n"+products.get(products.size()-1));

                    System.out.println("\nDo you wish to review manufacturer's information as well?\n1.Yes\n2.No\n\nYour Selection: ");
                    int reviewYes = scan.nextInt();
                    System.out.print((reviewYes == 1) ? "\n"+products.get(products.size()-1).getManufacturer():"\n");

                    break; //selection 2.product registration break

                case 3://3.Search Employee
                    System.out.print("\nHow would you like to search?\n1.By Name\n2.By Employee ID\n\nYour Selection: ");
                    int employeeSearchMethod = scan.nextInt();

                    switch(employeeSearchMethod){
                        case 1://by name
                            System.out.print("\nPlease enter the employee's first name: ");
                            String searchFirstName = scan.next();
                            System.out.print("Please enter the employee's last name: ");
                            String searchLastName = scan.next();

                            //reset the employee to null before going through the arraylist
                            Employee searchedEmployee = null;

                            for(Employee employee : employees){
                                if(employee.getFirstName().equalsIgnoreCase(searchFirstName) && employee.getLastName().equalsIgnoreCase(searchLastName)){
                                    searchedEmployee = employee;
                                    System.out.print(searchedEmployee.toString());
                                    System.out.println(" ");
                                }
                            }
                            if(searchedEmployee==null)
                                System.out.print("\nSorry, couldn't find the name "+ searchFirstName.toUpperCase() + " " + searchLastName.toUpperCase() + "\n");

                            break;//search by name break

                        case 2://by employee id
                            System.out.print("\nPlease enter the employee's ID \nex) Commission Employee: C1000\n\tHourly Employee: H1000\n\tSalary Employee: S1000\n\nPlease enter: ");
                            String searchID = scan.next();

                            searchedEmployee = null;

                            for(Employee employee : employees){
                                if(employee.getEmpID().equalsIgnoreCase(searchID)){
                                    searchedEmployee = employee;
                                    System.out.print(searchedEmployee.toString());
                                    System.out.println(" ");
                                }
                            }
                            if(searchedEmployee==null)
                                System.out.print("\nSorry, couldn't find the employee ID "+ searchID.toUpperCase() + "\n");

                            break;//search by emp id break
                    }
                    break;//selection 3.search employee break

                case 4://Search Product
                    System.out.print("\nHow would you like to search?\n1.By Name\n2.By Product ID\n\nYour Selection: ");
                    int productSearchMethod = scan.nextInt();

                    switch(productSearchMethod){
                        case 1://by name
                            System.out.print("\nPlease enter the product name: ");
                            String searchProductName = scan.next();

                            //reset the searched product to null in case it has the previous value.
                            Product searchedProduct = null;

                            for(Product product : products){
                                if(product.getProductName().equalsIgnoreCase(searchProductName)){
                                    searchedProduct = product;
                                    System.out.print(searchedProduct.toString());
                                    System.out.println(" ");

                                    System.out.println("\nDo you wish to review manufacturer's information as well?\n1.Yes\n2.No\n\nYour Selection: ");
                                    int reviewManufacturer = scan.nextInt();
                                    System.out.print(reviewManufacturer==1? "\n"+searchedProduct.getManufacturer(): "\n");
                                }
                            }
                            if(searchedProduct==null)
                                System.out.print("\nSorry, couldn't find the product "+ searchProductName.toUpperCase()+ "\n");

                            break;//search by name break

                        case 2://by product ID

                            System.out.print("\nPlease enter the product ID \nex) 100000P\n\nPlease enter: ");
                            String searchID = scan.next();

                            searchedProduct = null;

                            for(Product product : products){
                                if(product.getProductID().equalsIgnoreCase(searchID)){
                                    searchedProduct = product;
                                    System.out.print(searchedProduct.toString());
                                    System.out.println(" ");

                                    System.out.println("\nDo you wish to review manufacturer's information as well?\n1.Yes\n2.No\n\nYour Selection: ");
                                    int reviewManufacturer = scan.nextInt();
                                    System.out.print(reviewManufacturer==1? "\n"+searchedProduct.getManufacturer(): "\n");
                                }
                            }
                            if(searchedProduct==null)
                                System.out.print("\nSorry, couldn't find the product ID "+ searchID.toUpperCase() + "\n");
                            
                            break;//search by product ID break
                    }
                    break;//selection 4.search product break
                case 5://5. exit
                    exit = false;
                    break;
            }//end of switch for main menu selection
        }//end of while    
    }//end of main
}//end of class