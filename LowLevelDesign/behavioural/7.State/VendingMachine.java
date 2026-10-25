package behavioural.state.machine;

import behavioural.state.state.*;

public class VendingMachine
{
    private State current_state;
    public VendingMachine()
    {
        this.current_state = new WaitingCoinState(this);
    }

    public void setState(State state)
    {
        this.current_state = state;
    }

    public State getState()
    {
        return this.current_state;
    }

    public void acceptCoin()
    {
        this.current_state.acceptCoin();
    }

    public void dispenseItem()
    {
        this.current_state.dispenseItem("B12");
    }
}