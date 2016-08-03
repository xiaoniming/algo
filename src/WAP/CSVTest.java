package WAP;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;

public class CSVTest {
	private static final String PATH = "D:/EclipseProject/files/test.csv";
	private static final String PATH_JAR = "D:/EclipseProject/files/test_jar.csv";

	public static void main(String[] args) {
		new CSVTest();
	}

	public CSVTest() {
		// exportCsv();
		// importCsv();
		exportCsvWithJar();
		importCsvWithJar();
	}

	public void exportCsv() {
		List<String> dataList = new ArrayList<String>();
		dataList.add("1,Mike,male");
		dataList.add("2,Jim,male");
		dataList.add("3,Rose,female");
		boolean isSuccess = CSVUtils.exportCsv(new File(PATH), dataList);
		System.out.println(isSuccess);
	}

	public void importCsv() {
		List<String> dataList = CSVUtils.importCsv(new File(PATH));
		if (dataList != null && !dataList.isEmpty()) {
			for (String data : dataList) {
				System.out.println(data);
			}
		}
	}

	// 写入CSV文件，无追加功能，所以每次都得重新写（包括表头）：
	public void exportCsvWithJar() {
		try {
			CsvWriter wr = new CsvWriter(PATH_JAR, ',', Charset.forName("GBK"));
			String[] contents = { "Name", "Class", "ID", "Sex" };
			String[] contents_1 = { "Mike", "6012", "1201", "Male" };
			String[] contents_2 = { "Jim", "6013", "1301", "Male" };
			String[] contents_3 = { "Rose", "6013", "1302", "Female" };
			wr.writeRecord(contents);
			wr.writeRecord(contents_1);
			wr.writeRecord(contents_2);
			wr.writeRecord(contents_3);
			wr.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void importCsvWithJar() {
		try {
			CsvReader reader = new CsvReader(PATH_JAR, ',', Charset.forName("GBK"));
			// 读取表头
			reader.readHeaders();
			// 逐条读取记录，直至读完
			while (reader.readRecord()) {
				// 读取一条记录
				System.out.println(reader.getRawRecord());
				// 按列名读取这条记录的值
				System.out.println(reader.get("Name"));
				System.out.println(reader.get("Class"));
				System.out.println(reader.get("ID"));
				System.out.println(reader.get("Sex"));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
