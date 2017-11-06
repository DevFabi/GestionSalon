package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main extends Application {
	private Stage primaryStage;
	private AnchorPane root;
	@Override
	public void start(Stage primaryStage) {
		try {
			this.primaryStage  = primaryStage;
			 root = new AnchorPane();
			
			FXMLLoader acc = new FXMLLoader() ;
			acc.setLocation(Main.class.getClassLoader().getResource("views/Selection.fxml"));
			AnchorPane root = (AnchorPane)acc.load();
			Scene scene = new Scene(root,950,600);
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			this.primaryStage.setScene(scene);
			this.primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	/**
     * Returns the main stage.
     * @return
     */
    public Stage getPrimaryStage() {
        return primaryStage;
    }
	public static void main(String[] args) {
		launch(args);
	}
}
