
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


public class AcceptTest1 {
	
	@Before
	public void setUp() throws Exception {
	}

	@Test(timeout=5000)
	public void testMain() throws IOException {
		
		PrintStream stdout = System.out;
		//設定從鍵盤輸入Q
		final ByteArrayInputStream  inContent = new ByteArrayInputStream("Q". getBytes());
		System.setIn(inContent);
		
		//設定螢螢幕輸出
		final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		
		//執行程式
		Main.main(null);
		
		//比對螢幕輸出
		assertThat(outContent.toString(), containsString("結束了"));
		
		System.setOut(stdout);
		System.out.println("Acceptance Test 1 is pass");
		
	}
	
	@After
	public void tearDown() throws Exception {
	}
	
}
