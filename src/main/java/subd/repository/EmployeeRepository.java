package subd.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import subd.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    @Query(" select employeefio from employee where position = pos ORDER BY id ASC;")
    public List<Employee> getEmployeeByMenedzherPosition(String pos);
}