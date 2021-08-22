package com.EmployeePayrollApp.Service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Service;

import com.EmployeePayrollApp.DTO.EmployeePayRollDTO;
import com.EmployeePayrollApp.Entity.EmployeePayrollEntity;
import com.EmployeePayrollApp.Repository.EmployeePayrollRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EmployeePayrollServiceImpl implements EmployeePayrollService {
	@Autowired
	EmployeePayrollRepository repository;

	@Override
	public EmployeePayrollEntity createEmployeePayRollData(EmployeePayRollDTO empDTO) {
		log.info("Inside CreateEmployeePayRollData() Method of the EmpPayRollService");
		EmployeePayrollEntity employeeData = new EmployeePayrollEntity(empDTO);
		return repository.save(employeeData);
	}

	@Override
	public List<EmployeePayrollEntity> getEmployeePayRollData() {
		 log.info("Inside getEmployeePayRollData() Method of the EmpPayRollService");
	        return repository.findAll();
	}

	@Override
	public EmployeePayrollEntity getEmployeePayRollDataById(int empId) {
		 log.info("Inside getEmployeePayRollDataById() Method of the EmpPayRollService Class!");
	        return repository.findById(empId).get();
	}

	@Override
	public EmployeePayrollEntity updateEmployeePayRollDataById(int empId, EmployeePayRollDTO empDTO) {
		log.info("Inside UpdateEmployeePayrollDataById() Method of EmpPayRollService Class");
        EmployeePayrollEntity employeeData = repository.findById(empId).get();

        if (Objects.nonNull(empDTO.getEmpName()) &&
                !"".equalsIgnoreCase(empDTO.getEmpName())) {
            employeeData.setEmpName(empDTO.getEmpName());
        }
        employeeData.setEmpSalary(empDTO.getEmpSalary());
        return repository.save(employeeData);
	}

	@Override
	public EmployeePayrollEntity deleteEmployeePayRollDataById(int empId) {
		 log.info("Inside deleteEmployeePayRollDataById() Method of the EmpPayRollService Class");
	        repository.deleteById(empId);
	        return null;
	}

}
