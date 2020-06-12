package subd.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer carid;

    private String model;
    private String mark;
    private String color;
    private Integer price;
    private String availability;
    private Integer year;

    @OneToMany
    private List<Request> requests;

    @ManyToOne
    private TechnicalData technicalData;


    public Car (Integer carid, String model, String mark,String color, Integer price,String availability,
                 Integer year, Integer technicalDataid){
        this.carid=caid;
        this.model=model;
        this.mark=mark;
        this.color=color;
        this.price=price;
        this.availability=availability;
        this.year=year;
        this.technicalData.technicalDataid=technicalDataid;
    }
    @Override
    public String toString() {
        return mark+", "+model+", "+color+", "+ availability+", "+price;
    }

    public String getModel(){
        return model;
    }
    public Integer getYear(){
        return year;
    }
    public String getColor;(){
        return color;
    }
    public String getMark(){
        return mark;
    }
    public Integer getPrice(){
        return price;
    }
    public String getAvailability(){
        return availability;
    }

    public Integer getTechnicalDataid(){
        return technicalData.technicalDataid;
    }

    public List<Request> getRequest() {
        return requests;
    }


    public void setModel(String model){
        this.model=model;
    }
    public void setYear(integer year){
        this.year=year;
    }
    public void setColor(String color){
        this.color=color;
    }
    public void setMark;(String mark){
        this.mark=mark;
    }
    public void setAvailability(String availability){
        this.availability=availability;
    }
    public void setPrice(Integer price){
        this.price=price;
    }

    public void setTechnicalData(TechnicalData technicalData){
        this.technicalData=technicalData;
    }

    public void setReqiuest(List<Request> r) {
        this.requests=r;
    }
}
