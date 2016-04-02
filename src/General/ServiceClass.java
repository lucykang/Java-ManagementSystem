
package General;

/**
 *
 * @author Hae Yeon Kang
 */
public class ServiceClass {

    private static int empID = 1000;
    private static int productID = 100000;
    
    
    //methods
    public static int getEmpID(){
        return empID++;
    }
    public static int getProductID(){
        return productID++;
    }
}
