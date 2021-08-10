package Data.Lib;

import java.util.*;

public class User {
    private String userID;
    private String name;
    private InfoUser info;
    private Map<String, Card> listCard = new HashMap<>();
    
    public User(String userID, String name) {
        setUserID(userID);
        setName(name);
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getUserID() {
        return userID;
    }
    public void setUserID(String userID) {
        this.userID = userID;
    }
    public Map<String, Card> getListCard(){
        return listCard;
    }
    public InfoUser getInfo() {
        return info;
    }
    public void setInfo(InfoUser info) {
        this.info = info;
    }
    public Card getCard(String cardNum){
        return listCard.get(cardNum);
    }
    public void addCard(Card card){
        listCard.put(card.getCardNum(), card);
    }
    public void drawMoney(int cash, Card card){
        if (card.getAccBal() - card.getFee() >= cash){
            card.setAccBal(card.getAccBal() - cash - card.getFee());// accBal = accBal - cash - fee
            return;
        }
        System.out.println("Cann't draw! Your balance account isn't enough!");
    }
    public void transferMoney(int cash, Card card, Card transfered_card){
        if (card.getAccBal() - card.getFee() >= cash){
            card.setAccBal(card.getAccBal() - cash - card.getFee());// accBal = accBal - cash - fee
            transfered_card.setAccBal(transfered_card.getAccBal() + cash);
            return;
        }
        System.out.println("Can't transfer! Your balance account isn't enough!");
    }
    @Override
    public String toString(){
        return String.format("UserID: %s, Name: %s", userID, name);
    }
    public void printInfor(){
        System.out.printf("User ID: %s\nName: %s\n", userID, name);
        System.out.println(this.info);
        System.out.println("Cards:");
        for (String i : listCard.keySet())
            System.out.println("\t" + listCard.get(i)); 
        System.out.println();
    }
}
