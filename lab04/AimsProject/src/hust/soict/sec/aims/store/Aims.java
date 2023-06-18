package hust.soict.sec.aims.store;


import java.util.Scanner;

import hust.soict.sec.aims.Store;
import hust.soict.sec.aims.cart.Cart;
import hust.soict.sec.aims.media.*;

public class Aims {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Store store = new Store();
		
		//Create new dvd objects and add them to the cart
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
		store.addMedia(dvd1);
		
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
		store.addMedia(dvd2);
		
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
		store.addMedia(dvd3);
		
		//print total cost of the items in the cart
//		anOrder.removeDigitalVideoDisc(dvd1);
//		System.out.println(anOrder.itemsOrdered[0].getTitle());
//		System.out.println("Total Cost is: ");
//		System.out.println(store.totalCost());
		
		
		//show book's information: id, title, category, cost, list of authors
		Scanner scanner = new Scanner(System.in);
		String inputString = scanner.nextLine();
			//play
			if(inputString.equals("showDetail")) {
				showDetail();
			}
			else if (inputString.split(" ")[0].equals("play")) {
				for(Media media : Store.getItemsInStore()) {
					if( media.getTitle().equals(inputString.substring(5))) {
						play(media);
					}
				}
			} 
		scanner.close();
		}

	public static void showDetail() {
		for(Media media : Store.getItemsInStore()) {
			
			if(media instanceof Book) {
				System.out.println("*Book*");
				System.out.println("title: " + ((Book)media).getTitle());
				System.out.println("category: " + ((Book)media).getCategory());
				System.out.println("author list: " + ((Book)media).getAuthors());
				System.out.println("content length: " + ((Book)media).getLength());
			}
			
			//show CD's information: id, title, category, artist, director, track, list of price
			//each track in a CD
			if(media instanceof CompactDisc) {
				System.out.println("*Compact Disc*");
				System.out.println("title: " + ((CompactDisc)media).getTitle());
				System.out.println("category: " + ((CompactDisc)media).getCategory());
				System.out.println("artist: " + ((CompactDisc)media).getArtist());
				System.out.println("director: " + ((CompactDisc)media).getDirector());
				System.out.println("length: " + ((CompactDisc)media).getLength());
				System.out.println("cost: " + ((CompactDisc)media).getCost());
			}
			
			//for DVD
			if(media instanceof DigitalVideoDisc) {
				System.out.println("*DigitalVideoDisc*");
				System.out.println("title: " + ((DigitalVideoDisc)media).getTitle());
				System.out.println("category: " + ((DigitalVideoDisc)media).getCategory());
				System.out.println("director: " + ((DigitalVideoDisc)media).getDirector());
				System.out.println("length: " + ((DigitalVideoDisc)media).getLength());
				System.out.println("cost: " + ((DigitalVideoDisc)media).getCost());
			}
		}
	}
	
	public static void play(Media media) {
		if(Store.getItemsInStore().contains(media)) {	
			if(media instanceof CompactDisc) {
				((CompactDisc)media).play();
			}
			else if(media instanceof DigitalVideoDisc) {
				((DigitalVideoDisc)media).play();
			}
		}
		else {
			System.out.println("you must choose 1 media in the list");
		}
	}
}
