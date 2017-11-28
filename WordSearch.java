import java.util.*; //random, scanner, arraylist
import java.io.*; //file, filenotfoundexception

public class WordSearch{

    public static void main(String[]args){
	WordSearch d = new WordSearch(10,10);
	d.addWord("poo", 1, 2, 0, 1);
	d.addWord("see", 4, 4, -1, -1);
	d.addWord("ooo", 0, 3, 1, 0);
	d.addWord("ooo", 0, 2, 1, 0);
	System.out.println(d+"");

	WordSearch f = new WordSearch(10, 10, "words.txt");
	System.out.println(f+"");
    }
    
    private char[][]data;
    private Random randgen;
    private ArrayList<String>wordsToAdd;
    private ArrayList<String>wordsAdded;
    private int seed;


    /**Initialize the grid to the size specified 
     *fill all of the positions with '_'
     *@param row is the starting height of the WordSearch
     *@param col is the starting width of the WordSearch
     */
    public WordSearch(int rows,int cols){
	data = new char[rows][cols];
	clear();
    }


    public WordSearch(int rows, int cols, String fileName){
	data = new char[rows][cols];
	clear();
	seed = (int)(Math.random()*100000);
    	randgen = new Random(seed);
	wordsToAdd=new ArrayList<String>();
	wordsAdded=new ArrayList<String>();
	try{
	    Scanner woo = new Scanner(new File(fileName));
	    
	    while(woo.hasNextLine()){
		wordsToAdd.add(woo.nextLine().toLowerCase());
	    }
	} catch (FileNotFoundException e){
	    System.out.println("File not found");
	}
	for (int x = 0; x < wordsToAdd.size(); x++){
	    int currentpos = Math.abs( randgen.nextInt()%wordsToAdd.size());
		if(addWord(wordsToAdd.get(currentpos), randgen.nextInt()%(rows - 1), randgen.nextInt()%(cols - 1), randgen.nextInt(), randgen.nextInt())){
		    wordsAdded.add(wordsToAdd.get(currentpos));
		    wordsToAdd.remove(currentpos);
		    x--;
		}
	}
    }
    
    /**Set all values in the WordSearch to underscores'_'*/
    private void clear(){
	for(int x = 0; x < data.length; x++){
	    for(int y = 0; y < data[x].length; y++){
		data[x][y] = '_';
	    }
	}
    }

    /**The proper formatting for a WordGrid is created in the toString.
     *@return a String with each character separated by spaces, and rows
     *separated by newlines.
     */
    public String toString(){
	String a = "";
	for (int x = 0; x < data.length; x++){
	    for(int y = 0; y < data[x].length; y++){
		a += data[x][y] + " ";
	    }
	    a += "\n";
	}
	a += "\n";
	int jeff = 1;
	for(int x = 0; x < wordsAdded.size(); x++){
	    a+=wordsAdded.get(x)+"  ";
	    jeff+=1;
	    if(jeff == 3){
		a+= "\n";
	    }
	}
	return a;
    }


    /**Attempts to add a given word to the specified position of the WordGrid.
     *The word is added from left to right, must fit on the WordGrid, and must
     *have a corresponding letter to match any letters that it overlaps.
     *
     *@param word is any text to be added to the word grid.
     *@param row is the vertical locaiton of where you want the word to start.
     *@param col is the horizontal location of where you want the word to start.
     *@return true when the word is added successfully. When the word doesn't fit,
     * or there are overlapping letters that do not match, then false is returned 
     * and the board is NOT modified.
     */
    public boolean addWordHorizontal(String word,int row, int col){
	if(word.length() < data[0].length-row-1){
	    return false;
	}
	else{
	    for(int x = 0; x < word.length(); x++){
		data[row][col + x] = word.charAt(x);
		    }
	}
	return true;
    }

   /**Attempts to add a given word to the specified position of the WordGrid.
     *The word is added from top to bottom, must fit on the WordGrid, and must
     *have a corresponding letter to match any letters that it overlaps.
     *
     *@param word is any text to be added to the word grid.
     *@param row is the vertical locaiton of where you want the word to start.
     *@param col is the horizontal location of where you want the word to start.
     *@return true when the word is added successfully. When the word doesn't fit,
     *or there are overlapping letters that do not match, then false is returned.
     *and the board is NOT modified.
     */

    public boolean canAdd(int row, int col, char c){
	return data[row][col]=='_' || data[row][col]==c;
    }

    public boolean canAddWord(String word, int row, int col, int dirx, int diry){
	try{
	    for(int x = 0; x < word.length(); x++){		
		if(!canAdd(row + diry*x, col + dirx*x, word.charAt(x))){
		    return false;
		}
	    }
	}catch(ArrayIndexOutOfBoundsException e){
	    return false;
	}
	return true;
    }

    
    public boolean addWord(String word, int row, int col, int rincr, int cincr){
	int rinc = rincr % 2;
	int cinc = cincr % 2;
	if(canAddWord(word, row, col, cinc, rinc)){
	    for(int x = 0; x < word.length(); x++){
		data[row + x*rinc][col + x*cinc]=word.charAt(x);
	    }
	}
	return true;
    }
    
    public boolean addWordVertical(String word,int row, int col){	
	if(word.length() < data.length-col-1){
	    return false;
	}
	else{
	    for(int x = 0; x < word.length(); x++){
		data[row + x][col] = word.charAt(x);
	    }
	}
	return true;
    }

}
