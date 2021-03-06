package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.DriveTrain;

public class DriveWithJoystick extends CommandBase
{
    public DriveWithJoystick()
    {

    }

    @Override
    public void initialize()
    {
        RobotContainer.geDriveTrain().joystick(RobotContainer.getJoy());
    }
    
    @Override
    public void execute()
    {
        RobotContainer.geDriveTrain().joystick(RobotContainer.getJoy());
    }
    
    @Override
    public void end(boolean interupted)
    {
        RobotContainer.geDriveTrain().stopMotor();
    }

    public boolean isFinished()
    {
        return false;
    }
}