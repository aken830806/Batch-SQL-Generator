import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
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
    /**
     * Show information dialog with dialog(標題列文字,對話框視窗裡的標頭文字,對話框的訊息文字)
     *	 提示
     * 
     * @param
     */ 
    public Alert informDialog(String title,String header,String content) {
    	final Alert alert = new Alert(AlertType.INFORMATION); // 實體化Alert對話框物件，並直接在建構子設定對話框的訊息類型
        alert.setTitle(title); //設定對話框視窗的標題列文字
        alert.setHeaderText(header); //設定對話框視窗裡的標頭文字。若設為空字串，則表示無標頭
        alert.setContentText(content); //設定對話框的訊息文字
        alert.showAndWait(); //顯示對話框，並等待對話框被關閉時才繼續執行之後的程式
        return alert;
    }
	public static void main(String[] args) {
		launch(args);
	}
}
