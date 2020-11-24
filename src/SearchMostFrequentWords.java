
import java.text.BreakIterator;
import java.util.*;

public class SearchMostFrequentWords {
    private final String text;

    public SearchMostFrequentWords(String text) {
        this.text = text;
    }

    public List<String> wordsMass(String text) {
        List<String> wordsList = new ArrayList<>();


        wordsSequenceList(text, wordsList);

        Collections.sort(wordsList);

        int count = searchUniqueWord(wordsList);
        if (count < 3) {
            wordsList.clear();
            return wordsList;
        }


        String maxWord = searchFrequentWord(wordsList);

        String maxWord2 = searchFrequentWord(wordsList, maxWord);

        String maxWord3 = searchFrequentWord(wordsList, maxWord, maxWord2);


        wordsList.clear();
        wordsList.add(maxWord);
        wordsList.add(maxWord2);
        wordsList.add(maxWord3);


        return wordsList;
    }


    private int searchUniqueWord(List<String> wordsList) {
        String word = "";
        int count = 0;

        for (String str1 : wordsList) {
            if (!str1.equals(word)) {
                count++;
            }
            word = str1;
        }

        return count;
    }

    private String searchFrequentWord(List<String> wordsList) {
        String word = "";
        int count = 1;
        String maxWord1 = "";
        int maxCount1 = 0;
        for (String str1 : wordsList) {
            if (str1.equals(word)) {
                count++;
            } else {
                if (count > maxCount1) {
                    maxCount1 = count;
                    maxWord1 = word;
                }
                word = str1;
                count = 1;
            }
        }

        if (count > maxCount1) {

            maxWord1 = word;
        }
        return maxWord1;
    }

    private String searchFrequentWord(List<String> wordsList, String maxWord1) {
        int count = 1;
        String maxWord2 = "";
        String word = "";
        int maxCount2 = 0;
        for (String str1 : wordsList) {
            if (str1.equals(word) && !str1.equals(maxWord1)) {
                count++;
            } else {
                if (count > maxCount2) {
                    maxCount2 = count;
                    maxWord2 = word;
                }
                word = str1;
                count = 1;
            }
        }

        if (count > maxCount2) {

            maxWord2 = word;
        }
        return maxWord2;
    }


    private String searchFrequentWord(List<String> wordsList, String maxWord1, String maxWord2) {
        String word = "";
        int count = 1;
        String maxWord3 = "";
        int maxCount3 = 0;
        for (String str1 : wordsList) {
            if (str1.equals(word) && !str1.equals(maxWord1) && !str1.equals(maxWord2)) {
                count++;
            } else {
                if (count > maxCount3) {
                    maxCount3 = count;
                    maxWord3 = word;
                }
                word = str1;
                count = 1;
            }
        }

        if (count > maxCount3) {

            maxWord3 = word;
        }
        return maxWord3;
    }

    private void wordsSequenceList(String text, List<String> wordsList) {
        BreakIterator wordIterator = BreakIterator.getWordInstance();
        wordIterator.setText(text);
        int end = wordIterator.first();


        while (BreakIterator.DONE != end) {
            int start = end;
            end = wordIterator.next();
            if (end != BreakIterator.DONE && Character.isLetterOrDigit(text.charAt(start))) {
                wordsList.add(text.substring(start, end).toLowerCase().trim());
            }
        }
    }
}
