package entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author felixreichel
 */

@Entity
@Table(name = "DLU_Technician")
public class Technician implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "TECHNICIAN_ID")
    long id;
    
    String firstName;
    
    String lastName;
    
    Integer salaryPerHour;
    
    @OneToMany(mappedBy = "technician", targetEntity = Repair.class)
    List<Repair> repairs;

    public Technician() {
    }

    public Technician(String firstName, String lastName, Integer salaryPerHour) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salaryPerHour = salaryPerHour;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getSalaryPerHour() {
        return salaryPerHour;
    }

    public void setSalaryPerHour(Integer salaryPerHour) {
        this.salaryPerHour = salaryPerHour;
    }

    public List<Repair> getRepairs() {
        return repairs;
    }

    public void setRepairs(List<Repair> repairs) {
        this.repairs = repairs;
    }
    
    
    
}
