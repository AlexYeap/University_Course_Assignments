public class RegisteredUser {
    private Account account;

    public RegisteredUser(){

    }

    public RegisteredUser(Account account){
        this.account = account;
    }

    public void setAccount(Account account){
        this.account = account;
    }

    public Account getAccount(){
        return this.account;
    }

    public void payFee(){
        account.setFeesPaid(1);
        account.setDatePaid(java.time.LocalDate.now().toString());
        System.out.println(account.getDatePaid());
    }

}
