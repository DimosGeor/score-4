import java.util.*;
public class Main {

	public static void main(String[] args) {
		Game game=new Game();
	    Scanner user_input = new Scanner( System.in );
		int r,c;
		String name1,name2;
		String chip1,chip2;
		

		
		System.out.println("This is Score4");
		
		System.out.print("Please enter the name of the 1st player: ");
		name1=user_input.next();
		System.out.print("Please enter the name of the 2nd player: ");
		name2=user_input.next();
		
		System.out.println(name1 +",please select your chip: ");
		chip1=user_input.next();
				
		
		if (chip1.contentEquals("x")) { 
			chip2="o";
			System.out.println(name2 +",your chip is: " +chip2);
		 
		}
		else {
			chip2="x";
			System.out.println(name2 +",your chip is: " +chip2);
		}
		
		do{
			System.out.println("Please enter the number of rows: ");
			r=user_input.nextInt();
			if (r<4 || r>15) {
				System.out.print("Invalid number.");
			    }
			
			} while(r<4 || r>15 );
			
			
			do {
				System.out.println("Please enter the number of columns: ");
				c=user_input.nextInt();
				
				if (c<4 || c>15)
					{System.out.print("Invalid number.");
					}
					
				}while(c<4 || c>15);
			//φτιαχνω τον πινακα
			char[][] newArray = new char [r][c];
			
			for (int i=0;i<r;i++)
			{
				
                  	for(int j=0;j<c;j++)
				{
	
					newArray[i][j]='-';
				}
				
			}
			game.Display(newArray, r, c);
			game.Start_Playing(name1, name2, newArray, chip1, chip2, r, c);
			
					
			
	}

}
