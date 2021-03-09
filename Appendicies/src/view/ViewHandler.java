package view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import mediator.ExamListModel;


public class ViewHandler
{
    private Scene currentScene;
    private Stage primaryStage;
    private ExamListModel examModel;
    private CheckScheduleViewController scheduleViewController;
    private DetailsViewController detailsViewController;
    private ManageDataViewController manageDataViewController;
    private PlanAnExamViewController planAnExamViewController;

    public ViewHandler(ExamListModel model)
    {
        this.currentScene = new Scene(new Region());
        this.examModel = model;
    }

    public void start(Stage primaryStage)
    {
        this.primaryStage = primaryStage;
        openView("DetailsView");
    }

    public void openView(String id)
    {
        Region root = null;
        switch (id)
        {
            case "DetailsView":
                root = loadDetailsView("DetailsView.fxml");
                break;
            case "CheckScheduleView":
                root = loadCheckScheduleView("CheckScheduleView.fxml");
                break;
            case "PlanAnExamView":
                root = loadPlanAnExamView("PlanAnExamView.fxml");
                break;
            case "ManageDataView":
                root = loadManageDateView("ManageDataView.fxml");
                break;
        }
        currentScene.setRoot(root);
        String title = "";
        if (root.getUserData() != null)
        {
            title += root.getUserData();
        }
        primaryStage.setTitle((title));
        primaryStage.setScene(currentScene);
        primaryStage.setWidth(root.getPrefWidth());
        primaryStage.setHeight(root.getPrefHeight());
        primaryStage.show();
    }

    private Region loadDetailsView(String fxmlFile)
    {
        if (detailsViewController == null)
        {
            try
            {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource(fxmlFile));
                Region root = loader.load();
                detailsViewController = loader.getController();
                detailsViewController.init(this, examModel, root);
            } catch (Exception e)
            {
                e.printStackTrace();
            }

        } else
        {
            detailsViewController.reset();
        }
        return detailsViewController.getRoot();
    }

    private Region loadCheckScheduleView(String fxmlFile)
    {
        if (scheduleViewController == null)
        {
            try
            {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource(fxmlFile));
                Region root = loader.load();
                scheduleViewController = loader.getController();
                scheduleViewController.init(this, examModel, root);
            } catch (Exception e)
            {
                e.printStackTrace();
            }

        } else
        {
            scheduleViewController.reset();
        }
        return scheduleViewController.getRoot();
    }

    private Region loadPlanAnExamView(String fxmlFile)
    {
        if (planAnExamViewController == null)
        {
            try
            {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource(fxmlFile));
                Region root = loader.load();
                planAnExamViewController = loader.getController();
                planAnExamViewController.init(this, examModel, root);
            } catch (Exception e)
            {
                e.printStackTrace();
            }

        } else
        {
            planAnExamViewController.reset();
        }
        return planAnExamViewController.getRoot();
    }
    private Region loadManageDateView(String fxmlFile){
        if (manageDataViewController == null)
        {
            try
            {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource(fxmlFile));
                Region root = loader.load();
                manageDataViewController = loader.getController();
                manageDataViewController.init(this, examModel, root);
            } catch (Exception e)
            {
                e.printStackTrace();
            }

        } else
        {
            manageDataViewController.reset();
        }
        return manageDataViewController.getRoot();
    }

    public void closeView()
    {
        primaryStage.close();
    }
}
