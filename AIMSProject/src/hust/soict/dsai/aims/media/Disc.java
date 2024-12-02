package hust.soict.dsai.aims.media;

public class Disc extends Media{
	
	protected int length;
	protected String director;
	
	public int getLength() {
		return length;
	}
	public String getDirector() {
		return director;
	}
	public Disc(String title) {
		super(title);
		this.title = title;
	}
	public Disc(String title, String category, float cost) {
		super(title, category, cost);
		this.title = title;
		this.category = category;
		this.cost = cost;
	}
	public Disc(String title, String category, String director, float cost) {
		super(title, category, cost);
		this.title = title;
		this.category = category;
		this.director = director;
		this.cost = cost;
	}
	public Disc(String title, String category, String director, int length, float cost) {
		super(title, category, cost);
		this.title = title;
		this.category = category;
		this.director = director;
		this.length = length;
		this.cost = cost;
	}
}
