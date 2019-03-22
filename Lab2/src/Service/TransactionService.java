package Service;

import Domain.Medicament;
import Domain.Transaction;
import Repository.IRepository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TransactionService extends MyException {

    private IRepository<Transaction> transactionRepository;
    private IRepository<Medicament> medicamentRepository;

    public TransactionService(IRepository<Transaction> transactionRepository, IRepository<Medicament> medicamentRepository) {
        this.transactionRepository = transactionRepository;
        this.medicamentRepository = medicamentRepository;
    }

//metodele crud

    private
    Date convertToDate(String date){

            SimpleDateFormat sdf = new SimpleDateFormat();
            sdf.applyPattern("dd.MM.yyyy");
            sdf.setLenient(false);
            Date d;
            try{
               d = sdf.parse(date);
        } catch (ParseException e) {
            throw new RuntimeException("Unparseable using " + e.getMessage());
        }
        return d;
    }

    /**
     * @param id
     * @param idMedicament
     * @param idCardClient
     * @param nrOfItems
     * @param date
     * @param time
     * @return
     */
    public Transaction addOrUpdate(String id, String idMedicament, String idCardClient, int nrOfItems, String date, String time) {

        Transaction existing = transactionRepository.findById(id);
        Date d;

        if (existing != null) {
            if (idMedicament.isEmpty()) {
                idMedicament = existing.getIdMedicament();
            }
            if (idCardClient.isEmpty()) {
                idCardClient = existing.getIdCardClient();
            }
            if (nrOfItems == 0) {
                nrOfItems = existing.getNrOfItems();
            }
            if (date.isEmpty()) {
                d = existing.getDate();
            }
            if (time.isEmpty()) {
                time = existing.getTime();
            }
        }


        Medicament medicamentSold = medicamentRepository.findById(idMedicament);
        if (medicamentSold == null) {
            throw new RuntimeException ("There is no medicament with the given id!");
        }

        double discount = 0;

        if (idCardClient != null && (!medicamentSold.isNeedRecipe())) {
            discount = 0.1; // 10% discount
        } else {
            discount = 0.15;
        }

        d = convertToDate(date);

        Transaction transaction = new Transaction(id, idMedicament, idCardClient, nrOfItems, d, time, discount);
        transactionRepository.upsert(transaction);
        return transaction;

    }

    public void remove(String id) {

        transactionRepository.remove(id);
    }

    public List<Transaction> getAll() {

        return transactionRepository.getAll();
    }

    //Afișarea tuturor tranzacțiilor dintr-un interval de zile dat.
    public List<Transaction> PrintAllTransInterval(String date1, String date2) throws MyException {
        Date d1, d2;
        d1 = convertToDate(date1);
        d2 = convertToDate(date2);

        List<Transaction> trans = new ArrayList<>();

        if (d1.compareTo(d2) > 0) { //date1 is later than date2
            throw new MyException("The date must be inverse");
        } else {
            for (Transaction t : transactionRepository.getAll()) {
                if (t.getDate().compareTo(d1) >= 0 && t.getDate().compareTo(d2) <= 0){
                    trans.add(t);
                }
            }
        }
        return trans;
    }


}
