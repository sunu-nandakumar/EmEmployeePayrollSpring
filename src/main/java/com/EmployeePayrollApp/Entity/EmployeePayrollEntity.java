package com.EmployeePayrollApp.Entity;
import com.EmployeePayrollApp.DTO.*;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class EmployeePayrollEntity {
	  @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private int empId;
	    private String empName;
	    private long empSalary;
	    private LocalDate createdDate;
	    private LocalDate updatedDate;

	    public EmployeePayrollEntity(EmployeePayRollDTO empDTO) {
	        this.empName=empDTO.getEmpName();
	        this.empSalary=empDTO.getEmpSalary();
	        this.createdDate=LocalDate.now();
	        this.updatedDate=LocalDate.now();
	    }

	    public EmployeePayrollEntity() {

	    }
}
