import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;

public class OverviewController {
	@FXML
	private TextField cer_id;
	@FXML
	private TextField cer_no;
	@FXML
	private TextField reader;
	@FXML
	private TextField writer;
	@FXML
    private Button readerButton ;
	@FXML
    private Button writerButton ;
	
	// Reference to the main application.
    private Overview overview;
    /**
     * The constructor.
     * The constructor is called before the initialize() method.
     */
    public OverviewController() {
    	cer_id = new TextField();
    	cer_no = new TextField();
    	reader = new TextField();
    	writer = new TextField();
    }
    public void initialize() {
    	readerButton.setOnAction(e -> handleBrowse("reader"));
    	writerButton.setOnAction(e -> handleBrowse("writer"));
    }
    public void setMain(Overview overview) {
        this.overview = overview;
        cer_id.setText(String.valueOf(overview.getModel().getCer_id()));
    	cer_no.setText(String.valueOf(overview.getModel().getCer_no()));
    	reader.setText(overview.getModel().getReader());
    	writer.setText(overview.getModel().getWriter());
    }
    private void handleBrowse(String option){
    	FileChooser fileChooser = new FileChooser();
    	if(option.equals("reader")) {
    		fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter(
                    "Excel files (*.xlsx)", "*.xlsx"));
        }else if(option.equals("writer")) {
        	fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter(
                    "txt files (*.txt)", "*.txt"));
        }
//        if(new File("").exists())
//        	fileChooser.setInitialDirectory(new File(getFolderPath(fileFlag)));
        
        File openFile = fileChooser.showOpenDialog(overview.getPrimaryStage());
        if(option.equals("reader")) {
        	reader.setText(openFile.getPath());
        }else if(option.equals("writer")) {
        	writer.setText(openFile.getPath());
        }
    }
    @FXML
    private void handleExport()throws IOException {
		int num = Integer.parseInt(cer_no.getText());
		List<String> list = ReadExcel.load(new File(reader.getText()));
		FileWriter fw = null;
		try {
			fw = new FileWriter(writer.getText());
			int ctr = 0;
			while(ctr < list.size()) {
				if(!list.get(ctr+1).equals("NULL")) {
					System.out.println("INSERT INTO `students` (`id`, `certificate_id`, `cer_no`, `name`, `mail`, `en_name`) VALUES (NULL,"+'"'+cer_id.getText()+'"'+","+'"'+num+'"'+", "+'"'+list.get(ctr)+'"'+", "+'"'+list.get(ctr+1)+'"'+", '');");
					fw.write("INSERT INTO `students` (`id`, `certificate_id`, `cer_no`, `name`, `mail`, `en_name`) VALUES (NULL,"+'"'+cer_id.getText()+'"'+","+'"'+num+'"'+", "+'"'+list.get(ctr)+'"'+", "+'"'+list.get(ctr+1)+'"'+", '');\r\n");
				}
				num = num + 1;
				ctr = ctr + 2;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			fw.close();
		}
    }
}