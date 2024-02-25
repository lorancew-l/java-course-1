package src.lr2.Task2;

public class SnakeArray {
  int[][] array;
  int rowCount, columnCount;

  public SnakeArray(int rowCount, int columnCount) {
    this.rowCount = rowCount;
    this.columnCount = columnCount;
    this.array = new int[rowCount][columnCount];

    int maxIndex = rowCount * columnCount;

    for (int i = 0; i < maxIndex; i++) {
      int rowIndex = i / columnCount;
      boolean isEvenRow = rowIndex % 2 == 0;
      int columnIndex = isEvenRow ? i - rowIndex * columnCount : (columnCount * (rowIndex + 1) - 1) - i;

      this.array[rowIndex][columnIndex] = i;
    }

  }

  public void printArray() {
    for (int i = 0; i < this.rowCount; i++) {
      for (int j = 0; j < this.columnCount; j++) {
        System.out.print(this.array[i][j] + "\t");
      }
      System.out.println();
    }
  }
}
