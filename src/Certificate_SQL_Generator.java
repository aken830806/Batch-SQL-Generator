import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Certificate_SQL_Generator{
	
	public static void main (String[] args) throws IOException{
		Certificate_SQL_Generator g = new Certificate_SQL_Generator();
		g.generator("C:\\Users\\USER\\Desktop\\123.xlsx");
    }
	public void generator(String path) throws IOException {
		String cer_id = "109";
		int cer_no = 1;
		List<String> list = ReadExcel.load(new File(path));
		FileWriter fw = null;
		try {
			fw = new FileWriter("C:\\Users\\USER\\Desktop\\SQL.txt");
			int ctr = 0;
			while(ctr < list.size()) {
				if(!list.get(ctr+1).equals("NULL")) {
					System.out.println("INSERT INTO `students` (`id`, `certificate_id`, `cer_no`, `name`, `mail`, `en_name`) VALUES (NULL,"+'"'+cer_id+'"'+","+'"'+cer_no+'"'+", "+'"'+list.get(ctr)+'"'+", "+'"'+list.get(ctr+1)+'"'+", '');");
					fw.write("INSERT INTO `students` (`id`, `certificate_id`, `cer_no`, `name`, `mail`, `en_name`) VALUES (NULL,"+'"'+cer_id+'"'+","+'"'+cer_no+'"'+", "+'"'+list.get(ctr)+'"'+", "+'"'+list.get(ctr+1)+'"'+", '');\r\n");
//					System.out.println("UPDATE course SET sponsor = "+'"'+list.get(ctr+1)+'"'+" WHERE id="+list.get(ctr)+";");
//					fw.write("UPDATE course SET sponsor = "+'"'+list.get(ctr+1)+'"'+" WHERE id="+list.get(ctr)+";\r\n");
				}
				cer_no = cer_no + 1;
				ctr = ctr + 2;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			fw.close();
		}
	}
}