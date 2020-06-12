package subd.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import subd.model.*;

import java.util.Date;
import java.util.Optional;

@Service
public class CrudService {
    private static final Logger log = LoggerFactory.getLogger(CrudService.class);
    private final static int PAGE_OF_RECORDS_SIZE = 10;

    public CarsService cr = new CarsService();
    public ClientsService cl = new ClientsService();
    public EmployeesService em =new EmployeesService();
    public RequestsService re =new RequestsService();
    public TechnicalDataService td =new TechnicalDataService();

    public void createCar(Integer carid, String model, String mark,String color, Integer price,String availability,
                         Integer year, Integer technicalDataid){
        Car car= new Car(carid, model, mark, color, price, availability, year, technicalDataid);
        cr.create(car);
        cr.findAll();
    }

    public void createClient(Integer clientid, String clientfio, String passport, String address, String phone){
        Client client=new Client(clientid, clientfio, passport, address, phone);
        cl.create(client);
        cl.findAll();
    }

    public void createEmployee(Integer employeeid, String fio, String passport, String address, String phone
    String position, Integer salary){
        Employee employee=new Employee(employeeid, fio, passport, address, phone
                position, salary);
        em.create(employee);
        em.findAll();
    }

    public void createRequest(Integer requestid, Date date, String delivery, Integer sum, Integer employeeid,
                              Integer clientid, Integer carid){
        Request request =new Request(requestid, date, delivery, sum, employeeid,
                clientid, carid);
        re.create(request);
        re.findAll();
    }

    public void createTechnicalData(Integer technicalDataid, String doorType, String bodyType, Integer seatsNumber,
                                    String engineType, String engineVolume){
        TechnicalData technicalData=new TechnicalData(technicalDataid, doorType, bodyType, seatsNumber,
               engineType, engineVolume);
        td.create(technicalData);
        td.findAll();
    }

        public void getRequestByDateZapros(Timestamp dateFrom, Timestamp dateTo){
            System.out.println("Запрос 1 ");
            System.out.println(re.zapros(dateFrom, dateTo);
        }
        public void getEmployeeByMenedzherPositionZapros(String pos){
            System.out.println("Запрос 2");
            System.out.println( em.zapros(pos));
        }
        public void getCarZapros(){
            System.out.println("Запрос 3");
            System.out.println(cr.zapros());
        }

        public void updateCar((Integer carid, String model, String mark,String color, Integer price,String availability,
                              Integer year, Integer technicalDataid){
            Car car= new Car(carid, model, mark, color, price, availability, year, technicalDataid);
            cr.update(car);
            cr.findAll();
        }
        public void updateClient(Integer clientid, String clientfio, String passport, String address, String phone){
            Client client=new Client(clientid, clientfio, passport, address, phone);
            cl.update(client);
            cl.findAll();
        }
        public void updateEmployee(Integer employeeid, String fio, String passport, String address, String phone
    String position, Integer salary){
            Employee employee=new Employee(employeeid, fio, passport, address, phone
                    position, salary);
            em.update(employee);
            em.findAll();
        }
        public void updateRequest(Integer requestid, Date date, String delivery, Integer sum, Integer employeeid,
                                  Integer clientid, Integer carid){
            Request request =new Request(requestid, date, delivery, sum, employeeid,
                    clientid, carid);
            re.update(request);
            re.findAll();
        }


        public void updateTechnicalData(Integer technicalDataid, String doorType, String bodyType, Integer seatsNumber,
                                String engineType, String engineVolume){
            TechnicalData technicalData=new TechnicalData(technicalDataid, doorType, bodyType, seatsNumber,
                    engineType, engineVolume);
            td.update(technicalData);
            td.findAll();
        }


        public void deleteCar(int id){
            cr.delete(id);
            cr.findAll();
        }
        public void deleteClient(int id){
            cl.delete(id);
            cl.findAll();
        }
        public void deleteEmployee(int id){
            em.delete(id);
            em.findAll();
        }
        public void deleteRequest(int id){
            re.delete(id);
            re.findAll();
        }
        public void deleteTechnicalData(int id){
            td.delete(id);
            td.findAll();
        }
    public void showAllCars(){
        log.info("All Cars:\n");
        log.info(cr.findAll().toString());
    }

    public void showAllClients(){
        log.info("All Clients:\n");
        log.info(cl.findAll().toString());
    }

    public void showAllEmployees(){
        log.info("All Employees:\n");
        log.info(emp.findAll().toString());
    }

    public void showAllRequests(){
        log.info("All Requests:\n");
        log.info(re.findAll().toString());
    }

    public void showAllTechnicalDates(){
        log.info("All TechnicalDates:\n");
        log.info(td.findAll().toString());
    }
                              
    private static final Logger log = LoggerFactory.getLogger(CrudService.class);

    public void showFirstPageOfRecords() {
        log.info("First page of records:\n");
        log.info(cr.findAll(0, PAGE_OF_RECORDS_SIZE).getItems().toString());
        log.info(cl.findAll(0, PAGE_OF_RECORDS_SIZE).getItems().toString());
        log.info(em.findAll(0, PAGE_OF_RECORDS_SIZE).getItems().toString());
        log.info(re.findAll(0, PAGE_OF_RECORDS_SIZE).getItems().toString());
        log.info(td.findAll(0, PAGE_OF_RECORDS_SIZE).getItems().toString());
    }

}
