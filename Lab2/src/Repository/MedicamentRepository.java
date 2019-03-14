package Repository;

import Domain.Medicament;
import Domain.MedicamentValidator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MedicamentRepository {

    private Map<String, Medicament> storage = new HashMap<>();
    private MedicamentValidator validator;

    public MedicamentRepository(MedicamentValidator validator) {
        this.validator = validator;
    }

    public Medicament findById(String id) {

        return storage.get(id);
    }

    /**
     * Adds or updates a medicament if already exists
     *
     * @param medicament to add or to update the medicament
     */

    public void upsert(Medicament medicament) {
        validator.validate(medicament);
        storage.put(medicament.getId(), medicament);
    }

    /**
     * Removes a medicament with a given id.
     *
     * @param id the id.
     * @throws RuntimeException if there is no medicament with the given id.
     */
    public void remove(String id) {
        if (!storage.containsKey(id)) {
            throw new RuntimeException("There is no medicament with the given id to remove.");
        }

        storage.remove(id);
    }

    public List<Medicament> getAll() {

        if (storage.values() == null) {
            throw new RuntimeException("The list of medicaments is empty!");
        } else {
        }
        return new ArrayList<>(storage.values());

    }
}
