package Module5.IOFileSystem.Lesson4;

import java.io.*;
import java.util.Objects;

public class Serialize {
    class Animal implements Serializable {
        private final String name;

        public Animal(String name) {
            this.name = name;
        }

        @Override
        public boolean equals(Object obj) {
            return obj instanceof Animal && Objects.equals(name,
                    ((Animal) obj).name);
        }
    }

    public static Animal[] deserializeAnimalArray(byte[] data) {
        try (ObjectInputStream objectInputStream =
                     new ObjectInputStream(new ByteArrayInputStream(data))) {
            int size = objectInputStream.readInt();
            Animal[] result = new Animal[size];
            for (int i = 0; i < size; i++) {
                result[i] = (Animal) objectInputStream.readObject();
            }
            return result;
        } catch (IOException | ClassNotFoundException | ClassCastException e) {
            throw new IllegalArgumentException();
        }
    }

}
