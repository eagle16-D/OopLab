package hust.soict.sec.aims;

import java.util.ArrayList;

import hust.soict.sec.aims.media.Media;

public class Store {
	static ArrayList<Media> itemsInStore = new ArrayList<Media>();
	public void addMedia(Media media) {
		itemsInStore.add(media);
		System.out.println("the media is added");
	}
	
	public void removeMedia(Media media) {
		itemsInStore.remove(media);
	}
	/*public static void main(String[] args) {
		System.out.println(numDisc);
	}*/
}
