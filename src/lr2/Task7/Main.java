package src.lr2.Task7;

public class Main {
  public static void main(String[] args) {
    IBankAccount account = new BankAccount(1000);

    System.out.println("Initial balance: " + account.getBalance());

    try {
      double depositAmount = 500;
      double balanceAfterDeposit = account.deposit(depositAmount);
      System.out.println(String.format("Balance after deposit %s: %s", depositAmount, balanceAfterDeposit));
    } catch (Exception error) {
      System.out.println("Trying to deposit invalid amount: " + error);
    }

    try {
      account.deposit(-500);
    } catch (Exception error) {
      System.out.println("Trying to deposit invalid amount: " + error);
    } finally {
      System.out.println("Balance: " + account.getBalance());
    }

    try {
      double withdrawAmount = 200;
      double balanceAfterWithdraw = account.withdraw(withdrawAmount);
      System.out.println(String.format("Balance after withdraw %s: %s", withdrawAmount, balanceAfterWithdraw));
    } catch (Exception error) {
      System.out.println("Trying to deposit invalid amount: " + error);
    }

    try {
      account.withdraw(-500);
    } catch (Exception error) {
      System.out.println("Trying to withdraw invalid amount: " + error);
    }

    try {
      account.withdraw(20000);
    } catch (Exception error) {
      System.out.println("Trying to withdraw invalid amount: " + error);
    }

    System.out.println("Final balance: " + account.getBalance());
  }
}
