package com.EmployeePayrollApp.Repository;

import com.EmployeePayrollApp.Entity.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeePayrollRepository extends JpaRepository<EmployeePayrollEntity ,Integer> {

}
