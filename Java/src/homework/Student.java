package homework;

import java.util.Scanner;
/*
 * 目的:学生の業務を管理します。
 * 作者：NGUYEN MINH NHUT
 * 終了日：2022/1/09
 * version:1.0
 */

public class Student extends Person {
	
/*1.attribute*/
	private float maths;
	private float physics;
	private float japanese;
	private float averageMark;
	private String grade;
	
	
/*2.get,set method*/
	
	public void setMaths(float maths) {
		this.maths = maths;
	}

	public void setPhysics(float physics) {
		this.physics = physics;
	}

	public void setJapanese(float japanese) {
		this.japanese = japanese;
	}
	public float getAverageMark() {
		return averageMark;
	}
	
	public String getGrade() {
		return grade;
	}
	
/*3. constructors*/

	public Student() {
		
	}
	public Student(String name, int myNumber,String  addRess, String  eMail, float maths, float physics, float japanese ) {
		super(name,myNumber,addRess,eMail);
		this.maths=maths;
		this.physics=physics;
		this.japanese=japanese;
	
	}
	
	
/*4.input, output*/
	
	private  void inputMark(Scanner scan) {
		System.out.println("1から１００までの点数を入力してください。");
		System.out.println("数学：");
		this.maths=Float.parseFloat(scan.nextLine());
		System.out.println("理学：");
		this.physics=Float.parseFloat(scan.nextLine());
		System.out.println("日本語：");
		this.japanese=Float.parseFloat(scan.nextLine());
	} 
	@Override
	public void inputData(Scanner scan) {
		super.inputData(scan);
		inputMark(scan);
		while((this.maths<0||this.maths>100)||(this.physics<0||this.physics>100)||(this.japanese<0||this.japanese>100)){
			inputMark(scan);
		}
	}
	@Override
	public void outputData() {
		super.outputData();
		System.out.println("\t数学の点数：　"+this.maths+"\t理学の点数: 　"+this.physics+"\t日本語の点数:　"+this.japanese);
			
	}
	public void averageMarkAndGrade() {
		System.out.println(	"\t平均点数:  "+this.averageMark+"\t評価:　"+this.grade);
	}
	
/*5.business method*/
	
	public void AverageMark() {
		 this.averageMark =(this.maths+ this.physics+this.japanese)/3;
		
	}
	public void gradeStudent() {
		if(this.averageMark>=90) {
			this.grade="秀";
		}
		else {
			if(this.averageMark>=80 ) {
				this.grade="優";
			}
			else {
				if(this.averageMark>=70) {
					this.grade="良";
				}
				else {
					if(this.averageMark>=60) {
						this.grade="可";
					}
					else {
						this.grade="不可";
					}
					
				}
			}
		}
	}
}
