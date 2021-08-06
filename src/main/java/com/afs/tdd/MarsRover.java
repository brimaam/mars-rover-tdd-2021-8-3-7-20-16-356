package com.afs.tdd;

public class MarsRover {
    RoverStatus status;

    private final String NORTH = "N";
    private final String SOUTH = "S";
    private final String EAST = "E";
    private final String WEST = "W";

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
            default:
                String[] act = command.split("");
                for (String action : act) executeCommand(action);

        }
    }

    private void moveRover() {
        int x = this.status.getLocationX();
        int y = this.status.getLocationY();
        String direction = this.status.getDirection();
        switch (direction) {
            case NORTH:
                y++;
                break;
            case SOUTH:
                y--;
                break;
            case EAST:
                x++;
                break;
            case WEST:
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
            case NORTH:
                direction = WEST;
                break;
            case SOUTH:
                direction = EAST;
                break;
            case EAST:
                direction = NORTH;
                break;
            case WEST:
                direction = SOUTH;
                break;
        }

        this.status = new RoverStatus(x, y, direction);
    }

    private void turnRight() {
        int x = this.status.getLocationX();
        int y = this.status.getLocationY();
        String direction = this.status.getDirection();

        switch (direction) {
            case NORTH:
                direction = EAST;
                break;
            case SOUTH:
                direction = WEST;
                break;
            case EAST:
                direction = SOUTH;
                break;
            case WEST:
                direction = NORTH;
                break;
        }

        this.status = new RoverStatus(x, y, direction);
    }
}
