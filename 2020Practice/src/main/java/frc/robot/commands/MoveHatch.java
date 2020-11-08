package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

public class MoveHatch extends CommandBase
{   public static boolean up = false;
    public MoveHatch()
    {}

    public void execute()
    {
        up = !up;
        RobotContainer.getHatch().moveHatch(up);
    }
    
    public boolean isFinished()
    {
        return true;
    }
}