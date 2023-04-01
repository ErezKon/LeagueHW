/**
 * Represents an abstract person's basic details.
 *
 */
public abstract class Person {
    protected String firstName;
    protected String lastName;
    protected String id;

    /**
     * Constructs a person.
     *
     * @param firstName The person's first name.
     * @param lastName The person's last name.
     * @param id The person's ID.
     */
    public Person(String firstName, String lastName, String id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
    }

    @Override
    public String toString() {
        return String.format("First Name: %s, Last Name: %s, ID: %s", firstName, lastName, id);
    }

    /**
     * Print the person's details.
     *
     */
    public void printDetails() {
        System.out.println(toString());
    }

    public abstract boolean isExcellent();

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getId() {
        return id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
