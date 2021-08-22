package com.EmployeePayrollApp.DTO;
import com.EmployeePayrollApp.Entity.*;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor

public class ResponseDTO {
	private String message;
    private Object data;
}
