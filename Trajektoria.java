public class Trajektoria {
	
	public static void main(String[] args) {
		String[] track=new String[50000];
		int amplituda=Integer.parseInt(args[0]) ;
		int dlugosc_lotu=Integer.parseInt(args[1]);
		int local=0;
		int general=0;
		boolean direction=true; 
		for(int i=0;i<50000;i++) {
			track[i]="";
		}
		if(amplituda<1||dlugosc_lotu<1) {System.out.print("klops"); return;}
		else if(amplituda==1) {
			for(int i=0;i<dlugosc_lotu;i++) {
				System.out.print("*");
			}
		}
		else {		
			int ii=0, kk=0;
			while(ii<dlugosc_lotu) {
				if(kk==local) {track[kk]=track[kk]+"*"; ii++;}
				else track[kk]=track[kk]+" ";
				
				kk++;
				if(kk==amplituda) {
					kk=0; 
					if(direction==true) {local++; general++;}
					if(direction==false) {local--; general++;}				
				}
				if(general==amplituda-1) {direction=!direction; general=0;}	
			}
			
			for(int i=0;i<amplituda;i++) {
				System.out.println(track[i]);
			}
		}
	}

}
