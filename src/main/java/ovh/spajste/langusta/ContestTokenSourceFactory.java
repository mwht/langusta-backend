package ovh.spajste.langusta;

import ovh.spajste.langusta.ContestTokenSource;
import ovh.spajste.langusta.FileContestTokenSource;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class ContestTokenSourceFactory {
    public static ContestTokenSource getInstance(String contestTokenSource) {
        if(contestTokenSource.equals("file")) return new FileContestTokenSource();
        else throw new NotImplementedException();
    }
}
