

public enum TransactionType {
    CASH_WITHDRAWL,
    CHECK_BALANCE;

    public static void showTransactions() {
        for (TransactionType transactionType : TransactionType.values()) {
            System.out.println("Transaction: " + transactionType.name());
        }
    }
}
