package lab;

public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
	DigitalVideoDisc itemsOrdered[] = 
			new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
	
	int qtyOrdered = 0;//keep track number of disc in cart
	void addDigitalVideoDisc(DigitalVideoDisc disc) {
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
	
	float totalCost() {
		float sum = 0;
		for(int i = 0; i < this.qtyOrdered; i++) {
			sum += this.itemsOrdered[i].getCost();
		}
		return sum;
	}
	
}
