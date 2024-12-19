package hust.soict.dsai.aims.media;

import hust.soict.dsai.aims.exception.PlayerException;

public class DigitalVideoDisc extends Disc implements Playable{
	private static int nbDigitalVideoDiscs = 1;
	
	//Question 6
	public DigitalVideoDisc(String title) {
		super(title);
		this.id = nbDigitalVideoDiscs;
		nbDigitalVideoDiscs++;
		this.title = title;
	}
	public DigitalVideoDisc(String title, String category, float cost) {
		super(title, category, cost);
		this.id = nbDigitalVideoDiscs;
		nbDigitalVideoDiscs++;
		this.title = title;
		this.category = category;
		this.cost = cost;
	}
	public DigitalVideoDisc(String title, String category, String director, float cost) {
		super(title, category, director, cost);
		this.id = nbDigitalVideoDiscs;
		nbDigitalVideoDiscs++;
		this.title = title;
		this.category = category;
		this.director = director;
		this.cost = cost;
	}
	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		super(title, category, director, length, cost);
		this.id = nbDigitalVideoDiscs;
		nbDigitalVideoDiscs++;
		this.title = title;
		this.category = category;
		this.director = director;
		this.length = length;
		this.cost = cost;
	}
	@Override
	public void play() {
		System.out.println("Playing DVD: " + this.getTitle()); 
		System.out.println("DVD length: " + this.getLength()); 	
	}
	
	public String toString() {
		return "[DVD] - [" + this.id + "] - " + this.title + " - " + this.category + " - " + this.director
				+ " - " + this.length + ": " + this.cost + "$";
	}
	
	public String playGUI() throws PlayerException {
        if (this.getLength() > 0) {
                return "Playing DVD: " + this.getTitle() + "\n" + 
                    "DVD length: " + formatDuration(this.getLength());
            } else {
                throw new PlayerException("ERROR: DVD length is non-positive!");
            }
    }
}
