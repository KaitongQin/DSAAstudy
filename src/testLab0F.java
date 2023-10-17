import java.util.Random;

public class testLab0F {
    private static final String[] RANKS = {"1", "2", "3", "4", "5", "6", "7","8","9"};
    private static final String[] SUITS = {"w", "b", "s", "z"};

    public static void main(String[] args) {
        for (int i = 0; i < 30000;i++) {
            System.out.println(generateSatoriString());
        }
    }

    private static String generateSatoriString() {
        StringBuilder s = new StringBuilder();
        Random random = new Random();
        int count = 0;
        for (int i = 0; i < 14; i++) {
            // Get a random rank and suit.
            String rank = RANKS[random.nextInt(RANKS.length)];
            String suit = SUITS[random.nextInt(SUITS.length)];
            if(suit.equals("z")){
                rank = RANKS[random.nextInt(7)];
            }
            // Place the rank and suit in the correct positions in the string.
            s.append(rank);
            s.append(suit);

            // Check if the same character has appeared more than 3 times.
            if (++count > 4) {
                // If so, re-generate the rank and suit.
                rank = RANKS[random.nextInt(RANKS.length)];
                suit = SUITS[random.nextInt(SUITS.length)];
                --count;
            }
        }
        return s.toString();
    }
}