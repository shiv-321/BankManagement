package banking_project;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Calendar;

public class Utils {
	public String accountNumber() {
		Calendar c = Calendar.getInstance();
		String year = (c.get(Calendar.YEAR))%100 +"";
		int month = c.get(Calendar.MONTH) +1;
		String mon = "";
		if(month<10) {
			mon= "0"+month;
		}else {
			mon = "" + month;
		}
		int date = c.get(Calendar.DATE);
		String d = "";
		if(date <10) {
			d ="0"+date;
		}else {
			d = "" +date;
		}
		String dt = year + mon +d;
		File file = new File(dt+".txt");
		if(file.exists()) {
			try {
				FileInputStream fis = new FileInputStream(file);
				String data = "";
				int x;
				while((x=fis.read())!=-1) {
					data += (char)x;
				}
				int useNum = Integer.parseInt(data) +1;
				FileOutputStream fos = new FileOutputStream(dt+".txt");
				fos.write((useNum+"").getBytes());
				
				if(useNum<10) {
					return dt + "00" + useNum;
				}else if(useNum<100) {
					return dt + "0"+ useNum;
				}else {
					return dt + useNum;
				}
	
			}catch(Exception e ){
			System.out.println(e.getMessage());
			return null;
			}
			
		}else {
			try {
				FileOutputStream fos = new FileOutputStream(dt + ".txt");
				fos.write("1".getBytes());
				return dt + "001";

			}catch(Exception e) {
				System.out.println(e.getMessage());
				return null;
			}
			
		}
	}

}
