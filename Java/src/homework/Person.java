package homework;

import java.util.Scanner;
/*
 * 目的：人の共通点を管理します。。
 * 作者：NGUYEN MINH NHUT
 * 終了日：2022/1/09
 * version:1.0
 */

public class Person {
	
/*1. attribute*/
	
	protected String name;
	protected int myNumber;
	protected String addRess;
	protected String eMail;
	protected ListPerson listPerson;
	
/*2. get,set method*/
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMyNumber() {
		return myNumber;
	}

	public void setMyNumber(int myNumber) {
		this.myNumber = myNumber;
	}

	public String getAddRess() {
		return addRess;
	}

	public void setAddRess(String addRess) {
		this.addRess = addRess;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}
	
/*3.constructors*/
	
	public Person() {
		
	}
	
	public Person(String name, int  myNumber,String  addRess, String  eMail) {
		this.name=name;
		this.myNumber=myNumber;
		this.addRess= addRess;
		this.eMail= eMail;
	}
	
/*4.input,output*/
	
	public void inputData(Scanner scan) {
		
		
		System.out.println("お名前を入力してください。");
		this.name=scan.nextLine();
		System.out.println("個人番号を入力してください。");
		this.myNumber=Integer.parseInt(scan.nextLine());
		System.out.println("ご住所を入力してください。");
		this.addRess=scan.nextLine();
		System.out.println("メールを入力してください。");
		this.eMail=scan.nextLine();
	}

	
	public void outputData() {
		System.out.print("名前:　"+this.name+"\t個人番号:　"+this.myNumber+"\t住所：　"+this.addRess+"\tメール:　"+this.eMail+"\t");
	}
/*5.business method */
	
	
}
