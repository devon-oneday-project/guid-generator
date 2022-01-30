package devon.oneday.guid.generator.server.util;

public class RandomUtil {

    private static final String ALPHABET_NUMERIC = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    public static String getRandomString(int size) {
        StringBuilder builder = new StringBuilder(size);
        for (int idx = 0; idx < size; idx++) {
            int randomIdx = (int) (ALPHABET_NUMERIC.length() * Math.random());
            builder.append(ALPHABET_NUMERIC.charAt(randomIdx));
        }
        return builder.toString();
    }

}
