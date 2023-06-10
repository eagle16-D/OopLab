package hust.soict.sec.aims.media;

public abstract class Track implements Playable{

	public Track() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Track(String title) {
		// TODO Auto-generated constructor stub
		this.title = title;
	}

	private String title;
	private int length;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	
	public void play(Track track) {
		System.out.println("Track" + track.getTitle() + "has length " + track.getLength());
	}
}
