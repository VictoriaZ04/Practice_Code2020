package frc.robot.commands.auto;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Constants;
import frc.robot.commands.MoveForward;

public class ForwardDrop extends CommandBase //do a CommandGroup
{
    public ForwardDrop(){}
    
    public void execute()
    {
        new SequentialCommandGroup(new MoveForward(5.0), new MoveArmAuto(Constants.INTAKE_SPEED_OUT, 5.0));
    }

    public void end(){}

    public boolean isFinished()
    {
        return true;
    }
}