package Domain;

public class MedicamentValidator implements IValidator<Medicament> {

    //pretul sa fie strict pozitiv

    /**
     * Validates a medicament
     * @param medicament
     * @throws RuntimeException if there are validation errors.
     */

    public void validate(Medicament medicament){
        if(medicament.getPrice() <= 0) {
            throw new RuntimeException("The price must be a positive value!");
        }
    }
}
