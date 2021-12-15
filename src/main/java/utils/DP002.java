package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class DP002 {
	
	@DataProvider(name="ssk")
	public static String[][] getData() {
		
		String[][] testData = null;
		
		/*testData[0][0]="Tester123";
		testData[0][1]="Johnson";
		testData[0][2]="Tester123@gmail.com";
		testData[0][3]="9999988888";
		testData[0][4]="SSk";
		testData[0][5]="PVK Street";
		testData[0][6]="SBI Colony";
		testData[0][7]="Vizag";
		testData[0][8]="Andhra Pradesh";
		testData[0][9]="555555";
		testData[0][10]="India";
		testData[0][11]="0";
		testData[0][12]="9999988888";
		
		testData[1][0]="Tester456";
		testData[1][1]="Testerson";
		testData[1][2]="Tester456@gmail.com";
		testData[1][3]="9999977777";
		testData[1][4]="SSS";
		testData[1][5]="KV Street";
		testData[1][6]="SBH Colony";
		testData[1][7]="Hyderabad";
		testData[1][8]="Telangana";
		testData[1][9]="555444";
		testData[1][10]="India";
		testData[1][11]="1";
		testData[1][12]="9999977777";*/
		
		try {
			FileInputStream fis=new FileInputStream("./testData/TC002.xlsx");
			
		    XSSFWorkbook wb=new XSSFWorkbook(fis);
		    XSSFSheet sheet=wb.getSheetAt(0);
		    int rowCount=sheet.getLastRowNum();
			int columnCount=sheet.getRow(0).getLastCellNum();
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
