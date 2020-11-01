package com.demo.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * 十三水牌型获取工具
 * @author lxw
 *
 */
public class ThirteenWaterCardAnalysisUtils extends ThirteenWaterSizeComparison {

	
	private static List<Poker> pokers = Poker.getPokers();

	public static void main(String[] args) {
//		for (int i = 0; i < 500; i++) {
//			Collections.shuffle(pokers);
//			List<Poker> poker = pokers.subList(0, 13);
//			sort(poker);
//			System.out.println(poker.toString());
//			getGourd(poker);
//		}
		
		List<Poker> poker  = new ArrayList<Poker>();
		Poker p1 = new Poker();p1.setDeck(1);p1.setDecor(1);
		Poker p2 = new Poker();p2.setDeck(2);p2.setDecor(2);
		Poker p3 = new Poker();p3.setDeck(3);p3.setDecor(3);
		Poker p4 = new Poker();p4.setDeck(4);p4.setDecor(4);
		Poker p5 = new Poker();p5.setDeck(5);p5.setDecor(1);
		Poker p6 = new Poker();p6.setDeck(6);p6.setDecor(1);
		Poker p7 = new Poker();p7.setDeck(7);p7.setDecor(1);
		Poker p8 = new Poker();p8.setDeck(8);p8.setDecor(1);
		Poker p9 = new Poker();p9.setDeck(9);p9.setDecor(1);
		Poker p10 = new Poker();p10.setDeck(10);p10.setDecor(1);
		Poker p11 = new Poker();p11.setDeck(12);p11.setDecor(3);
		Poker p12 = new Poker();p12.setDeck(13);p12.setDecor(4);
		Poker p13 = new Poker();p13.setDeck(13);p13.setDecor(1);

		poker.add(p1);
		poker.add(p2);
		poker.add(p3);
		poker.add(p4);
		poker.add(p5);
		poker.add(p6);
		poker.add(p7);
		poker.add(p8);
		poker.add(p9);
		poker.add(p10);
		poker.add(p11);
		poker.add(p12);
		poker.add(p13);
		System.out.println(poker);
		System.out.println(getStraightFlush(poker));
	}
	
	/**
	 * 获取所有对子组合
	 * @param arr
	 * @return
	 */
	public static List<List<Poker>> getPairs(List<Poker> arr){
		List<List<Poker>> result = new ArrayList<List<Poker>>();
		for (int i = 0; i < arr.size(); i++) {
			int a = arr.get(i).getDeck();
			for (int j = 0; j < arr.size(); j++) {
				int b = arr.get(j).getDeck();
				if(i == j){
					continue;
				}
				if(a == b){
					List<Poker> aa = new ArrayList<Poker>();
					aa.add(arr.get(i));
					aa.add(arr.get(j));
					boolean ab = false;
					for (int k = 0; k < result.size(); k++) {
						Poker p1 = result.get(k).get(0);
						Poker p2 = result.get(k).get(1);
						if((p1 == arr.get(j) && p2 == arr.get(i)) || (p2 == arr.get(i) && p1 == arr.get(j))){
							ab = true;	
						}
					}
					if(!ab){
						result.add(aa);
					}
				}
			}
		}
		return result;
	}
	
	/**
	 * 获取所有两对组合
	 * @param arr
	 * @return
	 */
	public static List<List<Poker>> getTwoPairs(List<Poker> arr){
		List<List<Poker>> result = new ArrayList<List<Poker>>();

		for (int i = 0; i < arr.size(); i++) {
			int a = arr.get(i).getDeck();
			for (int j = 0; j < arr.size(); j++) {
				int b = arr.get(j).getDeck();
				if(i == j){
					continue;
				}
				if(a == b){
					for (int k = 0; k < arr.size(); k++) {
						int c = arr.get(k).getDeck();
						if(j == k || k == i){
							continue;
						}
						if(b != c && a != c){
							for (int l = 0; l < arr.size(); l++) {
								int d = arr.get(l).getDeck();
								if(k == l || l == j || l==i){
									continue;
								}
								if(c == d){
									List<Poker> list = new ArrayList<Poker>();

									list.add(arr.get(i));	
									list.add(arr.get(j));
									list.add(arr.get(k));
									list.add(arr.get(l));
									boolean contain = false;
									for (int m = 0; m < result.size(); m++) {
										if(result.get(m).get(1).getDeck()+result.get(m).get(2).getDeck() == b+c){
											contain = true;
										}
									}
									if(!contain){
										result.add(list);
									}
								}
							}
						}
					}
				}
			}
		}
		
//	  for (int i = 0; i < result.size(); i++) {
//		System.out.println(result.get(i));
//	  }
		return result;
	}

	/**
	 * 获取所有三条组合
	 * @param arr
	 * @return
	 */
	public static List<List<Poker>> getThree(List<Poker> arr){
		List<List<Poker>> result = new ArrayList<List<Poker>>();
		Map<Integer, List<Poker>> notRepeatingMap = new HashMap<>();
		for (int i = 0; i < arr.size(); i++) {
			int a = arr.get(i).getDeck();
			for (int j = 0; j < arr.size(); j++) {
				int b = arr.get(j).getDeck();
				if(i == j){
					continue;
				}
				if(a == b){
					for (int h = 0; h < arr.size(); h++) {
						int c = arr.get(h).getDeck();
						if(j == h || h == i){
							continue;
						}
						if(b == c){
							List<Poker> list = new ArrayList<Poker>();
							list.add(arr.get(i));	
							list.add(arr.get(j));
							list.add(arr.get(h));
							notRepeatingMap.put(a, list);
						}
					}
				}
			}
		}
		for(Entry<Integer, List<Poker>> entry:notRepeatingMap.entrySet()){  
			result.add(entry.getValue());
		}  
		return result;
	}

	/**
	 * 获取所有的顺子组合
	 * @param arr
	 * @return
	 */
	public static List<List<Poker>> getStraight(List<Poker> arr){
		List<List<Poker>> result = new ArrayList<List<Poker>>();
		Map<Integer,Poker> notRepeatingMap = new HashMap<Integer, Poker>();
		List<Poker> list = new ArrayList<Poker>();
		List<Poker> copylist = copyPokerList(arr);

		//A==13,可以组成12345 & 10JQKA,方便计算添加一个A=0
		for (int j = 0; j < arr.size(); j++) {
			if(arr.get(j).getDeck() == 13){
				Poker poker = new Poker();
				poker.setDeck(0);
				poker.setDecor(arr.get(j).getDecor());
				copylist.add(poker);
			}
		}
		//排序
		sort(copylist);
		
		for (int i = 0; i < copylist.size(); i++) {
			int poker = copylist.get(i).getDeck();
			int upPoker = -999;
			if(notRepeatingMap.size() > 0){
				upPoker = (int)notRepeatingMap.keySet().toArray()[notRepeatingMap.keySet().toArray().length-1]; 
			}

			if(Math.abs(poker-upPoker) == 1 || notRepeatingMap.size() < 1 || Math.abs(poker-upPoker) == 0){
				notRepeatingMap.put(poker, copylist.get(i));
			}else{
				if(notRepeatingMap.size() > 0){
					if(Math.abs(upPoker-poker) != 1 && notRepeatingMap.size() < 5){
						notRepeatingMap.clear();
						notRepeatingMap.put(poker, copylist.get(i));
					}
					if(Math.abs(upPoker-poker) != 1 && notRepeatingMap.size() > 5){
					    for(Entry<Integer, Poker> entry:notRepeatingMap.entrySet()){  
					    	list.add(entry.getValue());
					    }  
					    notRepeatingMap.clear();
					    notRepeatingMap.put(poker, copylist.get(i));
					}
					
				}
			}
		}
	    for(Entry<Integer, Poker> entry:notRepeatingMap.entrySet()){ 	
	    	list.add(entry.getValue());
	    } 
	    
	    notRepeatingMap.clear();
	    
		sort(list);

	    
		for (int i = 0; i < list.size(); i++) {
			List<Poker> aa = new ArrayList<Poker>();

			for (int j = 0; j < 5; j++) {
				if(i+j == list.size()){
					break;
				}
				aa.add(list.get(i+j));	
			}
			if(containStraight(aa)){
				result.add(aa);
			}
		}
		
		for (int i = 0; i < result.size(); i++) {
			for (int j = 0; j < result.get(i).size(); j++) {
				if(result.get(i).get(j).getDeck() == 0){
					result.get(i).get(j).setDeck(13);
				}
			}
		}
		
		return  result;
	}

	/**
	 * 获取所有的同花组合
	 * @param arr
	 * @return
	 */
	public static List<List<Poker>> getSameColor(List<Poker> arr){
		List<List<Poker>> result = new ArrayList<List<Poker>>();
		List<Poker> black = new ArrayList<>();
		List<Poker> red = new ArrayList<>();
		List<Poker> flower = new ArrayList<>();
		List<Poker> square = new ArrayList<>();

		for (int i = 1; i < 5; i++) {
			for (int j = 0; j < arr.size(); j++) {
				if(i==1 && i == arr.get(j).getDecor()){
					black.add(arr.get(j));
				}
				if(i==2 && i == arr.get(j).getDecor()){
					red.add(arr.get(j));
				}
				if(i==3 && i == arr.get(j).getDecor()){
					flower.add(arr.get(j));
				}
				if(i==4 && i == arr.get(j).getDecor()){
					square.add(arr.get(j));
				}
			}
		}
		
		if(black.size() > 5){
			for (int i = 0; i < black.size(); i++) {
				List<Poker> aa = new ArrayList<Poker>();
				for (int j = 0; j < 5; j++) {
					if(i+j == black.size()){
						break;
					}
					aa.add(black.get(i+j));	
				}
				if(aa.size() >= 5){
					result.add(aa);
				}
			}
		}else if(black.size() == 5){
			result.add(black);
		}
		
		if(red.size() > 5){
			for (int i = 0; i < red.size(); i++) {
				List<Poker> aa = new ArrayList<Poker>();
				for (int j = 0; j < 5; j++) {
					if(i+j == red.size()){
						break;
					}
					aa.add(red.get(i+j));	
				}
				if(aa.size() >= 5){
					result.add(aa);
				}			}
		}else if(red.size() == 5){
			result.add(red);
		}
		
		if(flower.size() > 5){
			for (int i = 0; i < flower.size(); i++) {
				List<Poker> aa = new ArrayList<Poker>();
				for (int j = 0; j < 5; j++) {
					if(i+j == flower.size()){
						break;
					}
					aa.add(flower.get(i+j));	
				}
				if(aa.size() >= 5){
					result.add(aa);
				}			}
		}else if(flower.size() == 5){
			result.add(flower);
		}
		
		if(square.size() > 5){
			for (int i = 0; i < square.size(); i++) {
				List<Poker> aa = new ArrayList<Poker>();
				for (int j = 0; j < 5; j++) {
					if(i+j == square.size()){
						break;
					}
					aa.add(square.get(i+j));	
				}
				if(aa.size() >= 5){
					result.add(aa);
				}			}
		}else if(square.size() == 5){
			result.add(square);
		}
//		for (int i = 0; i < result.size(); i++) {
//			System.out.println(result.get(i));
//
//		}
		
		return result;
	}
	
	
	/**
	 * 获取所有的葫芦组合
	 * @param arr
	 * @return
	 */
	public static List<List<Poker>> getGourd(List<Poker> arr){
		List<List<Poker>> result = new ArrayList<List<Poker>>();
		List<List<Poker>> pair = getPairs(arr);
		List<List<Poker>> three = getThree(arr);
		if(pair.size() > 0 && three.size() > 0){
			if(pair.size()+three.size() > 2){
				for (int i = 0; i < pair.size(); i++) {
					for (int j = 0; j < three.size(); j++) {
						if(three.get(j).get(0).getDeck() != pair.get(i).get(0).getDeck()){
							boolean b = false;
							
							for (int j2 = 0; j2 < result.size(); j2++) {
								if((three.get(j).get(2).getDeck() + pair.get(i).get(0).getDeck()) == result.get(j2).get(2).getDeck()+result.get(j2).get(3).getDeck()){
									b = true;
									break;
								}
							}
							
							if(!b){
								List<Poker> list = new ArrayList<Poker>();
								list.add(three.get(j).get(0));	
								list.add(three.get(j).get(1));	
								list.add(three.get(j).get(2));	
								list.add(pair.get(i).get(0));	
								list.add(pair.get(i).get(1));
								result.add(list);
							}
							
						}
					}
				}
			}
		}
		return result;
	}
	
	/**
	 * 获取所有的铁支组合
	 * @param arr
	 * @return
	 */
	public static List<List<Poker>> getBranch(List<Poker> arr){
		List<List<Poker>> result = new ArrayList<List<Poker>>();
		Map<Integer, List<Poker>> map = new HashMap<Integer, List<Poker>>();
		for (int i = 0; i < arr.size(); i++) {
			int a = arr.get(i).getDeck();
			for (int j = 0; j < arr.size(); j++) {
				int b = arr.get(j).getDeck();
				if(i == j){
					continue;
				}
				if(a == b){
					for (int h = 0; h < arr.size(); h++) {
						int c = arr.get(h).getDeck();
						if(j == h || h == i){
							continue;
						}
						if(b == c){
							for (int u = 0; u < arr.size(); u++) {
								int d = arr.get(u).getDeck();
								if(j == u || u == i || u == h){
									continue;
								}
								if(d == c){
									List<Poker> list = new ArrayList<Poker>();
									list.add(arr.get(i));	
									list.add(arr.get(j));
									list.add(arr.get(h));
									list.add(arr.get(u));
									map.put(a, list);
									break;
								}
							}
						}
					}
				}
			}
		}
		
	    for(Entry<Integer, List<Poker>> entry:map.entrySet()){  
	    	result.add(entry.getValue());
	    }  
		return result;
	}
	
	/**
	 * 获取所有同花顺组合
	 * @param arr
	 * @return
	 */
	public static List<List<Poker>> getStraightFlush(List<Poker> arr){
		List<List<Poker>> result = new ArrayList<List<Poker>>();
		List<Poker> temporaryRecord = new ArrayList<Poker>();
		List<Poker> list = new ArrayList<Poker>();
		List<Poker> copylist = copyPokerList(arr);

		List<Poker> black = new ArrayList<Poker>();
		List<Poker> red = new ArrayList<Poker>();
		List<Poker> plum  = new ArrayList<Poker>();
		List<Poker> cube = new ArrayList<Poker>();
		
		
		for (int j = 0; j < arr.size(); j++) {
			if(arr.get(j).getDeck() == 13){
				Poker poker = new Poker();
				poker.setDeck(0);
				poker.setDecor(arr.get(j).getDecor());
				copylist.add(poker);
			}
		}
		sort(copylist);
		for (int i = 0; i < copylist.size(); i++) {
			int a = copylist.get(i).getDeck();
			int h = -999;
			if(list.size() > 0){
				 h = list.get(list.size()-1).getDeck();
				 
			}

			if(Math.abs(a-h) == 1 || list.size() < 1 || Math.abs(a-h) == 0){
				list.add(copylist.get(i));
			}else{
				if(list.size() > 0){
					if(Math.abs(h-a) != 1 && list.size() < 5){
						list.clear();
						list.add(copylist.get(i));
					}
					if(Math.abs(h-a) != 1 && list.size() > 5){
						for (Poker poker : list) {
					    	temporaryRecord.add(poker);
						}
						list.clear();
						list.add(copylist.get(i));
					}
					
				}
				
			}
			
		}
		
	    for (Poker poker : temporaryRecord) {
		    	list.add(poker);
		}
	    
		sort(list);

	    
		for (int i = 1; i < 5; i++) {
			for (int k = 0; k < list.size(); k++) {
				if(i == 1 && i == list.get(k).getDecor()){
					black.add(list.get(k));
				}
				if(i == 2 && i == list.get(k).getDecor()){
					red.add(list.get(k));
				}
				if(i == 3 && i == list.get(k).getDecor()){
					plum.add(list.get(k));
				}
				if(i == 4 && i == list.get(k).getDecor()){
					cube.add(list.get(k));
				}
			}
		}
		
		for (int i = 0; i < black.size(); i++) {
			List<Poker> uu = new ArrayList<Poker>();
			for (int j = 0; j < 5; j++) {
				if(i+j == black.size()){
					break;
				}
				uu.add(black.get(i+j));	
			}
			if(containStraight(uu)){
				result.add(uu);
			}
		}
		for (int i = 0; i < red.size(); i++) {
			List<Poker> uu = new ArrayList<Poker>();
			for (int j = 0; j < 5; j++) {
				if(i+j == red.size()){
					break;
				}
				uu.add(red.get(i+j));	
			}
			if(containStraight(uu)){
				result.add(uu);
			}
		}
		for (int i = 0; i < plum.size(); i++) {
			List<Poker> uu = new ArrayList<Poker>();
			for (int j = 0; j < 5; j++) {
				if(i+j == plum.size()){
					break;
				}
				uu.add(plum.get(i+j));	
			}
			if(containStraight(uu)){
				result.add(uu);
			}
		}
		for (int i = 0; i < cube.size(); i++) {
			List<Poker> uu = new ArrayList<Poker>();
			for (int j = 0; j < 5; j++) {
				if(i+j == cube.size()){
					break;
				}
				uu.add(cube.get(i+j));	
			}
			if(containStraight(uu)){
				result.add(uu);
			}
		}
		
		for (int i = 0; i < result.size(); i++) {
			for (int j = 0; j < result.get(i).size(); j++) {
				if(result.get(i).get(j).getDeck() == 0){
					result.get(i).get(j).setDeck(13);
				}
			}
		}
		return result;
		
	}
}
