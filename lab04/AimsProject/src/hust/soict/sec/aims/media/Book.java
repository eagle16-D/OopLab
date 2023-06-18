package hust.soict.sec.aims.media;
import java.util.ArrayList;
import java.util.List;

public class Book extends Media {
	private int length;
	private List<String> authors = new ArrayList<String>();
	

	
	public Book(int id, String title, String category, float cost, int length) {
		super(id, title, category, cost);
		this.length = length;
	}

	public Book(int id, String title, String category, float cost) {
		super(id, title, category, cost);
		// TODO Auto-generated constructor stub
	}

	public Book(int id, String title, String category) {
		super(id, title, category);
		// TODO Auto-generated constructor stub
	}

	public Book(int id, String title) {
		super(id, title);
		// TODO Auto-generated constructor stub
	}

	public Book(String title) {
		super(title);
		// TODO Auto-generated constructor stub
	}

	public List<String> getAuthors() {
		return authors;
	}

	void setAuthors(List<String> authors) {
		this.authors = authors;
	}
	
	
	
	public int getLength() {
		return length;
	}

	void setLength(int length) {
		this.length = length;
	}

	void addAuthor(String authorName) {
		if(!authors.contains(authorName)) {
			authors.add(authorName);
			System.out.println("Author added: " + authorName);
		}
		else {
			System.out.println("Author " + authorName + " already exists");
		}
	}
	
	void removeAutho(String authorName) {
		if(authors.contains(authorName)) {
			authors.remove(authorName);
			System.out.println("Author removed: " + authorName);
		}
		else {
			System.out.println("Author " + authorName + " is not exist");
		}
	}
	
	
}
