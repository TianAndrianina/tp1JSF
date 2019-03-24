/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entities.Customer;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Kiady
 */
@Stateless
@LocalBean
public class CustomerManager {
    
    @PersistenceContext(unitName = "TP1CustomerApplication-ejbPU")
    private EntityManager em;

    /**
     * Methode pour séléctionner la liste de tous les clients(Customer)
     * @return List<Customer> Retourne la liste de tous les Clients(Customer)
     */
    public List<Customer> getAllCustomers() {
        Query query = em.createNamedQuery("Customer.findAll");  
        return query.getResultList();  
    }

    /**
     *Méthode pour modifier la ligne désignant un client
     * @param customer le Client à modifier
     * @return Customer le même Client avec ses valeurs modifiées
     */
    public Customer update(Customer customer) {
        return em.merge(customer); 
    }

    /**
     * Méthode pour ajouter un nouveau client
     * @param customer
     */
    public void persist(Customer customer) {
        em.persist(customer);
    }
    
    /**
     * Méthode pour trouver un Client selon son Id
     * @param idCustomer
     * @return Customer
     */
    public Customer getCustomer(int idCustomer) {  
        return em.find(Customer.class, idCustomer);  
    }
}
