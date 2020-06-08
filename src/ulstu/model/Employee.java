package ru.ulstu.model;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(indexes = {@Index(columnList = "fio")})
public class Employee extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer employeeid;
    private String fio;
    private String passport;
    private String address;
    private String phone;
    private String position;
    private Integer salary;

    @Override
    public String toString() {
        return fio;
    }
}