package subd.service;

import subd.model.PageableItems;
import subd.repository.CarRepository;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import subd.model.Employee;
import subd.model.OffsetablePageRequest;
import subd.model.PageableItems;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeesService implements Crud<Employee> {

    private final EmployeeRepository employeeRepository;

    @Override
    public Employee create(Employee spec) {

        return EmployeeRepository.save(spec);
    }

    @Override
    public List<Employee> findAll() {

        return employeeRepository.findAll();
    }

    @Override
    public Employee get(int id) {

        return employeeRepository.getOne(id);
    }

    @Override
    public Optional<Employee> find(int id) {

        return employeeRepository.findById(id);
    }

    @Override
    public PageItems<Employee> findAll(int offset, int count) {
        Page<Employee> page = employeeRepository.findAll(new OffsetTablePageRequest(offset, count));
        return new PageItems<>(page.getTotalElements(), page.getContent());

    }
    @Override
    public Employee update(Client spec) {

        return employeeRepository.save(spec);
    }

    @Override
    public void delete(int id) {

        employeeRepository.deleteById(id);
    }
    public String zapros (Sting pos){
        return employeeRepository.getEmployeeByMenedzherPosition(pos).toString();
    }
}