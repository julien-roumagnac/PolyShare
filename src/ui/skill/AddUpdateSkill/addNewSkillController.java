package ui.skill.AddUpdateSkill;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import application.classesApp.SchoolClass;
import application.classesApp.Skill;
import facades.LoginFacade;
import facades.SchoolClassFacade;
import facades.SkillFacade;
import facades.exceptions.DisconnectedStudentException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import ui.Router;

/**
 * @author martinCayuelas
 */

public class addNewSkillController implements Initializable {

	private SchoolClassFacade schoolClassFacade = new SchoolClassFacade();
	private SkillFacade skillFacade = new SkillFacade();
	ObservableList<String> SchoolClassObservableList;
	Router r = Router.getInstance();

	@FXML
	private TextField nameSkill;

	@FXML
	private Spinner<Integer> mySpinner;
	@FXML
	private ChoiceBox<String> choiceBoxClass;

	public void addSkill(ActionEvent event) throws DisconnectedStudentException, IOException {
		int idStudent = LoginFacade.getInstance().getConnectedStudent().getId();

		SchoolClass lClass = schoolClassFacade.findSchoolClass(choiceBoxClass.getValue());
		int idClass = lClass.getIdSchoolClass();
		Skill s = new Skill(0, nameSkill.getText(), mySpinner.getValue(), idStudent, idClass);
		skillFacade.addSkill(s);

		Node source = (Node) event.getSource();
		Stage stage = (Stage) source.getScene().getWindow();
		stage.close();

		Router.getInstance().activate("Skill");

	}

	private void initSpinner() {

		mySpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 5));
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

		initSpinner();
		List<SchoolClass> sc = new ArrayList<>();
		sc = schoolClassFacade.getAllSchoolClass();
		SchoolClassObservableList = FXCollections.observableArrayList();
		for (SchoolClass c : sc) {
			SchoolClassObservableList.add(c.getNameSchoolClass());
		}

		this.choiceBoxClass.setItems(SchoolClassObservableList);

	}

}
