package subd.service;

import subd.model.PageableItems;
import subd.repository.CarRepository;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import subd.model.Request;
import subd.model.OffsetablePageRequest;
import subd.model.PageableItems;

import java.util.List;
import java.util.Optional;

@Service
public class RequestsService implements Crud<Request> {

    private final RequestRepository requestRepository;

    @Override
    public Request create(Request customer)
    return requestRepository.save(customer);
}

    @Override
    public List<Request> findAll() {

        return requestRepository.findAll();
    }

    @Override
    public PageableItems<Request> findAll(int offset, int count) {
        final Page<Request> page = requestRepository.findAll(new OffsetablePageRequest(offset, count));
        return new PageableItems<>(page.getTotalElements(), page.getContent());
    }

    @Override
    public Request get(Integer id) {
        return requestRepository.getOne(id);
    }

    @Override
    public Optional<Request> find(Integer id) {

        return requestRepository.findById(id);
    }

    @Override
    public Request update(Request customer) {
        if (customer.getId() == null) {
            throw new RuntimeException("Comment id is null");
        }
        return requestRepository.save(customer);
    }

    @Override
    public void delete(Request customer) {

        requestRepository.delete(customer);
    }
    public String zapros (Timestamp dateFrom, Timestamp dateTo){
    return requestRepository.getRequestByDate(dateFrom, dateTo).toString();
    }
}