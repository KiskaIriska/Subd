package subd.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import subd.model.Request;

@Repository
public interface RequestRepository extends JpaRepository<Request, Integer> {
    @Query("select r.requestid, r.date, r.sum from " +
            "request r where r.date> :dateFrom and r.zakazdate< :dateTo;")
    public List<Request> getRequestByDate(Timestamp dateFrom, Timestamp dateTo);

}