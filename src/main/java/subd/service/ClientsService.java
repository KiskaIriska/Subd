package subd.service;

import subd.model.PageableItems;
import subd.repository.CarRepository;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import subd.model.Client;
import subd.model.OffsetablePageRequest;
import subd.model.PageableItems;

import java.util.List;
import java.util.Optional;

@Service
public class ClientsService implements Crud<Client> {

    private final ClientRepository clientRepository;

    @Override
    public Client create(Client spec) {
        return ClientRepository.save(spec);
    }

    @Override
    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    @Override
    public Client get(int id) {
        return clientRepository.getOne(id);
    }

    @Override
    public Optional<Client> find(int id) {
        return clientRepository.findById(id);
    }

    @Override
    public PageItems<Client> findAll(int offset, int count) {
        Page<Client> page = clientRepository.findAll(new OffsetTablePageRequest(offset, count));
        return new PageItems<>(page.getTotalElements(), page.getContent());

    }
    @Override
    public Client update(Client spec) {
        return clientRepository.save(spec);
    }

    @Override
    public void delete(int id) {
        clientRepository.deleteById(id);
    }
}