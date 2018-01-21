package dienstleistungsunternehmen;

import entities.*;
import java.util.*;
import javax.persistence.*;

public class Dienstleistungsunternehmen {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DienstleistungsunternehmenPU");
        EntityManager em = emf.createEntityManager();
        
        //2 Technician: einen Lehrling mit salaryPerHour = 10, sowie eine Meister mit salaryPerHour = 25
        Technician lehrling = new Technician("Florian", "Höllmüller", 10);
        Technician master = new Technician("Peter", "Bauer", 25);
        
        // 2 Customer
        Customer customer1 = new Customer("Max", "Muster", "Holzweg 7");
        Customer customer2 = new Customer("Katze", "Peter", "Mond 99");
        
        //4 SparePart , welche den Reparaturaufträgen zugeordnet sein sollen (price: 2, 5, 12, 25)
        SparePart sp1 = new SparePart("Fenser", 60);
        SparePart sp2 = new SparePart("Tischfußballtisch", 20);
        SparePart sp3 = new SparePart("Rohr", 400);
        SparePart sp4 = new SparePart("Kärcher", 10);
        
        //Jeweils einen Reparaturauftrag InHouseRepair, sowie zwei Reparaturaufträge
        //ExternalRepair
        InHouseRepair inhr1 = new InHouseRepair("Fensteraustausch");
        inhr1.setCustomer(customer1);
        inhr1.setDescription("Fenster eingeschlagen");
        inhr1.setDuration(5);
        inhr1.setOrderNr("1");
        inhr1.setRepairDate(new Date());
        inhr1.setWarranty(true);
        inhr1.setTechnician(lehrling);
        List<SparePart> l1 = new ArrayList<>();
        l1.add(sp1);
        inhr1.setSpareParts(l1);
        
        InHouseRepair inhr2 = new InHouseRepair("Tischfußballtisch");
        inhr2.setCustomer(customer2);
        inhr2.setDescription("Tischfußballtisch kaputt!");
        inhr2.setDuration(5);
        inhr2.setOrderNr("2");
        inhr2.setRepairDate(new Date());
        inhr2.setWarranty(false);
        List<SparePart> l2 = new ArrayList<>();
        l2.add(sp2);
        inhr2.setSpareParts(l2);
        
        ExternalRepair exr1 = new ExternalRepair(25, "S-SO-WS");
        exr1.setCustomer(customer1);
        exr1.setDescription("Rohrbruch im Bad");
        exr1.setDuration(60);
        exr1.setOrderNr("3");
        exr1.setRepairDate(new Date());
        exr1.setWarranty(false);
        List<SparePart> l3 = new ArrayList<>();
        l3.add(sp3);
        exr1.setSpareParts(l3);
        
        ExternalRepair exr2 = new ExternalRepair(19, "O-WS-SS");
        exr2.setCustomer(customer2);
        exr2.setTechnician(master);
        exr2.setDescription("Kärcher defekt");
        exr2.setDuration(40);
        exr2.setOrderNr("4");
        exr2.setRepairDate(new Date());
        exr2.setWarranty(true);
        List<SparePart> l4 = new ArrayList<>();
        l4.add(sp4);
        exr2.setSpareParts(l4);
        
        /*
            TESTDATEN PERSISTIEREN
        */
        em.getTransaction().begin();
        
        em.persist(lehrling);
        em.persist(master);
        
        em.persist(customer1);
        em.persist(customer2);
        
        /*
        Werden bei den Repairs mitpersistiert!
        em.persist(sp1);
        em.persist(sp2);
        em.persist(sp3);
        em.persist(sp4);
        */
        
        em.persist(inhr1);
        em.persist(inhr2);
        em.persist(exr1);
        em.persist(exr2);

        em.getTransaction().commit();
        
        em.getTransaction().begin();

        TypedQuery<Repair> longWarrantyRepairs = em.createQuery("SELECT r FROM Repair r WHERE r.warranty = true AND r.duration > 30", Repair.class);
        List<Repair> res1 = longWarrantyRepairs.getResultList();
        System.out.println("=== TYPED QUERY 1 ===");
        res1.forEach(r -> {
            System.out.println("Res1: " + r.getDescription() + " warranty: " + r.isWarranty() + " dur.: " + r.getDuration());
        });

        em.getTransaction().commit();
        
        TypedQuery<Repair> namedQuery1 = em.createNamedQuery("aboveSpecificSalPerHour", Repair.class).setParameter("salPerHour", 20);
        List<Repair> res2 = namedQuery1.getResultList();
        System.out.println("=== NAMED QUERY 1 ===");
        res2.forEach(r -> {
            System.out.println(r);
        });
                        
        TypedQuery<Repair> namedQuery2 = em.createNamedQuery("gotSomeSpareParts", Repair.class);
        List<Repair> res3 = namedQuery2.getResultList();
        System.out.println("=== NAMED QUERY 2 ===");
        res3.forEach(r -> {
            System.out.println(r);
        });
        
        TypedQuery<Repair> namedQuery3 = em.createNamedQuery("smallDriveDistance", Repair.class);
        List<Repair> res4 = namedQuery3.getResultList();
        System.out.println("=== NAMED QUERY 3 ===");
        res4.forEach(r -> {
            System.out.println(r);
        });
    }
    
    
}
