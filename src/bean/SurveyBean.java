package bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import percistance.Question;
import percistance.Results;
import services.QuestionEJB;
import services.ResultEJB;

@Named("surveyB")
@ViewScoped
public class SurveyBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EJB ResultEJB res;
	@EJB QuestionEJB questionn;
	private Integer id_Question;
	private String question;
	private String answer_A;
	private String answer_B;
	private String answer_C;
	private String answer_D;
	private String Correct_Answer;
	private Question q = new Question();
	private Integer count =0 ;
private Boolean disable=false;
	private List<Question> QuestionsList= new ArrayList<Question>();

	@PostConstruct
	public void displayQuestion() {
		QuestionsList=questionn.getShared();
		if(QuestionsList.size()>count) {
			//.out.println("aaaaaaaaaaaaaa : "+QuestionsList.get(0).getId_Question());
id_Question=QuestionsList.get(count).getId_Question();
question=QuestionsList.get(count).getQuestion();
answer_A=QuestionsList.get(count).getAnswer_A();
answer_B=QuestionsList.get(count).getAnswer_B();
answer_C=QuestionsList.get(count).getAnswer_C();
answer_D=QuestionsList.get(count).getAnswer_D();
Correct_Answer= QuestionsList.get(count).getCorrect_Answer();
			FacesContext.getCurrentInstance().addMessage(
					"form",
					new FacesMessage(FacesMessage.SEVERITY_INFO,
							"Questions retrieved Successfully", ""));
		}
		else {
			FacesContext.getCurrentInstance().addMessage(
					"form",
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"No Data Available", ""));
		}
	}
	
	public String save() {
		Results result = new Results();
		result.setId_question(id_Question);
		result.setQuestion(question);
		
		if(answer_A.equals(Correct_Answer)) {
			result.setAnswer_A(answer_A);
			result.setResult_A("1");
		}
		else if(answer_B.equals(Correct_Answer)) {
			result.setAnswer_B(answer_B);
			result.setResult_B("1");
		}
		else if(answer_C.equals(Correct_Answer)) {
			result.setAnswer_C(answer_C);
			result.setResult_C("1");
		}
		else if(answer_D.equals(Correct_Answer)) {
			result.setAnswer_D(answer_D);
			result.setResult_D("1");
		}
		
		System.out.println("correct "+Correct_Answer);
		res.persist(result);
		return null;
	}
	
	public String next() {
		
		save();
		count++;
		if(count<QuestionsList.size()) {
		displayQuestion();
		}
		else {
			FacesContext.getCurrentInstance().addMessage(
					"form",
					new FacesMessage(FacesMessage.SEVERITY_INFO,
							"survey Ended Successfuly", ""));
			disable=true;
		}
		return null;
	}

	public Question getQ() {
		return q;
	}
	public void setQ(Question q) {
		this.q = q;
	}
	public List<Question> getQuestionsList() {
		return QuestionsList;
	}
	public void setQuestionsList(List<Question> questionsList) {
		QuestionsList = questionsList;
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

	public String getCorrect_Answer() {
		return Correct_Answer;
	}

	public void setCorrect_Answer(String correct_Answer) {
		Correct_Answer = correct_Answer;
	}
	public Integer getId_Question() {
		return id_Question;
	}

	public void setId_Question(Integer id_Question) {
		this.id_Question = id_Question;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Boolean getDisable() {
		return disable;
	}

	public void setDisable(Boolean disable) {
		this.disable = disable;
	}

}
