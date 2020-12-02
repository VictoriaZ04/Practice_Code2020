package frc.robot.commands.auto;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

public class MoveArmAuto extends CommandBase
{
    double speed;
    double start = Timer.getFPGATimestamp();
    double time;
	public MoveArmAuto(double speed, double time) {
        this.speed = speed;
        this.time = time;
    }

    // Called when the command is initially scheduled.
     @Override
    public void initialize() {
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        RobotContainer.getArm().move(speed);
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        RobotContainer.getArm().stopMotor();
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return Timer.getFPGATimestamp() > (start + time);
    }
}