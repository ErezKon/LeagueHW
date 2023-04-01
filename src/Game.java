import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Game {
    private Date matchTime;
    private Team host;
    private Team guest;
    private String score;
    private int hostGoals = 0;
    private int guestGoals = 0;
    private List<Referee> referees;

    public Game(Date matchTime, Team host, Team guest, Referee[] referees) {
        this.matchTime = matchTime;
        this.host = host;
        this.guest = guest;
        this.referees = new ArrayList<Referee>(Arrays.asList(referees));
    }

    public String getScore() {
        return String.format("%s: %d - %s: %d", host.getName(), hostGoals, guest.getName(), guestGoals);
    }

    public void scoreGoal(String playerID) {
        Player player = host.getPlayerById(playerID);
        if (player != null) {
            hostGoals++;
            player.addAttempts(1);
            player.addSuccessfulAttempts(1);
        }
        player = guest.getPlayerById(playerID);
        if (player != null) {
            guestGoals++;
            player.addAttempts(1);
            player.addSuccessfulAttempts(1);
        }
    }

    private String formatDate() {
        String pattern = "dd/MM/yyyy HH:mm";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

        String date = simpleDateFormat.format(matchTime);
        return date;
    }

    public void print() {

        System.out.println("Game details:");
        System.out.println(String.format("\t - Match Time: %s", formatDate()));
        System.out.println(String.format("\t - Score: %s", getScore()));
        System.out.println("\t - Host details:");
        host.print(true);
        System.out.println("\t - Guest details:");
        guest.print(true);
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
