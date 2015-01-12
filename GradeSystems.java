import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class GradeSystems {
	static double[] weights=new double[]{0.1,0.1,0.1,0.3,0.4};
	
	String[][] alist = new String[100][8];
	int index=0;
	
	public GradeSystems() throws FileNotFoundException {
		File file = new File("gradeInput.txt");
		Scanner sc=new Scanner(file);
		while(sc.hasNextLine()){
			String line = sc.nextLine();
			Scanner sc1=new Scanner(line);
			alist[index][0]=sc1.next();
			alist[index][1]=sc1.next();
			alist[index][2]=sc1.next();
			alist[index][3]=sc1.next();
			alist[index][4]=sc1.next();
			alist[index][5]=sc1.next();
			alist[index][6]=sc1.next();
			alist[index][7]=String.valueOf(calculateTotalGrade(weights, alist[index][2], alist[index][3], alist[index][4], alist[index][5], alist[index][6]));
			index=index+1;
		}
	}
	
	private double calculateTotalGrade(double[] weights, String lab1, String lab2, String lab3, String midTerm, String finalExam) {
		double result = (Integer.valueOf(lab1)*weights[0])+(Integer.parseInt(lab2)*weights[1])+(Integer.valueOf(lab3)*weights[2])+(Integer.valueOf(midTerm)*weights[3])+(Integer.valueOf(finalExam)*weights[4]);
		return result;
	}

	public String getcurrentname(String ID){
		String ret = "";
		for(int i=0; i<index; i++){
			if(ID==alist[i][0]){
				ret=alist[i][0];
			}
		}
		return ret;
	}
	
	public void showGrade(String ID){
		int lindex=Integer.valueOf(ID);
		System.out.println(alist[lindex][1]+"成績:");
		System.out.println("lab1:        "+alist[lindex][2]);
		System.out.println("lab2:        "+alist[lindex][3]);
		System.out.println("lab3:        "+alist[lindex][4]);
		System.out.println("mid-term:   "+alist[lindex][5]);
		System.out.println("final exam:  "+alist[lindex][6]);
		System.out.println("total grade:"+alist[lindex][7]);
	}
	
	public int showRank(String ID){
		int rank=1;
		 int crank=Integer.valueOf(alist[Integer.valueOf(ID)][7]);
		 for(int i=0; i<index; i++){
			 int crank2=Integer.valueOf(alist[i][7]);
			 if(crank<crank2){
				 rank=rank+1;
			 }
		 }
		 
		 System.out.println(getcurrentname(ID)+"排名第"+rank);
		 return rank;
	}
	
	public void updateWeights (){
		 showOldWeights() ;
		 weights=getNewWeights(); 
		 for(int i=0; i<index; i++){
				alist[i][7]=String.valueOf(calculateTotalGrade(weights, alist[index][2], alist[index][3], alist[index][4], alist[index][5], alist[index][6]));
		 }
	}

	private double[] getNewWeights() {
		double[] tmpweights=new double[5];
		
		boolean RIGHT=false;
		Scanner sc=new Scanner(System.in);
		while(!RIGHT){
			System.out.print("\t\tlab1\t\t");
			tmpweights[0]=sc.nextDouble()/100;
			System.out.print("\t\tlab2\t\t");
			tmpweights[1]=sc.nextDouble()/100;
			System.out.print("\t\tlab3\t\t");
			tmpweights[2]=sc.nextDouble()/100;
			System.out.print("\t\ttmid-term\t");
			tmpweights[3]=sc.nextDouble()/100;
			System.out.print("\t\tfinal exam\t");
			tmpweights[4]=sc.nextDouble()/100;
			System.out.println("\t請確認新配分");
			System.out.println("\t\tlab1\t\t"+(int)(tmpweights[0]*100)+"%");
			System.out.println("\t\tlab2\t\t"+(int)(tmpweights[1]*100)+"%");
			System.out.println("\t\tlab3\t\t"+(int)(tmpweights[2]*100)+"%");
			System.out.println("\t\tmid-term\t"+(int)(tmpweights[3]*100)+"%");
			System.out.println("\t\tfinal exam\t"+(int)(tmpweights[4]*100)+"%");
			System.out.println("以上正確嗎? Y (Yes) 或 N (No) ");
			String cmd=sc.next();
			if(cmd.equalsIgnoreCase("y")){
				RIGHT=true;
				return tmpweights;
			}
		}
		return weights;
		
		
		
	}


	private void showOldWeights() {
		System.out.println("\t舊配分");
		
		System.out.println("\t\tlab1\t\t"+(int)(weights[0]*100)+"%");
		System.out.println("\t\tlab2\t\t"+(int)(weights[1]*100)+"%");
		System.out.println("\t\tlab3\t\t"+(int)(weights[2]*100)+"%");
		System.out.println("\t\tmid-term\t"+(int)(weights[3]*100)+"%");
		System.out.println("\t\tfinal exam\t"+(int)(weights[4]*100)+"%");
	}


	public boolean checkID(String ID) {
		boolean result=false;
		for(int i=0; i<index; i++){
			String icom=alist[i][0];
			if(ID.equals(icom)){				
				result = true;
				break;
			}
		}
		return result;
	}
}
