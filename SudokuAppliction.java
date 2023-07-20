import java.io.IOException;

import javafx.application.Application;
import javafx.stage.Stage;

public class SudokuAppliction extends Application {
 private UserInterfaceImpl uiImpl;

 @Override
 public void start(Stage primaryStage) throws Exception {
  uiImpl = new UserInterfaceImpl();
  SudokuBuildLogic.build(uiImpl);
 }

 public static void main(String[] args) {
  launch(args);
 }
}