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
        if (direction.equals("N")) {
            y++;
        } else if (direction.equals("S")) {
            y--;
        } else if (direction.equals("E")) {
            x++;
        }
        this.status = new RoverStatus(x, y, direction);
    }

    private void turnLeft() {
        int x = this.status.getLocationX();
        int y = this.status.getLocationY();
        String direction = this.status.getDirection();

        if (direction.equals("N")) {
            direction = "W";
        } else  if (direction.equals("S")){
            direction = "E";
        }

        this.status = new RoverStatus(x, y, direction);
    }

    private void turnRight() {
        int x = this.status.getLocationX();
        int y = this.status.getLocationY();
        String direction = this.status.getDirection();

        if (direction.equals("N")) {
            direction = "E";
        } else if (direction.equals("S")){
            direction = "W";
        }

        this.status = new RoverStatus(x, y, direction);
    }

}
