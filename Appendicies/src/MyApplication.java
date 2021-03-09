import javafx.application.Application;
import javafx.stage.Stage;
import mediator.ExamModelManager;
import parser.ParserException;
import view.ViewHandler;

import java.io.FileNotFoundException;


public class MyApplication extends Application
{
    public void start(Stage primaryStage) throws ParserException, FileNotFoundException
    {
        ExamModelManager model = new ExamModelManager();
        ViewHandler view  = new ViewHandler(model);
        view.start(primaryStage);
    }
}