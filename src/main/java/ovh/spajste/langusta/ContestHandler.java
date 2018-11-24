package ovh.spajste.langusta;

import ovh.spajste.langusta.entity.Contest;

public interface ContestHandler {
    public Contest fetchNewContestData(Contest contest);
    public Contest doContest(Contest contest);
}
