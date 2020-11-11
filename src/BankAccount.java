import java.math.BigDecimal;

public class BankAccount {
    AccountOwner accountOwner;
    BigDecimal balance;
    long accountNumber;

    BankAccount(AccountOwner accountOwner, double balance) {
        this.accountOwner = accountOwner;
        this.balance = validateBalance(balance);
        accountNumber = (long)(Math.random() * 1000000000);
    }

    public int deposit(double amount) {
        BigDecimal _amount = new BigDecimal(amount);

        if (amount > 0) {
            balance = balance.add(_amount);
            return ATM.SUCCESS;
        } else {
            return ATM.INVALID_AMOUNT;
        }
    }

    public int withdraw(double amount) {
        BigDecimal _amount = new BigDecimal(amount);

        if (amount > 0 && _amount.compareTo(balance) < 0) {
            balance = balance.subtract(_amount);
            return ATM.SUCCESS;
        } else if (amount <= 0) {
            return ATM.INVALID_AMOUNT;
        } else {
            return ATM.INSUFFICIENT_FUNDS;
        }
    }

    public int transfer(long account, double amount) {
        BankAccount recipient = ATM.lookup(account);
        BigDecimal _amount = new BigDecimal(amount);

        if (amount > 0 && _amount.compareTo(balance) < 0 && recipient != null) {
            balance = balance.subtract(_amount);
            recipient.balance = recipient.balance.add(_amount);
            return ATM.SUCCESS;
        } else if (amount <= 0) {
            return ATM.INVALID_AMOUNT;
        } else if (_amount.compareTo(balance) > 0) {
            return ATM.INSUFFICIENT_FUNDS;
        } else {
            return ATM.ACCOUNT_NOT_FOUND;
        }
    }

    public java.lang.String getMaskedAccountNumber() {
        String num = String.valueOf(accountNumber);
        while (num.length() < 8) {
            num = "0".concat(num);
        }
        return "****".concat(num.substring(5));
    }

    public java.lang.String getFormattedBalance(){
        return "$".concat(String.format("%,.2f", balance));
    }

    public java.math.BigDecimal validateBalance(double balance) {
        if (balance >= 0) {
            return BigDecimal.valueOf(balance);
        } else {
            return BigDecimal.ZERO;
        }
    }

    public long getAccountNumber(){
        return accountNumber;
    }

    public AccountOwner getAccountOwner(){
        return accountOwner;
    }

    public void setAccountOwner(AccountOwner accountOwner) {
        this.accountOwner = accountOwner;
    }

    public java.math.BigDecimal getBalance() {
        return balance;
    }
}
