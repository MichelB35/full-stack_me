package net.manageremploye.mebackend.service.impl;

import lombok.AllArgsConstructor;
import net.manageremploye.mebackend.dto.DepartementDto;
import net.manageremploye.mebackend.exception.ResourceNoFoundException;
import net.manageremploye.mebackend.mapper.DepartementMapper;
import net.manageremploye.mebackend.repository.DepartementRepository;
import net.manageremploye.mebackend.entity.departement;
import net.manageremploye.mebackend.service.DepartementService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DepartementServiceImpl implements DepartementService {
   private DepartementRepository departementRepository;
    @Override
    public DepartementDto createDepartement(DepartementDto departementDto){
        departement departement = DepartementMapper.mapToDepartement(departementDto);
       departement saveDepartement =  departementRepository.save(departement);
        return DepartementMapper.mapToDepartementDto(saveDepartement);
    }

    @Override
    public DepartementDto getDepartementById(int departementId) {
       departement departement= departementRepository.findById(departementId).orElseThrow(
                ()-> new ResourceNoFoundException("Departement is not exists whith a given id:"+ departementId)
        );
        return DepartementMapper.mapToDepartementDto(departement);
    }

    @Override
    public List<DepartementDto> getAllDepartements() {
        List<departement> departemments = departementRepository.findAll();
        departemments.stream().map((departement)-> DepartementMapper.mapToDepartementDto(departement)).collect(Collectors.toList());
        return null;
    }

    @Override
    public DepartementDto updateDepartement(int departementId, DepartementDto updatedDepartement) {
        departement departement =departementRepository.findById(departementId).orElseThrow(
                ()-> new ResourceNoFoundException("Departement is not exist with id given")
        );
        departement.setDepartementName(updatedDepartement.getDepartementName());
        departement.setDepartementDescription(updatedDepartement.getDepartementDescription());
        departement saveDepartement = departementRepository.save(departement);
        return  DepartementMapper.mapToDepartementDto(saveDepartement);
    }

    @Override
    public void deleteDepartement(int departementId) {
        departement departement = departementRepository.findById(departementId).orElseThrow(
                ()-> new ResourceNoFoundException("Departement can't find with id"+ departementId)
        );
        departementRepository.deleteById(departementId);
    }


}
