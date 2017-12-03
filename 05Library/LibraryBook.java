public abstract class LibraryBook extends Book implements Comparable<LibraryBook>{
    private String callNumber;

    public LibraryBook(String author, String title, String ISBN, String callN){
	super(author, title, ISBN);
	setCallNumber(callN);
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
	return getCallNumber().compareTo(other.getCallNumber());
    }

    public String toString(){
	return super.toString() + ", " + callNumber + circulationStatus();
    }
}
