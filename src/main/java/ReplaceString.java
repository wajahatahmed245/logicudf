import java.util.regex.Pattern;

public class ReplaceString {

    public static String validationsCol(StringBuilder sb) {
        return String.format("element_at(kv, '%s') AS %s", sb.toString(), new StringBuilder(sb.toString().replaceAll("[^a-zA-Z0-9]", "").replaceAll("^[\\s\\.\\d]+", "")));

    }
}

