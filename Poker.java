package com.demo.test;

import java.util.ArrayList;
import java.util.List;

public class Poker {
	public static List<Poker> pokes;

    public int deck;//牌面

    public int decor;//花色 1=黑 2=红 3=麻 4=方

    public int size;//大小 比较值

    public int deckInt;//大小 比较值



    public int getDeck() {
        return deck;
    }

    public void setDeck(int deck) {
        this.deck = deck;
    }

    public int getDecor() {
        return decor;
    }

    public void setDecor(int decor) {
        this.decor = decor;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }


    public int getDeckInt() {
        return deckInt;
    }

    public void setDeckInt(int deckInt) {
        this.deckInt = deckInt;
    }

    public static List<Poker> getPokers() {
        if(pokes == null){
            pokes = new ArrayList<Poker>();
            for (int i = 0; i < PokerDeckEnum.values().length; i++) {
                for(int j = 0; j < 4; j++){
                    Poker poker = new Poker();
                    poker.setDeck(PokerDeckEnum.values()[i].ordinal() + 1);
                    poker.setDecor(4-j);
                    poker.setSize(((i) * 4) + j+1);
                    pokes.add(poker);
                    if(PokerDeckEnum.values()[i] == PokerDeckEnum.ONE){
                        poker.setDeckInt(PokerDeckEnum.values()[i].ordinal() + 1);
                    }
                    if(PokerDeckEnum.values()[i] == PokerDeckEnum.TWO){
                        poker.setDeckInt(PokerDeckEnum.values()[i].ordinal() + 1);
                    }
                    if(PokerDeckEnum.values()[i] == PokerDeckEnum.THREE){
                        poker.setDeckInt(PokerDeckEnum.values()[i].ordinal() + 1);
                    }
                    if(PokerDeckEnum.values()[i] == PokerDeckEnum.FOUR){
                        poker.setDeckInt(PokerDeckEnum.values()[i].ordinal() + 1);
                    }
                    if(PokerDeckEnum.values()[i] == PokerDeckEnum.FIVE){
                        poker.setDeckInt(PokerDeckEnum.values()[i].ordinal() + 1);
                    }
                    if(PokerDeckEnum.values()[i] == PokerDeckEnum.SIX){
                        poker.setDeckInt(PokerDeckEnum.values()[i].ordinal() + 1);
                    }
                    if(PokerDeckEnum.values()[i] == PokerDeckEnum.SEVEN){
                        poker.setDeckInt(PokerDeckEnum.values()[i].ordinal() + 1);
                    }
                    if(PokerDeckEnum.values()[i] == PokerDeckEnum.EIGHT){
                        poker.setDeckInt(PokerDeckEnum.values()[i].ordinal() + 1);
                    }
                    if(PokerDeckEnum.values()[i] == PokerDeckEnum.NINE){
                        poker.setDeckInt(PokerDeckEnum.values()[i].ordinal() + 1);
                    }
                    if(PokerDeckEnum.values()[i] == PokerDeckEnum.TEN){
                        poker.setDeckInt(PokerDeckEnum.values()[i].ordinal() + 1);
                    }
                    if(PokerDeckEnum.values()[i] == PokerDeckEnum.J){
                        poker.setDeckInt(PokerDeckEnum.values()[i].ordinal() + 1);
                    }
                    if(PokerDeckEnum.values()[i] == PokerDeckEnum.Q){
                        poker.setDeckInt(PokerDeckEnum.values()[i].ordinal() + 1);
                    }
                    if(PokerDeckEnum.values()[i] == PokerDeckEnum.K){
                        poker.setDeckInt(PokerDeckEnum.values()[i].ordinal() + 1);
                    }

                }
            }
        }
        return pokes;
    }
    
    

 
   



	@Override
	public String toString() {
		String str = "";
		String decorName = "";
		if(decor == 1){
			decorName = "黑桃";
		}
		if(decor == 2){
			decorName = "红桃";
		}
		if(decor == 3){
			decorName = "梅花";
		}
		if(decor == 4){
			decorName = "方块";
		}
		return decorName+"="+deck;
	}








	public enum PokerDeckEnum{
        /**
         * TWO = 2
         * THREE = 3
         * FOUR = 4
         * FIVE = 5
         * SIX = 6
         * SEVEN = 7
         * EIGHT = 8
         * NINE = 9
         * Ten = 10
         * J = J
         * Q = Q
         * K = K
         * ONE = A
         */
        TWO,THREE,FOUR,FIVE,SIX,SEVEN,EIGHT,NINE,TEN,J,Q,K,ONE
    }

}
