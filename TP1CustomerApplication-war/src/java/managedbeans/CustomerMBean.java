/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbeans;

import entities.Customer;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import session.CustomerManager;

/**
 *
 * @author Kiady
 */
@Named(value = "customerMBean")
@ViewScoped
public class CustomerMBean implements Serializable {

    private List<Customer> customerList;
    @EJB
    private CustomerManager customerManager;

    /**
     * Creates a new instance of CustomerMBean
     */
    public CustomerMBean() {
    }
    
    /**  
    * Retourne la liste des clients pour affichage dans une DataTable  
    * @return 
    */   
    public List<Customer> getCustomers() { 
        if (customerList == null) {
            customerList = customerManager.getAllCustomers(); 
        } 
        return customerList; 
    }  
}
