package hust.soict.sec.aims.media;

public abstract class Media {
	
	private int id;
	private String title;
	private String category;
	private float cost;
	
	public Media(int id, String title, String category, float cost) {
		super();
		this.id = id;
		this.title = title;
		this.category = category;
		this.cost = cost;
	}

	public Media(String title) {
		super();
		this.title = title;
	}

	public Media(int id, String title) {
		super();
		this.id = id;
		this.title = title;
	}

	public Media(int id, String title, String category) {
		super();
		this.id = id;
		this.title = title;
		this.category = category;
	}

	
	public int getId() {
		return id;
	}
	void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	void setTitle(String title) {
		this.title = title;
	}
	public String getCategory() {
		return category;
	}
	void setCategory(String category) {
		this.category = category;
	}
	public float getCost() {
		return cost;
	}
	void setCost(float cost) {
		this.cost = cost;
	}
}
