package Module5.IOFileSystem.Lesson2;


import java.io.IOException;
import java.io.InputStream;

public class ByteStream {
    public static int checkSumOfStream(InputStream inputStream) throws IOException {
        int current = -1;
        int sumOfStream = 0;
        while (!((current = inputStream.read()) < 0)) {
            sumOfStream = Integer.rotateLeft(sumOfStream, 1) ^ current;
        }
        return sumOfStream;
    }
}
