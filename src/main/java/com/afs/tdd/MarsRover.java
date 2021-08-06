package com.afs.tdd;

import java.util.Arrays;
import java.util.List;

public class MarsRover {
    RoverStatus status;
    private final List<String> DIRECTIONS = Arrays.asList("N","W","S","E");

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

        if(DIRECTIONS.get(0).equals(direction)){
            y++;
        } else if (DIRECTIONS.get(1).equals(direction)) {
            x--;
        } else if (DIRECTIONS.get(2).equals(direction)) {
            y--;
        } else if (DIRECTIONS.get(3).equals(direction)) {
            x++;
        }

        this.status = new RoverStatus(x, y, direction);
    }

    private void turnLeft() {
        int index = DIRECTIONS.indexOf(status.getDirection());
        int size = DIRECTIONS.size();
        String newDirection = DIRECTIONS.get((index + 1) % size);

        this.status = new RoverStatus(status.getLocationX(), status.getLocationY(), newDirection);
    }

    private void turnRight() {
        int index = DIRECTIONS.indexOf(this.status.getDirection());
        int size = DIRECTIONS.size();
        String newDirection = DIRECTIONS.get((index - 1 + size) % size);

        this.status = new RoverStatus(status.getLocationX(), this.status.getLocationY(), newDirection);
    }
}
