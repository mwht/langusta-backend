import ovh.spajste.langusta.ContestTokenSource;
import ovh.spajste.langusta.FileContestTokenSource;

public class ContestTokenSourceFactory {
    public static ContestTokenSource getInstance(String contestTokenSource) {
        if(contestTokenSource.equals("file")) return new FileContestTokenSource();
        else return null;
    }
}
