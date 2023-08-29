package net.manageremploye.mebackend.service.impl;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import net.manageremploye.mebackend.dto.EmployeDto;
import net.manageremploye.mebackend.entity.Employe;
import net.manageremploye.mebackend.exception.ResourceNoFoundException;
import net.manageremploye.mebackend.mapper.EmployeMapper;
import net.manageremploye.mebackend.repository.EmployeeRepository;
import net.manageremploye.mebackend.service.EmployeService;
import java.util.List;

@Service
@AllArgsConstructor
public class EmployeServiceImplement implements EmployeService {

	private EmployeeRepository employeRepository;
	@Override
	public EmployeDto createEmployeDto(EmployeDto employeDto) {
		
		Employe employe = EmployeMapper.mapToEmploye(employeDto);
		Employe svedEmploye = employeRepository.save(employe);
		return EmployeMapper.mapToEmployeDto(svedEmploye);
	}
	@Override
	public EmployeDto getEmployeById(int employeId) {
		Employe emplye = employeRepository.findById(employeId)
		.orElseThrow(()-> new ResourceNoFoundException("Employe is not exist with given id:"+employeId));
		return  EmployeMapper.mapToEmployeDto(emplye);
	}
	@Override
	public List<EmployeDto> getAllEmployes(){
		List<Employe> employes =  employeRepository.findAll();
		return employes.stream().map((employe)->EmployeMapper.mapToEmployeDto(employe)).collect(java.util.stream.Collectors.toList());

	}

	public EmployeDto updateEmple (int employeId, EmployeDto updatedEmploye){
		Employe  employe =employeRepository.findById(employeId).orElseThrow(()-> new ResourceNoFoundException("Employe is not exist"));
		employe.setFirstName(updatedEmploye.getFirstName());
		employe.setLastName(updatedEmploye.getLastName());
		employe.setEmail(updatedEmploye.getEmail());

		Employe updateEmplyeObj = employeRepository.save(employe);
		return EmployeMapper.mapToEmployeDto(updateEmplyeObj);

	}

	@Override
	public void deleteEmploye(int employeId){
		Employe employe = employeRepository.findById(employeId).orElseThrow(()-> new ResourceNoFoundException("Employe not existe with given id:"+ employeId));
				employeRepository.deleteById(employeId);
	}



	

}
