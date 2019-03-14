package Domain;

public class TransactionValidator {

    //validarea tranzactiei

    public void validate(Transaction transaction){
        if(transaction.getNrOfItems() <= 0){
            throw new RuntimeException("The number of items must be at least 1.");
        }
    }

}
