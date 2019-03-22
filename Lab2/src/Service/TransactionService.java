package Service;

import Domain.Medicament;
import Domain.Transaction;
import Repository.MedicamentRepository;
import Repository.TransactionRepository;

import java.util.List;

public class TransactionService {

    private TransactionRepository transactionRepository;
    private MedicamentRepository medicamentRepository;

    public TransactionService(TransactionRepository transactionRepository, MedicamentRepository medicamentRepository) {
        this.transactionRepository = transactionRepository;
        this.medicamentRepository = medicamentRepository;
    }

    //metodele crud

    /**
     *
     * @param id
     * @param idMedicament
     * @param idCardClient
     * @param nrOfItems
     * @param date
     * @param time
     * @return
     */
    public Transaction addOrUpdate(String id, String idMedicament, String idCardClient, int nrOfItems, String date, String time){

        Transaction existing = transactionRepository.findById(id);

       if(existing != null) {
            if (idMedicament.isEmpty()){
                idMedicament = existing.getIdMedicament();
            }
            if (idCardClient.isEmpty()){
                idCardClient = existing.getIdCardClient();
            }
            if (nrOfItems == 0) {
                nrOfItems = existing.getNrOfItems();
            }
            if (date.isEmpty()) {
               date = existing.getDate();
            }
            if (time.isEmpty()) {
               time = existing.getTime();
            }
        }


       Medicament medicamentSold = medicamentRepository.findById(idMedicament);
       if (medicamentSold == null){
           throw new RuntimeException("There is no medicament with the given id!");
       }

        double discount = 0;

        if (idCardClient != null && (!medicamentSold.isNeedRecipe())) {
            discount = 0.1; // 10% discount
        } else {
            discount = 0.15;
        }

        Transaction transaction = new Transaction(id, idMedicament, idCardClient, nrOfItems, date, time, discount);
        transactionRepository.upsert(transaction);
        return transaction;

    }

    public void remove(String id) {

        transactionRepository.remove(id);
    }

    public List<Transaction> getAll() {

        return transactionRepository.getAll();
    }

}
