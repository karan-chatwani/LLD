public class OperationSelectionAtmState extends AtmState {
    public OperationSelectionAtmState() {
        TransactionType.showTransactions();
        ;
        System.out.println("Select operation");
    }

    @Override
    public void selectOperations(Atm atm, TransactionType transactionType) {
        switch (transactionType) {
            case CASH_WITHDRAWL -> {
                atm.setAtmState(new CashWithdrawlState());
                break;
            }
            case CHECK_BALANCE -> {
                atm.setAtmState(new CheckBalanceState());
                break;
            }
            default -> {
                System.out.println("Invalid operation");
                cancel(atm);
            }
        }
    }
}
