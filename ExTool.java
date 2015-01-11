//Actually nothing to do here

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ExTool {
	public static void main(String[] args){
		System.out.println(System.getenv("JAVA_HOME")+"\\bin");
		System.out.println("C:\\Program Files (x86)\\Java\\jdk1.7.0\\bin");
	}
	public static void copydir(File oldDir,File newDir){
		if(newDir.exists()){
			System.out.println("Directory is already existed!");
			return;
		}
		Process p;
		try {
			p=Runtime.getRuntime().exec("cp -r " + oldDir.getPath() +" "+newDir.getPath());
			p.waitFor();
			if(p.exitValue()==0){
				System.out.println("copydir success");
			}else{
				System.out.println("copydir error");
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public static void delDir(File problem) {
		Process p;
		try {
			p=Runtime.getRuntime().exec("rm -r " + problem.getPath());
			p.waitFor();
			if(p.exitValue()==0){
				System.out.println("deldir success");
			}else{
				System.out.println("deldir error");
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public static void mkdir(String path) {
		File newDir=new File(path);
		Process p;
		if(newDir.exists()){
			System.out.println("Directory is already existed!");
			return;
		}
		try {
			p=Runtime.getRuntime().exec("mkdir " + path);
			p.waitFor();
			if(p.exitValue()==0){
				System.out.println("mkdir success");
			}else{
				System.out.println("mkdir error");
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void copyFile(File oldFile, File newFile) {
		Process p;
		try {
			p=Runtime.getRuntime().exec("cp " + oldFile.getPath() +" "+newFile.getPath());
			p.waitFor();
			if(p.exitValue()==0){
				System.out.println("copyFile success");
			}else{
				System.out.println("copyFile error");
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static String printErrmsg(Process p) throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(p.getErrorStream()));
		String fullmsg="";
		String errmsg;
		while((errmsg=bf.readLine())!=null)
			fullmsg+=errmsg+"\n";
		bf.close();
		return fullmsg;
	}
	
	public static String printOutmsg(Process p) throws IOException, InterruptedException{
		p.waitFor();
		BufferedReader bf=new BufferedReader(new InputStreamReader(p.getInputStream()));
		String fullmsg="";
		String outmsg;
		while((outmsg=bf.readLine())!=null)
			fullmsg+=outmsg+"\n";
		bf.close();
		return fullmsg;
	}
	
	public static String printOutmsg2(Process p) throws IOException, InterruptedException{
		//no wait for
		BufferedReader bf=new BufferedReader(new InputStreamReader(p.getInputStream()));
		String fullmsg="";
		String outmsg;
		while((outmsg=bf.readLine())!=null)
			fullmsg+=outmsg+"\n";
		bf.close();
		return fullmsg;
	}
	
	 public static String[] streamToStringArray(Scanner sc){
	    	List<String> listx = new ArrayList<String>();
			
			 while(sc.hasNextDouble()) { 
		            String input = sc.next();
		            listx.add(input); 
		        }
			 Object[] objectx=listx.toArray();
			 String[] stringx=new String[objectx.length];
			 for(int i=0;i<objectx.length;i++){
				 stringx[i]=objectx[i].toString();
			 }
			 return stringx;
	    }
	 
	 public static double[] streamToDoubleArray(Scanner sc){
	    	if(!sc.hasNextDouble())return null;
	    	List<String> listx = new ArrayList<String>();
			
			 while(sc.hasNextDouble()) { 
		            String input = sc.next();
		            listx.add(input); 
		        }
			 Object[] objectx=listx.toArray();
			 double[] doublex=new double[objectx.length];
			 for(int i=0;i<objectx.length;i++){
				 doublex[i]=Double.valueOf(objectx[i].toString());
			 }
			 return doublex;
	    }
}
