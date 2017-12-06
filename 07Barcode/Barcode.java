public class Barcode implements Comparable<Barcode>{
    private String zip;
    private static String[] code = new String[] {"||:::", ":::||", "::|:|", "::||:", ":|::|", ":|:|:", ":||::", "|:::|", "|::|:", "|:|::"};
    public Barcode(String z){
	killBadZip(z);
	zip = z;
    }

    public static void killBadZip(String s){
	if(s.length()!=5){
	    throw new IllegalArgumentException();
	}
    }

    public String getBarcode(){
	return "barcode ";
    }

    public String getZip(){
	return zip;
    }
    
    public static String toZip(String cod){
	if(cod.length()!=32 || cod.charAt(0) != '|' || cod.charAt(31)!='|'){
	    throw new IllegalArgumentException();
	}
	String t = "";
	for(int x = 1; x < 31; x+=5){
	    String current = cod.substring(x,x+5);
	    for(int y = 0; y<code.length; y++){
		if (current.equals(code[y])){
		    t += y + "";
		    break;
		}
	    }
	}
	if(Integer.parseInt(t.substring(0,5))%10 != Character.getNumericValue(t.charAt(5))){
	    throw new IllegalArgumentException();
	}
	return t.substring(0,5);
    }

		    
    public String getCode(){
	return toCode(zip);
    }
    
    public static String toCode(String zip){
	killBadZip(zip);
	String B = "|";
	int sum = 0;
	for(int x = 0; x < zip.length(); x++){
	    int current = Character.getNumericValue(zip.charAt(x));
	    B += code[current];
	    sum+=current;
	}
	B+=code[sum%10]+"|";
	return B;
    }

    public int compareTo(Barcode other){
	return Integer.parseInt(this.getZip()) - Integer.parseInt(other.getZip());
    }

    public String toString(){
	return getCode()+" ("+getZip()+')';
    }
    
    public static void main(String[]args){
	Barcode g = new Barcode("12345");
	System.out.println(g.getCode());
	System.out.println(g.getZip());
	System.out.println(g);
	System.out.println(Barcode.toZip(g.getCode()));
    }
}
