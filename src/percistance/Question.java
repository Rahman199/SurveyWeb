package percistance;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Question implements Serializable {
    private static final long serialVersionUID = 1L;

    // Persistent Fields:
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_Question;
    private String question;
	private String answer_A;
    private String answer_B;
    private String answer_C;
    private String answer_D;
    private String Correct_Answer;
    private Integer share_dis;
    private String Email;

    // Constructors:
    public Question() {
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


	public Integer getShare_dis() {
		return share_dis;
	}


	public void setShare_dis(Integer share_dis) {
		this.share_dis = share_dis;
	}


	public String getEmail() {
		return Email;
	}


	public void setEmail(String email) {
		Email = email;
	}
	

}
