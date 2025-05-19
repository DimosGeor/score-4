import java.util.Scanner;

public class Game {
   private String turn_chip,last_chip;
	private int player;
	private int round;
	private boolean end;
	
	
  public static void  Display(char[][] newArray,int r,int c)
  {	
	  
	        for (int i=0;i<r;i++)
			{
				
				System.out.print("|");
				
				for(int j=0;j<c;j++)
				{
					
					
					System.out.print( "  " +newArray[i][j]);
					

				}
				System.out.print(" |");
				System.out.println("  ");	
			
			}
		
			for (int i=0;i<c;i++)
			{
			
				
					if(i==0)System.out.print("   -"  ) ;
					else System.out.print( "  -"  );
					
					
				
			}
			System.out.println("");
			for (int i=1;i<c+1;i++)
			{
				if(i<10) {
				if(i==1)System.out.print("   " +i ) ;
				else System.out.print( "  " +i );
				}
				else System.out.print(" "+i );
				
				
			}
			System.out.println("");
  }
  

	public void Start_Playing(String name1,String name2,char newArray[][],String chip1,String chip2,int r,int c) {
		Scanner user_input = new Scanner( System.in );
		
		
//επιλογη πρωτου παιχτη  και αντιστοιχια του αναλογου chip-name
	int play=0;
//τυχαια επιλογη πρωτου παιχτη και αποθηκευση σε μεταβλητη
	int temp = ((Math.random() <= 0.5) ?1 : 2);
	
	//ο 1ος παιχτης διαλεγει στηλη για να παιξει
	if (temp==1)
		{
		  player=1;
		}
	else {
		player=2;
		}
	end=false;
	while(!end && round<=r*c) {
	
	round++;
	  // εναλλαγη των παιχτων σε καθε round
	if (player==1 && round%2!=0) { 
		System.out.println (name1 + " your turn.Select column : ");
		 play=user_input.nextInt();
		 turn_chip=chip1;
		
	  
	}
	else if (player==1 && round%2==0)
	{
		System.out.println (name2 +" your turn.Select column : ");
	     play=user_input.nextInt();
		turn_chip=chip2;
		
	}
	else if (player!=1 && round%2==0) {
		System.out.println (name1 + " your turn.Select column : ");
		 play=user_input.nextInt();
		 turn_chip=chip1;	
	}
	else if (player!=1 && round%2!=0) {
		System.out.println (name2 +" your turn.Select column : ");
	     play=user_input.nextInt();
		 turn_chip=chip2;
		
	}
	//αναγκαιος ελεγχος για την αρχη γεμισματος του πινακα //r-1 η πρωτη θεση οχι το 0
	//if (newArray[r-1][play-1]=='-') newArray[r-1][play-1]=turn_chip.charAt(0);
	
	for (int row = r-1; row >= 0; row--){
		if(newArray[row][play-1] == '-'){
			newArray[row][play-1] = turn_chip.charAt(0);
			break;
		}

	}
	last_chip=turn_chip; //gia na krathsw ton teleutaio paixth
	Game.Display(newArray, r, c);
	end=Game.isWinner(turn_chip, newArray);

	
	}
	
	if(end) {
		if( last_chip.contentEquals(chip2))
		System.out.println(name2+ " is the WINNER!!!");
		else if (last_chip.contentEquals(chip1))
			System.out.println(name1+ " is the WINNER!!!");
		
	}
	else System.out.println( "TIE");

	}
	public static boolean isWinner(String turn_chip, char newArray[][]){
		//οριζοντια νικη
		for(int row = 0; row<newArray.length; row++){
			for (int col = 0;col < newArray[0].length - 3;col++){
				if (newArray[row][col] == turn_chip.charAt(0)  && 
					newArray[row][col+1] == turn_chip.charAt(0) &&
					newArray[row][col+2] == turn_chip.charAt(0) &&
					newArray[row][col+3] == turn_chip.charAt(0)){
					return true;
				}
			}			
		}
		//καθετη νικη
		for(int row = 0; row < newArray.length - 3; row++){
			for(int col = 0; col <newArray[0].length; col++){
				if (newArray[row][col] == turn_chip.charAt(0)  && 
					newArray[row+1][col] ==turn_chip.charAt(0) &&
					newArray[row+2][col] == turn_chip.charAt(0) &&
					newArray[row+3][col] == turn_chip.charAt(0)){
					return true;
				}
			}
		}
		//διαγωνια νικη
		for(int row = 3; row <newArray.length; row++){
			for(int col = 0; col <newArray[0].length - 3; col++){
				if (newArray[row][col] == turn_chip.charAt(0)   && 
					newArray[row-1][col+1] == turn_chip.charAt(0) &&
					newArray[row-2][col+2] == turn_chip.charAt(0) &&
					newArray[row-3][col+3] == turn_chip.charAt(0)){
					return true;
				}
			}
		}
		
		return false;
	}


}
