package com.demo.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 十三水自动摆牌计算
 * @author lxw
 *
 */
public class ThirteenWaterAutomaticPlacingUtils extends ThirteenWaterCardAnalysisUtils  {

	private static List<Poker> pokers = Poker.getPokers();

	
	public static void main(String[] args) {
//		for (int i = 0; i < 100; i++) {
//			Collections.shuffle(pokers);
//			List<Poker> poker = pokers.subList(0, 13);
//			sort(poker);
//			System.out.println(poker.toString());
//			
//			System.out.println(automatic(poker));
//			System.out.println("==========================================================");
//		}
		List<Poker> poker  = new ArrayList<Poker>();
//		Poker p1 = new Poker();p1.setDeck(1);p1.setDecor(1);
//		Poker p2 = new Poker();p2.setDeck(2);p2.setDecor(2);
//		Poker p3 = new Poker();p3.setDeck(3);p3.setDecor(3);
//		Poker p4 = new Poker();p4.setDeck(4);p4.setDecor(4);
//		Poker p5 = new Poker();p5.setDeck(5);p5.setDecor(1);
//		Poker p6 = new Poker();p6.setDeck(6);p6.setDecor(2);
//		Poker p7 = new Poker();p7.setDeck(7);p7.setDecor(3);
//		Poker p8 = new Poker();p8.setDeck(8);p8.setDecor(4);
//		Poker p9 = new Poker();p9.setDeck(9);p9.setDecor(1);
//		Poker p10 = new Poker();p10.setDeck(10);p10.setDecor(2);
//		Poker p11 = new Poker();p11.setDeck(12);p11.setDecor(3);
//		Poker p12 = new Poker();p12.setDeck(13);p12.setDecor(4);
//		Poker p13 = new Poker();p13.setDeck(13);p13.setDecor(1);
//
//		poker.add(p1);
//		poker.add(p2);
//		poker.add(p3);
//		poker.add(p4);
//		poker.add(p5);
//		poker.add(p6);
//		poker.add(p7);
//		poker.add(p8);
//		poker.add(p9);
//		poker.add(p10);
//		poker.add(p11);
//		poker.add(p12);
//		poker.add(p13);
//		System.out.println(poker);
//		System.out.println(automatic(poker));
//		System.out.println("==========================================================");

	}
	
	/**
	 * 自动摆牌 
	 * @param arr
	 * @return
	 */
	public static ThirteenWater automatic(List<Poker> arr){
		ThirteenWater thirteenWater = new ThirteenWater();
		List<Poker> copylist = copyPokerList(arr);
		setPier(copylist,thirteenWater,1);
		setPier(copylist,thirteenWater,2);
		setPier(copylist,thirteenWater,3);
		if(copylist.size() != 0){
			List<Poker> tail = thirteenWater.getTail();
			List<Poker> among = thirteenWater.getAmong();
			List<Poker> head = thirteenWater.getHead();
			if(tail.size() < 5){
				for (int i = 0; i < copylist.size(); i++) {
					if(tail.size() == 5){
						break;
					}
					tail.add(copylist.get(i));
					copylist.remove(copylist.get(i));
					i--;
				}
			}
			if(among.size() < 5){
				for (int i = copylist.size()-1; i > -1; i--) {
					if(among.size() == 5){
						break;
					}
					among.add(copylist.get(i));
					copylist.remove(copylist.get(i));
				}
			}
			if(head.size() < 3){
				for (int i = copylist.size()-1; i > -1; i--) {
					if(head.size() == 3){
						break;
					}
					head.add(copylist.get(i));
					copylist.remove(copylist.get(i));
				}
			}

		}
		return thirteenWater;
	}
	

	
	/**
	 * 获取尾墩
	 * @param arr
	 * @return
	 */
	private static void setPier(List<Poker> arr,ThirteenWater thirteenWater,int addType){
		List<List<Poker>> pokers = new ArrayList<List<Poker>>();
		int type = 0;
		int index = 0;
		//同花顺
		if(pokers == null || pokers.size() < 1){
			 pokers = getStraightFlush(arr);
			 type = 1;
		}
		//铁支
		if(pokers == null || pokers.size() < 1){
			 pokers = getBranch(arr);
			 type = 2;
		}
		//葫芦
		if(pokers == null || pokers.size() < 1){
			 pokers = getGourd(arr);
			 type = 3;
		}
		//同花
		if(pokers == null || pokers.size() < 1){
			 pokers = getSameColor(arr);
			 type = 4;
		}
		//顺子
		if(pokers == null || pokers.size() < 1){
			 pokers = getStraight(arr);
			 type = 5;
		}
		//三条
		if(pokers == null || pokers.size() < 1){
			 pokers = getThree(arr);
			 type = 6;

		}
		//两对
		if(pokers == null || pokers.size() < 1){
			 pokers = getTwoPairs(arr);
			 type = 7;

		}
		//对子
		if(pokers == null || pokers.size() < 1){
			 pokers = getPairs(arr);
			 type = 8;
		}
		if(pokers.size() > 1){
			switch (type) {
				case 1://同花顺
					for (int i = 0; i < pokers.size(); i++) {
						if(ThirteenWaterSizeComparison.containStraight(pokers.get(i),pokers.get(index))){
							index = i;
						}
					}
					break;
				case 2://铁支
					for (int i = 0; i < pokers.size(); i++) {
						if(ThirteenWaterSizeComparison.containIronBranch(pokers.get(i),pokers.get(index))){
							index = i;
						}
					}
					break;
				case 3://葫芦
					for (int i = 0; i < pokers.size(); i++) {
						if(ThirteenWaterSizeComparison.containGourd(pokers.get(i),pokers.get(index))){
							index = i;
						}
					}
					break;
				case 4://同花
					for (int i = 0; i < pokers.size(); i++) {
						if(ThirteenWaterSizeComparison.containSameColor(pokers.get(i),pokers.get(index))){
							index = i;
						}
					}
					break;
				case 5://顺子
					for (int i = 0; i < pokers.size(); i++) {
						if(ThirteenWaterSizeComparison.containStraight(pokers.get(i),pokers.get(index))){
							index = i;
						}
					}
					break;
				case 6://三条
					for (int i = 0; i < pokers.size(); i++) {
						if(ThirteenWaterSizeComparison.containThree(pokers.get(i),pokers.get(index))){
							index = i;
						}
					}
					break;
				case 7://两对
					for (int i = 0; i < pokers.size(); i++) {
						if(ThirteenWaterSizeComparison.containTwoPairs(pokers.get(i),pokers.get(index))){
							index = i;
						}
					}
					break;
				case 8://对子
					for (int i = 0; i < pokers.size(); i++) {
						if(ThirteenWaterSizeComparison.containPair(pokers.get(i),pokers.get(index))){
							index = i;
						}
					}
					break;
			}
		}
		
		
		if(pokers != null && pokers.size() > 0){
			for (int j = 0; j < pokers.get(index).size(); j++) {
				Poker pokerB = pokers.get(index).get(j);
				for (int i = 0; i < arr.size(); i++) {
					Poker pokerA = arr.get(i);
					if(pokerA.getDeck() == pokerB.getDeck() && pokerA.getDecor() == pokerB.getDecor()){
						arr.remove(pokerA);
						i--;
					}
				}
				
			}
		}
		
		
		if(pokers != null && pokers.size() > 0){
			if(addType == 1){
				thirteenWater.setTail(pokers.get(index));
			}
			if(addType == 2){
				thirteenWater.setAmong(pokers.get(index));
			}
			if(addType == 3){
				thirteenWater.setHead(pokers.get(index));
			}
		}else{
			if(addType == 1){
				thirteenWater.setTail(new ArrayList<Poker>());
			}
			if(addType == 2){
				thirteenWater.setAmong(new ArrayList<Poker>());
			}
			if(addType == 3){
				thirteenWater.setHead(new ArrayList<Poker>());
			}
		}
	}
	
	
}
