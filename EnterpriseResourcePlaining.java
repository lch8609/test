import java.util.ArrayList;

public class EnterpriseResourcePlaining {
	ArrayList<Employeer> emp;
	public EnterpriseResourcePlaining(){
		emp = new ArrayList<Employeer>();
	}
	
	
	//직원 정보 호출
	public String getEmployeer(int select){
		return emp.get(select-1).toString();
	}

	
	//직원 등록
	public boolean EmployeeAdd(String name, String department, String servicePeriod) {
		int pay = getSalary(convertServicePeriodToMonth(servicePeriod));
		String position = getPosition(convertServicePeriodToMonth(servicePeriod));
		emp.add(new Employeer(name, department, pay, position, servicePeriod));
		return true;
	}
	//직원 삭제
	public boolean EmployeeDelete(int select){
		if(emp.size() > 0){
			emp.remove(select-1);
			return true;
		}else{
			return false;
		}
	}
	
	//경력에 따른 연봉 계산
	private int getSalary(int servicePeriod){
		int salary=0;
		String position = getPosition(servicePeriod);
		//직책 수당
		if(position.equals("부장")){
			salary += 7000;
		}else if(position.equals("차장")){
			salary += 5000;
		}else if(position.equals("과장")){
			salary += 4000;
		}else if(position.equals("대리")){
			salary += 3500;
		}else if(position.equals("주임")){
			salary += 2800;
		}else if(position.equals("사원")){
			salary += 2400;
		}
		//경력에 대한 연봉 책정
		salary += ((servicePeriod/12)*100);
		return salary;
	}
	
	//경력에 따른 직급을 알려줌
	private String getPosition(int servicePeriod){
		String position;
		if((servicePeriod/12) >= 15){
			position = "부장";
		}else if((servicePeriod/12) >= 12){
			position = "차장";
		}else if((servicePeriod/12) >= 8){
			position = "과장";
		}else if((servicePeriod/12) >= 5){
			position = "대리";
		}else if((servicePeriod/12) >= 2){
			position = "주임";
		}else{
			position = "사원";
		}
		return position;
	}
	//문자열 00년00개월  -> 숫자 00개월수로 반환.
	private int convertServicePeriodToMonth(String servicePeriod){
		String strYear, strMonth;
		strYear = servicePeriod.split("년")[0];
		strMonth = (servicePeriod.split("년")[1]).split("개")[0];
		return ((Integer.parseInt(strYear))*12)+(Integer.parseInt(strMonth));
	}

	
	//이름 검색
	public ArrayList<Employeer> searchName(String name) {
		ArrayList<Employeer> search = new ArrayList<Employeer>();
		for(int i=0; i<emp.size(); i++){
			if(emp.get(i).getName().contains(name)){
				search.add(emp.get(i));
			}
		}
		return search;
	}

	//부서 검색
	public ArrayList<Employeer> searchDepartment(String department) {
		ArrayList<Employeer> search = new ArrayList<Employeer>();
		for(int i=0; i<emp.size(); i++){
			if(emp.get(i).getDepartment().contains(department)){
				search.add(emp.get(i));
			}
		}
		return search;
	}


	public ArrayList<Employeer> searchAll() {
		return emp;
	}
}
