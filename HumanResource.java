import java.util.ArrayList;
import java.util.Scanner;

public class HumanResource {
	static EnterpriseResourcePlaining erp = new EnterpriseResourcePlaining();
	public static void main(String[] args) {
		int select;
		do{
			System.out.println("============[직원관리 시스템]===========");
			System.out.println("[1]직원 추가 [2]직원 삭제 [3]직원 조회 [4]종료");
			select = new Scanner(System.in).nextInt();
			switch (select) {
			case 1://직원추가
				add();
				break;
			case 2://직원삭제
				delete();
				break;
			case 3://직원조회
				search();
				break;
			case 4://종료
				break;
			default:
				input_err();
				break;
			}
		}while(select!=4);
	}

	private static void delete() {
		searchAll();
		System.out.println("==============[직원 삭제]==============");
		System.out.print("삭제할 번호 입력 : ");
		int select = new Scanner(System.in).nextInt();
		if(erp.searchAll().size() != 0){
			erp.EmployeeDelete(select);
		}else{
			input_err();
		}
	}

	private static void search() {
		System.out.println("==============[직원 검색]==============");
		System.out.println("[1]이름                        [2]부서                     [3]전체");
		System.out.print("선택(숫자) : ");
		int select = new Scanner(System.in).nextInt();
		switch (select) {
		case 1:	//이름 검색
			searchName();
			break;
		case 2:	//부서
			searchDepartment();
			break;
		case 3:	//전체
			searchAll();
			break;
		default:
			input_err();
			break;
		}
	}

	private static void searchAll() {
		ArrayList<Employeer> saerch = erp.searchAll();
		employeePrint(saerch);
	}

	private static void searchDepartment() {
		System.out.println("==============[직원 검색]==============");
		System.out.print("부서 입력 >> ");
		String department = new Scanner(System.in).nextLine();
		ArrayList<Employeer> saerch = erp.searchDepartment(department);
		employeePrint(saerch);
	}

	private static void searchName() {
		System.out.println("==============[직원 검색]==============");
		System.out.print("직원 이름 입력 >> ");
		String name = new Scanner(System.in).nextLine();
		ArrayList<Employeer> saerch = erp.searchName(name);
		employeePrint(saerch);
	}
	
	private static void employeePrint(ArrayList<Employeer> employee){
		System.out.println("==============[직원 명단]==============");
		if(employee.size() == 0){
			System.out.println("등록된 사원이 없습니다.");
		}else{
			for(int i=0; i<employee.size(); i++){
				System.out.println((i+1) + ". " + employee.get(i).getString());
			}
		}
		System.out.println("=============[직원 명단 끝]=============");
	}

	private static void add() {
		System.out.println("================[추가]===============");
		System.out.print("이름 입력 >> ");
		String name = new Scanner(System.in).nextLine();
		System.out.print("부서 입력 >> ");
		String dept = new Scanner(System.in).nextLine();
		System.out.print("경력 입력(0년0개월) >> ");
		String sp = new Scanner(System.in).nextLine();
		if(erp.EmployeeAdd(name, dept, sp)){
			System.out.println("직원 추가가 완료되었습니다.");
		}
	}

	private static void input_err() {
		System.out.println("잘못 입력했습니다.");
	}
}
