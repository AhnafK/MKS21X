public class CirculatingBook extends LibraryBook{
    private String currentHolder;
    private String dueDate;

    public CirculatingBook(String author, String title, String ISBN, String callNumber){
	super(author, title, ISBN, callNumber);
	currentHolder=null;
	dueDate=null;
    }

    public void setCurrentHolder(String name){
	currentHolder = name;
    }
    
    public String getCurrentHolder(){
	return currentHolder;
    }

    public void setDueDate(String date){
	dueDate = date; 
    }

    public String getDueDate(){
	return dueDate;
    }

    public void checkout(String patron, String due){
	currentHolder = patron;
	dueDate = due;
    }

    public void returned(){
	currentHolder = null;
	dueDate = null;
    }

    public String circulationStatus(){
	if (dueDate == null && currentHolder == null){
	    return "book available on shelves";
	}
	return "" + this + ' ' + getCurrentHolder() +' '+ getDueDate();
    }
}
