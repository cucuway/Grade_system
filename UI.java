import java.io.FileNotFoundException;
import java.util.Scanner;


public class UI {
	boolean Quit = false;
	boolean Exit = false;
	GradeSystems aGradeSystem;
	String ID = "";
	String cmd = "";
	Scanner sc=new Scanner(System.in);
	public UI() throws NoSuchIDExceptions, NoSuchCommandExceptions, FileNotFoundException{
		
	try {
		aGradeSystem = new GradeSystems();
		while (true) {
			String ID = promptID();
			if (ID.equals("Q")){
				showFinishMsg();
				break;
			}
			else if (aGradeSystem.checkID(ID)==true) {
				showWelcomeMsg();
				promptCommand();
			} 
		}
				
	} 
		finally {		}
}		 
	
	
	private void promptCommand() throws NoSuchCommandExceptions {
		System.out.println("\t輸入指令\t1) G 顯示成績 (Grade)");
		System.out.println("\t\t2) R 顯示排名 (Rank)");
		System.out.println("\t\t3) W 更新配分 (Weight)");
		System.out.println("\t\t4) E 離開選單 (Exit)");
		
		cmd=sc.next();

		  switch (cmd.charAt(0)) {
				case 'G':
					aGradeSystem.showGrade(ID);
				break;
				case 'R':
					aGradeSystem.showRank(ID);
				break;
				case 'W':
					aGradeSystem.updateWeights();
				break;
				case 'Q':	
				default:
					System.out.println("指令錯了!");
					promptCommand();
		  }
		
	}

	private void showWelcomeMsg() {
		System.out.println("Welcome "+ aGradeSystem.getcurrentname(ID) + "!");
	}

	private void showFinishMsg() {
		System.out.println("結束");	
	}
	
	public String promptID() {
		System.out.print("輸入ID或 Q (結束使用)？");
		String idTmp = sc.next();
		return idTmp;
		
	}

}
