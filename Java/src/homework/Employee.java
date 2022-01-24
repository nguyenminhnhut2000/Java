package homework;

import java.util.Scanner;
/*
 * 目的：従業員の業務を管理します。
 * 作者：NGUYEN MINH NHUT
 * 終了日：2022/1/09
 * version:1.0
 */

public class Employee extends Person {
/*1.contants*/	
	final int  hourlyWageRate = 100;/*時給*/
	
/*2.attribute*/
	private float numberOfWorkingHours;/*出勤時間*/
	private float salary;/*給料*/
	
/*3.get,set method*/
	
	public float getNumberOfWorkingHours() {
		return numberOfWorkingHours;
	}

	public float getSarary() {
		return salary;
	}
/*4.constructors*/
	public Employee() {
		
	}
	public Employee(String name, int  myNumber,String  addRess, String  eMail,float numberOfWorkingHous) {
		super(name,myNumber,addRess,eMail);
		this.numberOfWorkingHours= numberOfWorkingHous;
	}
/*5.input,output*/
	@Override
	public void inputData(Scanner scan) {
		super.inputData(scan);
		System.out.println("出勤時間:　");
		this.numberOfWorkingHours=Float.parseFloat(scan.nextLine());
	}
	@Override
	public void outputData() {
		super.outputData();
		System.out.println("\t出勤時間:　"+this.numberOfWorkingHours);
	}
	
/*6.business method*/
	
	public  void Salary() {
		this.salary=this.numberOfWorkingHours*hourlyWageRate;
	}
	
}
