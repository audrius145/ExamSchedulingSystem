package view;

import mediator.ExamListModel;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.Region;
import model.*;
import parser.ParserException;

import java.io.FileNotFoundException;
import java.util.Optional;

public class ManageDataViewController
{
    private Region root;
    private ViewHandler viewHandler;
    private ExamListModel model;
    private ExamListViewModel viewModel;
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
    Label errorLabel;
    @FXML
    ChoiceBox roomDropDown;
    @FXML
    TextField dayTextField;
    @FXML
    TextField monthTextField;
    @FXML
    TextField yearTextField;

    public ManageDataViewController()
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
        roomDropDown.setItems(FXCollections.observableArrayList(model.getRooms().getAllRooms()));
        roomDropDown.setTooltip(new Tooltip("Select a room!"));
        errorLabel.setText("");
        reset();

    }

    public void reset()
    {

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
    private void editButtonPressed() throws FileNotFoundException, ParserException
    {
        try
        {
            errorLabel.setText("");
            if (examTable.getSelectionModel().getSelectedItem() != null)
            {

                ExamViewModel selectedItem = examTable.getSelectionModel().getSelectedItem();
                Exam exam = new Exam(selectedItem.getCourse(), selectedItem.getTheClass(), selectedItem.getRoom(), selectedItem.isWritten());
                if (roomDropDown.getSelectionModel().getSelectedItem() != null)
                {
                    model.setExamRoom((Room) roomDropDown.getSelectionModel().getSelectedItem(), exam);
                }
            }
        } catch (Exception e)
        {
            errorLabel.setText("Select an exam to edit!");
        }
        viewModel.update();
        model.getFileConsole().writeExamList(model.getExamList());

    }

    @FXML
    private void deleteButtonPressed() throws FileNotFoundException, ParserException
    {
        if (examTable.getSelectionModel().getSelectedItem() != null)
        {
            errorLabel.setText("Select an exam to delete!");
        }
        errorLabel.setText("");
        try
        {
            ExamViewModel selectedItem = examTable.getSelectionModel().getSelectedItem();
            boolean remove = confirmation();

            if (remove)
            {

                Exam exam = new Exam(selectedItem.getCourse(), selectedItem.getTheClass(), selectedItem.getRoom(), selectedItem.isWritten());
                model.removeAnExam(exam);
                viewModel.remove(exam);
                examTable.getSelectionModel().clearSelection();
            }
        } catch (Exception e)
        {
            errorLabel.setText("Item not found: " + e.getMessage());
        }
        viewModel.update();
        model.getFileConsole().writeExamList(model.getExamList());
        model.getFileConsole().writeExamListManual(model.getExamList());
    }

    private boolean confirmation()
    {
        int index = examTable.getSelectionModel().getSelectedIndex();
        ExamViewModel selectedItem = examTable.getItems().get(index);
        if (index < 0 || index >= examTable.getItems().size())
        {
            return false;
        }
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText("Removing exam {Course: " + selectedItem.getCourseProperty().get() + ", Class: " + selectedItem.getclassProperty().get() + "}");
        Optional<ButtonType> result = alert.showAndWait();
        return (result.isPresent()) && (result.get() == ButtonType.OK);
    }

    @FXML
    private void addButton()
    {

        ExamViewModel selectedItem = examTable.getSelectionModel().getSelectedItem();
        Exam exam = new Exam(selectedItem.getCourse(), selectedItem.getTheClass(), selectedItem.getRoom(), selectedItem.isWritten());
        MyDate date = new MyDate(Integer.parseInt(dayTextField.getText()), Integer.parseInt(monthTextField.getText()), Integer.parseInt(yearTextField.getText()));
        model.getDate(exam).add(date);
    }

}
