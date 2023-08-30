package net.manageremploye.mebackend.service;

import net.manageremploye.mebackend.dto.DepartementDto;

import java.util.List;

public interface DepartementService   {
    DepartementDto createDepartement(DepartementDto departementDto);
    DepartementDto getDepartementById(int departementId);
    List<DepartementDto> getAllDepartements();
    DepartementDto updateDepartement(int departementId,DepartementDto updatedDepartement);

    void deleteDepartement(int departementId);
}
