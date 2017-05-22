public class Employeer {
	private String name;
	private String department;
	private int pay;
	private String position;
	private String servicePeriod;
	
	public Employeer(String name, String department, int pay, String position, String servicePeriod) {
		this.name = name;
		this.department = department;
		this.pay = pay;
		this.position = position;
		this.servicePeriod = servicePeriod;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public int getPay() {
		return pay;
	}

	public void setPay(int pay) {
		this.pay = pay;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getServicePeriod() {
		return servicePeriod;
	}

	public void setServicePeriod(String servicePeriod) {
		this.servicePeriod = servicePeriod;
	}
	
	public String getString(){
		return "이름 : "+this.name + "\t부서 : " +this.department + "\t\t연봉 : " +this.pay + 
				"\t직급 : " +this.position + "\t\t근무기간 : " + this.servicePeriod;
	}
}
