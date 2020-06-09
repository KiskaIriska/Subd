package subd.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import subd.model.Request;

@Repository
public interface RequestRepository extends JpaRepository<Request, Integer> {
    @Query("select r.requsedtid, r.date, r.sum from " +
            "request r where r.date> '2020-01-01' and r.date<'2020-06-01';")
    public List<Request> getRequestByDate();

}