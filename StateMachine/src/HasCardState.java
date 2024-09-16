public class HasCardState extends AtmState {
    public HasCardState() {
        System.out.println("Enter the pin");
    }

    @Override
    public void validatePin(Atm atm, Card card, int pin) {
        System.out.println("Pin entered");
        if (card.getPin() != pin) {
            System.out.println("Inavlid pin");
            cancel(atm);
        } else {
            System.out.println("Pin validated");
            atm.setAtmState(new OperationSelectionAtmState());
        }
    }
}
