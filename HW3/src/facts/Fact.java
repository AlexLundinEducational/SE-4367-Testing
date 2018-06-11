package facts;

public class Fact {

	private String author;
	private String type;
	private String text;

	// HW3 addition value constructor
	public Fact(String author, String type, String text) {
		this.author=author;
		this.type=type;
		this.text=text;
	}
	
	public Fact() {}


	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getText() {
		return text;
	}

	// HW3 addition toString method
	public String toString(){
		String tempString = "";
		
		System.out.println("Fact toString method:");
		System.out.println(this.author);
		System.out.println(this.type);
		System.out.println(this.text);
		
		return tempString;
	}
	
	public void setText(String text) {
		this.text = text;
	}




}
