package com.employee.service.impl;

import java.util.List;
import java.util.Objects;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.employee.exception.BadRequestException;
import com.employee.exception.ResourceNotFoundException;
import com.employee.model.dto.EmployeeDto;
import com.employee.model.entity.Employee;
import com.employee.repository.EmployeeRepository;
import com.employee.service.EmployeeService;
@Service
public class EmployeeServiceImpl  implements EmployeeService {
	

	private final EmployeeRepository employeeRepository;
	 private final ModelMapper modelMapper;
	
	public  EmployeeServiceImpl(EmployeeRepository employeeRepository , ModelMapper modelMapper) {
		this.employeeRepository = employeeRepository;
		this.modelMapper = modelMapper;
	}

	@Override
	public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
		if(employeeDto.getId()!=null) {
			throw new  RuntimeException("Employee already exists.");
		}
		Employee entity = modelMapper.map(employeeDto, Employee.class);
		Employee saveEntity = employeeRepository.save(entity);
	//	Employee saveDto = modelMapper.map(saveEntity, EmployeeDto.class);
	
		return modelMapper.map(saveEntity, EmployeeDto.class);
	}

	@Override
	public EmployeeDto updateEmployee(Long id, EmployeeDto employeeDto) {
		
		if(id == null || employeeDto.getId() == null) {
			throw new BadRequestException("Please Provide Id for employee");
		}
		if(!Objects.equals(id, employeeDto.getId())) {
			throw new BadRequestException("ID mismatch");
		}
		employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee not Found with id " + id));
		Employee entity = modelMapper.map(employeeDto, Employee.class);
		Employee updatedEmployee = employeeRepository.save(entity);
	
		 return modelMapper.map(updatedEmployee, EmployeeDto.class);
	}

	@Override
	public void deleteEmployee(Long id) {
		Employee employee = employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee not Found with id " + id));
		employeeRepository.delete(employee);
		
	}

	@Override
	public EmployeeDto getSingleEmployee(Long id) {
		Employee employee = employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee not Found with id " + id));
		return modelMapper.map(employee, EmployeeDto.class);
	}

	@Override
	public List<EmployeeDto> getAllEmployees() {
		List<Employee> employees = employeeRepository.findAll();
		if(employees.isEmpty()) {
			throw new ResourceNotFoundException("Employee not Found ");
		}
		List<EmployeeDto> dtoList = employees.stream().map(emp->modelMapper.map(emp, EmployeeDto.class)).toList();
		return dtoList;
	
	}

	@Override
	public EmployeeDto getEmployeeByEmpCodeAndCompanyName(String empCode, String companyName) {
		 Employee employee = employeeRepository.findByEmpCodeAndCompanyName(empCode, companyName).orElseThrow(() -> new ResourceNotFoundException("Employee not found with empCode: " + empCode + " and companyName: " + companyName));
	        return modelMapper.map(employee, EmployeeDto.class);
	}

}
