package ovh.spajste.langusta;

import ovh.spajste.langusta.entity.Contest;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class FileContestTokenSource implements ContestTokenSource {

    private String sourceFilePath = null;
    private int linesInFile = -1;
    private int currentLine = -1;
    private List<String> lines;

    @Override
    public String getTokenName() {
        return "Text file (.txt)";
    }

    @Override
    public String accessNextToken(Contest contest) {
        if(getRemainingTokens() > 0) {
            return lines.get(currentLine++);
        } else {
            return null;
        }
    }

    @Override
    public void setUpTokenSource(Object source) {
        sourceFilePath = (String) source;
        try {
            FileReader fileReader = new FileReader(sourceFilePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            lines = new ArrayList<String>();

            linesInFile = 0;
            String line;
            while((line = bufferedReader.readLine()) != null) {
                lines.add(line);
                linesInFile++;
            }

            bufferedReader.close();
            currentLine = 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getRemainingTokens() {
        return linesInFile - currentLine;
    }
}
