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
import services.QuestionEJB;

@Named("end")
@ViewScoped
public class EndSurrveyBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EJB QuestionEJB questionn;
	private List<Question> pickList = new ArrayList<Question>();
	private Integer PickedQuestion;
	
	
	@PostConstruct
	public void pickQuestions() {
		
		pickList=questionn.getShared();
		if(pickList.size()>0) {
			//System.out.println("aaaaaaaaaaaaaa : "+pickList.get(0).getId_Question());
			FacesContext.getCurrentInstance().addMessage(
					"searchform",
					new FacesMessage(FacesMessage.SEVERITY_INFO,
							"Questions retrieved Successfully", ""));
		}
		else {
			FacesContext.getCurrentInstance().addMessage(
					"searchform",
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"No Data Available", ""));
		}
	}
	
	public String end() {
		
		Question q = new Question();
		
		q.setId_Question(PickedQuestion);
		questionn.endShared(q);
		FacesContext.getCurrentInstance().addMessage(
				"searchform",
				new FacesMessage(FacesMessage.SEVERITY_INFO,
						"Questions Has Been Shared", ""));
		pickQuestions();
		return null;
	}
	
	public List<Question> getPickList() {
		return pickList;
	}
	public void setPickList(List<Question> pickList) {
		this.pickList = pickList;
	}

	public Integer getPickedQuestion() {
		return PickedQuestion;
	}

	public void setPickedQuestion(Integer pickedQuestion) {
		PickedQuestion = pickedQuestion;
	}

}
