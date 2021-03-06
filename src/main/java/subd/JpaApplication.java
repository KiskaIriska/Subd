package subd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import subd.model.*;
import subd.service.CrudService;

import java.sql.Date;
import java.sql.Timestamp;


@SpringBootApplication
public class JpaApplication {
    Timestamp start, end;
    CrudService cs= new CrudService();
    @Autowired
    public static void main(String[] args) {
        SpringApplication.run(Main.class,args);
    }
    @EventListener(ApplicationReadyEvent.class)

    public void onStart() {

        start=new Timestamp(System.currentTimeMillis());
        cs.getRequestByDateZapros(new Timestamp(1582502400), new Timestamp(1585440000));
        end=new Timestamp(System.currentTimeMillis());
        System.out.println("Время выполнения запроса: " + (end.getTime() - start.getTime()) + " мс");

        System.out.println("----------------------------------------------------------");
        start=new Timestamp(System.currentTimeMillis());
        cs.getEmployeeByMenedzherPositionZapros('menedzher');
        end=new Timestamp(System.currentTimeMillis());
        System.out.println("Время выполнения запроса: " + (end.getTime() - start.getTime()) + " мс");

        System.out.println("----------------------------------------------------------");
        start=new Timestamp(System.currentTimeMillis());
        cs.getCarZapros();
        end=new Timestamp(System.currentTimeMillis());
        System.out.println("Время выполнения запроса: " + (end.getTime() - start.getTime()) + " мс");

        crudService.showAllCars();
        crudService.showAllTechicalDates();
        crudService.showAllEmployees();
        crudService.showAllRequests();
        crudService.showAllClients();

        crudService.showFirstPageOfRecords();
    }

}