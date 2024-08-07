package Springboot_Exception_example;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee,Integer>
{
    List<Employee> findByName (String name);
    List<Employee> findByCity(String city);
}
