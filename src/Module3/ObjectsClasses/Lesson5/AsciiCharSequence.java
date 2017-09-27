package Module3.ObjectsClasses.Lesson5;

import java.util.Arrays;

public class AsciiCharSequence implements CharSequence {

    private byte[] sequence;

    private AsciiCharSequence(byte[] bytes) {
        sequence = bytes;
    }

    @Override
    public int length() {
        return sequence.length;
    }

    @Override
    public char charAt(int i) {
        return (char)sequence[i];
    }

    @Override
    public CharSequence subSequence(int i, int i1) {
        return new AsciiCharSequence(Arrays.copyOfRange(sequence, i, i1));
    }

    @Override
    public String toString(){
        return new String(sequence);
    }
}