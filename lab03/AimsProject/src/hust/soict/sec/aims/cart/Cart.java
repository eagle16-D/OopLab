package hust.soict.sec.aims.cart;

import hust.soict.sec.aims.disc.DigitalVideoDisc;

public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
	DigitalVideoDisc itemsOrdered[] = 
			new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
	
	int qtyOrdered = 0;//keep track number of disc in cart
	public void addDigitalVideoDisc(DigitalVideoDisc disc) {
		if(this.qtyOrdered < 20) {
			this.itemsOrdered[qtyOrdered] = disc;
			this.qtyOrdered ++;
			System.out.println("The disc has been added");
		}
		else {
			System.out.println("The cart is almost full");
		}
	}
	
	void removeDigitalVideoDisc(DigitalVideoDisc disc) {
		int i;
		for(i = 0; i < this.qtyOrdered ; i++) {
			if( this.itemsOrdered[i] == disc) {
				this.itemsOrdered[i] = null;
				break;
			}
		}
		for(i++; i < this.qtyOrdered; i++) {
			this.itemsOrdered[i-1] = this.itemsOrdered[i];
		}
		this.qtyOrdered --;
	}
	
	public float totalCost() {
		float sum = 0;
		for(int i = 0; i < this.qtyOrdered; i++) {
			sum += this.itemsOrdered[i].getCost();
		}
		return sum;
	}
	
	void addDigitalVideoDisc(DigitalVideoDisc [] dvdList){
		int num = dvdList.length;
		if(this.qtyOrdered + num <= 20) {
			for(int i = 0; i < num; i++) {
				this.itemsOrdered[this.qtyOrdered] = dvdList[i];
				this.qtyOrdered ++;
			}
			System.out.println("The list of disc has been added");
		}
		else {
			System.out.println("the cart is overloaded if add dvdList");
		}
	}
	/*void addDigitalVideoDisc(DigitalVideoDisc... args){
		int num = args.length;
		if(this.qtyOrdered + num <= 20) {
			for(DigitalVideoDisc arg : args) {
				this.itemsOrdered[qtyOrdered] = arg;
				this.qtyOrdered ++;
			}
			System.out.println("The list of disc has been added");
		}
		else {
			System.out.println("the cart is overloaded if add dvdList");
		}
	}*/
	//it will raise an error because of duplicating method. it mean that this method is the same with the above one.
	
	
	void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
		DigitalVideoDisc list[] = {dvd1, dvd2};
		int i = 0;
		while(this.qtyOrdered < 20) {
			this.itemsOrdered[this.qtyOrdered] = list[i];
			i ++;
			this.qtyOrdered ++;
			System.out.println("the cart has been added one more disc");
		}
	}
	
	public void print() {
		System.out.println("******************************CART******************************");
		System.out.println("Ordered Items:");
		for(int i = 0; i < this.qtyOrdered; i++) {
			System.out.println(this.itemsOrdered[i].toString());
		}
		System.out.println("Total cost: " + this.totalCost());
		System.out.println("*****************************************************************");
	}
	
	
}
