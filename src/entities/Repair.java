package entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author felixreichel
 */
@NamedQueries({
    @NamedQuery(name = "aboveSpecificSalPerHour",
                query = "SELECT r FROM Repair r WHERE r.technician.salaryPerHour > :salPerHour"),
    @NamedQuery(name = "gotSomeSpareParts",
                query = "SELECT r FROM Repair r WHERE SIZE(r.spareParts) > 2"),
    @NamedQuery(name = "smallDriveDistance",
                query = "SELECT r FROM Repair r WHERE (TYPE(r)=InHouseRepair) OR (TYPE(r)=ExternalRepair AND (TREAT(r as ExternalRepair).drivingDistance < 5))")
})
@Entity
@Table(name = "DLU_Repair")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Repair implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "REPAIR_ID")
    long id;
    
    String orderNr;
    
    String description;
    
    Integer duration;
    
    boolean warranty;
    
    @Temporal(TemporalType.DATE)
    Date repairDate;
    
    @ManyToOne(optional = false)
    Customer customer;
    
    @ManyToOne
    Technician technician;
    
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "DLU_Repair_SparePart",
            joinColumns = @JoinColumn(name = "REPAIR_ID", nullable = true),
            inverseJoinColumns = @JoinColumn(name = "SPAREPART_ID", nullable = true))
    List<SparePart> spareParts;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getOrderNr() {
        return orderNr;
    }

    public void setOrderNr(String orderNr) {
        this.orderNr = orderNr;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public boolean isWarranty() {
        return warranty;
    }

    public void setWarranty(boolean warranty) {
        this.warranty = warranty;
    }

    public Date getRepairDate() {
        return repairDate;
    }

    public void setRepairDate(Date repairDate) {
        this.repairDate = repairDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Technician getTechnician() {
        return technician;
    }

    public void setTechnician(Technician technician) {
        this.technician = technician;
    }

    public List<SparePart> getSpareParts() {
        return spareParts;
    }

    public void setSpareParts(List<SparePart> spareParts) {
        this.spareParts = spareParts;
    }

    @Override
    public String toString() {
        return "Repair{" + "id=" + id + ", orderNr=" + orderNr + ", description=" + description + ", duration=" + duration + ", warranty=" + warranty + ", repairDate=" + repairDate + ", customer=" + customer + ", technician=" + technician + ", spareParts=" + spareParts + '}';
    }
    
    
    
}
