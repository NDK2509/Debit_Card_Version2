package Data.Lib;

public class InfoUser {
    private String idCard;
    private String phoneNum;
    private String email;
    private String address;
    private Date birthday;
    public InfoUser(String idCard, String birthday, String phoneNum, String email, String address) {
        setIdCard(idCard);
        setBirthday(new Date(birthday));
        setPhoneNum(phoneNum);
        setEmail(email);
        setAddress(address);
    }
    public String getIdCard() {
        return idCard;
    }
    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }
    public String getPhoneNum() {
        return phoneNum;
    }
    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }
    public Date getBirthday() {
        return birthday;
    }
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    @Override
    public String toString(){
        return String.format("Info:\n\tID card: %s\n\tDOB: %s\n\tPhone number: %s\n\tEmail: %s\n\tAddress: %s.", this.idCard, this.birthday, this.phoneNum, this.email, this.address);
    }
}
