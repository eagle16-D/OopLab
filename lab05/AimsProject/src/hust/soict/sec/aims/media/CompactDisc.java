package hust.soict.sec.aims.media;

import java.util.ArrayList;

import hust.soict.sec.aims.exception.PlayerException;


public class CompactDisc extends Disc implements Playable{
	private String artist;
	private ArrayList<Track> tracks;


	
	public CompactDisc(int id, String title, String category, float cost, String artist) {
		super(id, title, category, cost);
		this.artist = artist;
	}

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
	
	public void play() throws PlayerException{
		if(this.getLength() <= 0) {
			throw new PlayerException("ERROR: CD length is non-positive");

		}
		else {
			for(Track track : tracks) {
				try {
					track.play();
					
				} catch (PlayerException e) {
					// TODO: handle exception
					throw e;
				}
			}			
		}
	}
	
	@Override
	public String toString() {
		return "CD - " + this.getTitle() + " - " + this.getCategory() + " - " + this.getArtist() + " - " + this.getLength() + ": " + this.getCost(); 
	}
	
	
	
}
