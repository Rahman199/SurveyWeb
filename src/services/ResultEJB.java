package services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import percistance.Question;
import percistance.Results;

/**
 * Session Bean implementation class ResultEJB
 */
@Stateless
@LocalBean
public class ResultEJB {

    /**
     * Default constructor. 
     */
    public ResultEJB() {
        // TODO Auto-generated constructor stub
    }
 @PersistenceContext private EntityManager em;
    
    
    public void persist(Results result) {
        em.persist(result);
       
    }

   
    public List<Results> getSpecificQuestion(Integer id) {
    	
    	
    	
    	CriteriaBuilder cb = em.getCriteriaBuilder();

    	CriteriaQuery<Results> cq = cb.createQuery(Results.class);
    	Root<Results> from = cq.from(Results.class);

    
    	cq.where(cb.equal(from.get("Id_question"),id));
    	cq.select(from);
    	TypedQuery<Results> q = em.createQuery(cq);
    	List<Results> allitems = q.getResultList();
       System.out.println("EJB all - " + allitems.size());
        return allitems;
    }
    

    
    public void updateShared(Question q) {
    	//EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "Eclipselink_JPA" );
        
        //EntityManager entitymanager = emfactory.createEntityManager( );
        
       // Question question = em.find( Question.class, q );
        
        //before update
        //System.out.println( employee );
       // question.setShare_dis(1);;
        //question=em.merge(q.getId_Question());
        
        //after update
        //System.out.println( employee );
    	Query query = em.createQuery("UPDATE Question  SET share_dis = 1 "+ "WHERE id_Question="+q.getId_Question());
        query.executeUpdate();

    }
}
