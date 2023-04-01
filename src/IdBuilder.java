import java.util.HashSet;
import java.util.Random;

/**
 * Helper class to generate random IDs.
 *
 */
public abstract class IdBuilder {
    private static final Random rand = new Random();
    private static final int idLength = 9;
    private static final HashSet<String> ids = new HashSet<>();

    /**
     * Generate a random unique ID.
     *
     * @return Random ID.
     */
    public static String randomizeID() {
        StringBuilder stb = new StringBuilder();
        for (int i = 0; i < idLength; i++) {
            stb.append(rand.nextInt(10));
        }
        String id = stb.toString();
        if (ids.contains(id)) {
            return randomizeID();
        }
        ids.add(id);
        return id;
    }

}
