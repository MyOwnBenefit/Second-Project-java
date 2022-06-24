package day22_project;

import java.util.ArrayList;
import java.util.List;

public class Store {

    private List<Menu> menuList;
    private String name;
    private String phoneNumber;
    private String no;
    private double grade;
    private int gradecount;

    public Store() {}

   
    
	public Store(String name, String phoneNumber, String no) {
		super();
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.no = no;
		menuList=new ArrayList<>();
	}
	

	public String getNo() {
		return no;
	}



	public void setNo(String no) {
		this.no = no;
	}



	public List<Menu> getMenuList() {
		return menuList;
	}

	public void setMenuList(List<Menu> menuList) {
		this.menuList = menuList;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public double getGrade() {
		return grade;
	}

	public void setGrade(double grade) {
		this.grade = grade;
	}
	
	
    
	public int getGradecount() {
		return gradecount;
	}



	public void setGradecount(int gradecount) {
		this.gradecount = gradecount;
	}



	public void show() {
		System.out.println(no+"."+name);
		System.out.println("tel:"+phoneNumber);
		System.out.println("∆Ú¡°:"+grade);
		for(Menu m:menuList) m.show();
		
	}
    
}

