package lr8.task5;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ImprovedExcelParser {
  public static void main(String[] args) {
    String filePath = "src/lr8/task5/example.xlsx";
    XSSFWorkbook workbook = null;

    try {
      File file = new File(filePath);
      workbook = new XSSFWorkbook(file);

      Sheet sheet = workbook.getSheet("Товары");
      if (sheet == null) {
        throw new IllegalArgumentException(
            "Лист 'Товары' не найден. Пожалуйста, проверьте название листа в файле " + filePath);
      }

      for (Row row : sheet) {
        for (Cell cell : row) {
          System.out.print(cell.toString() + "\t");
        }
        System.out.println();
      }

    } catch (FileNotFoundException e) {
      System.err.println("Файл не найден: " + filePath + ". Проверьте путь к файлу и попробуйте снова.");
    } catch (InvalidFormatException e) {
      System.err.println("Неверный формат файла: " + filePath + ". Убедитесь, что файл имеет формат .xlsx.");
    } catch (IOException e) {
      System.err.println("Ошибка ввода-вывода при работе с файлом: " + filePath);
    } catch (IllegalArgumentException e) {
      System.err.println(e.getMessage());
    } finally {
      try {
        if (workbook != null) {
          workbook.close();
        }
      } catch (IOException e) {
        System.err.println("Ошибка при закрытии ресурсов.");
      }
    }
  }
}