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

    public void printDetails() {
        String details = toString();
        System.out.println(details);
    }

    public abstract boolean isExcellent();
}
