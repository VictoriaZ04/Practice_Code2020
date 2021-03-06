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
public class MoveIntake extends CommandBase {
    double speed;
    boolean reverse;

	public MoveIntake(double speed ) {
        this.speed = speed;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    RobotContainer.getIntake().move(speed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    RobotContainer.getIntake().stopMotor();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if(speed > 0)
      return RobotContainer.getJoy().getRawButtonPressed(Constants.INTAKE_IN_BUTTON) == false; 
  
    return RobotContainer.getJoy().getRawButtonPressed(Constants.INTAKE_OUT_BUTTON) == false;
    //returns if button no longer pressed 
  }
}