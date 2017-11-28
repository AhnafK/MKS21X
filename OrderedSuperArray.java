public class OrderedSuperArray extends SuperArray{
    public OrderedSuperArray(){
	super();
    }

    public OrderedSuperArray(int capacity){
	super(capacity);
    }

    public OrderedSuperArray(String[] ary){
	super(ary.length);
	for(int x = 0; x < ary.length; x++){
	    add(ary[x]);
	}
    }

    
    public void add(int index, String value){
	add(value);
    }

    public boolean add(String value){
	super.add(findIndex(value), value);
	return true;
    }
    
    public int indexOf(String element){
	for(int x = 0; x < size(); x++){
	    if(get(x).equals(element)){
		return x;
	    }
	}
	return -1;
    }


    public int lastIndexOf(String element){
	for(int x = size(); x > 0; x--){
	    if(get(x).equals(element)){
		return x;
	    }
	}
	return -1;
    }
    
    private int findIndex(String element){
	for(int x = 0; x < size(); x++){
	    if(element.compareTo(get(x)) <= 0){
		return x;
	    }
	}
	return size();
    }
}
