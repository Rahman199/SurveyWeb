package services;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import percistance.Registration;

/**
 * Session Bean implementation class LoginEJB
 */
@Stateless
public class LoginEJB {

    /**
     * Default constructor. 
     */
    public LoginEJB() {
        // TODO Auto-generated constructor stub
    }
    
    @PersistenceContext private EntityManager em;
    public Registration getUser(Registration login) {
    	
    	Registration user = em.find(Registration.class, login.getEmail());
    	if(user!=null) {
    	if(user.getPassword().compareTo(login.getPassword())==0) {
        return  user;
    	}
    	else {
    		return null;
    	}
    	}
    	else {
    		return null;
    	}
       
    }
}
