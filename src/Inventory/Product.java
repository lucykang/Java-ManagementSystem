
package Inventory;

import General.ServiceClass;
import java.util.ArrayList;

/**
 *
 * @author Hae Yeon Kang
 */
public class Product {
    //variables
    private String productID, productName, category, description, partNum;
    private int minimumInventory;
    private ArrayList<Manufacturer> manufacturers = new ArrayList<>();
    private Manufacturer manufacturer;
    private double productPrice, productCost, productMarkup;
    
    //constructor
    public Product(){}
    public Product(String productName, String category, String description,
                    String partNum, double productCost, double productPrice, double productMarkup, int minimumInventory, Manufacturer manufacturer){
        this.productID = (ServiceClass.getProductID()+"P");
        this.productName = productName;
        this.category = category;
        this.description = description;
        this.partNum = partNum;
        this.productCost = productCost;
        this.productPrice = productPrice;
        this.productMarkup = productMarkup;
        this.minimumInventory = minimumInventory;
        this.manufacturers.add(manufacturer);
        this.manufacturer = manufacturer;
    }
    
    //accessor methods
    public String getProductID() {
        return this.productID;
    }
    
    public String getProductName(){
        return this.productName;
    }

    public String getCategory(){
        return this.category;
    }
    
    public String getDescription() {
        return description;
    }

    public String getPartNum() {
        return partNum;
    }
    
    public double getProductPrice() {
        return productPrice;
    }

    public double getProductCost() {
        return productCost;
    }

    public double getProductMarkup() {
        return productMarkup;
    }

    public int getMinimumInventory() {
        return minimumInventory;
    }
    
    public Manufacturer getManufacturer() {
        return this.manufacturer;
    }
    
    //mutator methods
    public void setProductID(String productID){
        this.productID = productID;
    }
    
    public void setProductName(String productName){
        this.productName = productName.toUpperCase();
    }
    
    public void setCategory(String category){
        this.category = category;
    }
    
    public void setDescription(String description){
        this.description = description;
    }
    
    public void setPartNum(String partNum){
        this.partNum = partNum;
    }
    
    public boolean setProductCost(double productCost){
        boolean success;
        if(productCost >= 0.0){
            this.productCost = productCost;
            //when the cost is changed, change the markup rate.
            this.productMarkup = (this.productPrice/this.productCost)-1;
            success = true;
        }else{
            System.out.print("\nProduct cost cannot be negative value.\n");
            success = false;
        }
        return success;
    }
    
    public boolean setProductPrice(double productPrice){
        boolean success;
        if(productPrice >= 0.0 && productPrice > this.productCost){
            this.productPrice = productPrice;
            success = true;
        }else{
            System.out.print("\nProduct price is either negative value or lower than product cost. Please enter proper product price.\n");
            success = false;
        }
        return success;
    }
    
    public boolean setProductMarkup(double productMarkup){
        boolean success;
        if(productMarkup > 0.0 && productMarkup < 1.0){
            this.productMarkup = productMarkup;
            //when the markup rate is changed, change the cost.
            this.productCost = this.productPrice/(this.productMarkup+1);
            success = true;
        }else{
            System.out.print("\nProduct markup should be between 0 and 1.\n");
            success = false;
        }
        return success;
    }
    
    public boolean setMinimumInventory(int minimumInventory){
        boolean success;
        if(minimumInventory >= 0){
            this.minimumInventory = minimumInventory;
            success = true;
        }else{
            System.out.print("\nMinimum Inventory is negative value.\n");
            success = false;
        }
        return success;
    }
    
    public void setManufacturer(Manufacturer manufacturer){
        this.manufacturers.add(manufacturer);
    }
    
    @Override
    public String toString(){
        String productInfo = " * * * * * * Product Information * * * * * *";
        
        productInfo += "\nName: \t\t" + getProductName();
        productInfo += "\nID: \t\t" + getProductID();
        productInfo += "\nCategory: \t" + getCategory();
        productInfo += "\nDescription: \t" + getDescription();
        productInfo += "\nPart Number: \t" + getPartNum();
        productInfo += "\nPrice: \t\t\t" + getProductPrice();
        productInfo += "\nCost: \t\t\t" + getProductCost();
        productInfo += "\nMarkup: \t\t" + String.format( "%.2f", getProductMarkup());
        productInfo += "\nMinimum Inventory: \t" + getMinimumInventory();
    
        return productInfo;
    }
}
