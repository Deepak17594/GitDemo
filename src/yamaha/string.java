package yamaha;

public class string {
//write a string program  to reverse all the word in a string in forward in direction
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String name="Deepak Kumar is a good boy";
		String[] arr=name.split(" ");
		int arrlen=arr.length;
		String newname="";
		
		for(int i=0;i<arrlen;i++) {
			for(int j=arr[i].length()-1;j>=0;j--) {
				
				newname=newname+arr[i].charAt(j);	
			}	
			newname=newname+" ";
			}
	System.out.println(newname.trim());
	
		}
	
	}
//rbfrekhgrvbegvrkjevgkjrbgjkrbjkb
