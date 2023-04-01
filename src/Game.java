import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * Represents a football game.
 *
 */
public class Game {
    private Date matchTime;
    private Team host;
    private Team guest;
    private String score;
    private int hostGoals = 0;
    private int guestGoals = 0;
    private List<Referee> referees;


    private static final String pattern = "dd/MM/yyyy HH:mm";
    private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
    private static Random rand = new Random();
    private static final String HBS_LITERAL = "Hapoel Beer Sheva";
    /**
     * Constructs a game.
     *
     * @param matchTime Date and time of the match.
     * @param host The hosting team.
     * @param guest The guest team.
     * @param referees The referees of the match.
     */
    public Game(Date matchTime, Team host, Team guest, Referee[] referees) {
        this.matchTime = matchTime;
        this.host = host;
        this.guest = guest;
        this.referees = new ArrayList<Referee>(Arrays.asList(referees));
    }

    /**
     * Gets the score of the game, as {Host}: {score} - {Guest}: {score}.
     *
     * @return Game's score.
     */
    public String getScore() {
        return String.format("%s: %d - %s: %d", host.getName(), hostGoals, guest.getName(), guestGoals);
    }

    /**
     * Update a scored goal by a player.
     *
     * @param playerID The ID of the player who scored the goal.
     */
    public void scoreGoal(String playerID) {
        Player player = host.getPlayerById(playerID);
        if (player != null) {
            hostGoals++;
            player.addAttempts(1);
            player.addSuccessfulAttempts(1);
            System.out.println(String.format("Player %s %s scored a goal for %s!\nCurrent score is: %s",player.getFirstName(), player.getLastName(), host.getName(), getScore()));
        }
        player = guest.getPlayerById(playerID);
        if (player != null) {
            guestGoals++;
            player.addAttempts(1);
            player.addSuccessfulAttempts(1);
            System.out.println(String.format("Player %s %s scored a goal for %s!\nCurrent score is: %s",player.getFirstName(), player.getLastName(), guest.getName(),getScore()));
        }
    }


    /**
     * Print the game details.
     *
     */
    public void printDetails() {
        System.out.println("Game details:");
        System.out.println(String.format("\t - Match Time: %s", simpleDateFormat.format(matchTime)));
        System.out.println(String.format("\t - Score: %s", getScore()));
        System.out.println("\t - Host details:");
        host.printDetails(true);
        System.out.println("\t - Guest details:");
        guest.printDetails(true);
    }

    public List<Referee> getReferees() {
        return referees;
    }

    public Date getMatchTime() {
        return matchTime;
    }

    public Team getHost() {
        return host;
    }

    public Team getGuest() {
        return guest;
    }

    public int getHostGoals() {
        return hostGoals;
    }

    public int getGuestGoals() {
        return guestGoals;
    }

}
