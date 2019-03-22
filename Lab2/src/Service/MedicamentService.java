package Service;

import Domain.Medicament;
import Repository.MedicamentRepository;

import java.util.List;

public class MedicamentService {

    private MedicamentRepository repository;

    /**
     *
     * @param repository
     */

    public MedicamentService(MedicamentRepository repository) {
        this.repository = repository;
    }

    /**
     *
     * @param id
     * @param name
     * @param manufacturer
     * @param price
     * @param needRecipe
     */

    public void addOrUpdate(String id, String name, String manufacturer, double price, boolean needRecipe) {
        Medicament existing = repository.findById(id);

        if (existing != null) {
            // keep unchanged fields as they were
            if (name.isEmpty()) {
                name = existing.getName();
            }
            if (name.isEmpty()) {
                name = existing.getName();
            }
            if (manufacturer.isEmpty()) {
                manufacturer = existing.getManufacturer();
            }
            if (price == 0) {
                price = existing.getPrice();
            }
        }
        Medicament medicament = new Medicament(id, name, manufacturer, price,needRecipe);
        repository.upsert(medicament);

    }

    /**
     *
     * @param name
     * @return
     */
    public double getPriceByID(String name){
        Medicament medicament = repository.findById(name);
        return medicament.getPrice();
    }

    public void remove(String id) {
        repository.remove(id);
    }
    public List<Medicament> getAll(){
        return repository.getAll();
    }
}
