package com.EmployeePayrollApp.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.EmployeePayrollApp.DTO.EmployeePayRollDTO;
import com.EmployeePayrollApp.DTO.ResponseDTO;
import com.EmployeePayrollApp.Entity.EmployeePayrollEntity;
import com.EmployeePayrollApp.Service.EmployeePayrollService;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@RestController
public class EmployeePayrollController {
	 @Autowired
	    EmployeePayrollService empPayRollService;



	    @PostMapping("/create")
	    public ResponseEntity<ResponseDTO> createEmployeePayRollData(@RequestBody EmployeePayRollDTO empDTO) {
		    EmployeePayrollEntity employeeData = empPayRollService.createEmployeePayRollData(empDTO);
	        ResponseDTO responseDTO = new ResponseDTO("Created Employee Payroll Data Successfully!", employeeData);
	        log.info("Inside CreateEmployeePayRollData of EmpPayRollController");
	        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
	    }
	    @GetMapping(value = {"/get"})
	    public ResponseEntity<ResponseDTO> getEmployeePayRollData() {
	        log.info("Inside getEmployeePayrollData of EmpPayRollControl");
	        List<EmployeePayrollEntity> employeeDataList = empPayRollService.getEmployeePayRollData();
	        ResponseDTO responseDTO = new ResponseDTO("Retrieved Data Successfully!", employeeDataList);
	        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
	    }
	    @GetMapping("/getById/{empId}")
	    public ResponseEntity<ResponseDTO> getEmployeePayRollDataByID(@PathVariable("empId") int empId) {
	        log.info("Inside getEmployeePayRollData() Method of the Class EmpPayRollController");
	        EmployeePayrollEntity employeeData = empPayRollService.getEmployeePayRollDataById(empId);
	        ResponseDTO responseDTO = new ResponseDTO("Employee Data Fetched Successfully By Using Id", employeeData);
	        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
	    }
	    @PutMapping("/update/{empId}")
	    public ResponseEntity<ResponseDTO> updateEmployeePayRollDataById(@PathVariable("empId") int empId,
	                                                               @RequestBody EmployeePayRollDTO empDTO) {
	        log.info("Inside updateEmployeePayRollDataById() Method of the EmpPayRollController");
	        EmployeePayrollEntity employeeData = empPayRollService.updateEmployeePayRollDataById(empId, empDTO);
	        ResponseDTO responseDTO = new ResponseDTO("Employee Data Updated Successfully!!", employeeData);
	        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
	    }

	    /**
	     * Purpose: Ability to delete the existing employee data.
	     * @param empId;
	     * @return deleted.
	     */
	    @DeleteMapping("/delete/{empId}")
	    public ResponseEntity<ResponseDTO> deleteEmployeePayRollDataById(@PathVariable("empId") int empId) {
	        log.info("Inside deleteEmployeePayRollDatById() Method of the EmpPayRollController");
	        EmployeePayrollEntity employeeData = empPayRollService.deleteEmployeePayRollDataById(empId);
	        ResponseDTO responseDTO = new ResponseDTO("Deleted Successfully!!", employeeData);
	        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
	    }

}
