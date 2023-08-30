package net.manageremploye.mebackend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DepartementDto {
    private int id;
    private String departementName;
    private String departementDescription;
}
