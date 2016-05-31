package ma.bps.presentation;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import ma.bps.entities.Utilisateurs;

public class BeanSession {
	 public static HttpSession getSession() {
	    	//if str  se
	        return (HttpSession) FacesContext.getCurrentInstance()
	                .getExternalContext().getSession(false);
	    }
	 public static HttpServletRequest getRequest() {
	        return (HttpServletRequest) FacesContext.getCurrentInstance()
	                .getExternalContext().getRequest();
	    }
	 
//	 public static Utilisateur getUser() {
//	        HttpSession session = getSession();
//	        if (session != null)
//	            return (Utilisateur) session.getAttribute("user1");
//	        else
//	            return null;
//	    }
	 
	 public static Utilisateurs getUser(){
		  HttpSession session = getSession();
		  if(session != null){
			  return (Utilisateurs) session.getAttribute("user");
		  }
		  else{
			  return null;
		  }
	 }
}
