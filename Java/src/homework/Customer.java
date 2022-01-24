package homework;

import java.util.Scanner;
/*
 * 目的：クライアントの業務を管理します。
 * 作者：NGUYEN MINH NHUT
 * 終了日：2022/1/09
 * version:1.0
 */

public class Customer extends Person{
/*1.attribute*/
	private String nameCompany;/**/
	private int valueOrder;/**/
/*2.get,set method*/
	

	public String getNameCompany() {
		return nameCompany;
	}

	public void setNameCompany(String nameCompany) {
		this.nameCompany = nameCompany;
	}

	public int getValueOrder() {
		return valueOrder;
	}
	
/*3 constructors*/
	public Customer() {
	}
	public Customer(String name, int  myNumber,String  addRess, String  eMail,String nameCompany,int valueOrder ) {
		super(name,myNumber,addRess,eMail);
		this.nameCompany=nameCompany;
		this.valueOrder=valueOrder;
	}
/*4 input,output*/
	@Override
	public void inputData(Scanner scan) {
		super.inputData(scan);
		System.out.println("社名　");
		this.nameCompany=scan.nextLine();
		System.out.println("注文する商品の金額：　");
		this.valueOrder=Integer.parseInt(scan.nextLine());
	}
	@Override
	public void outputData() {
		super.outputData();
		System.out.println("\t社名：　"+this.nameCompany+"\t金額：　"+this.valueOrder);
	}
/*5  business method */
	
	
}
