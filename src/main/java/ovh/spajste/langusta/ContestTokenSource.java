package ovh.spajste.langusta;

import ovh.spajste.langusta.entity.Contest;

public interface ContestTokenSource {
    public String getTokenName(); // TODO: this is going to kill the optimization. try to redesign this module to suck
                                  // less in future.
    public String accessNextToken(Contest contest);
}
