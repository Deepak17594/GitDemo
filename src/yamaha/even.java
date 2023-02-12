package yamaha;

import java.util.Scanner;

public class even {

	public static void main(String[] args)
    {
         
        String[] arr = {"Even", "Odd"};
         
        Scanner s = new Scanner(System.in);
         
        System.out.print("Enter the number: ");
        int no = s.nextInt();
 
        System.out.println(arr[no%2]);
    }
}//updates have been done in even no also by american guy
//guy 1 commit after guy 2 commit

//indian gut commit again