package Finals_OOP;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import javax.swing.*;
import java.util.*;

class Product {
   public String listOfProducts[][] = {
		   {"Toblerone", "55.0"},
		   {"Snickers","25.0"},
		   {"Hershey", "45.0"},
		   {"Baby Ruth","68.0"},
		   {"Kit Kat","34.0"}
   };
   
    
    
    //OVERLOADING
    public Product() {
       
    }

    public void customerOrder(String customerName, String discText, String cashText, String totText, String changeText, JTextField[] quantities) {
    	String info[] = {"Customer Name: "+customerName,"Discount: "+discText+"%", "Total: \u20B1"+totText, "Cash: \u20B1"+cashText,"Change: \u20B1"+changeText,"Date: "+new Date().toString()};
    	List<String> orders = new ArrayList<>();

    	for (int i = 0; i < listOfProducts.length; i++) {
    	    int quantity = Integer.parseInt(quantities[i].getText());
    	    if (quantity > 0) {
    	        String productName = listOfProducts[i][0];
    	        orders.add("Product: " + productName + " | Quantity: " + quantity);
    	    }
    	}  	
    	writeToTxt(info,orders);

    }
    
    public void customerOrder(String discText, String cashText, String totText, String changeText, JTextField[] quantities) {
    	String info[] = {"Customer Name: N/A","Discount: "+discText+"%", "Total: \u20B1"+totText, "Cash: \u20B1"+cashText,"Change: \u20B1"+changeText,"Date: "+new Date().toString()};    	
    	List<String> orders = new ArrayList<>();

    	for (int i = 0; i < listOfProducts.length; i++) {
    	    int quantity = Integer.parseInt(quantities[i].getText());
    	    if (quantity > 0) {
    	        String productName = listOfProducts[i][0];
    	        orders.add("Product: " + productName + " | Quantity: " + quantity);
    	    }
    	}
    	writeToTxt(info,orders);
    	
    }
    
    public void writeToTxt(String info[], List<String> orders) {
    	try (FileWriter writer = new FileWriter("Customer.txt", true)) {
            writer.write("\n"+info[0] + "\n");
           for(String x : orders) {
        	   writer.write(x+"\n");
           }
           for(int j=1; j<info.length;j++) {
        	   writer.write(info[j]+"\n");
           }
           writer.write("-------------------------------");
            JOptionPane.showMessageDialog(null, "Order saved successfully.");
        } catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error saving order.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
