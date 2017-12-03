public class ReferenceBook extends LibraryBook{
    private String collection;
    public ReferenceBook(String author, String title, String ISBN, String callN, String col){
	super(author, title, ISBN, callN);
	collection=col;
    }

    public void checkout(String patron, String due){

    }

    public void returned(){
	
    }

    public String circulationStatus(){
	return "ReferenceBooks can not be taken out";
    }
    
    public void setCollection(String col){
	collection = col;
    }

    public String getCollection(){
	return collection;
    }
}
