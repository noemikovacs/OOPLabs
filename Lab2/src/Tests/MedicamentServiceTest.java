package Tests;

import Domain.Client;
import Domain.ClientValidator;
import Domain.Medicament;
import Domain.MedicamentValidator;
import Repository.IRepository;
import Repository.InMemoryRepository;
import Service.MedicamentService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MedicamentServiceTest {

    @Test
    void addOrUpdateServiceShouldAddMedicament() {

        MedicamentValidator validator =new MedicamentValidator();
        IRepository<Medicament> medRepository = new InMemoryRepository<>(validator);
        MedicamentService medService = new MedicamentService(medRepository);

        Medicament med = new Medicament("1", "Fasconal", "THG", 86.6, true);

        medService.addOrUpdate("1", "Fasconal", "THG", 86.6, true);


        assertEquals(med,medService.getAll().get(0));
        assertEquals(1, medService.getAll().size());
    }

    @Test
    void shouldRemoveMedicament() {

        MedicamentValidator validator =new MedicamentValidator();
        IRepository<Medicament> medRepository = new InMemoryRepository<>(validator);
        MedicamentService medService = new MedicamentService(medRepository);

        Medicament med = new Medicament("1", "Fasconal", "THG", 86.6, true);

        medService.addOrUpdate("1", "Fasconal", "THG", 86.6, true);

        medService.remove("1");

        assertEquals(0, medService.getAll().size());
        assertFalse(medService.getAll().size() != 0);

    }


    @Test
    void getAllServieShouldGetAllMedicament() {

        MedicamentValidator validator =new MedicamentValidator();
        IRepository<Medicament> medRepository = new InMemoryRepository<>(validator);
        MedicamentService medService = new MedicamentService(medRepository);

        Medicament med = new Medicament("1", "Fasconal", "THG", 86.6, true);
        Medicament med1 = new Medicament("2", "Paracetamol", "THG", 6.6, false);

        medService.addOrUpdate("1", "Fasconal", "THG", 86.6, true);
        medService.addOrUpdate("2", "Paracetamol", "THG", 6.6, false);

        assertEquals(med, medService.getAll().get(0));
        assertEquals(med1, medService.getAll().get(1));
        assertFalse(medService.getAll().size() != 2);
    }
}