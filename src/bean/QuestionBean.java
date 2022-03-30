package bean;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import percistance.Question;
import services.QuestionEJB;

@Named("question")
@ViewScoped
public class QuestionBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EJB QuestionEJB questionn;
	private String question;
	private String answer_A;
    private String answer_B;
    private String answer_C;
    private String answer_D;
    private String corrctAnswer;
    private Integer share_dis;
    public String getCorrctAnswer() {
		return corrctAnswer;
	}

	public void setCorrctAnswer(String corrctAnswer) {
		this.corrctAnswer = corrctAnswer;
	}

	public String saveQuestion() {
    	
    	Question q = new Question();
    	q.setQuestion(question);
    	q.setAnswer_A(answer_A);
    	q.setAnswer_B(answer_B);
    	q.setAnswer_C(answer_C);
    	q.setAnswer_D(answer_D);
    	q.setCorrect_Answer(corrctAnswer);
    	q.setShare_dis(0);
    	
    	
    	questionn.persist(q);
    	FacesContext.getCurrentInstance().addMessage(
				"searchform",
				new FacesMessage(FacesMessage.SEVERITY_ERROR,
						"Question Saved Successfully", ""));
    	return null;
    }
    
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getAnswer_A() {
		return answer_A;
	}
	public void setAnswer_A(String answer_A) {
		this.answer_A = answer_A;
	}
	public String getAnswer_B() {
		return answer_B;
	}
	public void setAnswer_B(String answer_B) {
		this.answer_B = answer_B;
	}
	public String getAnswer_C() {
		return answer_C;
	}
	public void setAnswer_C(String answer_C) {
		this.answer_C = answer_C;
	}
	public String getAnswer_D() {
		return answer_D;
	}
	public void setAnswer_D(String answer_D) {
		this.answer_D = answer_D;
	}

	public Integer getShare_dis() {
		return share_dis;
	}

	public void setShare_dis(Integer share_dis) {
		this.share_dis = share_dis;
	}

}
