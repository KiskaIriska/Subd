package subd.model;
import javax.persistence.*;
import java.util.Date;

@Entity
public class TechnicalData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer technicalDataid;

    private String doorType;
    private String bodyType;
    private Integer seatsNumber;
    private String engineType;
    private String engineVolume;

    @OneToMany
    private List<Car> cars;

    public TechnicalData (Integer technicalDataid, String doorType, String bodyType, Integer seatsNumber,
                          String engineType, String engineVolume){
        this.technicalDataid=technicalDataid;
        this.doorType=doorType;
        this.bodyType=bodyType;
        this.seatsNumber=seatsNumber;
        this.engineType=engineType;
        this.engineVolume=engineVolume;
    }

    public String toString() {
        return doorType + ", "+ bodyType + ", "
                + engineType;
    }

    public String getDoorType() {
        return doorType;
    }

    public void setDoorType(String doorType) {

        this.doorType = doorType;
    }

    public String getBodyType() {

        return bodyType;
    }

    public void setBodyType(String bodyType) {

        this.bodyType = bodyType;
    }

    public String getEngineType() {

        return engineType;
    }

    public void setEngineType(String engineType)
    {
        this.engineType = engineType;
    }

    public String getEngineVolume() {

        return engineVolume;
    }

    public void setEngineVolume(String engineVolume) {

        this.engineVolume = engineVolume;
    }

    public Integer getSeatsNumber() {

        return seatsNumber;
    }

    public void setSeatsNumber(Integer seatsNumber) {

        this.seatsNumber = seatsNumber;
    }


    public List<Car> getCars() {

        return cars;
    }
    public void setCar(List<Car> r) {
        this.cars=r;
    }

}