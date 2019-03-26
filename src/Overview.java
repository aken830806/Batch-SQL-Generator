import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;

public class Overview extends Application {
	private Stage primaryStage;
	private AnchorPane rootLayout;
	Model model;
	
	public Overview() {
		model = new Model(109,1,"C:\\Users\\USER\\Desktop\\123.xlsx","C:\\Users\\USER\\Desktop\\SQL.txt");
	}
	public Model getModel() {
		return model;
	}
	public Stage getPrimaryStage() {
        return primaryStage;
    }
	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Certificate_SQL_Generator");
        
        initRootLayout();
	}
	/**
     * Initializes the root layout.
     */
    public void initRootLayout() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Overview.class.getResource("Overview.fxml"));
            rootLayout = (AnchorPane) loader.load();
            
            OverviewController controller = loader.getController();
            controller.setMain(this);
            
            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	public static void main(String[] args) {
		launch(args);
	}
}
