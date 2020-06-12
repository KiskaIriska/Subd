package subd.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Employee{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer employeeid;
    private String fio;
    private String passport;
    private String address;
    private String phone;
    private String position;
    private Integer salary;

    @OneToMany
    private List<Request> requests;

    public Employee(Integer employeeid, String fio, String passport, String address, String phone
    String position, Integer salary){
        this.employeeid = employeeid;
        this.clientfio = clientfio;
        this.passport = passport;
        this.address = address;
        this.phone = phone;
        this.position = position;
        this.salary = salary;
    }

    public String toString() {
        return fio + ", "+ position + ", " + passport + ", "+ address + ", "
                + phone + ", " +  salary;
    }

    public String getFio(){
        return fio;
    }
    public String getPhone(){
        return  phone;
    }
    public String getPassport() {
        return  pasport;
    }
    public String getAddress() {
        return  address;
    }
    public Integer getSalary() {
        return  salary;
    }

    public String getPosition() {
        return  position;
    }
    public List<Request> getRequest() {
        return requests;
    }

    public void setFio(String fio){
        this.fio = fio;
    }

    public void setPhone(String phone){
        this.phone=phone;
    }

    public void setPassport(String passport){
        this.passport = passport;
    }
    public void setAddress(String address){
        this.address = address;
    }

    public void setPosition(String position){
        this.position = position;
    }

    public void setRequest(List<Request> r) {
        this.requests=r;
    }
}