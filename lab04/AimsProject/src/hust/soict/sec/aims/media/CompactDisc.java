package hust.soict.sec.aims.media;

import java.util.ArrayList;


public class CompactDisc extends Disc implements Playable{


	
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

	private String artist;
	private ArrayList<Track> tracks;
	public String getArtist() {
		return artist;
	}
	
	public void addTrack(Track track1) {
		for(Track track: tracks) {
			if (track == track1) {
				System.out.println("this track has been in track list");
				return;
			}
		}
		tracks.add(track1);
		System.out.println("the track is added");
	}
	
	public void removeTrack(Track track1) {
		for(Track track : tracks) {
			if (track == track1) {
				tracks.remove(track1);
				System.out.println("this track is removed");
			}
		}
	}
	
	public int getLength() {
		int len = 0;
		for(Track track : tracks) {
			len += track.getLength();
		}
		return len;
	}
	
	public void play() {
		for(Track track : tracks) {
			track.play();
		}
	}
	
	
	
}
