package entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;

@Entity
public class InHouseRepair extends Repair implements Serializable {
    
    String officeName;

    public InHouseRepair() {
    }

    public InHouseRepair(String officeName) {
        this.officeName = officeName;
    }

    public String getOfficeName() {
        return officeName;
    }

    public void setOfficeName(String officeName) {
        this.officeName = officeName;
    }

    @Override public long getId() {
        return id;
    }

    @Override public void setId(long id) {
        this.id = id;
    }

    @Override public String getOrderNr() {
        return orderNr;
    }

    @Override public void setOrderNr(String orderNr) {
        this.orderNr = orderNr;
    }

    @Override public String getDescription() {
        return description;
    }

    @Override public void setDescription(String description) {
        this.description = description;
    }

    @Override public Integer getDuration() {
        return duration;
    }

    @Override public void setDuration(Integer duration) {
        this.duration = duration;
    }

    @Override public boolean isWarranty() {
        return warranty;
    }

    @Override public void setWarranty(boolean warranty) {
        this.warranty = warranty;
    }

    @Override public Date getRepairDate() {
        return repairDate;
    }

    @Override public void setRepairDate(Date repairDate) {
        this.repairDate = repairDate;
    }

    @Override public Customer getCustomer() {
        return customer;
    }

    @Override public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override public Technician getTechnician() {
        return technician;
    }

    @Override public void setTechnician(Technician technician) {
        this.technician = technician;
    }

    @Override public List<SparePart> getSpareParts() {
        return spareParts;
    }

    @Override public void setSpareParts(List<SparePart> spareParts) {
        this.spareParts = spareParts;
    }

    
    
    
}
