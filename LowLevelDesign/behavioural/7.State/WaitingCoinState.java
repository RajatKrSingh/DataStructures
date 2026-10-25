package behavioural.state.state;

import behavioural.state.machine.VendingMachine;

public class WaitingCoinState implements State
{
    VendingMachine vending_machine;
    public WaitingCoinState(VendingMachine machine)
    {
        this.vending_machine = machine;
    }

    @Override
    public void acceptCoin()
    {
        System.out.println("Accepted Coin");
        vending_machine.setState(new AcceptedCoinState(this.vending_machine));
    }

    @Override
    public void dispenseItem(String itemCode)
    {
        System.out.println("Please enter coin first");
    }
}