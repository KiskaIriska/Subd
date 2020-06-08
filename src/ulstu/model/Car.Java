package ru.ulstu.model;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(indexes = {@Index(columnList = "model")})
public class Car extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer carid;
    private String model;
    private String mark;
    private String color;
    private Integer price;
    private String availability;

    @ManyToOne
    private TechnicalData technicalData;

    @Override
    public String toString() {
        return model;
    }
}