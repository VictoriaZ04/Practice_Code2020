/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.SteelTalonsController;

public class Arm extends SubsystemBase {
  public SteelTalonsController arm;

  public Arm(SteelTalonsController arm) {
    this.arm = arm;
  }

  public void move(double speed,boolean reverse) {
    if (RobotContainer.armpot.get() >= Constants.ARM_UPPER_LIMIT || RobotContainer.armpot.get() <= Constants.ARM_LOWER_LIMIT) {
      arm.set(speed);//switch these
    }
    else{
      arm.set(0);
    }
  }

  public void stopMotor(){
    arm.set(0);
    }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    //always check for limits here 
  }
  

}
