package com.EmployeePayrollApp.Service;

import java.util.List;

import com.EmployeePayrollApp.DTO.EmployeePayRollDTO;
import com.EmployeePayrollApp.Entity.EmployeePayrollEntity;

public interface EmployeePayrollService {

	public EmployeePayrollEntity createEmployeePayRollData(EmployeePayRollDTO empDTO);

	public List<EmployeePayrollEntity> getEmployeePayRollData();

	public EmployeePayrollEntity getEmployeePayRollDataById(int empId);

	public EmployeePayrollEntity updateEmployeePayRollDataById(int empId, EmployeePayRollDTO empDTO);

	public EmployeePayrollEntity deleteEmployeePayRollDataById(int empId);

}
