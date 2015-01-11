//class finished

import java.util.Scanner;


public class Grades {
	public String ID;
	public String name;
	public int lab1;
	public int lab2;
	public int lab3;
	public int midTerm;
	public int finalExam;
	public double totalGrade;
	
	public Grades() {
	}
	
	public void setGrades(String line) {
		Scanner sc=new Scanner(line);
		ID = sc.next();
		name = sc.next();
		lab1 = sc.nextInt();
		lab2 = sc.nextInt();
		lab3 = sc.nextInt();
		midTerm = sc.nextInt();
		finalExam = sc.nextInt();
	}

	public double calculateTotalGrade(double[] weights){
		double[] weights1=GradeSystems.weights;
		double result = (lab1*weights1[0])+(lab2*weights1[1])+(lab3*weights1[2])+(midTerm*weights[3])+(finalExam*weights[4]);
		return result;
	}
}
