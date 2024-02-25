package src.lr2.Task7;

interface IBankAccount {
  double deposit(double amount) throws Exception;

  double withdraw(double amount) throws Exception;

  double getBalance();
}

class BankAccount implements IBankAccount {
  private double balance;

  public BankAccount(double initialDeposit) {
    this.balance = initialDeposit;
  }

  @Override
  public double deposit(double amount) throws Exception {
    if (amount <= 0) {
      throw new Exception("Amount must be greater than zero");
    }

    this.balance += amount;
    return this.getBalance();

  }

  @Override
  public double withdraw(double amount) throws Exception {
    if (amount <= 0) {
      throw new Exception("Amount must be greater than zero");
    }

    if (this.balance < amount) {
      throw new Exception("Insufficient balance");
    }

    this.balance -= amount;
    return this.getBalance();

  }

  @Override
  public double getBalance() {
    return this.balance;
  }
}
