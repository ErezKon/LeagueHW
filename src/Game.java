import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

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

    public void simulateGame() {
        System.out.println(String.format("the match between %s and %s has begun!", host.getName(), guest.getName()));
        if(host.getName().equals(HBS_LITERAL) || guest.getName().equals(HBS_LITERAL)) {
            Team hbs = host.getName().equals(HBS_LITERAL) ? host : guest;
            Team noobs = host.getName().equals(HBS_LITERAL) ? guest : host;
            int hbsGoals = rand.nextInt(3) + 2;
            int noobsGoals = rand.nextInt(2);
            for (int i = 0; i < hbsGoals; i++) {
                List<Player> hbsPlayers = hbs.getPlayers()
                        .stream()
                        .filter(p -> p.getPosition() != Position.GOALKEEPER)
                        .collect(Collectors.toList());
                Player scorer = hbsPlayers.get(rand.nextInt(hbsPlayers.size()));
                scoreGoal(scorer.getId());
            }

            for (int i = 0; i < noobsGoals; i++) {
                List<Player> noobsPlayers = noobs.getPlayers()
                        .stream()
                        .filter(p -> p.getPosition() != Position.GOALKEEPER)
                        .collect(Collectors.toList());
                Player scorer = noobsPlayers.get(rand.nextInt(noobsPlayers.size()));
                scoreGoal(scorer.getId());
            }
        } else {
            int hostGoals = rand.nextInt(3);
            int guestGoals = rand.nextInt(3);
            for (int i = 0; i < hostGoals; i++) {
                List<Player> hostPlayers = host.getPlayers()
                        .stream()
                        .filter(p -> p.getPosition() != Position.GOALKEEPER)
                        .collect(Collectors.toList());
                Player scorer = hostPlayers.get(rand.nextInt(hostPlayers.size()));
                scoreGoal(scorer.getId());
            }

            for (int i = 0; i < guestGoals; i++) {
                List<Player> guestPlayers = guest.getPlayers()
                        .stream()
                        .filter(p -> p.getPosition() != Position.GOALKEEPER)
                        .collect(Collectors.toList());
                Player scorer = guestPlayers.get(rand.nextInt(guestPlayers.size()));
                scoreGoal(scorer.getId());
            }
        }

        for (Referee ref: referees) {
            ref.addErrors(rand.nextInt(10));
        }
        System.out.println(String.format("the match between %s and %s has finished!\nThe score is: %s", host.getName(), guest.getName(), getScore()));
        System.out.println("\n------------------------------------------------------------------------------------------------------\n");
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
