package entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author felixreichel
 */

@Entity
@Table(name = "DLU_Customer")
public class Customer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) 
    @Column(name = "CUSTOMER_ID")
    long id;
    
    String firstName;
    
    String lastName;
    
    String addresse;
    
    @OneToMany(mappedBy = "customer", fetch = FetchType.EAGER)
    List<Repair> repairs;

    public Customer() {
    }

    public Customer(String firstName, String lastName, String addresse) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.addresse = addresse;
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

    public String getAddresse() {
        return addresse;
    }

    public void setAddresse(String addresse) {
        this.addresse = addresse;
    }

    public List<Repair> getRepairs() {
        return repairs;
    }

    public void setRepairs(List<Repair> repairs) {
        this.repairs = repairs;
    }
    
    
         
}
