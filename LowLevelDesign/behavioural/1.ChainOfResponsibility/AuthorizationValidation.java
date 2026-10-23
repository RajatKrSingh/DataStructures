package behavioural.cor.chain;

public class AuthorizationValidation extends ChainValidation
{
    @Override
    public boolean check(String email, String password)
    {
        if(email != "admin@support.com")
        {
            System.out.println("Authorization Check Failed");
            return false;
        }
        System.out.println("Authorization Check Successful");
        return this.checkNext(email, password);
    }
}