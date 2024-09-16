public class IdleAtmState extends AtmState {

    public IdleAtmState() {
        System.out.println("Enter the card");
    }

    @Override
    public void enterCard(Atm atm, Card card) {
        System.out.println("Card entered succesfully");
        atm.setAtmState(new HasCardState());
    }


}
