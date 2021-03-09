package view;

import mediator.ExamListModel;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.Region;
import model.*;
import model.Class;
import parser.ParserException;

import java.io.FileNotFoundException;

public class PlanAnExamViewController
{
    private Region root;
    private ViewHandler viewHandler;
    private ExamListModel model;
    boolean isWritten = true;
    @FXML
    ChoiceBox examTypeDropdown;
    @FXML
    ChoiceBox courseDropdown;
    @FXML
    ChoiceBox classDropDown;
    @FXML
    TextField dayTextField;
    @FXML
    TextField monthTextField;
    @FXML
    TextField yearTextField;
    @FXML
    ChoiceBox roomDropDown;
    @FXML
    private Label errorLabel;


    public PlanAnExamViewController()
    {
    }

    public void init(ViewHandler viewHandler, ExamListModel model, Region root)
    {
        this.viewHandler = viewHandler;
        this.model = model;
        this.root = root;
        examTypeDropdown.setItems(FXCollections.observableArrayList("Oral", "Written"));
        examTypeDropdown.setTooltip(new Tooltip("Select if the exam is oral or written!"));
        courseDropdown.setItems(FXCollections.observableArrayList(model.getCourses().getCourses()));
        courseDropdown.setTooltip(new Tooltip("Select a course!"));
        classDropDown.setItems(FXCollections.observableArrayList(model.getTheClasses().getAllClasses()));
        classDropDown.setTooltip(new Tooltip("Select a class!"));
        roomDropDown.setItems(FXCollections.observableArrayList(model.getRooms().getAllRooms()));
        roomDropDown.setTooltip(new Tooltip("Select a room!"));
        errorLabel.setText("");
        reset();

    }

    public void reset()
    {
        errorLabel.setText("");
    }

    public Region getRoot()
    {
        return root;
    }

    @FXML
    private void cancelButtonPressed()
    {
        viewHandler.closeView();
        viewHandler.openView("DetailsView");
    }

    @FXML
    private void confirmExamButtonPressed() throws ParserException, FileNotFoundException
    {
        if (courseDropdown.getSelectionModel().getSelectedItem() != null && classDropDown.getSelectionModel().getSelectedItem() != null && roomDropDown.getSelectionModel().getSelectedItem() != null)
        {
            model.PlanAnExam((Course) courseDropdown.getSelectionModel().getSelectedItem(), (Class) classDropDown.getSelectionModel().getSelectedItem(), (Room) roomDropDown.getSelectionModel().getSelectedItem(), model.getDates(), isWritten);
            for (int i = 0; i < model.getCourses().size(); i++)
            {
                if (model.getCourses().get(i).equals((Course) courseDropdown.getSelectionModel().getSelectedItem()))
                {
                    model.getCourses().get(i).setIsScheduled();
                }
            }
            for (int i = 0; i < model.getDates().size(); i++)
            {
                model.getDates().remove(model.getDates().getDates().get(i));
            }

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation");
            alert.showAndWait();
            model.getFileConsole().writeExamList(model.getExamList());
            model.getFileConsole().writeExamListManual(model.getExamList());
        }


        errorLabel.setText("You must enter data!");


    }

    @FXML
    private void addAnotherPressed()
    {
        examTypeDropdown.setItems(FXCollections.observableArrayList("Oral", "Written"));

        courseDropdown.setItems(FXCollections.observableArrayList(model.getCourses().getCourses()));

        classDropDown.setItems(FXCollections.observableArrayList(model.getTheClasses().getAllClasses()));
        roomDropDown.setItems(FXCollections.observableArrayList(model.getRooms().getAllRooms()));
        dayTextField.setText("");
        monthTextField.setText("");
        yearTextField.setText("");
        for (int i = 0; i < model.getDates().size(); i++)
        {
            model.getDates().remove(model.getDates().getDates().get(i));
        }
        reset();
    }

    @FXML
    private void addButton()
    {
        int oralDays = 0;
        if (((Class) classDropDown.getSelectionModel().getSelectedItem()).getStudentCount() % 20 == 0)
        {
            oralDays = ((Class) classDropDown.getSelectionModel().getSelectedItem()).getStudentCount() / 20;
        } else if (((Class) classDropDown.getSelectionModel().getSelectedItem()).getStudentCount() % 20 != 0)
        {
            oralDays = (((Class) classDropDown.getSelectionModel().getSelectedItem()).getStudentCount() / 20) + 1;
        }
        if (examTypeDropdown.getSelectionModel().getSelectedItem().toString().equals("Written"))
        {
            isWritten = true;
            errorLabel.setText("Don't add more dates, written exams take only 1 day!");
        } else if (examTypeDropdown.getSelectionModel().getSelectedItem().toString().equals("Oral"))
        {
            isWritten = false;
            errorLabel.setText("Pick exactly " + oralDays + " date(s), since only 20 students can take the oral exam/day.");
        }
        if (isWritten == true)
        {
            roomDropDown.setItems(FXCollections.observableArrayList(model.getRooms().getRoomsForWritten()));
            if (model.getDates().size() > 0)
            {
                errorLabel.setText("Start over the exam planning (clear)! You picked more than 1 day!");
            }
        } else if (isWritten == false)
        {
            roomDropDown.setItems(FXCollections.observableArrayList(model.getRooms().getRoomsForOral()));

            if (model.getDates().size() >= oralDays)
            {
                errorLabel.setText("Start over the exam planning (clear)! You picked too many days!");
            } else if (model.getDates().size() == oralDays - 1)
            {
                errorLabel.setText("Don't pick more dates!");
            }


        }

        MyDate date = new MyDate(Integer.parseInt(dayTextField.getText()), Integer.parseInt(monthTextField.getText()), Integer.parseInt(yearTextField.getText()));
        model.getDates().add(date);
    }


}
