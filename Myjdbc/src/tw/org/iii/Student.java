package tw.org.iii;

import java.io.Serializable;

public class Student implements Serializable{
	private int ch,eng,math;
	private String id;
	public Student(String id,int ch,int eng,int math){
		this.id=id;this.eng=eng;this.ch=ch;this.math=math;
	}
	public int total(){
		return ch+eng+math;
	}
	public double avg(){
		return total()/3.0;
	}
	public String getId(){return id;}

}
