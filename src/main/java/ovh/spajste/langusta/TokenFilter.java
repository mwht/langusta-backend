package ovh.spajste.langusta;

import ovh.spajste.langusta.ContestTokenSource;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TokenFilter {

    private static Map<String, ContestTokenSource> tokenSourceMap = new HashMap<>();
    private static final String TOKEN_REGEX = "\\{{2}([a-z]+)\\s(.*)\\}{2}";

    public static String processText(String input) {
        Pattern tokenPattern = Pattern.compile(TOKEN_REGEX);
        Matcher matcher = tokenPattern.matcher(input);
        String output = input;
        // initialize token sources
        while(matcher.find()) {
            ContestTokenSource contestTokenSource;
            if(!tokenSourceMap.containsKey(matcher.group(1))) {
                /* TODO: support multiple sources */
                System.out.println("Working Directory = " +
                        System.getProperty("user.dir"));
                contestTokenSource = ContestTokenSourceFactory.getInstance(matcher.group(1));
                contestTokenSource.setUpTokenSource(matcher.group(2));
                tokenSourceMap.put(matcher.group(1), contestTokenSource);
            } else {
                contestTokenSource = tokenSourceMap.get(matcher.group(1));
            }
            output = input.replaceAll(TOKEN_REGEX, contestTokenSource.accessNextToken(null));
        }
        return output;
    }
}
