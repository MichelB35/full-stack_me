package net.manageremploye.mebackend.controller;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.AllArgsConstructor;
import net.manageremploye.mebackend.dto.EmployeDto;
import net.manageremploye.mebackend.service.EmployeService;
import net.manageremploye.mebackend.service.impl.EmployeServiceImplement;
import java.util.List;


@CrossOrigin(origins="http://localhost:3000/")
@AllArgsConstructor
@RestController
@RequestMapping("/api/employe")
public class EmployeController {
	
	private EmployeService employeService =  new EmployeService() {
		
		@Override
		public EmployeDto getEmployeById(int employeId) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public EmployeDto createEmployeDto(EmployeDto employeDto) {
			// TODO Auto-generated method stub
			return employeDto ;
		}
		@Override
		public List<EmployeDto> getAllEmployes(){
			return null;
		}
		@Override
		public EmployeDto  updateEmple (int employeId, EmployeDto updatedEmploye){

			return  null;
		}

		@Override
		public void deleteEmploye(int employeId){

		}
	}
	;
	
	
	//Built Add Employe Rest API
	@PostMapping 
	public ResponseEntity<EmployeDto> createEmploye(@RequestBody EmployeDto employeDto){

		
		EmployeDto savedEmploye = employeService.createEmployeDto(employeDto);
		
		
		return new ResponseEntity<>(savedEmploye, HttpStatus.CREATED);
		 
	}
	//Build Get Employe Rest API
	@GetMapping("{id}")
	public ResponseEntity<EmployeDto> getEmployeById(@PathVariable("id") int employeId){
		EmployeDto employeDto = employeService.getEmployeById(employeId);
		return ResponseEntity.ok(employeDto);
	}


	//build Get All Employe Rest APi
	@GetMapping
	public ResponseEntity <List<EmployeDto>> getAllEmployes() {
		List<EmployeDto> employes = employeService.getAllEmployes();
		return ResponseEntity.ok(employes);
	}

	//Build Update Employe RST API
	@PutMapping("{id}")
	public ResponseEntity <EmployeDto> updateEmploye(@PathVariable("id") int employeId, @RequestBody EmployeDto updatedEmploye){
		EmployeDto employeDto = employeService.updateEmple(employeId,updatedEmploye);
		return  ResponseEntity.ok(employeDto);
	}

	// Build delete employe RST Api
	@DeleteMapping({"{id}"})
	public ResponseEntity<String> deleteEmploye(@PathVariable("id") int employeId){
		employeService.deleteEmploye(employeId);
		return ResponseEntity.ok("Employe delete successfully");
	}

}
