package hust.soict.sec.aims.store;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import hust.soict.sec.aims.Store;
import hust.soict.sec.aims.cart.Cart;
import hust.soict.sec.aims.exception.PlayerException;
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
		
		CompactDisc cd = new CompactDisc("Huu");
		Book book = new Book("Duan");
		store.addMedia(book);
		
		List<Media> mediae = new ArrayList<Media>();
		mediae.add(dvd1);
		mediae.add(cd);
		mediae.add(book);
		

		
		java.util.Collections.sort(Store.getItemsInStore(), Media.COMPARE_BY_TITLE_COST);
		
		//show book's information: id, title, category, cost, list of authors
//		Scanner scanner = new Scanner(System.in);
//		String inputString = scanner.nextLine();
//			//play
//			if(inputString.equals("showDetail")) {
//				showDetail();
//			}
//			else if (inputString.split(" ")[0].equals("play")) {
//				for(Media media : Store.getItemsInStore()) {
//					if( media.getTitle().equals(inputString.substring(5))) {
//						play(media);
//					}
//				}
//			} 
//		scanner.close();
		showMenu();
		handlerInput1();
	}
	
	private static String input() {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
//		scanner.close();
		return input;
	}
	public static void handlerInput2() {
		//viewstore
		String input = input();
		switch (input) {
		case "1":
			System.out.println("Enter the title of media: ");
			String title = input();
			int i = 0;
			while (i < Store.getItemsInStore().size()) {
				if (Store.getItemsInStore().get(i).getTitle().equals(title)) {
					System.out.println(Store.getItemsInStore().get(i).toString());
					System.out.println("--------------------------------");
					mediaDetailsMenu();
					
					String inputString2 = input();
					switch (inputString2) {
					case "1":
						//add to cart
						Cart.getItemsOrdered().add(Store.getItemsInStore().get(i));
						System.out.println("the media is added to cart");
						break;
					
					case "2":
						try {
							play(Store.getItemsInStore().get(i));
						} catch (PlayerException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						break;
						
					case "0":
						storeMenu();
						handlerInput2();
						break;
					default:
						break;
					}
					
					break;
				}
				i ++;
			}
			if( i == Store.getItemsInStore().size()) {
				System.out.println("you must enter valid title");
			}
			break;
		case "2":
			System.out.println("Enter the title of media: ");
			String title1 = input();
			int i1 = 0;
			while( i1 < Store.getItemsInStore().size()) {
				if(title1.equals(Store.getItemsInStore().get(i1).getTitle())) {
					Cart.getItemsOrdered().add(Store.getItemsInStore().get(i1));
					System.out.println("the media is added");
					break;
				}
				i1++;
			}
			if(i1 == Store.getItemsInStore().size()) {
				System.out.println("you must enter valid title");
			}
			break;
		case "3":
			System.out.println("Enter the title of media: ");
			String title11 = input();
			int i2 = 0;
			while( i2 < Store.getItemsInStore().size()) {
				if(title11.equals(Store.getItemsInStore().get(i2).getTitle())) {
					try {
						play(Store.getItemsInStore().get(i2));
					} catch (PlayerException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				}
				i2 ++;
			}
			if(i2 == Store.getItemsInStore().size()) {
				System.out.println("you must enter valid title");
			}
			break;
		case "4":
			Cart.printCart();
			cartMenu();
			handlerInput3();
			break;
		case "5":
			showMenu();
			handlerInput1();
			break;
		}

	}
	
	public static void handlerInput1() {
		String inputString = input();
		switch (inputString) {
		case "1":
			Store.printTitleAll();
			storeMenu();
			handlerInput2();
			break;
		case "2":
			optionUpdate();
			if(input().equals("1")) {
					
				System.out.println("Enter information about media that you want to add into store.");
	
				String type = input();
	
				switch (type) {
				case "1":
					//enter title
					System.out.println("title: ");
					String Booktitle = input();
					//create Book 
					Book book = new Book(Booktitle);
					//add category
					System.out.println("category: ");
					String category = input();
					book.setCategory(category);
					//add length
					System.out.println("length: ");
					Scanner scanner = new Scanner(System.in);
					Integer len = scanner.nextInt();
					book.setLength(len);
					//add authors
					System.out.println("authors: ");
					String[] authorlist = input().split(" ");
					List<String> authors = new ArrayList<>();
					for(String author : authorlist) {
						authors.add(author);
					}
					book.setAuthors(authors);
					//add cost
					System.out.println("cost: ");
					Scanner scanner2 = new Scanner(System.in);
					Float cost = scanner2.nextFloat();
					book.setCost(cost);
						
					// add book to store
					Store.getItemsInStore().add(book);
					break;
						
				case "2":
					//enter title
					System.out.println("title: ");
					String CDTitle = input();
					//create CD
					CompactDisc cd = new CompactDisc(CDTitle);
					//add category
					System.out.println("category: ");
					cd.setCategory(input());
					//add cost
					System.out.println("cost: ");
					Scanner scanner3 = new Scanner(System.in);
					Float cost1 = scanner3.nextFloat();
					cd.setCost(cost1);
					//add cd to store
					Store.getItemsInStore().add(cd);
					break;
						
				case "3":
					System.out.println("title: ");
					String DVDTitle = input();
					//create DVD
					CompactDisc DVD = new CompactDisc(DVDTitle);
					//add category
					System.out.println("category: ");
					DVD.setCategory(input());
					//add cost
					System.out.println("cost: ");
					Scanner scanner4 = new Scanner(System.in);
					Float cost2 = scanner4.nextFloat();
					DVD.setCost(cost2);
					//add DVD to store
					Store.getItemsInStore().add(DVD);
					break;
						
				case "0":
					optionUpdate();
					handlerInput2();
					break;
				default:
					break;
				}
			}
			else if(input().equals("2")) {
				Store.printTitleAll();
				System.out.println("Choose the index of media that you want to remove");
				Scanner scanner = new Scanner(System.in);
				int index = scanner.nextInt();
				Store.getItemsInStore().remove(index - 1);
				System.out.println("the media is removed");
				scanner.close();
			}
			else if(input().equals("0")) {
				showMenu();
			}
		case "3":
			Cart.printCart();	
			cartMenu();
			handlerInput3();
			break;
		case "0":
			break;
		default:
			break;
		}
	}
	
	public static void handlerInput3() {
		String input = input();
		switch (input) {
		case "1":
			filterMediaInCart();
			String inputString = input();
			switch (inputString) {
			case "1":
				System.out.println("Enter id: ");
				Scanner scanner = new Scanner(System.in);
				int id = scanner.nextInt();
				for(Media media: Cart.getItemsOrdered()) {
					if(id == media.getId()) {
						System.out.println(media.toString());
					}
				}
				break;
			case "2":
				System.out.println("Enter title: ");
				String titleString = input();
				for(Media media: Cart.getItemsOrdered()) {
					if(titleString.equals(media.getTitle())) {
						System.out.println(media.toString());
					}
				}
				break;
			case "0":
				cartMenu();
				handlerInput3();
				break;

			default:
				break;
			}
			break;
		case "2":
			String inputString2 = input();
			switch (inputString2) {
			case "1":
				Collections.sort(Cart.getItemsOrdered(),Media.COMPARE_BY_TITLE_COST);
				break;
			case "2":
				Collections.sort(Cart.getItemsOrdered(),Media.COMPARE_BY_COST_TITLE);
				break;
			case "0":
				cartMenu();
				handlerInput3();
			default:
				break;
			}
		case "3":
			System.out.println("choose the index of the media that you want to remove");
			Scanner scanner = new Scanner(System.in);
			Integer index = scanner.nextInt();
			Cart.getItemsOrdered().remove(index - 1);
			System.out.println("the media is removed");
			break;
		case "4":
			System.out.println("choose the index of the media that you want to play");
			Scanner scanner1 = new Scanner(System.in);
			Integer index1 = scanner1.nextInt();
			try {
				play(Cart.getItemsOrdered().get(index1 - 1));
			} catch (PlayerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "5":
			System.out.println("the order is created, and the cart is empty now.");
			break;
		case "0":
			showMenu();
			handlerInput1();
			break;
		default:
			break;
		}
	}
	
	public static void sortMediaInCart() {
		System.out.println("Option: ");
		System.out.println("--------------------------------");
		System.out.println("1. Title");
		System.out.println("2. Cost");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2");
	}
	
	public static void filterMediaInCart() {
		System.out.println("Option: ");
		System.out.println("--------------------------------");
		System.out.println("1. ID");
		System.out.println("2. Title");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2");
	}

	public static void optionUpdate() {
		System.out.println("Option: ");
		System.out.println("--------------------------------");
		System.out.println("1. Add");
		System.out.println("2. Remove");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2");
	}

	public static void type() {
		System.out.println("Type: ");
		System.out.println("--------------------------------");
		System.out.println("1. Book");
		System.out.println("2. CD");
		System.out.println("3. DVD");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3");
	}
	
	public static void mediaDetailsMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Add to cart");
		System.out.println("2. Play");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2");
		}
	
	public static void storeMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. See a media’s details");
		System.out.println("2. Add a media to cart");
		System.out.println("3. Play a media");
		System.out.println("4. See current cart");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3-4");
	}
	
	public static void showMenu() {
		System.out.println("AIMS: ");
		System.out.println("--------------------------------");
		System.out.println("1. View store");
		System.out.println("2. Update store");
		System.out.println("3. See current cart");
		System.out.println("0. Exit");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3");
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
	
	public static void cartMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Filter medias in cart");
		System.out.println("2. Sort medias in cart");
		System.out.println("3. Remove media from cart");
		System.out.println("4. Play a media");
		System.out.println("5. Place order");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3-4-5");
}
	
	public static void play(Media media) throws PlayerException{
		try {
			if(Store.getItemsInStore().contains(media)) {	
				if(media instanceof CompactDisc) {
					((CompactDisc)media).play();
				}
				else if(media instanceof DigitalVideoDisc) {
					((DigitalVideoDisc)media).play();
				}
			}
			else {
				throw new PlayerException("ERROR: this media is not CD or DVD");
			}
		} catch (PlayerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
