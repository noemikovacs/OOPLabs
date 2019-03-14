package Domain;

public class Client {
    //CRUD card client: id, nume, prenume, CNP, data nașterii (dd.mm.yyyy), data înregistrării (dd.mm.yyyy). CNP-ul trebuie să fie unic.


    private String id, firstName, lastName, CNP, dateOfRegistration;

    public Client(String id, String firstName, String lastName, String CNP, String dateOfRegistration) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.CNP = CNP;
        this.dateOfRegistration = dateOfRegistration;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", CNP='" + CNP + '\'' +
                ", dateOfRegistration='" + dateOfRegistration + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCNP() {
        return CNP;
    }

    public void setCNP(String CNP) {
        this.CNP = CNP;
    }

    public String getDateOfRegistration() {
        return dateOfRegistration;
    }

    public void setDateOfRegistration(String dateOfRegistration) {
        this.dateOfRegistration = dateOfRegistration;
    }
}