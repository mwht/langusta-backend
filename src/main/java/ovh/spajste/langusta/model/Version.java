package ovh.spajste.langusta.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

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

    public Version() {
        Logger logger = LoggerFactory.getLogger(Version.class);
        commitHash = getGitCommandOutput("git log --format=%H -n 1");
        commitAuthor = getGitCommandOutput("git log --format=%an -n 1");
        logger.debug("now getting commit author, the almighty " + commitAuthor);
        String rawDate = getGitCommandOutput("git log --format=%ad -n 1");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE MMM d HH:mm:ss yyyy Z", Locale.ENGLISH);
        try {
            commitDate = simpleDateFormat.parse(rawDate);
            logger.debug("kewl, date is " + commitDate.toString());
        } catch (ParseException pe) {
            commitDate = null;
        }
    }

    public static Version getInstance() {
        if(instance == null) instance = new Version();
        return instance;
    }

    public Date getCommitDate() {
        return commitDate;
    }

    public String getCommitHash() {
        return commitHash;
    }

    public String getCommitAuthor() {
        return commitAuthor;
    }
}
