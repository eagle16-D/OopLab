package hust.soict.sec.aims.media;
import java.util.ArrayList;
import java.util.List;

public class Book extends Media {
	private List<String> authors = new ArrayList<String>();
	

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

	public void setAuthors(List<String> authors) {
		this.authors = authors;
	}
	
	public void addAuthor(String authorName) {
		for(String author : authors) {
			if(author.equals(authorName)) {
				System.out.println("Author has already in the list");
				return ;
			}
		}
		authors.add(authorName);
		System.out.println("the author is added");
	}
	
	public void removeAutho(String authorName) {
		for(String author : authors) {
			if(author.equals(authorName)) {
				authors.remove(authorName);
				System.out.println("the author is removed");
				break;
			}
		}
		System.out.println("the author is not in the list");
	}
	
	
}
