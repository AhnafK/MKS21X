public abstract class LibraryBook extends Book implements Comparable<LibraryBook>{
    private String callNumber;

    public LibraryBook(String author, String title, String ISBN, Stirng callN){
	super(author, title, ISBN);
	callNumber = callN;
    }

    
}
