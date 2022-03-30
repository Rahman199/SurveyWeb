package percistance;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Results implements Serializable {
    private static final long serialVersionUID = 1L;

    // Persistent Fields:
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_result;
    private Integer Id_question;
    private String question;
	private String answer_A;
	private String result_A;
    private String answer_B;
    private String result_B;
    private String answer_C;
    private String result_C;
    private String answer_D;
    private String result_D;
    
	
	
	public Integer getId_result() {
		return id_result;
	}
	public void setId_result(Integer id_result) {
		this.id_result = id_result;
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
	public Integer getId_question() {
		return Id_question;
	}
	public void setId_question(Integer id_question) {
		Id_question = id_question;
	}

}
