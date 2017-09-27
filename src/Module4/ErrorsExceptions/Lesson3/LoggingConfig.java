package Module4.ErrorsExceptions.Lesson3;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.XMLFormatter;

public class LoggingConfig {
    private static void configureLogging() {
        Logger classALogger =
                Logger.getLogger("org.stepic.java.logging.ClassA");
        Logger classBLogger =
                Logger.getLogger("org.stepic.java.logging.ClassB");
        classALogger.setLevel(Level.ALL);
        classBLogger.setLevel(Level.WARNING);
        Logger.getLogger("org.stepic.java").setLevel(Level.ALL);
        Logger.getLogger("org.stepic.java").setUseParentHandlers(false);
        ConsoleHandler handler = new ConsoleHandler();
        handler.setLevel(Level.ALL);
        handler.setFormatter(new XMLFormatter());
        Logger.getLogger("org.stepic.java").addHandler(handler);
        Path path = Paths.get("/");
    }
}
