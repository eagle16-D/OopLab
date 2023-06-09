package hust.soict.sec.javafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Painter extends Application {

	@SuppressWarnings("exports")
	@Override
	public void start(Stage stage) throws Exception{
		Parent rootParent = FXMLLoader.load(getClass().getResource("/hust/soict/sec/javafx/Painter.fxml"));
		
		
		
		Scene scene = new Scene(rootParent);
		stage.setTitle("Painter");
		stage.setScene(scene);
		stage.initStyle(StageStyle.DECORATED);
		stage.show();
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

}
