package bean;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import percistance.Registration;
import services.RegistrationEJB;

@Named("bean1")
@ViewScoped
public class Register implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@EJB RegistrationEJB register;
	
	
private String name;
private String userType;
private String Password;
private String confirmPassword;
private String Email;
private Boolean render=false;



public String ddo() {
	
		Registration reg = new Registration();
		reg.setName(name);
		reg.setEmail(Email);
		if(Password.equals(confirmPassword)) {
		reg.setPassword(Password);
		}
		else {
			FacesContext.getCurrentInstance().addMessage(
					"searchform",
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"Password & it's confirmation didn't match", ""));
			return null;
		}
		
		reg.setUserType(userType);
		if(register.checkuser(reg)!=null) {
			FacesContext.getCurrentInstance().addMessage(
					"searchform",
					new FacesMessage(FacesMessage.SEVERITY_INFO,
							"User Already Exists", ""));
			return null;
		}
		else {
		register.persist(reg);
	
	
		//System.out.println(register.getAllGuests().size());
		render=true;
		FacesContext.getCurrentInstance().addMessage(
				"searchform",
				new FacesMessage(FacesMessage.SEVERITY_INFO,
						"Congeratulation you have created successfully your Account!", ""));
		return null;
		}
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}
public String getUserType() {
	return userType;
}

public void setUserType(String userType) {
	this.userType = userType;
}

public String getPassword() {
	return Password;
}

public void setPassword(String password) {
	Password = password;
}

public String getEmail() {
	return Email;
}

public void setEmail(String email) {
	Email = email;
}

public String getConfirmPassword() {
	return confirmPassword;
}

public void setConfirmPassword(String confirmPassword) {
	this.confirmPassword = confirmPassword;
}

public Boolean getRender() {
	return render;
}

public void setRender(Boolean render) {
	this.render = render;
}


}
