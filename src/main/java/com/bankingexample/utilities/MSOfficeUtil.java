package com.bankingexample.utilities;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * This class will use to read data from external resources such as fetching login credentials from excel sheet.
 */
public class MSOfficeUtil {

    private static FileInputStream fileInputStream;
    private static FileOutputStream fileOutputStream;
    private static Workbook excelWBook;
    private static Sheet excelWSheet;


    public static Object[][] getTableArray(String filePath, String SheetName) throws Exception {
        Object[][] tabArray = null;

        try {
            fileInputStream = new FileInputStream(filePath);
            Workbook excelWBook = new XSSFWorkbook(fileInputStream);
            excelWSheet = excelWBook.getSheet(SheetName);

            int totalRows = excelWSheet.getLastRowNum() + 1;
            int totalCols = excelWSheet.getRow(0).getLastCellNum();

            tabArray = new Object[totalRows][totalCols];

            for (int i = 0; i < totalRows; i++) {

                Row row = excelWSheet.getRow(i);

                for (int j = 0; j < totalCols; j++) {

                    Cell cell = row.getCell(j);
                    if (CellType.NUMERIC == cell.getCellType()) {
                        tabArray[i][j] = cell.getNumericCellValue();

                    } else if (CellType.STRING == cell.getCellType()) {
                        tabArray[i][j] = cell.getStringCellValue();

                    } else if (CellType.BOOLEAN == cell.getCellType()) {
                        tabArray[i][j] = cell.getBooleanCellValue();

                    } else {
                        tabArray[i][j] = "";
                    }
                }
            }
            CustomLogger.getInstance().info("list " + tabArray);

        } catch (FileNotFoundException e) {
            System.out.println("Could not read the Excel sheet");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Could not read the Excel sheet");
            e.printStackTrace();
        }
        return tabArray;
    }

    public static int getRowCount(String filePath, String SheetName) {

        try {
            fileInputStream = new FileInputStream(filePath);
            excelWBook = new XSSFWorkbook(fileInputStream);
            excelWSheet = excelWBook.getSheet(SheetName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        closeFile();
        return excelWSheet.getLastRowNum();

    }

    public static int getCellCount(String filePath, String SheetName, int rowNum) {

        try {
            fileInputStream = new FileInputStream(filePath);
            excelWBook = new XSSFWorkbook(fileInputStream);
            excelWSheet = excelWBook.getSheet(SheetName);
            //  row = excelWSheet.getRow(rowNum);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        closeFile();
        return excelWSheet.getRow(rowNum).getLastCellNum();
    }

    public static void closeFile() {
        try {
            excelWBook.close();
            fileInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
