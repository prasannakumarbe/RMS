package com.crg.rms;

public class Employee implements Comparable{
	int empId;
	String empName;
	String jobType;

	public Employee() {
		
	}
	public Employee(int empId, String empName,String jobType) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.jobType=jobType;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getJobType() {
		return jobType;
	}
	public void setJobType(String jobType) {
		this.jobType = jobType;
	}
	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return this.empId-((Employee)o).empId;
	}
	

}
