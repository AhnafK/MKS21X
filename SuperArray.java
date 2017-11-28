public class SuperArray{
    private int size;
    private String[] data;
    
    public SuperArray(){
	data = new String[10];
	size = 0;
    }

    public SuperArray(int capacity){
	data = new String[capacity];
    }
    
    public void clear(){
	for(int x = 0; x < size; x++){
	    data[x] = null;
	}
    }

    public int size(){
	return size;
    }

    public boolean isEmpty(){
	return data[0] == null;
    }
    
    public boolean add(String poop){
	if(size == data.length){
	    resize();
	}
	data[size + 1] = poop;
	size += 1;
	return true;
    }

    public String toString(){
	String ans = "[";
	for (int x = 0; x < size; x++){
	    ans+=data[x]+", ";
	}
	ans += "]";
	return ans;
    }

    public String get(int poopy){
	if(poopy < size){
	    return data[poopy];
	}
	else{
	    System.out.println("error, outside of defined list,");
	    return null;
	}
    }

    public void add(int poo1, String poo2){
	if (poo1 < 0 || poo1  > size()){
	    System.out.println("Error: position must be within or next to list");
	}
	if (poo1 == size){
	    add(poo2);
	}
	else{
	    resize();
	    for(int x = data.length-1;x > poo1; x--){
		data[x+1] = data[x];
	    }
	}
	size += 1;
    }

    private void resize(){
	String[] newlist = new String[data.length*2];
	for(int x = 0; x < size; x++){
	    newlist[x]=data[x];
		    }
	data = newlist;
    }

    public String set(int poo1, String poo2){
	if(poo1 > size){
	    System.out.println("Error: position must be within or next to list");
	    return null;
	}
	else{
	    add(poo1+1, poo2);
	    return remove(poo1);
	}
    }

    public boolean contains(String nomorepoo){
	for (int x = 0; x < size; x++){
	    if (data[x] == nomorepoo){
		return true;
	    }
	}
	return false;
    }

    public int indexOf(String target){
	if (contains(target)){
	    for (int x = 0; x < size; x++){
		if (data[x].equals(target)){
		    return x;
		}
	    }
	}
	return -1;
    }

    public String remove(int index){
	String ans = data[index] + "";
	add(index,null);
	for(int x = indexOf(null); x < data.length - 2; x++){
	    data[x]=data[x+2];
	}
	return ans;
    }
}
