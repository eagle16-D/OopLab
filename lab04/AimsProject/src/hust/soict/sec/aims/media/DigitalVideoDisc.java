package hust.soict.sec.aims.media;

import hust.soict.sec.aims.exception.PlayerException;

public class DigitalVideoDisc extends Disc implements Playable{
	
	private String director;
	private int length;
	private static int nbDigitalVideoDisc = 0;
	
	public String getDirector() {
		return director;
	}

	public int getLength() {
		return length;
	}

	//constructor
	public DigitalVideoDisc(String title) {
		super(title);
		this.setTitle(title);
		nbDigitalVideoDisc ++;
		this.setId(nbDigitalVideoDisc);
	}
	
	public DigitalVideoDisc(String title, String category, float cost) {
		super(title);
		this.setTitle(title);
		this.setCategory(category);
		this.setCost(cost);
		DigitalVideoDisc.nbDigitalVideoDisc ++;
		this.setId(nbDigitalVideoDisc);
	}
	
	public DigitalVideoDisc(String title, String category, String director, float cost) {
		super(title);
		this.setTitle(title);
		this.setCategory(category);
		this.setCost(cost);
		this.director = director;
		DigitalVideoDisc.nbDigitalVideoDisc ++;
		this.setId(nbDigitalVideoDisc);
	}

	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		super(title);
		this.setTitle(title);
		this.setCategory(category);
		this.setCost(cost);
		this.director = director;
		this.length = length;
		DigitalVideoDisc.nbDigitalVideoDisc ++;
		this.setId(nbDigitalVideoDisc);
	}
	
	
	public DigitalVideoDisc(int id, String title, String category, float cost, String director, int length) {
		super(id, title, category, cost);
		this.director = director;
		this.length = length;
		DigitalVideoDisc.nbDigitalVideoDisc ++;
		this.setId(nbDigitalVideoDisc);
	}

	@Override
	public String toString() {
		return "DVD - " + this.getTitle() + " - " + this.getCategory() + " - " + this.getDirector() + " - " + this.getLength() + ": " + this.getCost(); 
	}
	
	public boolean isMatch(int id) {
		if(this.getId() == id) {
			return true;
		}
		return false;
	}
	
	public boolean isMatch(String title) {
		if(this.getTitle() == title) {
			return true;
		}
		return false;
	}
	
	public void play() throws PlayerException{
		if(this.getLength() <= 0) {
			throw new PlayerException("ERROR: DVD length is non-positive");
		}else {
			System.out.println("DVD " + this.getTitle() + " has length " + this.getLength());
			
		}
	}
			
}