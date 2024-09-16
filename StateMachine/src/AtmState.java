public abstract class AtmState {
    public void enterCard(Atm atm, Card card) {
        throw new NotValidOperationException("Not valid operation");
    }

    public void validatePin(Atm atm, Card card, int pin) {
        throw new NotValidOperationException("Not valid operation");
    }

    public void selectOperations(Atm atm, TransactionType transactionType) {
        throw new NotValidOperationException("Not valid operation");

    }

    public void cachWithdrawl(Atm atm, Card card, int amount) {
        throw new NotValidOperationException("Not valid operation");
    }

    public void checkBalance(Atm atm, Card card) {
        throw new NotValidOperationException("Not valid operation");
    }

    public void cancel(Atm atm) {
        returnCard();
        atm.setAtmState(new IdleAtmState());
        System.out.println("exit");
    }
    private void returnCard() {
        System.out.println("Take back your card");
    }
}
