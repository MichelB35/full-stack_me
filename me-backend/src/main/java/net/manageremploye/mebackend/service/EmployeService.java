package net.manageremploye.mebackend.service;

import net.manageremploye.mebackend.dto.EmployeDto;
import java.util.List;

public interface EmployeService {

	
	EmployeDto  createEmployeDto(EmployeDto employeDto);

	EmployeDto  getEmployeById(int employeId);

	List<EmployeDto> getAllEmployes();

	EmployeDto updateEmple(int employeId, EmployeDto updatedEmploye);
	void deleteEmploye(int employeId);
}
