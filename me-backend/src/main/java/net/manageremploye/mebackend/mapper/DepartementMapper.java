package net.manageremploye.mebackend.mapper;

import net.manageremploye.mebackend.dto.DepartementDto;
import net.manageremploye.mebackend.entity.departement;

public class DepartementMapper {

    //convert departement jpa entity into departement dto
    public static DepartementDto mapToDepartementDto(departement departement){
       return  new DepartementDto(
               departement.getId(),
               departement.getDepartementName(),
               departement.getDepartementDescription()
       );
    }
    //convert departement dto into deprtement jpa entity
    public static departement mapToDepartement(DepartementDto departementDto){
        return new departement(
                departementDto.getId(),
                departementDto.getDepartementName(),
                departementDto.getDepartementDescription()
        );
    }
}
