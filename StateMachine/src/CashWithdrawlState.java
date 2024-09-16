public class CashWithdrawlState extends AtmState {
    public CashWithdrawlState() {
        System.out.println("Enter the amount");
    }

    @Override
    public void cachWithdrawl(Atm atm, Card card, int amount) {
        if (validateAmount(amount, card, atm)) {
            CachWithdrawalProcessor cachWithdrawalProcessor = new FiveHundredWithdrawalProcessor(new HundredWithdrawalProcessor(null));
            cachWithdrawalProcessor.withdraw(atm, amount);
            card.setBalance(card.getBalance() - amount);
            cancel(atm);
        }

    }

    private boolean validateAmount(int amount, Card card, Atm atm) {
        if (card.getBalance() < amount || atm.getAtmBalance() < amount) {
            System.out.println("Insufficient fund");
            cancel(atm);
            return false;
        }
        return true;
    }
}
