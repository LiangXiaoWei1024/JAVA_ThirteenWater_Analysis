package com.demo.test;

import java.util.List;

/**
 * ʮ��ˮʵ����
 * @author lxw
 *
 */
public class ThirteenWater {
	/**
	 * ͷ��
	 */
	private List<Poker> head;
	/**
	 * �ж�
	 */
	private List<Poker> among;
	/**
	 * β��
	 */
	private List<Poker> tail;
	
	public List<Poker> getHead() {
		return head;
	}
	public void setHead(List<Poker> head) {
		this.head = head;
	}
	public List<Poker> getAmong() {
		return among;
	}
	public void setAmong(List<Poker> among) {
		this.among = among;
	}
	public List<Poker> getTail() {
		return tail;
	}
	public void setTail(List<Poker> tail) {
		this.tail = tail;
	}
	@Override
	public String toString() {
		return "ThirteenWater [head=" + head + ", among=" + among + ", tail="
				+ tail + "]";
	}
	
	
	
}
