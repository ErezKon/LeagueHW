/**
 * represents a football referee.
 *
 */
public class Referee extends Employee{
    private int errors;
    private int totalGames;

    private static int maxErrors = 0;

    /**
     * Constructs a referee.
     * 
     * @param firstName The referee's first name.
     * @param lastName The referee's last name.
     * @param id The referee's ID.
     * @param seniority The referee's seniority.
     * @param errors The amount of errors the referee made.
     * @param totalGames Total games the referee participate in.
     */
    public Referee(String firstName, String lastName, String id, int seniority, int errors, int totalGames) {
        super(firstName, lastName, id, seniority);
        this.errors = errors;
        this.totalGames = totalGames;

        updateMaxErrors();
    }

    private void updateMaxErrors() {
        if (errors > maxErrors) {
            maxErrors = errors;
        }
    }

    public void addErrors(int errors) {
        this.errors += errors;
        updateMaxErrors();
    }

    public void addGames(int games) {
        totalGames += games;
    }

    /**
     * Calculates the referee's salary.
     *
     * @return The referee's salary.
     */
    @Override
    public double calculateSalary() {
        double salary = basis + 30 * totalGames;
        if(errors >= maxErrors) {
            salary -= 500;
        }
        return salary;
    }

    /**
     * A referee is defined excellent if his errors are less than half of the maximum errors made by a referee.
     *
     * @return excellency status.
     */
    @Override
    public boolean isExcellent() {
        return errors <= (0.5 * maxErrors);
    }

    @Override
    public String toString() {
        return String.format("%s, Errors: %d, , Games: %d, Salary: %d", super.toString(),
                errors, totalGames, calculateSalary());
    }

    /**
     * Print the referee's details.
     *
     */
    public void printDetails() {
        System.out.println(toString());
    }

    public int getErrors() {
        return errors;
    }

    public int getTotalGames() {
        return totalGames;
    }

    public static int getMaxErrors() {
        return maxErrors;
    }
}
