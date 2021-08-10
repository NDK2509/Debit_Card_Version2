package Data.Lib;

public class VIP_Card extends Card{
    private final int TRANSACTIONLIMIT = 100000000;
    private final int LIMITPERTIME = 10000000;
    private final int FEE = 2000;

    public VIP_Card(String cardNum, String userName, String regisDate, String type, long accBal, String passWord, boolean status){
        super(cardNum, userName, regisDate, type, accBal, passWord, status);
    }
    @Override
    public int getTransactionLimit(){
        return this.TRANSACTIONLIMIT;
    }
    @Override
    public int getLimitPerTime(){
        return this.LIMITPERTIME;
    }
    @Override
    public int getFee(){
        return this.FEE;
    }
}
