package net.manageremploye.mebackend.controller;

import lombok.AllArgsConstructor;
import net.manageremploye.mebackend.dto.DepartementDto;
import net.manageremploye.mebackend.service.DepartementService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/departements")
public class DepartementController {

    private DepartementService departementService;

    //build Add Departement Rest Api
    @PostMapping
    public ResponseEntity<DepartementDto> createDepartement(@RequestBody  DepartementDto departementDto){
        DepartementDto departement =  departementService.createDepartement(departementDto);
        return new ResponseEntity<>(departement, HttpStatus.CREATED);
    }
    //BUILD DEPARTEMENT BY ID
    @GetMapping("{id}")
    public ResponseEntity<DepartementDto> getDepartementByid(@PathVariable("id") int departementId){
        DepartementDto departementDto =departementService.getDepartementById(departementId);
        return  ResponseEntity.ok(departementDto);
    }

    //build get all Depratement
    @GetMapping
    public ResponseEntity<List<DepartementDto>> getAllDepartements(){
        List<DepartementDto>departements= departementService.getAllDepartements();
        return  ResponseEntity.ok(departements);
    }


    // Build update Departement
    @PutMapping("{id}")
    public ResponseEntity<DepartementDto> updateDepartement (@PathVariable("id") int departementId,@RequestBody DepartementDto updateDepartement){
        DepartementDto departementDto = departementService.updateDepartement(departementId,updateDepartement);
        return  ResponseEntity.ok(departementDto);
    }

    @DeleteMapping("{id}")
    public  ResponseEntity<String> removeDepartement (@PathVariable("id") int departementId){
        departementService.deleteDepartement(departementId);
        return ResponseEntity.ok("Departement is remove sucessesfull");
    }
}
