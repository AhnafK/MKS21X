public class Barcode implements Comparable<Barcode>{
    private String zip;
    
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

    public static String toBarcode(int d){
	String[] code = new String[] {"||:::", ":::||", "::|:|", "::||:", ":|::|", ":|:|:", ":||::", "|:::|", "|::|:", "|:|::"};
	    return code[d];
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
	    B += toBarcode(current);
	    sum+=current;
	}
	B+=toBarcode(sum%10)+"|";
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
    }
}
