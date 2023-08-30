package net.manageremploye.mebackend.repository;
import net.manageremploye.mebackend.entity.departement;
import org.springframework.data.jpa.repository.JpaRepository;

public  interface DepartementRepository extends JpaRepository<departement,Integer> {

}