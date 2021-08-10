package Data.Lib;
public class Card{

    protected final int TRANSACTIONLIMIT = 50000000;
    protected final int LIMITPERTIME = 5000000;
    protected final int FEE = 5000;
    protected String cardNum;
    protected String userName;
    protected Date regisDate; // Registration Date
    protected String type;
    protected long accBal; // Account balance
    protected String password; //Password 8 numeric characters
    protected boolean status; // true is unlocked

    public Card(String cardNum, String userName, String regisDate, String type, long accBal, String password, boolean status) {
        setCardNum(cardNum);
        setUserName(userName);
        setRegisDate(new Date(regisDate));
        setType(type);
        setAccBal(accBal);
        setPassword(password);
        setStatus(status);
    }

    public String getCardNum() {
        return cardNum;
    }
    public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public Date getRegisDate() {
        return regisDate;
    }
    public void setRegisDate(Date regisDate) {
        this.regisDate = regisDate;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public long getAccBal() {
        return accBal;
    }
    public void setAccBal(long accBal) {
        this.accBal = accBal;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public boolean isLocked(){
        return !status;
    }
    public void setStatus(boolean status){
        this.status = status;
    }
    public int getTransactionLimit() {
        return this.TRANSACTIONLIMIT;
    }
    public int getLimitPerTime(){
        return this.LIMITPERTIME;
    }
    public int getFee(){ 
        return this.FEE;
    }
    @Override
    public String toString(){
        return String.format("%9s  %-25s  %10s  %-14s  $%-12d  %8s", this.cardNum, this.userName, 
                                        this.regisDate, this.type, this.accBal, this.password);
    }
    public void protectedInfo(){
        System.out.printf("Card Number: %s\nUser: %s\n", this.cardNum, this.userName);
    }
}