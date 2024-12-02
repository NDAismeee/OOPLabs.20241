package hust.soict.dsai.aims.media;

import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable{
	private static int nbCompactDiscs = 1;
	private String artist;
	private ArrayList<Track> tracks = new ArrayList<Track>();
	public String getArtist() {
		return artist;
	}
	
	public CompactDisc(String title, String category, String artist, float cost) {
		super(title, category, cost);
		this.id = nbCompactDiscs;
		nbCompactDiscs++;
		this.title = title;
		this.category = category;
		this.cost = cost;
		this.artist = artist;
		this.length = getLength();
	}
	
	public int getLength() {
		int length = 0;
		for (int i = 0; i < tracks.size(); i++) {
			length += tracks.get(i).getLength();
		}
		return length;
	}
	
	public void addTrack(Track track) {
		if (tracks.contains(track)) {
			System.out.println("Already have '" + track.getTitle() + "' in the track list");
		}else {
			tracks.add(track);
			System.out.println("Add successfully");
		}
	}
	
	public void removetrack(Track track) {
		if (tracks.contains(track)) {
			tracks.remove(track);
			System.out.println("Remove successfully");
		}else {
			System.out.println("The track list doesn't have '" + track.getTitle() + "'");
		}
	}

	@Override
	public void play() {
		System.out.println("Playing CD: " + this.getTitle()); 
		System.out.println("CD length: " + this.getLength());
		System.out.println("********TRACK********");
		for (int i = 0; i < tracks.size(); i++) {
			tracks.get(i).play();
			System.out.println("***********************");
		}
	}
	
	public String toString() {
		return "[CD] - [" + this.id + "] - " + this.title + " - " + this.category + " - "+ this.artist + " - " + getLength() + ": " + this.cost + "$";
	}
}
