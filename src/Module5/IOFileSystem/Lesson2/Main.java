package Module5.IOFileSystem.Lesson2;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Main {
    public static void main(String[] args) {
        formatText(System.in, System.out);
    }

    private static void formatText(InputStream inputStream, OutputStream outputStream) {
        try {
            int currentByte = inputStream.read();;
            while (currentByte >= 0) {
                if(currentByte == 13){
                    int nextByte = inputStream.read();
                    if (nextByte == 13) {
                        outputStream.write(currentByte);
                        currentByte = nextByte;
                        continue;
                    }
                    if (nextByte == 10){
                        outputStream.write(nextByte);
                        currentByte = inputStream.read();
                        continue;
                    }
                    outputStream.write(currentByte);
                    outputStream.write(nextByte);
                    currentByte = inputStream.read();
                } else {
                    outputStream.write(currentByte);
                    currentByte = inputStream.read();
                }
            }
            outputStream.flush();
        } catch (IOException ignored) {}

    }

}
