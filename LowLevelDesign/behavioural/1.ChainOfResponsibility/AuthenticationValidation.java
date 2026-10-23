package behavioural.cor.chain;

public class AuthenticationValidation extends ChainValidation
{
    @Override
    public boolean check(String email, String password)
    {
        if(password != "admin123")
        {
            System.out.println("Authentication Check Failed");
            return false;
        }
        System.out.println("Authentication Check Successful");
        return this.checkNext(email, password);
    }
}