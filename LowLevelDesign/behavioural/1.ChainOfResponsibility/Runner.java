package behavioural.cor.runner;

import behavioural.cor.chain.*;

public class Runner
{
    public static void main(String args[])
    {
        String user = "admin@support.com", password =  "admin123";
        ChainValidation chain = ChainValidation.link(
            new ThrottlingValidation(2),
            new AuthorizationValidation(),
            new AuthenticationValidation()
        );
        System.out.println("*".repeat(15)+"Checking Login for Admin"+"*".repeat(15));
        chain.check(user, password);

        System.out.println("*".repeat(15)+"Checking Login for Customer"+"*".repeat(15));
        chain.check(user, password);
    }
}