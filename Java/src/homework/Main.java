package homework;

import java.util.ArrayList;
import java.util.Scanner;
/*
 * 目的：プログラムの業務を管理します。
 * 作者：NGUYEN MINH NHUT
 * 終了日：2022/1/09
 * version:1.0
 */


public class Main {

	public static void main(String[] args) {
		ListPerson person = new ListPerson();
		Scanner scan = new Scanner(System.in);
		person.testData();
		doMenu(scan, person);

	}

	private static void inMenu() {
		System.out.println("1.テストデータを出力します。");
		System.out.println("2.人を追加します。");
		System.out.println("3.名前を探します。");
		System.out.println("4.個人番号(MyNumber)で削除します。");
		System.out.println("5.平均点数を探して評価基準で判断してから出力します。");
		System.out.println("6.一番高い平均点数を得点する人を出力します。（　先に平均点数を探すのが必要です。）");
		System.out.println("7.社員の給料を出力します。");
		System.out.println("8.終わります。");

	}

	private static void doMenu(Scanner scan, ListPerson person) {
		boolean flag = true;

		do {
			inMenu();
			System.out.println("　どうぞ　1から8まで　正しく入力してください");
			int select = Integer.parseInt(scan.nextLine());
			switch (select) {

			case 1:
				person.outputData();
				break;
			case 2:
				person.inputData(scan);
				break;
			case 3:
				System.out.println("探したい名前を入力してください。");
				String name = scan.nextLine();
				Person SearchName = person.searchName(name);
				if (SearchName != null) {
					SearchName.outputData();
				} else {
					System.out.println("入力した名前は存在しませんでした。");
				}
				break;
			case 4:

				System.out.println("削除したい個人番号を入力してください ");
				int deleteNumber = Integer.parseInt(scan.nextLine());
				boolean deleted = person.deleteMyNumber(deleteNumber);
				if (deleted) {
					System.out.println("削除しました。");
				} else {
					System.out.println("この個人番号は存在しませんでした。");
				}
				break;
			case 5:
				person.averageMarkAndGrade();
				break;
			case 6:
				ArrayList<Person> listMax = person.listMaxMark();
				person.outputListMaxMark(listMax);
				break;
			case 7:
				person.salaryEmployee();
				break;

			case 8:
				flag = false;
				break;
			default:
				System.out.println("もう一度入力してください。");

			}
		} while (flag);
	}

}
