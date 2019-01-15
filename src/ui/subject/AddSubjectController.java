package ui.subject;

import javafx.scene.control.TextField;
import java.net.URL;
import java.util.ResourceBundle;

import application.classesApp.SchoolClass;
import application.classesApp.Skill;
import application.classesApp.Subject;
import facades.LoginFacade;
import facades.SchoolClassFacade;
import facades.exceptions.DisconnectedStudentException;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import ui.Router;

/**
 * @author guillaud
 */
public class AddSubjectController implements Initializable {
	
	private SchoolClassFacade schoolClassFacade = new SchoolClassFacade();
	
	@FXML private TextField nameSubject;

    /**
     * Default constructor
     */
    public AddSubjectController() {
    }
    
    public void addSubject() throws DisconnectedStudentException {
    	/////////////////////////////////////////////////////////////////////////////////////////////////////
    	//R�cup�rer l'ID de la SchoolClass courante gr�ce � la fonction getParams() de l'instance du router//
    	/////////////////////////////////////////////////////////////////////////////////////////////////////
    	//Pour l'instant, test avec la SchoolClass 2 (IG4)
		Subject newSubject = new Subject(0, nameSubject.getText(), 2);
		schoolClassFacade.addSubject(newSubject);
		
		//Quand on appuie sur Add �a doit renvoyer vers la page SchoolClass.fxml (avec la liste des subject et topics

	}
    
    
    /**
     * params need a SchoolClass to show his subjects
     */
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		/*Object[] params = Router.getInstance().getParams();
    	
    	if (params[0] instanceof SchoolClass) {
    		SchoolClass selectSchoolClass = (SchoolClass)params[0];
    		
    		//TODO afficher la liste des subjects de la class
    		this.nameSubject.setText(selectSchoolClass.getNameSchoolClass());
    	}
    	else {
    		//TODO do a custom message error
    		System.out.println("PASSER UN SUBJECT SVP");
    	}*/
	}

}