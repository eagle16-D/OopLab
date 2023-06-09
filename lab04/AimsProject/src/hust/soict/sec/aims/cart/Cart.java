package hust.soict.sec.aims.cart;


import javax.naming.LimitExceededException;

import hust.soict.sec.aims.media.Media;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
	private static ObservableList<Media> itemsOrdered = FXCollections.observableArrayList();
	
	public void addMedia(Media media) throws LimitExceededException{
		if(itemsOrdered.size() < MAX_NUMBERS_ORDERED) {
			itemsOrdered.add(media);
//			System.out.println("the media is added");
		}
		else {
			throw new LimitExceededException("Error: the number of media has reached its limit");
		}
	}
	
	public void removeMedia(Media media) {
		if(itemsOrdered.contains(media)) {
			itemsOrdered.remove(media);
			System.out.println(media.getTitle() + " is removed");
		}
		else {
			System.out.println(media.getTitle() + " is not in list");
		}
	}
	
	public static float totalCost() {
		float sum = 0;
		for(Media media : itemsOrdered) {
			sum += media.getCost();
		}
		return sum;
	}
	
	public static void printCart() {
		System.out.println("******************************CART******************************");
		System.out.println("Ordered Items:");
		for(Media media : itemsOrdered) {
			System.out.println(itemsOrdered.indexOf(media) + 1 +". " + media.toString());
		}
		System.out.println("Total cost: " + totalCost());
		System.out.println("*****************************************************************");
	}
	
	public static ObservableList<Media> getItemsOrdered(){
		return itemsOrdered;
	}
	
}
