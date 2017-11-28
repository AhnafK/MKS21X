public class Book{
    private String author;
    private String title;
    private String ISBN;

    public Book(){
	
    }
    
    public Book(String author, String title, String ISBN){
	this.author=author;
	this.title=title;
	this.ISBN=ISBN;
    }

    public void setAuthor(String poo){
	author = poo;
    }

    public void setTitle(String poo){
	title = poo;
    }

    public void setISBN(String poo){
	ISBN = poo;
    }
    
    public String getAuthor(){
	return author;
    }

    public String getTitle(){
	return title;
    }

    public String getISBN(){
	return ISBN;
    }

    public String toString(){
	return title() + ", " + author + ", " + ISBN;
    }
}
