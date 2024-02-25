package src.lr2.Task3;

public class CaesarCipher {
  private int key;
  private int alphabetLetterCount;
  private char firstChar;

  public CaesarCipher(int key, int alphabetLetterCount, char firstChar) {
    this.key = key;
    this.alphabetLetterCount = alphabetLetterCount;
    this.firstChar = firstChar;
  }

  public String encrypt(String text) {
    StringBuilder result = new StringBuilder();

    for (int i = 0; i < text.length(); i++) {
      char ch = text.charAt(i);
      if (Character.isLetter(ch)) {
        // Вычитаем код первого символа, чтобы "нормализовать алфавит", так как алфавит
        // стартует не с 0
        char shifted = (char) (((ch - this.firstChar + this.key) % this.alphabetLetterCount) + this.firstChar);
        result.append(shifted);
      } else {
        result.append(ch);
      }
    }

    return result.toString();
  }

  public String decrypt(String text) {
    StringBuilder result = new StringBuilder();

    for (int i = 0; i < text.length(); i++) {
      char ch = text.charAt(i);
      if (Character.isLetter(ch)) {
        char shifted = (char) (((ch - this.firstChar - this.key + this.alphabetLetterCount) % this.alphabetLetterCount)
            + this.firstChar);
        result.append(shifted);
      } else {
        result.append(ch);
      }
    }
    return result.toString();
  }
}
