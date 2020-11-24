/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.SteelTalonsController;

public class Intake extends SubsystemBase {
  public SteelTalonsController intake_left;
  public SteelTalonsController intake_right;


  public Intake(SteelTalonsController intake_motor_left, SteelTalonsController intake_motor_right) {
    this.intake_left = intake_motor_left;
    this.intake_right = intake_motor_right;

  }

  public void move(double speed, boolean reverse) {
      intake_left.set(speed,reverse);
      intake_right.set(speed,!reverse);
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
