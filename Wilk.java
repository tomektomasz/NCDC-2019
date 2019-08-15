import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Wilk {
	private float fuel=0;
	private float propertyTaps[] = new float[1000000];
	private float tempTaps[] = new float[1000000];
	private int hawManyTaps=0;
	
	public static void main(String[] args) throws Exception {
		Wilk wilk=new Wilk();
		wilk.fileToTap();
		float season=0;
		float hawHot=1;
		if(wilk.checkData()) {
			System.out.println("klops");
			return;
		}
		season=wilk.calculateTime();
		hawHot=wilk.calculateTemp(season);

		DecimalFormat df=new DecimalFormat("#.#####");
		String s=df.format(season);
		s=s.replace(",", ".");
		System.out.println(s);
		
		s=df.format(hawHot);
		s=s.replace(",", ".");
		System.out.println(s);
	}
	
	public void fileToTap() throws Exception  {
		String[] lines = new String[1000001];
		String[] oneLine = new String[2];
		Scanner sc=new Scanner(System.in);

		try {
			int ii=0;
			do{
				lines[ii]=sc.nextLine();
				ii++;
				hawManyTaps=ii-1;
			}while(ii<1000001);	
		}
		catch(NoSuchElementException e){
			//error
		}	
		sc.close();
				
		try {
			fuel=Float.parseFloat(lines[0]);
			for(int i=1;i<hawManyTaps+1;i++) {
				oneLine=lines[i].split(" ",2);
				propertyTaps[i-1]=Float.parseFloat(oneLine[0]);
				tempTaps[i-1]=Float.parseFloat(oneLine[1]);
			}
		}
		catch (NumberFormatException e) {
			System.out.print("klops");
			System.exit(0);
		}

	}
	
	public boolean checkData() {
		if(fuel>100000) return true;
		for(int i=0;i<hawManyTaps;i++) {
			if(tempTaps[i]>90||tempTaps[i]<1) return true;
		}
		return false;
	}
	
	public float calculateTime() {
		float amount = 0;
		for(int i=0; i<hawManyTaps;i++) {
			amount += propertyTaps[i];  
		}
		return fuel/amount*60000;
	}
	
	public float calculateTemp(float moment) {
		float amount = 0;
		for(int i=0;i<hawManyTaps;i++) {
			amount += (propertyTaps[i]*tempTaps[i]);			
		}
		return amount*moment/60000/fuel ;
	}
	
}
