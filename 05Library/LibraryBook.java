public abstract class LibraryBook extends Book implements Comparable<LibraryBook>{
    private String callNumber;

    public LibraryBook(String author, String title, String ISBN, Stirng callN){
	super(author, title, ISBN);
	callNumber = callN;
    }

    public void setCallNumber(String callN){
	callNumber = callN;
    }

    public String getCallNumber(){
	return callNumber;
    }

    public abstract void checkout(String patron, String due);
    public abstract void returned();
    public abstract String circulationStatus();

    public int compareTo(LibraryBook other){
	compareTo(other);
    }
}
