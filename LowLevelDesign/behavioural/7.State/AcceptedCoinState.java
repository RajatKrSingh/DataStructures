package behavioural.state.state;

import behavioural.state.machine.VendingMachine;

public class AcceptedCoinState implements State
{
    private VendingMachine vending_machine;

    public AcceptedCoinState(VendingMachine machine)
    {
        this.vending_machine = machine;
    }

    @Override
    public void acceptCoin()
    {
        System.out.println("Coin already Accepted. Returning coin");
    }

    @Override
    public void dispenseItem(String itemCode)
    {
        System.out.println("Dispensing Item: "+ itemCode);
        this.vending_machine.setState(new WaitingCoinState(this.vending_machine));
    }
}