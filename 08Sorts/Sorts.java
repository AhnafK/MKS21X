public class Sorts{
    public static String name(){
	return "01,Kazi,Ahnaf";
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

    public static void main(String[]argspoousihfiaohjeoilfaofjiefiaeojf){
	int[] randish = new int[15];                                                
	for(int i = 0 ; i < randish.length; i++){                                   
            randish[i] =(int)(Math.random()*100);                                   
        }
	System.out.println("" + randish);
	selectionSort(randish);
	System.out.println("" + randish);
    }
}
