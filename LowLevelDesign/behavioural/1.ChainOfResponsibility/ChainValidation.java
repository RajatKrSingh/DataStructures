package behavioural.cor.chain;

public abstract class ChainValidation
{
    private ChainValidation next;
    public static ChainValidation link(ChainValidation first, ChainValidation... chainlink)
    {
        ChainValidation head = first;
        for(ChainValidation chainElement: chainlink)
        {
            head.next = chainElement;
            head = head.next;
        }
        return first;
    }

    public abstract boolean check(String email, String password);

    public boolean checkNext(String email, String password)
    {
        if(next!=null)
            return next.check(email, password);
        return true;
    }
}