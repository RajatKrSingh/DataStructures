package behavioural.cor.chain;

public class ThrottlingValidation extends ChainValidation
{
    private int requests_per_minute, num_request;
    private long prev_time;
    
    public ThrottlingValidation(int requests_per_minute)
    {
        this.requests_per_minute = requests_per_minute;
        prev_time = System.currentTimeMillis();
    }

    @Override
    public boolean check(String email, String password)
    {
        long current_time = System.currentTimeMillis();
        if(current_time > prev_time+60_000)
        {
            num_request = 0;
            prev_time = current_time;
        }
        num_request++;
        if (requests_per_minute < num_request)
        {
            System.out.println("Exceeded Request threshold. Throttling request");
            return false;
        }
        System.out.println("Throttling Check Passed");

        return this.checkNext(email, password);

    }
}