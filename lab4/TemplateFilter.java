import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TemplateFilter {

    public static void main(String[] args) {

        String template = "Dear {name}, order {id} ships {date}.";

        String[] names = {"name", "id"};
        String[] values = {"Riya", "A07"};

        Pattern pattern = Pattern.compile("\\{(\\w+)\\}");
        Matcher matcher = pattern.matcher(template);

        StringBuilder result = new StringBuilder();

        int lastPosition = 0;

        while (matcher.find()) {

            // Add text before the placeholder
            result.append(template, lastPosition, matcher.start());

            String placeholder = matcher.group(1);

            String replacement = "[?]";

            // Search for placeholder in names array
            for (int i = 0; i < names.length; i++) {
                if (names[i].equals(placeholder)) {
                    replacement = values[i];
                    break;
                }
            }

            result.append(replacement);

            lastPosition = matcher.end();
        }

        // Add remaining text after the last placeholder
        result.append(template.substring(lastPosition));

        System.out.println(result);
    }
}