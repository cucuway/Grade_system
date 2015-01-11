import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class UnitTestCase1 {
	GradeSystems testTarget;
	Grades testTarget2;
	String id;
	double[] weights;
	
	@Before
	public void setUp() throws Exception {
		testTarget=new GradeSystems();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testshowRank1() {
		//測試showRank(ID)
		PrintStream stdout = System.out;
		final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		id="962001051";
		int except=29;
		int actual=testTarget.showRank(id);
		assertThat(outContent.toString(), containsString("李威廷排名第"));
		System.setOut(stdout);
	}
	
	@Test
	public void testshowRank2() {
		//測試showRank(ID)
		PrintStream stdout = System.out;
		final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		id="985002037";
		int except=50;
		int actual=testTarget.showRank(id);
		assertThat(outContent.toString(), containsString("張峻寧排名第"));
		System.setOut(stdout);
	}
	
	@Test
	public void testcontainsID1(){
		//測試containsID(ID)
		id="962001051";
		boolean except=true;
		boolean actual=testTarget.containsID(id);
		assertEquals(except,actual);
	}
	
	@Test
	public void testcontainsID2(){
		//測試containsID(ID)
		id="962001111";
		boolean except=false;
		boolean actual=testTarget.containsID(id);
		assertEquals(except,actual);
	}
	
	@Test
	public void testcaculateTotalGrade1(){
		testTarget2=new Grades();
		testTarget2.lab1=90;
		testTarget2.lab2=80;
		testTarget2.lab3=100;
		testTarget2.midTerm=75;
		testTarget2.finalExam=60;
		//測試caculateTotalGrade(weights)
		weights=new double[]{0.1,0.1,0.1,0.3,0.4};
		double except=90*0.1+80*0.1+100*0.1+75*0.3+60*0.4;
		double actual=testTarget2.calculateTotalGrade(weights);
		assertEquals(except,actual,0.1);//最後的0.1代表比對到小數點以下第一位
	}
	
	@Test
	public void testcaculateTotalGrade2(){
		testTarget2=new Grades();
		testTarget2.lab1=95;
		testTarget2.lab2=75;
		testTarget2.lab3=80;
		testTarget2.midTerm=95;
		testTarget2.finalExam=73;
		//測試caculateTotalGrade(weights)
		weights=new double[]{0.2,0.2,0.1,0.2,0.3};
		double except=95*0.2+75*0.2+80*0.1+95*0.2+73*0.3;
		double actual=testTarget2.calculateTotalGrade(weights);
		assertEquals(except,actual,0.1);//最後的0.1代表比對到小數點以下第一位
	}
}
