package subd.service;

import subd.model.PageableItems;
import subd.repository.CarRepository;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import subd.model.Car;
import subd.model.OffsetablePageRequest;
import subd.model.PageableItems;

import java.util.List;
import java.util.Optional;

@Service
public class CarsService implements Crud<Car> {

    private final CarRepository carRepository;


    @Override
    public Car create(Car customer)
    return carRepository.save(customer);
    }

    @Override
    public List<Car> findAll() {

    return carRepository.findAll();
    }

    @Override
    public PageableItems<Car> findAll(int offset, int count) {
        final Page<Car> page = carRepository.findAll(new OffsetablePageRequest(offset, count));
        return new PageableItems<>(page.getTotalElements(), page.getContent());
    }

    @Override
    public Car get(Integer id) {
        return carRepository.getOne(id);
    }

    @Override
    public Optional<Car> find(Integer id) {

    return carRepository.findById(id);
    }

    @Override
    public Car update(Car customer) {
        if (customer.getId() == null) {
            throw new RuntimeException("Comment id is null");
        }
        return carRepository.save(customer);
    }

    @Override
    public void delete(Car customer) {

    carRepository.delete(customer);
    }

    public void zapros (){
        System.out.println(carRepository.getCar());
    }
}