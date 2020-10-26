package seedu.duke.database;

import seedu.duke.wordlist.WordList;
import seedu.duke.words.Adjective;
import seedu.duke.words.Noun;
import seedu.duke.words.Verb;
import seedu.duke.words.Words;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class WordsSaver {
    private static final String FILE_PATH = "data/words.txt";

    public static void saveWordsToFile() {
        ArrayList<Words> words = WordList.getWordList();
        String textToSave = "";

        for (Words w : words) {
            if (w instanceof Noun) {
                textToSave = textToSave.concat("noun | " + w.getDescription() + " | " + w.getDefinition() + System.lineSeparator());
            } else if (w instanceof Verb) {
                textToSave = textToSave.concat("verb | " + w.getDescription() + " | " + w.getDefinition() + System.lineSeparator());
            } else if (w instanceof Adjective) {
                textToSave = textToSave.concat("adjective | " + w.getDescription() + " | " + w.getDefinition() + System.lineSeparator());
            } else {
                System.out.println("Word type error.");
            }
        }

        try {
            writeToFile(textToSave);
        } catch (IOException e) {
            System.out.println("Cannot write to file.");
        }
    }

    private static void writeToFile (String textToWrite) throws IOException {
        FileWriter fw = new FileWriter(FILE_PATH);
        fw.write(textToWrite);
        fw.close();
    }

}
