package bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import percistance.Question;
import percistance.Results;
import services.QuestionEJB;
import services.ResultEJB;

@Named("res")
@ViewScoped
public class ResultsBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EJB ResultEJB result;
	@EJB QuestionEJB questionn;
	private Integer question_Id;
    private String question;
	private String answer_A;
	private String result_A;
    private String answer_B;
    private String result_B;
    private String answer_C;
    private String result_C;
    private String answer_D;
    private String result_D;
    private List<Question> questionList=new ArrayList<Question>();
    private List<Results> resultList=new ArrayList<Results>();
    private List<Results> finalResultList=new ArrayList<Results>();
    
    @PostConstruct
    public void displayQuestions() {
    	questionList=questionn.getAll();
    	System.out.println("questionList="+ questionList.size());
    	
    	for(int i=0;i<questionList.size();i++) {
    		System.out.println(i);
    		Integer totalA=0,totalB=0,totalC=0,totalD=0;
    		Results r = new Results();
    		resultList=result.getSpecificQuestion(questionList.get(i).getId_Question());
    		System.out.println(questionList.get(i).getId_Question());
    		if(resultList.size()>0) {
    			System.out.println("resultList= "+resultList.size());
    		for(int x=0;x<resultList.size();x++) {
    			System.out.println(x);
    			if(resultList.get(x).getResult_A()!=null){
    				totalA=totalA+Integer.parseInt(resultList.get(x).getResult_A());
    			}
    			if(resultList.get(x).getResult_B()!=null){
    				totalB=totalB+Integer.parseInt(resultList.get(x).getResult_B());
    			}
    			if(resultList.get(x).getResult_C()!=null){
    				totalC=totalC+Integer.parseInt(resultList.get(x).getResult_C());
    			}
    			if(resultList.get(x).getResult_D()!=null){
    				totalD=totalD+Integer.parseInt(resultList.get(x).getResult_D());
    			}
    		}
    		System.out.println("---------------- " +totalA+"---"+totalB+"---"+totalC+"---"+totalD+"---");
    		Double percentA = (double) (totalA*100/resultList.size());
    		Double percentB = (double) (totalB*100/resultList.size());
    		Double percentC = (double) (totalC*100/resultList.size());
    		Double percentD = (double) (totalD*100/resultList.size());
    		
    		r.setResult_A(percentA.toString()+"%");
    		r.setResult_B(percentB.toString()+"%");
    		r.setResult_C(percentC.toString()+"%");
    		r.setResult_D(percentD.toString()+"%");
    		r.setAnswer_A(questionList.get(i).getAnswer_A());
    		r.setAnswer_B(questionList.get(i).getAnswer_B());
    		r.setAnswer_C(questionList.get(i).getAnswer_C());
    		r.setAnswer_D(questionList.get(i).getAnswer_D());
    		r.setId_question(questionList.get(i).getId_Question());
    		r.setQuestion(questionList.get(i).getQuestion());
    		finalResultList.add(r);
    	}
    	}
    }
	public Integer getQuestion_Id() {
		return question_Id;
	}
	public void setQuestion_Id(Integer question_Id) {
		this.question_Id = question_Id;
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
	public String getResult_A() {
		return result_A;
	}
	public void setResult_A(String result_A) {
		this.result_A = result_A;
	}
	public String getAnswer_B() {
		return answer_B;
	}
	public void setAnswer_B(String answer_B) {
		this.answer_B = answer_B;
	}
	public String getResult_B() {
		return result_B;
	}
	public void setResult_B(String result_B) {
		this.result_B = result_B;
	}
	public String getAnswer_C() {
		return answer_C;
	}
	public void setAnswer_C(String answer_C) {
		this.answer_C = answer_C;
	}
	public String getResult_C() {
		return result_C;
	}
	public void setResult_C(String result_C) {
		this.result_C = result_C;
	}
	public String getAnswer_D() {
		return answer_D;
	}
	public void setAnswer_D(String answer_D) {
		this.answer_D = answer_D;
	}
	public String getResult_D() {
		return result_D;
	}
	public void setResult_D(String result_D) {
		this.result_D = result_D;
	}
	public List<Question> getQuestionList() {
		return questionList;
	}
	public void setQuestionList(List<Question> questionList) {
		this.questionList = questionList;
	}
	public List<Results> getResultList() {
		return resultList;
	}
	public void setResultList(List<Results> resultList) {
		this.resultList = resultList;
	}
	public List<Results> getFinalResultList() {
		return finalResultList;
	}
	public void setFinalResultList(List<Results> finalResultList) {
		this.finalResultList = finalResultList;
	}
}
