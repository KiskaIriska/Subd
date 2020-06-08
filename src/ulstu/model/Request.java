package ru.ulstu.model;
import javax.persistence.*;
import java.util.Date;

@Entity
public class Request extends BaseEntity {
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

}