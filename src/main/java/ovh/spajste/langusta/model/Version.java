package ovh.spajste.langusta.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Version is model, that returns info about last commit on Git.
 * To be used at developement machine, otherwise it won't produce
 * any useful information at all.
 *
 * @author Sebastian Madejski (mwht)
 */
public class Version {
    private String commitHash;
    private Date commitDate;
    private String commitAuthor;

    private static Version instance = null;

    /**
     * Executes the given command and returns first line as a {@link String}.
     *
     * @param cmd command to execute
     * @return first line of executed command output
     */
    private String getGitCommandOutput(String cmd) {
        try {
            // TODO: OPTIMIZE THIS GOD'S ABOMINATION !!!
            return new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec(cmd).getInputStream())).readLine();
        } catch (Exception e) {
            return "[unknown] - "+e.getClass().getSimpleName()+": "+e.getMessage();
        }
    }

    /**
     * Constructor for Version object. Internal use only, use {@link Version#getInstance()} instead.
     */
    public Version() {
        commitHash = getGitCommandOutput("git log --format=%H -n 1");
        commitAuthor = getGitCommandOutput("git log --format=%an -n 1");
        String rawDate = getGitCommandOutput("git log --format=%ad -n 1");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE MMM d HH:mm:ss yyyy Z", Locale.ENGLISH);
        try {
            commitDate = simpleDateFormat.parse(rawDate);
        } catch (Exception e) {
            commitDate = null;
        }
    }

    /**
     * Get the instance of {@link Version}. If instance does not exist, create one.
     *
     * @return instance of {@link Version}
     */
    public static Version getInstance() {
        if(instance == null) instance = new Version();
        return instance;
    }

    /**
     * Get last commit date.
     *
     * To be removed on production.
     *
     * @return Last commit date
     */
    public Date getCommitDate() {
        return commitDate;
    }

    /**
     * Get last commit hash.
     *
     * To be removed on production.
     *
     * @return Last commit hash
     */
    public String getCommitHash() {
        return commitHash;
    }

    /**
     * Get last commit author.
     *
     * To be removed on production.
     *
     * @return Last commit author
     */
    public String getCommitAuthor() {
        return commitAuthor;
    }
}
