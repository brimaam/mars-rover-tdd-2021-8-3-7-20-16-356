public class MarsRover {
    RoverStatus status;

    public MarsRover(RoverStatus status) {
        this.status = status;
    }

    public RoverStatus getStatus() {
        return status;
    }

    public void executeCommand(String command) {
        if(command.equals("M")){
            moveRover();
        }
    }

    private void moveRover() {
        int x = this.status.getLocationX();
        int y = this.status.getLocationY();
        String direction = this.status.getDirection();
        this.status = new RoverStatus(x,y + 1,direction);
    }
}
