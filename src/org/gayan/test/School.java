package org.gayan.test;

public class School implements ISchool {
	
	private String schoolname = "Bandaranayake Collecge";
	
	private String principle = "Labuthale Sudassana Thero";
	
	private Student student;

	public String getSchoolname() {
		return schoolname;
	}

	public void setSchoolname(String schoolname) {
		this.schoolname = schoolname;
	}

	public String getPrinciple() {
		return principle;
	}

	public void setPrinciple(String principle) {
		this.principle = principle;
	}
	
	private String Bestword(){
		return "Vidvan sarwathra pujyathe";
		
	}
	
	private String description(int number, String sex){
		
	 return "there are "+number+" of "+sex+" students studey in there.";
	}
	
	
	public void welcome(){
		System.out.println("Welcome to BCG");
		
	}
	
	public School(Student student){
		
		this.student = student;
	}
	
	public School(int number,String text){
		
		System.out.println("Number is: "+number +" And Text is:"+text);
	}
	
	

}
