package hust.soict.sec.aims.media;

import java.util.ArrayList;


public class CompactDisc extends Disc implements Playable{
	private String artist;
	private ArrayList<Track> tracks;


	
	public CompactDisc(int id, String title, String category, float cost) {
		super(id, title, category, cost);
		// TODO Auto-generated constructor stub
	}

	public CompactDisc(int id, String title, String category) {
		super(id, title, category);
		// TODO Auto-generated constructor stub
	}

	public CompactDisc(int id, String title) {
		super(id, title);
		// TODO Auto-generated constructor stub
	}

	public CompactDisc(String title) {
		super(title);
		// TODO Auto-generated constructor stub
	}

	
	void addTrack(Track track1) {
		if(!tracks.contains(track1)) {
			tracks.add(track1);
			System.out.println("The track " + track1 + "is added");
		}
		else {
			System.out.println("The track " + track1 + " already exists");
		}
	}
	
	void removeTrack(Track track1) {
		if(tracks.contains(track1)) {
			tracks.remove(track1);
			System.out.println("Track " + track1 + "is removed");
		}
		else {
			System.out.println("Track " + track1 + " is not in the list");
		}
	}


	public ArrayList<Track> getTracks() {
		return tracks;
	}

	void setTracks(ArrayList<Track> tracks) {
		this.tracks = tracks;
	}

	public String getArtist() {
		return artist;
	}
	
	public int getLength() {
		int len = 0;
		for(Track track : tracks) {
			len += track.getLength();
		}
		return len;
	}
	
	public void play() {
		if(this.getLength() <= 0) {
			System.out.println("the CD " + this.getTitle() + " cannot be played");
		}
		else {
			for(Track track : tracks) {
				track.play();
			}			
		}
	}
	
	@Override
	public String toString() {
		return "CD - " + this.getTitle() + " - " + this.getCategory() + " - " + this.getArtist() + " - " + this.getLength() + ": " + this.getCost(); 
	}
	
	
	
}
