import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MarsRoverTest {
    @Test
    void should_return_locationX_0_locationY_1_direction_N_when_execute_command_given_locationX_0_locationY_direction_N_and_M(){
        //given
        MarsRover marsRover = new MarsRover(new RoverStatus(0,0,"N"));
        RoverStatus expectedRoverStatus = new RoverStatus(0,1,"N");

        //when
        marsRover.executeCommand("M");

        //then
        assertEquals(expectedRoverStatus.getLocationX(), marsRover.getStatus().getLocationX());
        assertEquals(expectedRoverStatus.getLocationY(), marsRover.getStatus().getLocationY());
        assertEquals(expectedRoverStatus.getDirection(), marsRover.getStatus().getDirection());
    }
}