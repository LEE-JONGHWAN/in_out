package verify.exam07;

import java.io.File;
import java.util.Scanner;

import sec00.Consts;

public class AddLineNumberExample {
	public static void main(String[] args) throws Exception {
		String filePath = Consts.CH18 
			+ "/sec05/exam04_bufferedreader/BufferedReaderExample.java";
		
		Scanner sc = new Scanner(new File(filePath));
		int lineNo = 0;
		StringBuilder sb = new StringBuilder();
		
		while(sc.hasNextLine()) {
			sb.append(++lineNo);
			sb.append(". ");
			sb.append(sc.nextLine());
			System.out.println(sb.toString());
			sb.setLength(0);
		}
		
//		FileReader fr = new FileReader(filePath);
//		BufferedReader br = new BufferedReader(fr);
//		
//		int rowNumber = 0;
//		String rowData;
//		while( (rowData=br.readLine())!= null ) {
//			System.out.println(++rowNumber + ": " + rowData);
//		}
//		
//		br.close(); fr.close();
	}
}
