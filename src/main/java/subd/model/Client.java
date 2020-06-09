package subd.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Client  {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer clientid;

    private String clientfio;
    private String passport;
    private String address;
    private String phone;

    @OneToMany
    private List<Request> requests;

    public Client (Integer clientid, String clientfio, String passport, String address, String phone){
        this.clientid = clientid;
        this.clientfio = clientfio;
        this.passport = passport;
        this.address = address;
        this.phone = phone;
    }
    public String toString() {
        return clientfio + ", "+ passport + ", " + address + ", "
                + phone+"\n";
    }
    public String getClientfio(){
        return clientfio;
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

    public List<Request> getRequest() {
        return requests;
    }

    public void setClientfio(String clientfio){
        this.clientfio = clientfio;
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

    public void setRequest(List<Request> r) {
        this.requests=r;
    }
}