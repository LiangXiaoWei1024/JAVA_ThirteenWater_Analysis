package com.demo.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * 十三水牌型判断工具
 * @author lxw
 *
 */
public class ThirteenWaterHandJudgmentUtils {

	/**
	 * 包含对子吗
	 * @param arr
	 * @return
	 */
	public static boolean containPair(List<Poker> arr){
		boolean result = false; 
		for (int i = 0; i < arr.size(); i++) {
			int a = arr.get(i).getDeck();
			for (int j = 0; j < arr.size(); j++) {
				int b = arr.get(j).getDeck();;
				if(i == j){
					continue;
				}
				if(a == b){
					result = true;
					break;
				}
			}
			if(result){
				break;
			}
		}
		return result;
	}
	
	/**
	 * 包含两对
	 * @param arr
	 * @return
	 */
	public static boolean containTwoPairs(List<Poker> arr){
		Map<Integer,Integer> storageMap = new HashMap<Integer, Integer>();
		for (int i = 0; i < arr.size(); i++) {
			int a = arr.get(i).getDeck();
			for (int j = 0; j < arr.size(); j++) {
				int b = arr.get(j).getDeck();
				if(i == j){
					continue;
				}
				if(a == b){
					storageMap.put(a, b);
				}
			}
		}
		return storageMap.size() > 1;
	}

	/**
	 * 包含三条
	 * @param arr
	 * @return
	 */
	public static boolean containThree(List<Poker> arr){
		boolean result = false; 
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
							result = true;
							break;
						}
					}
				}
			}
			if(result){
				break;
			}
		}
		return result;
	}
	
	/**
	 * 包含同花吗
	 * @param arr
	 * @return
	 */
	public static boolean containSameColor(List<Poker> arr){
		boolean result = false;
		for (int i = 1; i < 5; i++) {
			int num = 0;
			for (int j = 0; j < arr.size(); j++) {
				if(i == arr.get(j).getDecor()){
					num++;
				}
			}
			if(num >= 5){
				result = true;
				break;
			}
		}
		return result;
	}
	
	/**
	 * 包含葫芦吗
	 * @param arr
	 * @return
	 */
	public static boolean containGourd(List<Poker> arr){
		//所有的对子
		Map<Integer,Integer> pairMap = new HashMap<Integer, Integer>();
		//所有的三条
		Map<Integer,Integer> threeMap = new HashMap<Integer, Integer>();

		for (int i = 0; i < arr.size(); i++) {
			int a = arr.get(i).getDeck();
			for (int j = 0; j < arr.size(); j++) {
				int b = arr.get(j).getDeck();
				if(i == j){
					continue;
				}
				if(a == b){
					pairMap.put(a, a);
					break;
				}
			}
		}
		
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
							threeMap.put(a, a);
							break;
						}
					}
				}
			}
		}
		if(pairMap.size() > 0 && threeMap.size() > 0){
			return pairMap.size()+threeMap.size() > 2;
		}
		return false;
	}
	
	/**
	 * 包含铁支
	 * @param arr
	 * @return
	 */
	public static boolean containIronBranch(List<Poker> arr){
		boolean result = false; 
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
									result = true;
									break;
								}
							}
						}
					}
				}
			}
			if(result){
				break;
			}
		}
		return result;
	}
	
	/**
	 * 包含顺子
	 * @param arr
	 * @return
	 */
	public static boolean containStraight(List<Poker> arr){
		Map<Integer,Integer> recordingMap = new HashMap<Integer, Integer>();
		List<Integer> list = new ArrayList<Integer>();
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
			int poker = copylist.get(i).getDeck();//本次扑克
			int upPoker = -999;//上一次扑克
			if(recordingMap.size() > 0){
				upPoker = recordingMap.get((int)recordingMap.keySet().toArray()[recordingMap.keySet().toArray().length-1]); 
			}
			
			if(Math.abs(poker-upPoker) == 1 || recordingMap.size() < 1 || Math.abs(poker-upPoker) == 0){
				recordingMap.put(poker, poker);
			}else{
				if(recordingMap.size() > 0){
					if(Math.abs(upPoker-poker) != 1 && recordingMap.size() < 5){
						recordingMap.clear();
						recordingMap.put(poker, poker);
					}
					if(Math.abs(upPoker-poker) != 1 && recordingMap.size() > 5){
					    for(Entry<Integer, Integer> entry:recordingMap.entrySet()){  
					    	list.add(entry.getKey());
					    }  
					    recordingMap.clear();
					    recordingMap.put(poker, poker);
					}
					
				}
				
			}
			
		}
	    for(Entry<Integer, Integer> entry:recordingMap.entrySet()){ 	
	    	list.add(entry.getKey());
	    } 
	    recordingMap.clear();
		return  list.size() >= 5;
	}
	
	/**
	 * 包含同花顺
	 * @param arr
	 * @return
	 */
	public static boolean containIronStraightFlush(List<Poker> arr){
		List<Poker> temporaryRecord = new ArrayList<Poker>();
		List<Poker> copylist = copyPokerList(arr);
		List<Poker> list = new ArrayList<Poker>();


		List<Poker> black = new ArrayList<Poker>();
		List<Poker> red = new ArrayList<Poker>();
		List<Poker> plum  = new ArrayList<Poker>();
		List<Poker> cube = new ArrayList<Poker>();
		
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
			if(list.size() > 0){
				upPoker = list.get(list.size()-1).getDeck();
				 
			}

			if(Math.abs(poker-upPoker) == 1 || list.size() < 1 || Math.abs(poker-upPoker) == 0){
				list.add(copylist.get(i));
			}else{
				if(list.size() > 0){
					if(Math.abs(upPoker-poker) != 1 && list.size() < 5){
						list.clear();
						list.add(copylist.get(i));
					}
					if(Math.abs(upPoker-poker) != 1 && list.size() > 5){
					    for (Poker pokera : list) {
					    	temporaryRecord.add(pokera);
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
	    
	    //讲所有花色取出来
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
		return containStraight(black) || containStraight(red) ||containStraight(plum) ||containStraight(cube) ;
	}

	
	/**
	 * 深度拷贝一个Poker对象
	 * @param arr
	 * @return
	 */
	public static List<Poker> copyPokerList(List<Poker> arr){
		List<Poker> copylist = new ArrayList<Poker>();
		for (int j = 0; j < arr.size(); j++) {
			Poker poker = new Poker();
			poker.setDeck(arr.get(j).getDeck());
			poker.setDecor(arr.get(j).getDecor());
			copylist.add(poker);
		}
		return copylist;
	}
	
	/**
	 * 排序
	 * @param arr
	 */
	public static void sort(List<Poker> arr){
		for (int i = 0; i < arr.size(); i++) {
			for (int j = i+1; j < arr.size(); j++) {
				if(j == arr.size()){
					break;
				}
				if(arr.get(i).getDeck() > arr.get(j).getDeck()){
					Poker temp = arr.get(i);
					arr.set(i, arr.get(j));
					arr.set(j, temp);
				}
			}
		}
	}
	
	/**
	 * 排序
	 * @param arr
	 */
	public static void sortArr(List<Integer> arr){
		for (int i = 0; i < arr.size(); i++) {
			for (int j = i+1; j < arr.size(); j++) {
				if(j == arr.size()){
					break;
				}
				if(arr.get(i)> arr.get(j)){
					int temp = arr.get(i);
					arr.set(i, arr.get(j));
					arr.set(j, temp);
				}
			}
		}
	}
	
	/**
	 * 排序
	 * @param arr
	 */
	public static void sortArr(int[] arr){
		for (int i = 0; i < arr.length; i++) {
			for (int j = i+1; j < arr.length; j++) {
				if(j == arr.length){
					break;
				}
				if(arr[i]> arr[j]){
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
	}
}
