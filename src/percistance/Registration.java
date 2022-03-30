package percistance;



import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
 
public class Registration implements Serializable {
    private static final long serialVersionUID = 1L;

    // Persistent Fields:
    @Id //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private String Email;
    private String name;
    private String Password;
    private String userType;

    // Constructors:
    public Registration() {
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

   
}