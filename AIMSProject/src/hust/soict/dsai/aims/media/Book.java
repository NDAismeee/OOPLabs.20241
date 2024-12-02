package hust.soict.dsai.aims.media;

import java.util.ArrayList;

public class Book extends Media {
	
	private static int nbBooks = 1;
	private ArrayList<String> authors = new ArrayList<String>();
	
	public ArrayList<String> getAuthors() {
		return authors;
	}
	
	public void addAuthor(String authorName) {
		if (authors.contains(authorName)) {
			System.out.println("Already had '" + authorName +"' in the author list");
		}else {
			authors.add(authorName);
			System.out.println("Add successfully");
		}
	}
	
	public void removeAuthor(String authorName) {
		if (authors.contains(authorName)) {
			authors.remove(authorName);
			System.out.println("Remove successfully");
		}else {
			System.out.println("The list doesn't have '" + authorName + "'");
		}
	}

	public Book(String title, String category, float cost) {
		super(title, category, cost);
		this.id = nbBooks;
		nbBooks++;
		this.title = title;
		this.category = category;
		this.cost = cost;
	}
	
	public String toString() {
		return "[Book] - [" + this.id + "] - " + this.title + " - " + this.category + ": " + this.cost + "$";
	}
}
