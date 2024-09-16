public class HundredWithdrawalProcessor extends CachWithdrawalProcessor {
    CachWithdrawalProcessor cachWithdrawalProcessor;

    public HundredWithdrawalProcessor(CachWithdrawalProcessor cachWithdrawalProcessor) {
        this.cachWithdrawalProcessor = cachWithdrawalProcessor;
    }

    @Override
    public void withdraw(Atm atm, int amount) {
        int notes = amount / 100;
        if (notes > atm.getHundredNotes()) {
            System.out.println("Something went wrong");
            return;
        }
        atm.setHundredNotes(atm.getHundredNotes() - notes);
        atm.setAtmBalance(atm.getAtmBalance() - notes * 100);
        System.out.println(notes);
        int left = amount - (notes * 100);
        if (left > 0) {
            System.out.println("Something went wrong");
        }
    }
}
