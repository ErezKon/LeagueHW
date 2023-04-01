/**
 * represents a football player.
 *
 */
public class Player extends Employee {
    private String team;
    private int totalAttempts;
    private int successfulAttempts;
    private Position position;

    private static final int basis = 6500;

    /**
     * Constructs a player.
     *
     * @param firstName player's first name.
     * @param lastName player's last name.
     * @param id player's id.
     * @param seniority player's seniority.
     * @param team player's team.
     * @param totalAttempts player's total attempts (for goal keeper - saved goals, for defender - tackles, for midfielder - key passes, for forward - goals).
     * @param successfulAttempts player's successful attempts (for goal keeper - saved goals, for defender - tackles, for midfielder - key passes, for forward - goals).
     * @param position player's position.
     */
    public Player(String firstName, String lastName, String id, int seniority,
            String team, int totalAttempts, int successfulAttempts, Position position) {
        super(firstName, lastName, id, seniority);
        this.team = team;
        this.totalAttempts = totalAttempts;
        this.successfulAttempts = successfulAttempts;
        this.position = position;
    }

    /**
     * Gets the success rate of the players, by successful attempts out of total attempts percentage. Attempts are defined per position, see ctor for more details.
     *
     * @return Success rate percent [0-100].
     */
    public double getSuccessRate() {
        return (successfulAttempts * 100) / totalAttempts;
    }

    /**
     * Add attempts to player's total attempts.
     *
     * @param attempts The amount of attempts to add
     */
    public void addAttempts(int attempts) {
        totalAttempts += attempts;
    }

    /**
     * Add successful attempts to player's successful attempts.
     *
     * @param attempts The amount of attempts to add
     */
    public void addSuccessfulAttempts(int attempts) {
        successfulAttempts += attempts;
    }

    /**
     * A player is defined excellent if his success rate exceeds 75%.
     *
     * @return excellency status.
     */
    @Override
    public boolean isExcellent() {
        return getSuccessRate() >= 75.0;
    }

    /**
     * Calculates the player's salary.
     *
     * @return The player's salary.
     */
    @Override
    public double calculateSalary() {
        return basis + (getSuccessRate() / 100) * 2000 ;
    }

    @Override
    public String toString() {
        return String.format("%s, Team: %s, %s: %s, , %s: %s Position: %s, Salary: %f", super.toString(), team,
                formatAttempts(true), totalAttempts, formatAttempts(false), successfulAttempts, position, calculateSalary());
    }

    /**
     * Print the player's details.
     *
     */
    public void printDetails() {
        System.out.println(toString());
    }

    private String formatAttempts(boolean isTotal) {
        switch (position) {
            case GOALKEEPER:
                return isTotal ? "Total goal attempts" : "Saved goals";
            case DEFENDER:
                return isTotal ? "Total tackles" : "Successful tackles";
            case MIDFIELDER:
                return isTotal ? "Total key passes attempts" : "Successful key passes";
            case FORWARD:
                return isTotal ? "Total goal attempts" : "Scored goals";
        }
        return "";
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public int getTotalAttempts() {
        return totalAttempts;
    }

    public int getSuccessfulAttempts() {
        return successfulAttempts;
    }
}
