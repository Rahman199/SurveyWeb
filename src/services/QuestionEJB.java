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

/**
 * Session Bean implementation class QuestionEJB
 */
@Stateless
@LocalBean
public class QuestionEJB {

    /**
     * Default constructor. 
     */
    public QuestionEJB() {
        // TODO Auto-generated constructor stub
    }
    @PersistenceContext private EntityManager em;
    
    
    public void persist(Question question) {
        em.persist(question);
       // em.persist(arg0);
    }

   
    public List<Question> getNonShared() {
    	
    	/*CriteriaBuilder cb = em.getCriteriaBuilder();

    	CriteriaQuery<Question> cq = cb.createQuery(Question.class);
    	Root<Question> from = cq.from(Question.class);

    
    	cq.select(from);
    	TypedQuery<Question> q = em.createQuery(cq);
    	List<Question> allitems = q.getResultList();
       
        return allitems;*/
    	
    	CriteriaBuilder cb = em.getCriteriaBuilder();

    	CriteriaQuery<Question> cq = cb.createQuery(Question.class);
    	Root<Question> from = cq.from(Question.class);

    
    	cq.where(cb.equal(from.get("share_dis"),0));
    	cq.select(from);
    	TypedQuery<Question> q = em.createQuery(cq);
    	List<Question> allitems = q.getResultList();
       
        return allitems;
    }
    public List<Question> getAll(){
    	CriteriaBuilder cb = em.getCriteriaBuilder();

    	CriteriaQuery<Question> cq = cb.createQuery(Question.class);
    	Root<Question> from = cq.from(Question.class);

    
    	cq.select(from);
    	TypedQuery<Question> q = em.createQuery(cq);
    	List<Question> allitems = q.getResultList();
       
        return allitems;
    }
    
public List<Question> getShared() {
    	
    	CriteriaBuilder cb = em.getCriteriaBuilder();

    	CriteriaQuery<Question> cq = cb.createQuery(Question.class);
    	Root<Question> from = cq.from(Question.class);

    
    	cq.where(cb.equal(from.get("share_dis"),1));
    	cq.select(from);
    	TypedQuery<Question> q = em.createQuery(cq);
    	List<Question> allitems = q.getResultList();
       
        return allitems;
    }
    
    public void updateShared(Question q) {
    	
    	Query query = em.createQuery("UPDATE Question  SET share_dis = 1 "+ "WHERE id_Question="+q.getId_Question());
        query.executeUpdate();

    }

    public void endShared(Question q) {
    	
    	Query query = em.createQuery("UPDATE Question  SET share_dis = 0 "+ "WHERE id_Question="+q.getId_Question());
        query.executeUpdate();

    }
}
