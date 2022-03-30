package services;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import percistance.Registration;
@Stateless
@LocalBean
public class RegistrationEJB {
    // Injected database connection:
    @PersistenceContext private EntityManager em;
 
   
    public void persist(Registration user) {
        em.persist(user);
       // em.persist(arg0);
    }

    
    public Registration checkuser(Registration reg) {
        Registration user = em.find(Registration.class, reg.getEmail());
        return user;
    }
}
