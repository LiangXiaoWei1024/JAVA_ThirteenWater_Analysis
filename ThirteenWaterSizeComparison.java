package com.demo.test;

import java.util.List;

/**
 * 十三水大小比较
 * @author admin
 *
 */
public class ThirteenWaterSizeComparison extends ThirteenWaterHandJudgmentUtils {
	
	
	/**
	 * 比较对子 
	 * @param initiative
	 * @param passive
	 * @return initiative 是不是比 passive大   是true  否false
	 */
	public static  boolean containPair(List<Poker> initiative,List<Poker> passive){
		boolean result = false;
		if(initiative != null || passive != null){
			if(initiative.size() == 2 && initiative.size() == passive.size()){
				if(initiative.get(0).getDeck() > passive.get(0).getDeck()){
					result = true;
				}
			}
		}
		return result;
	}
	
	/**
	 * 比较两对
	 * @param initiative
	 * @param passive
	 * @return initiative 是不是比 passive大   是true  否false
	 */
	public static  boolean containTwoPairs(List<Poker> initiative,List<Poker> passive){
		boolean result = false;
		if(initiative != null || passive != null){
			if(initiative.size() == 4 && initiative.size() == passive.size()){
				int initiativeA = initiative.get(0).getDeck() > initiative.get(3).getDeck()? initiative.get(0).getDeck():initiative.get(3).getDeck();
				int initiativeB = initiative.get(0).getDeck() < initiative.get(3).getDeck()? initiative.get(0).getDeck():initiative.get(3).getDeck();
				int passiveInfA = passive.get(0).getDeck() > passive.get(3).getDeck()? passive.get(0).getDeck():passive.get(3).getDeck();
				int passiveInfB = passive.get(0).getDeck() < passive.get(3).getDeck()? passive.get(0).getDeck():passive.get(3).getDeck();

				if(initiativeA > passiveInfA){
					result = true;
				}else if(initiativeA == passiveInfA){
					if(initiativeB > passiveInfB){
						result = true;
					}
				}
			}
		}
		return result;
	}
	
	/**
	 * 比较三条
	 * @param initiative
	 * @param passive
	 * @return initiative 是不是比 passive大   是true  否false
	 */
	public static boolean containThree(List<Poker> initiative,List<Poker> passive){
		boolean result = false;
		if(initiative != null || passive != null){
			if(initiative.size() == 3 && initiative.size() == passive.size()){
				if(initiative.get(0).getDeck() > passive.get(0).getDeck()){
					result = true;
				}
			}
		}
		return result;
	}

	/**
	 * 比较顺子和同花顺
	 * @param initiative
	 * @param passive
	 * @return initiative 是不是比 passive大   是true  否false
	 */
	public static boolean containStraight(List<Poker> initiative,List<Poker> passive){
		boolean result = false;
		if(initiative != null || passive != null){
			if(initiative.size() == 5 && initiative.size() == passive.size()){
				sort(initiative);
				sort(passive);
				for (int i = 4; i > -1; i--) {
					int initiativeInfo = initiative.get(i).getDeck();
					int passiveInfo = passive.get(i).getDeck();
					if(initiativeInfo > passiveInfo){
						result = true;
						break;
					}else if(initiativeInfo == passiveInfo){
						continue;
					}else{
						break;
					}
				}
			}
		}
		return result;
	}

	/**
	 * 比较同花
	 * @param initiative
	 * @param passive
	 * @return initiative 是不是比 passive大   是true  否false
	 */
	public static boolean containSameColor(List<Poker> initiative,List<Poker> passive){
		boolean result = false;
		if(initiative != null || passive != null){
			if(initiative.size() == 5 && initiative.size() == passive.size()){
				sort(initiative);
				sort(passive);
				for (int i = 4; i > -1; i--) {
					int initiativeInfo = initiative.get(i).getDeck();
					int passiveInfo = passive.get(i).getDeck();
					if(initiativeInfo > passiveInfo){
						result = true;
						break;
					}else if(initiativeInfo == passiveInfo){
						continue;
					}else{
						break;
					}
				}
			}
		}
		return result;
	}

	/**
	 * 比较葫芦
	 * @param initiative
	 * @param passive
	 * @return initiative 是不是比 passive大   是true  否false
	 */
	public static boolean containGourd(List<Poker> initiative,List<Poker> passive){
		boolean result = false;
		if(initiative != null || passive != null){
			if(initiative.size() == 5 && initiative.size() == passive.size()){
				initiative = ThirteenWaterCardAnalysisUtils.getThree(initiative).get(0);
				passive = ThirteenWaterCardAnalysisUtils.getThree(passive).get(0);

				if(initiative.get(0).getDeck() > passive.get(0).getDeck()){
					result = true;
				}
			}
		}
		return result;
	}

	
	/**
	 * 比较铁支
	 * @param initiative
	 * @param passive
	 * @return initiative 是不是比 passive大   是true  否false
	 */
	public static boolean containIronBranch(List<Poker> initiative,List<Poker> passive){
		boolean result = false;
		if(initiative != null || passive != null){
			if(initiative.size() == 4 && initiative.size() == passive.size()){
				if(initiative.get(0).getDeck() > passive.get(0).getDeck()){
					result = true;
				}
			}
		}
		return result;
	}
}
