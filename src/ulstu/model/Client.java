package ru.ulstu.model;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(indexes = {@Index(columnList = "fio")})
public class Client extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer clientid;
    private String fio;
    private String passport;
    private String address;
    private String phone;

    @Override
    public String toString() {
        return fio;
    }
}