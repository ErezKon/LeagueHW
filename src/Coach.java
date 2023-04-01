/**
 * represents a football coach.
 *
 */
public class Coach extends Employee {
    private String team;
    private boolean pastPlayer;
    private int championships;

    /**
     * Constructs a coach.
     *
     * @param firstName The coach's first name.
     * @param lastName The coach's last name.
     * @param id The coach's ID.
     * @param seniority The coach's seniority.
     * @param team the coach's team
     * @param pastPlayer whether the coach is a past player or not.
     * @param championships championships won by the coach.
     */
    public Coach(String firstName, String lastName, String id, int seniority, String team, boolean pastPlayer, int championships) {
        super(firstName, lastName, id, seniority);
        this.team = team;
        this.championships = championships;
        this.pastPlayer = pastPlayer;
    }

    @Override
    public String toString() {
        return String.format("%s, Team: %s, Is past player: %s, , Championships won: %d, Salary: %f", super.toString(), team,
                pastPlayer, championships, calculateSalary());
    }

    /**
     * Print the coach's details.
     *
     */
    public void printDetails() {
        System.out.println(toString());
    }

    /**
     * Calculates the coach's salary.
     *
     * @return The coach's salary.
     */
    @Override
    public double calculateSalary() {
        return basis + 200 * seniority + 500 * championships;
    }

    /**
     * A coach is defined excellent if he won over two championships.
     *
     * @return excellency status.
     */
    @Override
    public boolean isExcellent() {
        return championships >= 2;
    }

    /**
     * Increment the championships won by the coach.
     *
     */
    public void wonChampionship() {
        championships++;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public boolean isPastPlayer() {
        return pastPlayer;
    }

    public void setPastPlayer(boolean pastPlayer) {
        this.pastPlayer = pastPlayer;
    }

    public int getChampionships() {
        return championships;
    }
}
