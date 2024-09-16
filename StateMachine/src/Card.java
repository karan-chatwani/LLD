public class Card {
    private int balance;
    private int pin;

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public String getBankInfo() {
        return bankInfo;
    }

    public void setBankInfo(String bankInfo) {
        this.bankInfo = bankInfo;
    }

    private String bankInfo;

    public Card(int balance, int pin, String bankInfo) {
        this.balance = balance;
        this.pin = pin;
        this.bankInfo = bankInfo;
    }
}
