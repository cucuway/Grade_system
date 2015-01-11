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
		/*TODO
		 * try 
		 * 1.call GradeSystems() to build "aGradeSystem"
		 * 2.loop1 until Q (Quit)
		 * 2.1.	promptID() to get user ID  輸入ID或 Q (結束使用)？ 
		 * 2.2.	checkID (ID) 看 ID 是否在 aGradeSystem內
		 * 2.3.	showWelcomeMsg (ID)      ex. Welcome李威廷
		 * 2.4.	loop2 until E (Exit)
		 * 			promptCommand() to prompt for inputCommand 
		 *  	end loop2
		 * end loop1
		 *  
		 * 3.showFinishMsg()           結束了
		 *  end try
		 *  finally {}
		 */
		 
		try {
		aGradeSystem = new GradeSystems(scanner);
		while (true) {
				String ID = promptID();
				if (ID.equals("Q"))
				break;
				else if (checkID(ID)) {
						showWelcomeMsg();
						promptCommand();
				} else
						throw new NoSuchIDExceptions();
				}
				showFinishMsg();
		} finally {
		}
		}		 
	}
	
	private void promptCommand() throws NoSuchCommandExceptions {
		System.out.println("\t輸入指令\t1) G 顯示成績 (Grade)");
		System.out.println("\t\t2) R 顯示排名 (Rank)");
		System.out.println("\t\t3) W 更新配分 (Weight)");
		System.out.println("\t\t4) E 離開選單 (Exit)");
		
		cmd=sc.next();
		/*TODO
		 * 取得輸入指令
		 * 1. prompt user for inputCommand
		 * 2. if inputCommand is not G (Grade),R (Rank), W (Weights), or E (Exit),
		 * 		throws an object of NoSuchCommandException
		 * 3. if inputCommand is E (Exit) then break
		 * 		else: G aGradeSystem.showGrade(ID), R showRank(ID), W updateWeights() end if
		 *end class UI
		 * 
		 */
		  switch (cmd) {
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
				System.exit(0);	
		
	}

	private void showWelcomeMsg() {
		System.out.println("Welcome "+ aGradeSystem.currentname + "!");
	}

	private void showFinishMsg() {
		System.out.println("結束");	
	}
	
	private boolean checkID(String ID)throws NoSuchIDExceptions {
			if(containsID(ID)){
					return true;
			}else
					return false;			
	}
	
	public void promptID() {
		System.out.print("輸入ID或 Q (結束使用)？");
		String idTmp = sc.next();
		return idTmp;
		
	}

}
