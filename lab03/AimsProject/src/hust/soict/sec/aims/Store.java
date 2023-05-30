package hust.soict.sec.aims;

import hust.soict.sec.aims.disc.DigitalVideoDisc;

public class Store {
	static DigitalVideoDisc itemsInStore[] = new DigitalVideoDisc[100];
	static int numDisc = 0;
	public void addDVD(DigitalVideoDisc disc) {
		itemsInStore[numDisc] = disc;
		numDisc++;
	}
	
	public void removeDVD(DigitalVideoDisc disc) {
		numDisc --;
		itemsInStore[numDisc] = null;
	}
	/*public static void main(String[] args) {
		System.out.println(numDisc);
	}*/
}
