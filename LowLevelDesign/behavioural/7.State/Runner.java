package behavioural.state.runner;

import behavioural.state.machine.VendingMachine;

public class Runner
{
    public static void main(String args[])
    {
        VendingMachine machine = new VendingMachine();
        machine.dispenseItem();
        machine.acceptCoin();
        machine.acceptCoin();
        machine.dispenseItem();
        machine.dispenseItem();
        machine.acceptCoin();
    }
}