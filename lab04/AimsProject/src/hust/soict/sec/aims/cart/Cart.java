package hust.soict.sec.aims.cart;

import java.util.ArrayList;

import hust.soict.sec.aims.media.Media;

public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
	private ArrayList<Media> itemsOrdered = new ArrayList<Media>();
	
	public void addMedia(Media media) {
		if(itemsOrdered.size() < MAX_NUMBERS_ORDERED) {
			itemsOrdered.add(media);
			System.out.println("the media is added");
		}
	}
	
	protected void removeMedia(Media media) {
		if(itemsOrdered.contains(media)) {
			itemsOrdered.remove(media);
			System.out.println(media.getTitle() + " is removed");
		}
		else {
			System.out.println(media.getTitle() + " is not in list");
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
