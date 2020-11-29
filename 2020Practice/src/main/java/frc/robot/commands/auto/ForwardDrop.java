package frc.robot.commands.auto;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.commands.MoveForward;

public class ForwardDrop extends CommandBase //do a CommandGroup
{
    double startTime = Timer.getFPGATimestamp();
    double time = 10;
    boolean intake = false;
    public ForwardDrop()
    {
    }
    
    public void execute()
    {
        new MoveForward(5.0);
        if(Timer.getFPGATimestamp() > startTime + 5 && !intake)
        {
            RobotContainer.getIntake().move(Constants.INTAKE_SPEED_OUT);
        }
    }

    public void end()
    {
        RobotContainer.getIntake().stopMotor();
    }

    public boolean isFinished()
    {
        return Timer.getFPGATimestamp() > startTime + 7;
    }
}