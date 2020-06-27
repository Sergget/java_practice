public class Main {
    public static void main(String[] args) {
        try {
            // Account a = new Account(1000);
            // a.deposit(200);
            // System.out.printf("Current balance: %.2f\n",a.getBalance());
            // a.withdraw(1500);
            // System.out.printf("Current balance: %.2f\n",a.getBalance());

            CheckingAccount ca = new CheckingAccount(500);
            ca.deposit(500);
            System.out.printf("Current balance: %.2f\n",ca.getBalance());
            ca.withdraw(1500);
            System.out.printf("Current balance: %.2f\n",ca.getBalance());
            ca.withdraw(600);
            System.out.printf("Current balance: %.2f\n",ca.getBalance());
        } catch (OverdraftException e) {
            Exception e1 = (Exception) e;
            e1.printStackTrace();
            System.out.println(e.getDeficit());
        }
    }
}

// Account类： 银行账号
// 属性： balance 余额
// 方法： getBalance() 获取余额
// 方法： deposit() 存钱
// 方法： withdraw() 取钱
class Account{
    protected double balance;
    
    public Account(){
        this(0);
    }

    public Account(double init){
        balance = init;
    }

    public double getBalance(){
        return balance;
    }

    public void deposit(double deposits){
        if(deposits>0){
            balance+=deposits;
        }
    }

    public void withdraw(double withdraws) throws OverdraftException {
        if(withdraws<=balance){
            balance-=withdraws;
        }else{
            throw new OverdraftException("Not enough balance!",balance-withdraws);
        }
    }
}

// 类： CheckingAccount 支票账户，具备透支额度，继承Account
// 属性：overdraftProtection 透支额度
class CheckingAccount extends Account{
    public CheckingAccount(){
        this(0);
    }
    public CheckingAccount(double init){
        super(init);
    }
    
    private double overdraftProtection =1000;

    @Override
    public void withdraw(double withdraws) throws OverdraftException{
        if(withdraws<=overdraftProtection+balance){
           balance-=withdraws;
        }else{
            throw new OverdraftException("Over-drafted difict", withdraws-balance-overdraftProtection);
        }
    }
}

// OverdraftException： 透支异常，继承Exception
// 属性： deficit 透支额
class OverdraftException extends Exception{
    private double deficit;

    public double getDeficit(){
        return deficit;
    }

    public OverdraftException() {
        deficit = 0;
    }

    public OverdraftException(String msg, double deficit){
        super(msg);
        this.deficit = deficit;
    }
}