package Module4.ErrorsExceptions.Lesson2.RobotConnections;

public class RobotConnections {
    public interface RobotConnection extends AutoCloseable {
        void moveRobotTo(int x, int y);
        @Override
        void close();
    }

    public interface RobotConnectionManager {
        RobotConnection getConnection();
    }

    public class RobotConnectionException extends RuntimeException {

        public RobotConnectionException(String message) {
            super(message);

        }

        public RobotConnectionException(String message, Throwable cause) {
            super(message, cause);
        }
    }

    public static void moveRobot(RobotConnectionManager robotConnectionManager, int toX, int toY) {
        boolean success = false;
        for (int i = 0; i < 3; i++) {
            if (success)
                break;
            try (RobotConnection connection = robotConnectionManager.getConnection()){
                connection.moveRobotTo(toX, toY);
                success = true;
            } catch (RobotConnectionException e) {
                if(i == 2) {
                    throw e;
                }
            }
        }
    }
}
