
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.containsString;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import org.hamcrest.MatcherAssert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class AcceptTest9 {
	
	@Before
	public void setUp() throws Exception {
		
	}
	
	//加上timeout設定可以防止無限迴圈
	@Test(timeout=1000)
	public void testMain() throws IOException {
		//把stdout記錄起來
		PrintStream stdout = System.out;
		//設定從鍵盤依序輸入"985002515\n", "R\n", "E\n, "Q\n""		
		ByteArrayInputStream  inContent = new ByteArrayInputStream("985002515\nR\nE\nQ\n". getBytes());
		System.setIn(inContent);
		//設定螢螢幕輸出
		final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		//執行程式
		Main.main(null);
		//把System.out還原，並把結果多印一分到stdout以利Debug
		System.setOut(stdout);
		System.out.println(outContent.toString());
		//比對螢幕輸出	
		assertThat(outContent.toString(), containsString("Welcome 辜麟傑 ! "));
		assertThat(outContent.toString(), containsString("輸入指令	1) G 顯示成績 (Grade)"));
		assertThat(outContent.toString(), containsString("2) R 顯示排名 (Rank)"));
		assertThat(outContent.toString(), containsString("3) W 更新配分 (Weight)"));
		assertThat(outContent.toString(), containsString("4) E 離開選單 (Exit)"));
		assertThat(outContent.toString(), containsString("使用者輸入："));
		assertThat(outContent.toString(), containsString("辜麟傑排名第2"));
		assertThat(outContent.toString(), containsString("使用者輸入："));
		assertThat(outContent.toString(), containsString("輸入ID或 Q (結束使用)？"));
		assertThat(outContent.toString(), containsString("結束了"));		
	}
	
	@After
	public void tearDown() throws Exception {
	}
	
}
