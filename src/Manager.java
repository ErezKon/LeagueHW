/**
 * Represents a football manager.
 *
 */
public class Manager extends Employee {

    /**
     *
     * @param firstName The manager's first name.
     * @param lastName The manager's last name.
     * @param id The manager's ID.
     * @param seniority The manager's seniority.
     */
    public Manager(String firstName, String lastName, String id, int seniority) {
        super(firstName, lastName, id, seniority);
    }

    /**
     * Calculates the manager's salary.
     *
     * @return The manager's salary.
     */
    @Override
    public double calculateSalary() {
        return basis * 3 + seniority * 500;
    }

    /**
     * A manager is defined excellent if his seniority is over 4 years.
     *
     * @return excellency status.
     */
    @Override
    public boolean isExcellent() {
        return seniority >= 4;
    }

    @Override
    public String toString() {
        return String.format("%s, Seniority: %d, Salary: %f", super.toString(), seniority, calculateSalary());
    }

    /**
     * Print the manager's details.
     *
     */
    public void printDetails() {
        System.out.println(toString());
    }
}
