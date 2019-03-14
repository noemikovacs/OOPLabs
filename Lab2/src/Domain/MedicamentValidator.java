package Domain;

public class MedicamentValidator {

    //pretul sa fie strict pozitiv

    public void validate(Medicament medicament){
        if(medicament.getPrice() <= 0) {
            throw new RuntimeException("The price must be a positive value!");
        }
    }
}
