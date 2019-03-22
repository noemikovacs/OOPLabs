package Domain;

public class TransactionValidator implements IValidator<Transaction> {

    //validarea tranzactiei

    /**
     * Validates a transaction
     * @param transaction
     * @throws RuntimeException if there are validation errors.
     */

    public void validate(Transaction transaction){
        if(transaction.getNrOfItems() <= 0){
            throw new RuntimeException("The number of items must be at least 1.");
        }
    }

}
