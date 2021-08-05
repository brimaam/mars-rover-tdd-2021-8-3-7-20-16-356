public class MarsRover {
    RoverStatus status;

    public MarsRover(RoverStatus status) {
        this.status = status;
    }

    public RoverStatus getStatus() {
        return status;
    }

    public void executeCommand(String command) {
        switch (command) {
            case "M":
                moveRover();
                break;
            case "L":
                turnLeft();
                break;
            case "R":
                turnRight();
                break;
        }
    }

    private void moveRover() {
        int x = this.status.getLocationX();
        int y = this.status.getLocationY();
        String direction = this.status.getDirection();
        switch (direction) {
            case "N":
                y++;
                break;
            case "S":
                y--;
                break;
            case "E":
                x++;
                break;
            case "W":
                x--;
                break;
        }
        this.status = new RoverStatus(x, y, direction);
    }

    private void turnLeft() {
        int x = this.status.getLocationX();
        int y = this.status.getLocationY();
        String direction = this.status.getDirection();

        switch (direction) {
            case "N":
                direction = "W";
                break;
            case "S":
                direction = "E";
                break;
            case "E":
                direction = "N";
                break;
            case "W":
                direction = "S";
                break;
        }

        this.status = new RoverStatus(x, y, direction);
    }

    private void turnRight() {
        int x = this.status.getLocationX();
        int y = this.status.getLocationY();
        String direction = this.status.getDirection();

        switch (direction) {
            case "N":
                direction = "E";
                break;
            case "S":
                direction = "W";
                break;
            case "E":
                direction = "S";
                break;
            case "W":
                direction = "N";
                break;
        }

        this.status = new RoverStatus(x, y, direction);
    }

    public void executeCommands(String commands) {
        String[] command = commands.split("");
        for (String action : command) executeCommand(action);
    }
}
