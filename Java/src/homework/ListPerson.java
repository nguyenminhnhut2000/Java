package homework;
import java.util.ArrayList;
/*
 * 目的：プログラムの業務を処理します。
 * 作者：NGUYEN MINH NHUT
 * 終了日：2022/1/09
 * version:1.0
 */
import java.util.Scanner;

public class ListPerson {

	/* 1.attribute */
	private ArrayList<Person> list;
	private float bonusEmployee;
	private float salaryEmployee;

	/* 2.get,set method */
	public ArrayList<Person> getList() {
		return list;
	}

	/* 3.constructors */

	public ListPerson() {
		this.list = new ArrayList<Person>();
	}

	/* 4.business method */
/*TEST DATA*/
public void testData(){
	Person person1 = new Person();
	person1 = new Student("kihon",1,"a1","kihon@gmail",70,80,90);
	this.list.add(person1);
	person1 = new Student("ouyou",2,"a2","ouyou@gmail",100,40,30);
	this.list.add(person1);
	person1 = new Student("koudoST",3,"a3","koudoST@gmail",60,80,100);
	this.list.add(person1);
	person1 = new Student("koudoPM",4,"a4","koudoPM@gmail",10,30,90);
	this.list.add(person1);

	person1 = new Employee("c++",5,"b1","c++@gmail",150);
	this.list.add(person1);
	person1 = new Employee("java",6,"b1","java@gmail",200);
	this.list.add(person1);
	person1 = new Employee("python",7,"b1","python@gmail",250);
	this.list.add(person1);

	person1= new Customer("html",11,"c1","html@gmail","WEB-design-Company",12300);
	this.list.add(person1);
	person1= new Customer("css",12,"c2","css@gmail","WEB-design-Company",5200);
	this.list.add(person1);
	person1= new Customer("js",13,"c3","js@gmail","WEB-design-Company",1200);
	this.list.add(person1);
	
}
/*人を追加します。*/
	private void inMenu() {
		System.out.println("メニューに従って選んでください。");
		System.out.println("1.お客様を追加します。");
		System.out.println("2.社員を追加します。");
		System.out.println("3.学生を追加します。");
		System.out.println("4.終わります。");
	}

	public void inputData(Scanner scan) {
		boolean flag = true;
		do {
			Person perSon;
			inMenu();
			System.out.println("どうぞ>>");
			int select = Integer.parseInt(scan.nextLine());
			switch (select) {
			case 1:
				perSon = new Customer();
				perSon.inputData(scan);
				this.list.add(perSon);
				break;
			case 2:
				perSon = new Employee();
				perSon.inputData(scan);
				this.list.add(perSon);
				break;
			case 3:
				perSon = new Student();
				perSon.inputData(scan);
				this.list.add(perSon);
				break;
			case 4:
				flag = false;
				break;
			default:
				System.out.println("1から4まで　正しく選んでください。");
			}

		} while (flag);
	}
/*出力します。*/
	public void outputData() {
		for (Person perSon : this.list) {
			perSon.outputData();
		}
	}


/*削除します。*/
	public boolean deleteMyNumber(int deleteNumber) {
		boolean deleted = false;
		for (Person perSon : this.list) {
			if (perSon.getMyNumber() == deleteNumber) {
				this.list.remove(perSon);
				deleted = true;
				break;
			}
		}
		return deleted;
	}
	
/*名前を探します。*/
	public Person searchName(String name) {
		Person currentName=null;/*探しています。*/
		for(Person perSon: this.list) {
			if(perSon.getName().compareTo(name)==0) {
			currentName=perSon;
			
				
			}
		}
		return currentName;
	}

/*平均点数を求めて判断します。*/
	public void averageMarkAndGrade() {
		for (Person perSon : this.list) {
			if (perSon instanceof Student) {
				((Student) perSon).AverageMark();
				((Student) perSon).gradeStudent();
				perSon.outputData();
				((Student)perSon).averageMarkAndGrade();
			}
		}
	}

/*一番高い平均点数を得点する人を探します。*/

	public ArrayList<Person> listMaxMark(){
		ArrayList<Person> listMaxMark= new ArrayList<Person>();
		Student studentMaxMark= null;
		int indexMax=0;/*リストの0の位置からスタートします。*/
		for(Person perSon: this.list) {
			indexMax++;
			if(perSon instanceof Student) {
				studentMaxMark=(Student)perSon;
			break;
			}
			}
		
		if(studentMaxMark!=null) {
		 for(int i= indexMax-1;i<this.list.size();i++) {
			 Person current =this.list.get(i);
			 if(current instanceof Student ) {
				 if(((Student)current).getAverageMark()>studentMaxMark.getAverageMark()) {
					 studentMaxMark=(Student)current;
				 }
			 }
			
		 }
		}
		for(int i= indexMax-1;i<this.list.size();i++) {
			Person current = this.list.get(i);
			if(current instanceof Student) {
				if(((Student)current).getAverageMark()==studentMaxMark.getAverageMark()) {
					listMaxMark.add(current);
				}
			}
		}		
		
		return listMaxMark;
	}
	public void outputListMaxMark(ArrayList<Person> listMax){
		for(Person student: listMax ){
			student.outputData();
			((Student) student).averageMarkAndGrade();
		}
	}

	/*4.給料を計算します。*/

	
	private void Salary() {
		for (Person perSon : this.list) {
			if (perSon instanceof Employee) {
				((Employee) perSon).Salary();
			}
		}
	}
	private void bonusValueOrder(){
		bonusEmployee=0;
		for (Person perSon :this.list ){
			if(perSon instanceof Customer){
				if(((Customer) perSon).getValueOrder()>10000){
					bonusEmployee +=(((Customer) perSon).getValueOrder()*5)/100;
				}
				else{
					if(((Customer)perSon).getValueOrder()>=5000){
						bonusEmployee +=(((Customer) perSon).getValueOrder()*2)/100;
					}
				}
			}
		}
	}
	public void salaryEmployee(){
		Salary();
		bonusValueOrder();
		for(Person perSon: this.list){
			if(perSon instanceof Employee){
			salaryEmployee=((Employee)perSon).getSarary()+ bonusEmployee;
			((Employee)perSon).outputData();
		System.out.println("\t給料:　"+ salaryEmployee);
			}

		}
	}
	

	

	




}
