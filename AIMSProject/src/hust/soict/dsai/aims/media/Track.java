package hust.soict.dsai.aims.media;

import java.time.Duration;

import hust.soict.dsai.aims.exception.PlayerException;

public class Track implements Playable{
	private String title;
	private int length;
	
	public String getTitle() {
		return title;
	}
	public int getLength() {
		return length;
	}
	public Track(String title, int length) {
		this.title = title;
		this.length = length;
	}
	
	@Override
	public void play() {
		System.out.println("Playing Track: " + this.getTitle()); 
		System.out.println("Track's length: " + this.getLength()); 
	}
	
	public String formatDuration(int durationInSeconds) {
        Duration duration = Duration.ofSeconds(durationInSeconds);
        return String.format("%02d:%02d", duration.toMinutes(), duration.minusMinutes(duration.toMinutes()).getSeconds());
    }
	
	public boolean equals(Object obj) {
        if (this == obj) {  
            return true;
        }
        if (!(obj instanceof Track)) {
            return false;
        }
        return ((Track)obj).getTitle() == this.getTitle() && ((Track)obj).getLength() == this.getLength();
    }
	
	 public String playGUI() throws PlayerException {
	        if (this.getLength() > 0) {
	            return "Playing track: " + this.getTitle() + "\n" + 
	                "Track length: " + formatDuration(this.getLength());
	        } else {
	            throw new PlayerException("ERROR: Track length is non-positive!");
	        }
	 }
}
