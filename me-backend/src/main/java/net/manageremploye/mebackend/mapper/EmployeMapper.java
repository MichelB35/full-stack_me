package net.manageremploye.mebackend.mapper;

import net.manageremploye.mebackend.dto.EmployeDto;
import net.manageremploye.mebackend.entity.Employe;

public class EmployeMapper {

	public static EmployeDto mapToEmployeDto(Employe employe) {
		
		
		return new  EmployeDto(
				employe.getId(),
				employe.getFirstName(),
				employe.getLastName(),
				employe.getEmail()
				
				);
	}
	
	
	public static Employe mapToEmploye(EmployeDto employeDto) {
		
		return new Employe(
				employeDto.getId(),
				employeDto.getFirstName(),
				employeDto.getLastName(),
				employeDto.getEmail()
				);
	}
	
}
