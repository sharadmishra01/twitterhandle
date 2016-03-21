package excelsaver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import model.User;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class UserDataFileSaver {

	short currentRow;

	String filename = "UserData.xls";

	private static UserDataFileSaver saver = null;

	public static UserDataFileSaver getFileSaverInstance() {
		if (saver == null) {
			saver = new UserDataFileSaver();
		}
		return saver;
	}

	private UserDataFileSaver() {
		createHeaderAnsSheet();
	}

	private void createHeaderAnsSheet() {

		boolean isAlreadyCreated = false;

		File f = new File(filename);

		if (f.exists() && !f.isDirectory()) {
			isAlreadyCreated = true;
		}

		if (!isAlreadyCreated) {
			HSSFWorkbook workbook = new HSSFWorkbook();
			HSSFSheet sheet = workbook.createSheet("UserData");

			HSSFRow rowhead = sheet.createRow(currentRow);
			rowhead.createCell(0).setCellValue("User Name");
			rowhead.createCell(1).setCellValue("Location");
			rowhead.createCell(2).setCellValue("No. Of Followers");
			rowhead.createCell(3).setCellValue("Status");
			rowhead.createCell(4).setCellValue("User Descr");
			FileOutputStream fileOut;
			try {
				fileOut = new FileOutputStream(filename);
				workbook.write(fileOut);
				fileOut.close();

			} catch (FileNotFoundException e) {
				System.out
						.println("File not found Exception while writing the data to file");
				e.printStackTrace();
			} catch (IOException e) {
				System.out
						.println("IO Exception while writing the data to file");
				e.printStackTrace();
			}
			System.out.println("Your excel file has been generated!");
		}

	}

	public void insertResultDataToExcel(User data) {

		try {
			FileInputStream file = new FileInputStream(filename);

			HSSFWorkbook workbook = new HSSFWorkbook(file);
			HSSFSheet sheet = workbook.getSheetAt(0);

			// Update the value of cell
			HSSFRow dataRow = sheet.createRow(sheet.getLastRowNum() + 1);
			dataRow.createCell(0).setCellValue(data.getUserName());
			dataRow.createCell(1).setCellValue(data.getLocation());
			dataRow.createCell(2).setCellValue(data.getFollowers());
			dataRow.createCell(3).setCellValue(data.getStatus());
			dataRow.createCell(4).setCellValue(data.getDescription());

			file.close();

			FileOutputStream outFile = new FileOutputStream(new File(filename));
			workbook.write(outFile);
			outFile.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
