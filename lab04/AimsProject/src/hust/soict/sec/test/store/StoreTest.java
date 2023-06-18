package hust.soict.sec.test.store;

import hust.soict.sec.aims.Store;
import hust.soict.sec.aims.media.*;

public class StoreTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Store sto1 = new Store();
		
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("Lion");
		sto1.addMedia(dvd1);
		
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Tiger");
		sto1.addMedia(dvd2);
		
		/*for(int i = 0; i < Store.numDisc; i++) {
			System.out.println(Store.itemsInStore[i].getTitle());
		}*/
	}

}
