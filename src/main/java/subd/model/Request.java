package subd.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Request{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer requestid;
    private Date date;
    private String delivery;
    private Integer sum;

    @ManyToOne
    private Car car;

    @ManyToOne
    private Client Client;

    @ManyToOne
    private Employee employee;

    public Request(Integer requestid, Date date, String delivery, Integer sum, Integer employeeid,
                   Integer clientid, Integer carid){
        this.requestIdid=requestid;
        this.date=date;
        this.car.carid=carid;
        this.client.clientid=clientid;
        this.date=date;
        this.employee.employeeid=employeeid;
        this.sum=sum;
    }

    @Override
    public String toString() {
        return  contractId + ", " + zakazDate + ", " + auto.id + ", "+client.passport+", "+
                zakazPrice+", "+zakaz.id+", "+motorShow.address+"\n";
    }


    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {

        this.date = date;
    }

    public String getDelivery() {

        return delivery;
    }

    public void setDelivery(String delivery) {

        this.delivery = delivery;
    }

    public Integer getSum() {
        return sum;
    }

    public void setSum(Integer sum) {
        this.sum = sum;
    }

    public Integer getClientid(){
        return client.clientid;
    }

    public void setClient(Client client){
        this.client=client;
    }

    public Integer getEmployeeid(){
        return employee.employeeid;
    }

    public void setClient(Employee employee){
        this.employee=employee;
    }

    public Integer getCarid(){
        return car.carid;
    }
    public void setCar(car car){
        this.car=car;
    }

}