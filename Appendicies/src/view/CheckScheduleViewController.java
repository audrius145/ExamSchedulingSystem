package view;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.Region;
import model.Class;
import model.Course;
import model.ExamList;
import mediator.ExamListModel;

import parser.ParserException;

public class CheckScheduleViewController
{
    private Region root;
    private ViewHandler viewHandler;
    private ExamListModel model;
    private ExamListViewModel viewModel;
    @FXML
    private TextField teacherField;
    @FXML
    private TableView<ExamViewModel> examTable;
    @FXML
    private TableColumn<ExamViewModel, String> classField;
    @FXML
    private TableColumn<ExamViewModel, String> courseField;
    @FXML
    private TableColumn<ExamViewModel, String> datesField;
    @FXML
    private TableColumn<ExamViewModel, String> roomField;
    @FXML
    private TableColumn<ExamViewModel, String> examinerField;
    @FXML
    ChoiceBox classDropDown;
    @FXML
    ChoiceBox courseDropDown;

    public CheckScheduleViewController()
    {
    }

    public void init(ViewHandler viewHandler, ExamListModel model, Region root)
    {
        this.viewHandler = viewHandler;
        this.model = model;
        this.root = root;
        this.viewModel = new ExamListViewModel(model);
        classField.setCellValueFactory(cellData -> cellData.getValue().getclassProperty());
        courseField.setCellValueFactory(cellData -> cellData.getValue().getCourseProperty());
        roomField.setCellValueFactory(cellData -> cellData.getValue().getroomProperty());
        datesField.setCellValueFactory(cellData -> cellData.getValue().getdateProperty());
        examinerField.setCellValueFactory(cellData -> cellData.getValue().getexaminerProperty());
        courseDropDown.setItems(FXCollections.observableArrayList(model.getCourses().getCourses()));
        courseDropDown.setTooltip(new Tooltip("Select a course!"));
        classDropDown.setItems(FXCollections.observableArrayList(model.getTheClasses().getAllClasses()));
        classDropDown.setTooltip(new Tooltip("Select a class!"));
        reset();

    }

    public void reset()
    {
        courseDropDown.setItems(FXCollections.observableArrayList(model.getCourses().getCourses()));
        courseDropDown.setTooltip(new Tooltip("Select a course!"));
        classDropDown.setItems(FXCollections.observableArrayList(model.getTheClasses().getAllClasses()));
        classDropDown.setTooltip(new Tooltip("Select a class!"));
        teacherField.setText("");
        examTable.setItems(viewModel.update());
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
    private void okButtonPressed() throws ParserException
    {
        try
        {
            if (teacherField.getText() != null)
            {
                ExamList teachersScheduleById = model.getTeachersScheduleById(teacherField.getText());
                viewModel.updateFilter(teachersScheduleById.getAll());
            }
            if ((classDropDown.getSelectionModel().getSelectedItem()) != null)
            {
                ExamList classSchedule = model.getClassSchedule((Class) classDropDown.getSelectionModel().getSelectedItem());
                viewModel.updateFilter(classSchedule.getAll());
            }
            if ((courseDropDown.getSelectionModel().getSelectedItem()) != null)
            {
                ExamList courseSchedule = model.getCourseSchedule((Course) courseDropDown.getSelectionModel().getSelectedItem());
                viewModel.updateFilter(courseSchedule.getAll());
            }
        } catch (Exception e)
        {
            if (teacherField.getText() == null && (classDropDown.getSelectionModel().getSelectedItem()) == null && (courseDropDown.getSelectionModel().getSelectedItem()) == null)
            {
            }
        }


    }

    @FXML
    private void resetButtonPressed()
    {
        reset();
    }

}
