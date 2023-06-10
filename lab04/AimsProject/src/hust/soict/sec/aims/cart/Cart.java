package hust.soict.sec.aims.cart;

import java.util.ArrayList;

import hust.soict.sec.aims.media.Media;

public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
	private ArrayList<Media> itemsOrdered = new ArrayList<Media>();
	
	public void addMedia(Media media) {
		if(itemsOrdered.size() < 20) {
			itemsOrdered.add(media);
			System.out.println("the media is added");
		}
	}
	
	public void removeMedia(Media media) {
		for(Media media1 : itemsOrdered) {
			if (media1.getTitle() == media.getTitle()) {
				itemsOrdered.remove(media);
				System.out.println("the media is removed");
				break;
			}
		}
	}
	
	public float totalCost() {
		float sum = 0;
		for(Media media : itemsOrdered) {
			sum += media.getCost();
		}
		return sum;
	}
	
	public void print() {
		System.out.println("******************************CART******************************");
		System.out.println("Ordered Items:");
		for(Media media : itemsOrdered) {
			System.out.println(itemsOrdered.indexOf(media) + "." + media.toString());
		}
		System.out.println("Total cost: " + this.totalCost());
		System.out.println("*****************************************************************");
	}
	
	
}
