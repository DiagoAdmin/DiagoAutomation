package excelFiles;

import java.io.File;
import java.io.IOException;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class WriteExcelTestData {

	public static void main(String[] args) throws BiffException, IOException {
		File f= new File("d:\\Test cases for ROPA.xls");
		Workbook wb=Workbook.getWorkbook(f);
		Sheet ws=wb.getSheet(0);
		int row=ws.getRows();
		int column=ws.getColumns();
		for(int j=0;j<column;j++)
		{
			for(int i=0;i<row;i++)
			{
				Cell cellexcel=ws.getCell(j, i);
				String contentsincell=cellexcel.getContents();
				System.out.println(contentsincell);
			}
		}

			}
	}

