package utils;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class DP001 {
	
//	@Test
	@DataProvider(name="fetchData")
	public static String[][] getData() {
		
		String [][] testData = null ;
		
		/*testData[0][0] ="Tester123";
		testData[0][1] ="Johnson";
		testData[0][2] ="tester123@gmail.com";
		testData[0][3] ="tester123@gmail.com";
		
		
		testData[1][0] ="Tester456";
		testData[1][1] ="Testerson";
		testData[1][2] ="tester456@gmail.com";
		testData[1][3] ="tester456@gmail.com";*/
		
		
		
		try {
			FileInputStream fis = new FileInputStream("./testData/TC001.xlsx");
			
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			
			XSSFSheet sheet = wb.getSheetAt(0);
			
			int rowCount = sheet.getLastRowNum();
			
			int columnCount = sheet.getRow(0).getLastCellNum();
			
			System.out.println("Row Count "+rowCount);
			
			System.out.println("Column Count "+columnCount);
			
			testData = new String[rowCount][columnCount];
			
			for(int i=1; i<=rowCount; i++) {
				
				XSSFRow row = sheet.getRow(i);
				
				for(int j=0; j<columnCount;j++) {
					
					String cellData = row.getCell(j).getStringCellValue();
					
					System.out.println("The value of row "+i+" and column "+j+" is "+cellData);
					
					testData[i-1][j] = cellData;
				}	
			}	
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return testData;	
	}
}
