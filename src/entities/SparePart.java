package entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author felixreichel
 */
@Entity
@Table(name = "DLU_SparePart")
public class SparePart implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "SPAREPART_ID")
    long id;
    
    String name;
    
    Integer price;
    
    @ManyToMany(mappedBy = "spareParts")
    List<Repair> repairs;

    public SparePart() {
    }

    public SparePart(String name, Integer price) {
        this.name = name;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public List<Repair> getRepairs() {
        return repairs;
    }

    public void setRepairs(List<Repair> repairs) {
        this.repairs = repairs;
    }
    
    
    
    
}
