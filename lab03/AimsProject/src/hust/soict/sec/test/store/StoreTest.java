package hust.soict.sec.test.store;

import hust.soict.sec.aims.Store;
import hust.soict.sec.aims.disc.DigitalVideoDisc;

public class StoreTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Store sto1 = new Store();
		
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("Lion");
		sto1.addDVD(dvd1);
		
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Tiger");
		sto1.addDVD(dvd2);
		
		/*for(int i = 0; i < Store.numDisc; i++) {
			System.out.println(Store.itemsInStore[i].getTitle());
		}*/
	}

}
