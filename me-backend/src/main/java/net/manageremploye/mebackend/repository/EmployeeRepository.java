package net.manageremploye.mebackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import net.manageremploye.mebackend.entity.Employe;

public interface EmployeeRepository extends JpaRepository<Employe, Integer> {

	
}
