package hust.soict.sec.aims;

import java.util.ArrayList;

import hust.soict.sec.aims.media.Book;
import hust.soict.sec.aims.media.Media;

public class Store {
	private static ArrayList<Media> itemsInStore = new ArrayList<Media>();
	public void addMedia(Media media) {
		if(!itemsInStore.contains(media)) {
			itemsInStore.add(media);
//			System.out.println("the media " + media.getTitle() + " is added");
		}
		else {
			System.out.println("the media " + media.getTitle() + " is already in list");
		}
	}
	
	protected void removeMedia(Media media) {
		if(itemsInStore.contains(media)) {
			itemsInStore.remove(media);
			System.out.println("the media " + media.getTitle() + " is removed");
		}
		else {
			System.out.println("the media " + media.getTitle() + " is not in list");
		}
	}
	/*public static void main(String[] args) {
		System.out.println(numDisc);
	}*/

	public static ArrayList<Media> getItemsInStore() {
		return itemsInStore;
	}
	
<<<<<<< Updated upstream
=======
	public static void print() {
		System.out.println("******************************STORE******************************");
		System.out.println("Ordered Items:");
		for(Media media : itemsInStore) {
			System.out.println(itemsInStore.indexOf(media) + 1 + ". " + media.toString());
		}
		System.out.println("*****************************************************************");
	}
	
	public static void printTitleAll() {
		for(Media media : itemsInStore) {
			System.out.println(itemsInStore.indexOf(media) + 1 + ": " + media.getTitle());
		}
	}
	
>>>>>>> Stashed changes
}
