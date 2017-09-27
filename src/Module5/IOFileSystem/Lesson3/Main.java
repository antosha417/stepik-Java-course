package Module5.IOFileSystem.Lesson3;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

public class Main {
    public static void main(String[] args) {
        double sum = sumAllDouble(System.in);
        System.out.printf("%.6f",sum);
    }

    private static double sumAllDouble(InputStream inputStream) {
        String input = "";
        try {
            input = readAsString(inputStream, Charset.defaultCharset());
        } catch (IOException ignored) { }
        String[] splitedInput = input.split("[ \n]");

        double sum = 0;
        for(String word : splitedInput) {
            try {
                sum += Double.parseDouble(word);
            } catch (NumberFormatException ignored) {}
        }

        return sum;
    }

    private static String readAsString(InputStream inputStream, Charset
            charset) throws IOException {
        byte[] input = new byte[1000];
        int length = inputStream.read(input);
        StringBuilder result = new StringBuilder();
        if (length <= 0) {
            return "";
        }
        while (length >= 0) {
            result.append(new String(input, 0, length, charset));
            length = inputStream.read(input);
        }
        return result.toString();
    }
}
