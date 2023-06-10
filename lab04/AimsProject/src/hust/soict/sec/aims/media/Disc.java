package hust.soict.sec.aims.media;

public class Disc extends Media {



	public Disc(int id, String title, String category, float cost) {
		super(id, title, category, cost);
		// TODO Auto-generated constructor stub
	}
	public Disc(int id, String title, String category) {
		super(id, title, category);
		// TODO Auto-generated constructor stub
	}
	public Disc(int id, String title) {
		super(id, title);
		// TODO Auto-generated constructor stub
	}
	public Disc(String title) {
		super(title);
		// TODO Auto-generated constructor stub
	}
	private int length;
	private String director;
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	
	
}
