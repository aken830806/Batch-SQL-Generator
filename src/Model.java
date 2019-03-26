import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Model{
	private final IntegerProperty cer_id;
	private final IntegerProperty cer_no;
	private final StringProperty reader;
	private final StringProperty writer;
	 /**
     * Default constructor.
     */
	public Model() {
		this(0,0,null,null);
	}
	 /**
     * Constructor with some initial data.
     * 
     * @param cer_id
     * @param cer_no 
     * @param reader
     * @param writer
     */
	public Model(int cer_id,int cer_no,String reader,String writer) {
        this.cer_id = new SimpleIntegerProperty(cer_id);
        this.cer_no = new SimpleIntegerProperty(cer_no);
        this.reader = new SimpleStringProperty(reader);
        this.writer = new SimpleStringProperty(writer);
	}
    public int getCer_id() {
        return cer_id.get();
    }

    public void setCer_id(int cer_id) {
        this.cer_id.set(cer_id);
    }

    public IntegerProperty cer_idProperty() {
        return cer_id;
    }
    public int getCer_no() {
        return cer_no.get();
    }

    public void setCer_no(int cer_no) {
        this.cer_no.set(cer_no);
    }

    public IntegerProperty cer_noProperty() {
        return cer_no;
    }
	public String getReader() {
        return reader.get();
    }

    public void setReader(String reader) {
        this.reader.set(reader);
    }

    public StringProperty readerProperty() {
        return reader;
    }

    public String getWriter() {
        return writer.get();
    }

    public void setWriter(String writer) {
        this.writer.set(writer);
    }

    public StringProperty writerProperty() {
        return writer;
    }
}