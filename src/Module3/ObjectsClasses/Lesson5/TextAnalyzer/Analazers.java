package Module3.ObjectsClasses.Lesson5.TextAnalyzer;

public class Analazers {

    abstract class KeywordAnalyzer implements TextAnalyzer {

        protected abstract String[] getKeywords();
        protected abstract Label getLabel();

        @Override
        public Label processText(String text) {
            String[] keywords = getKeywords();
            for (String word : keywords) {
                if (text.contains(word)) {
                    return getLabel();
                }
            }
            return Label.OK;
        }
    }

    class SpamAnalyzer extends KeywordAnalyzer {
        private String [] keywords;
        SpamAnalyzer(String[] spamWords) {
            this.keywords = spamWords;
        }

        @Override
        public String[] getKeywords() {
            return keywords;
        }

        @Override
        public Label getLabel() {
            return Label.SPAM;
        }
    }

    class NegativeTextAnalyzer extends KeywordAnalyzer {

        @Override
        public String[] getKeywords() {
            return new String[]{":(", "=(", ":|"};
        }

        @Override
        public Label getLabel() {
            return Label.NEGATIVE_TEXT;
        }
    }

    class TooLongTextAnalyzer implements TextAnalyzer {
        private int maxLength;
        public TooLongTextAnalyzer(int maxLen) {
            this.maxLength = maxLen;
        }

        @Override
        public Label processText(String text) {
            return text.length() > maxLength ? Label.TOO_LONG : Label.OK;
        }
    }

    public Label checkLabels(TextAnalyzer[] analyzers, String text) {
        for (TextAnalyzer analyzer : analyzers) {
            Label label = analyzer.processText(text);
            if (label != Label.OK) {
                return label;
            }
        }
        return Label.OK;
    }
}
