package Module3.ObjectsClasses.Lesson3;

public class Robot {
    public enum Direction {
        UP,
        DOWN,
        LEFT,
        RIGHT
    }

    public Direction getDirection() {
        return Direction.DOWN;
    }

    public int getX() {
        return 0;
    }

    public int getY() {
        return 0;
    }

    public void turnLeft() {
        // повернуться на 90 градусов против часовой стрелки
    }

    public void turnRight() {
        // повернуться на 90 градусов по часовой стрелке
    }

    public void stepForward() {
        // шаг в направлении взгляда
        // за один шаг робот изменяет одну свою координату на единицу
    }

    public static void moveRobot(Robot robot, int toX, int toY) {
        while (robot.getX() < toX){
            while (!robot.getDirection().equals(Direction.RIGHT)) {
                robot.turnRight();
            }
            robot.stepForward();
        }
        while (robot.getX() > toX){
            while (!robot.getDirection().equals(Direction.LEFT)) {
                robot.turnRight();
            }
            robot.stepForward();
        }
        while (robot.getY() > toY){
            while (!robot.getDirection().equals(Direction.DOWN)) {
                robot.turnRight();
            }
            robot.stepForward();
        }
        while (robot.getY() < toY){
            while (!robot.getDirection().equals(Direction.UP)) {
                robot.turnRight();
            }
            robot.stepForward();
        }
    }
}
