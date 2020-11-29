package frc.robot.commands;


import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

public class MoveForward extends CommandBase
{
    double startTime = Timer.getFPGATimestamp();
    double time;
    public MoveForward(double time)
    {
        this.time = time;
    }
    
    @Override
    public void execute()
    {
        RobotContainer.geDriveTrain().tankDrive(.5, .5);//add booleans here
    }

    @Override
    public void end(boolean interrupted)
    {
        RobotContainer.geDriveTrain().stopMotor();
    }

    @Override
    public boolean isFinished()
    {
        return Timer.getFPGATimestamp() > (startTime + time);
    }
}