package entity.documents;

public class Application {
    private final Long id;
    private Long nrPESEL;
    private String firstName;
    private String middleName;
    private String lastName;
    private String dateOfBirth;
    private Long amount;
    private Long earnings;
    private Long spending;

    public Application(Long id) {
        this.id = id;
    }

    public Application(Long id, Long nrPESEL, String firstName, String middleName, String lastName, String dateOfBirth, Long amount) {
        this.id = id;
        this.nrPESEL = nrPESEL;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.amount = amount;
    }

    public Application(Long id, Long nrPESEL, String firstName, String middleName, String lastName, String dateOfBirth, Long amount, Long earnings, Long spending) {
        this.id = id;
        this.nrPESEL = nrPESEL;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.amount = amount;
        this.earnings = earnings;
        this.spending = spending;
    }

    public Long getId() {
        return id;
    }

    public Long getNrPESEL() {
        return nrPESEL;
    }

    public void setNrPESEL(Long nrPESEL) {
        this.nrPESEL = nrPESEL;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Long getEarings() {
        return earnings;
    }

    public void setEarings(Long earings) {
        this.earnings = earings;
    }

    public Long getSpending() {
        return spending;
    }

    public void setSpending(Long spending) {
        this.spending = spending;
    }

    @Override
    public String toString() {
        return "Application{" +
                "id=" + id +
                ", nrPESEL=" + nrPESEL +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", amount=" + amount +
                ", earings=" + earnings +
                ", spendings=" + spending +
                '}';
    }
}

