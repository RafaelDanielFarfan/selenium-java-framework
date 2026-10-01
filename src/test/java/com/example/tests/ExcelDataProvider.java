package com.example.tests;

import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.DataProvider;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public final class ExcelDataProvider {
    private ExcelDataProvider() {
    }

    @DataProvider(name = "excelLoginData", parallel = true)
    public static Object[][] loginData() {
        return readSheet("testdata/testdata.xlsx", "Login");
    }

    private static Object[][] readSheet(String resource, String sheetName) {
        try (InputStream input = ExcelDataProvider.class.getClassLoader()
                .getResourceAsStream(resource)) {
            if (input == null) {
                throw new IllegalArgumentException("Excel resource not found: " + resource);
            }

            try (Workbook workbook = WorkbookFactory.create(input)) {
                Sheet sheet = workbook.getSheet(sheetName);
                if (sheet == null) {
                    throw new IllegalArgumentException("Sheet not found: " + sheetName);
                }

                List<Object[]> rows = new ArrayList<>();
                DataFormatter formatter = new DataFormatter();

                for (int rowIndex = 1; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
                    Row row = sheet.getRow(rowIndex);
                    if (row == null || row.getCell(0) == null) continue;

                    String username = formatter.formatCellValue(row.getCell(0));
                    String password = formatter.formatCellValue(row.getCell(1));
                    rows.add(new Object[]{username, password});
                }

                return rows.toArray(new Object[0][]);
            }
        } catch (Exception e) {
            throw new RuntimeException("Unable to read Excel test data", e);
        }
    }
}
