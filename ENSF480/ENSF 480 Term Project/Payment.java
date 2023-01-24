public class Payment {
    private String cardNumber;
    private String expiryDate;
    private String cvv;

    public Payment(){

    }

    public void setCardNumber(String cardNumber){
        this.cardNumber = cardNumber;
    }

    public void setExpiryDate(String expiry){
        this.expiryDate = expiry;
    }

    public void setCvv(String cvv){
        this.cvv = cvv;
    }

    public String getCvv(){
        return cvv;
    }

    public String getCardNumber(){
        return cardNumber;
    }

    public String getExpiryDate(){
        return expiryDate;
    }
}
