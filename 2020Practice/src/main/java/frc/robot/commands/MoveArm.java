/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import frc.robot.Constants;
import frc.robot.RobotContainer;
import edu.wpi.first.wpilibj2.command.CommandBase;

/**
 * An example command that uses an example subsystem.
 */
public class MoveArm extends CommandBase {
    double speed;
	public MoveArm(double speed ) {
        this.speed = speed;
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
    return RobotContainer.getJoy().getRawButtonPressed(Constants.ARM_DOWN_BUTTON) == false;
    //returns if button no longer pressed OR if you are at the limit (based on reverse)
  }
}
