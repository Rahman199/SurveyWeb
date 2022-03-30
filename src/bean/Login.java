package bean;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import percistance.Registration;
import services.LoginEJB;

@Named("login")
@ViewScoped
public class Login implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EJB LoginEJB log;
	private String email;
	private String password;
	
	
	public String loginn() {
		Registration r=new Registration();
		r.setEmail(email);
		r.setPassword(password);
		Registration logged = new Registration();
		logged = log.getUser(r);
		if(logged!=null) {
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("user", logged);
			if(Integer.parseInt(logged.getUserType())==0) {
				//System.out.println("loggeddddddd12 "+logged.getUserType());
				return "StudentPage";
			}
			else {
				System.out.println("loggeddddddd00 "+logged.getUserType());
				return  "ProfPage";
			}
			
		}
		else {
			FacesContext.getCurrentInstance().addMessage(
					"searchform",
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"Login fail!!, please check your data", ""));
			return null;
		}
		
		
		
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
