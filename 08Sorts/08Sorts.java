import java.util.Arrays;

public class Sorts{
    public static String name(){
	return "10,Kazi,Ahnaf";
    }


    public static void selectionSort(int[] ary){
	for(int x = 0; x < ary.length; x++){
	    int temp=ary[x];
	    int strongest=x;
	    for(int y = 0; y < ary.length; y++){
		if(ary[y]>=strongest){
		    strongest = y;
		}
	    }
	    ary[x]=ary[strongest];
	    ary[strongest]=temp;
	}
    }
    
    public static void bubbleSort(int[] ary){
	for(int x = ary.length; x>0; x--){
	    for(int y = 1; y < x; y++){
		if(ary[y]<ary[y-1]){
		    int temp = ary[y-1];
		    ary[y-1] = ary[y];
		    ary[y]=temp;
		}
	    }
	}
    }

    public static void insertionSort(int[]ary){
	for(int x = 1; x < ary.length; x++){
	    int temp = ary[x];
	    int rep = x;
	    for(int y = x - 1; y >= 0 && ary[y] < temp; y--){
		    ary[y+1]=ary[y];
		    rep = y;
	    }
	    ary[rep]=temp;
	}
    }
    
    public static void main(String[]argspoousihfiaohjeoilfaofjiefiaeojf){
	int[] randish = new int[15];                                                
	for(int i = 0 ; i < randish.length; i++){                                   
            randish[i] =(int)(Math.random()*100);                                   
        }
	System.out.println(Arrays.toString(randish));
	insertionSort(randish);
	System.out.println(Arrays.toString(randish));
    }
}
