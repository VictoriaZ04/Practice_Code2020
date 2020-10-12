/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Intake extends SubsystemBase {
  public SpeedController intake_left;
  public SpeedController intake_right;


  public Intake(SpeedController intake_left, SpeedController intake_right) {
    this.intake_left = intake_left;
    this.intake_right = intake_right;

  }

  public void move(double speed) {
      intake_left.set(speed);
      intake_right.set(-speed);
  }

  public void stopMotor(){
    intake_left.set(0);
    intake_right.set(0);
    }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  

}
