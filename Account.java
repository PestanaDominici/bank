package es.pestana.bank;

public class Account {

    private static final int MAX_LENGHT = 90;
    private String ag;
    private String cc;
    private String name;

    private double balance;



    private Log logger;

    public  Account(String ag, String cc, String name) {
        this.ag =ag;
        this.cc = cc;
        setName(name);
        logger = new Log();
    }

     public void setName(String name) {
        if (name.length() > MAX_LENGHT) {
            this.name = name.substring(0, MAX_LENGHT);
        } else {
            this.name = name;
        }

     }

     public void deposit(double value) {
        balance += value;
        logger.out("DEPOSITO - R$ " + value + " Sua conta e de R$ " + balance);
     }


     public boolean withDraw(double value) {
         if (balance < value) {
             logger.out("Você nao tem saldo suficiente, Seu saldo atual e de R$ " + balance);
             return false;
         }
         balance -= value;
         logger.out("SAQUE - R$ " + value + " Sua conta e de R$ " + balance);
         return true;


     }

   

}

