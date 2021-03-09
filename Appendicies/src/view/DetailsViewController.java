package view; //DONE FUNCTIONALITYVISE

import javafx.fxml.FXML;
import javafx.scene.layout.Region;
import mediator.ExamListModel;

public class DetailsViewController
{
    private Region root;
    private ViewHandler viewHandler;
    private ExamListModel model;
    private ExamListViewModel viewModel;

    public DetailsViewController()
    {
    }


    public void init(ViewHandler viewHandler, ExamListModel model, Region root)
    {
        this.viewHandler = viewHandler;
        this.model = model;
        this.root = root;
        this.viewModel = new ExamListViewModel(model);

    }

    public void reset()
    {
    }

    public Region getRoot()
    {
        return root;
    }

    @FXML
    private void planAnExamButtonPressed()
    {
        viewHandler.closeView();
        viewHandler.openView("PlanAnExamView");
    }

    @FXML
    private void manageDataButtonPressed()
    {
        viewHandler.closeView();
        viewHandler.openView("ManageDataView");
    }

    @FXML
    private void checkScheduleButtonPressed()
    {
        viewHandler.closeView();
        viewHandler.openView("CheckScheduleView");
    }
}
