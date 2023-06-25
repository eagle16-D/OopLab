package hust.soict.sec.aims.media;

public class Track implements Playable{
	private String title;
	private int length;

	public Track(String title, int length) {
		super();
		this.title = title;
		this.length = length;
	}

	public Track(String title) {
		super();
		this.title = title;
	}



	public String getTitle() {
		return title;
	}
	protected void setTitle(String title) {
		this.title = title;
	}
	public int getLength() {
		return length;
	}
	protected void setLength(int length) {
		this.length = length;
	}
	@Override
	public void play() {
		if(this.getLength() <= 0) {
			System.out.println("Track " + this.getTitle() + " cannot be played");
		}
		else {
			System.out.println("Track " + this.getTitle() + " has length " + this.getLength());	
		}
	}

}
