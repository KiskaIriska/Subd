package subd.service;

import subd.model.PageableItems;
import subd.repository.CarRepository;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import subd.model.TechnicalData;
import subd.model.OffsetablePageRequest;
import subd.model.PageableItems;

import java.util.List;
import java.util.Optional;

@Service
public class TechnicalDatasService implements Crud<TechnicalData> {

    private final TechnicalDataRepository technicalDataRepository;

    @Override
    public TechnicalData create(TechnicalData spec) {
        return technicalDataRepository.save(spec);
    }

    @Override
    public List<TechnicalData> findAll() {
        return technicalDataRepository.findAll();
    }

    @Override
    public TechnicalData get(int id) {
        return technicalDataRepository.getOne(id);
    }

    @Override
    public Optional<TechnicalData> find(int id) {
        return technicalDataRepository.findById(id);
    }

    @Override
    public PageItems<TechnicalData> findAll(int offset, int count) {
        Page<TechnicalData> page = technicalDataRepository.findAll(new OffsetTablePageRequest(offset, count));
        return new PageItems<>(page.getTotalElements(), page.getContent());

    }
    @Override
    public TechnicalData update(TechnicalData spec) {
        return technicalDataRepository.save(spec);
    }

    @Override
    public void delete(int id) {
        technicalDataRepository.deleteById(id);
    }
}