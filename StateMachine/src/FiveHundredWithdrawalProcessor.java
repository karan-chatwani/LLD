public class FiveHundredWithdrawalProcessor extends CachWithdrawalProcessor {
    CachWithdrawalProcessor cachWithdrawalProcessor;

    public FiveHundredWithdrawalProcessor(CachWithdrawalProcessor cachWithdrawalProcessor) {
        this.cachWithdrawalProcessor = cachWithdrawalProcessor;
    }

    @Override
    public void withdraw(Atm atm, int amount) {
        int notes = amount / 500;
        if (notes > atm.getFiveHundredNotes()) {
            System.out.println("Something went wrong");
            return;
        }
        atm.setFiveHundredNotes(atm.getFiveHundredNotes() - notes);
        atm.setAtmBalance(atm.getAtmBalance() - notes * 500);
        System.out.println(notes);
        int left = amount - (notes * 500);
        if (left > 0) {
            cachWithdrawalProcessor.withdraw(atm, left);
        }
    }
}
