import java.util.NoSuchElementException;
import java.util.Scanner;

public class Krolik {
	
	private int howManyColumns=0;
	private int howManyRows=0;
	private String[][] board = new String[5000][5000]; // [wiersze] [kolumny]
	
	public static void main(String[] args)  throws Exception  {
		int columnNumber=0;
		Krolik krolik =new Krolik();
		krolik.fileToBoard();
		columnNumber=krolik.checkBoard(args[0]);
		if(columnNumber==0||columnNumber==-1) System.out.println("klops");
		else System.out.println(krolik.totalColumn(columnNumber));
	}
	
	public void fileToBoard()  throws Exception {
		Scanner sc=new Scanner(System.in);
		String[] rows = new String[5000];
		try {
			int i=0;
			do{
				rows[i]=sc.nextLine();
				i++;
				howManyRows=i;
			}while(i<5000);	
		}
		catch(NoSuchElementException e){
			//error
		}
		try {
			for(int i=0;i<rows.length;i++) {
				board[i]=rows[i].split(",");
			}
		}
		catch(NullPointerException e){
			//error
		}
		howManyColumns=board[0].length;
		sc.close();
	}
	
	public int checkColumn(String parametr, int oneColumn) {
		int howMany=0;
		parametr = "{"+parametr+"}";
		for(int i=0;i<howManyRows;i++) {
			if (board[i][oneColumn].equals(parametr)) howMany++ ;
		}				
		return howMany;
	}
	
	public int totalColumn(int oneColumn) {
		int total=0;
		for(int i=0;i<howManyRows;i++) {
			try {
				total=total+Integer.parseInt(board[i][oneColumn]);
			}
			catch(NumberFormatException e) {
				// error
			}
		}
		return total;
	}
	
	public int checkBoard(String parametr) {
		int howMany=0;
		int whichColumn=0;
		for(int i=0;i<howManyColumns;i++) {
			howMany=howMany+checkColumn(parametr, i);
			if(checkColumn(parametr, i)==1) whichColumn=i;
		}
		if(howMany==1) return whichColumn;
		else return -1;
	}
}
