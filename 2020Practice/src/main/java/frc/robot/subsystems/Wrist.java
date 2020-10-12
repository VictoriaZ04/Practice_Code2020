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

public class Wrist extends SubsystemBase {
    SpeedController wrist;
    public Wrist(SpeedController wrist) {
      this.wrist = wrist;
  }

  public void move(double speed){
    if(RobotContainer.wristpot.get() <= Constants.WRIST_UPPER_LIMIT || RobotContainer.wristpot.get() >= Constants.WRIST_LOWER_LIMIT){
        wrist.set(speed);
    }
    else{
        wrist.set(0);
    }
  }

  public void stopMotor(){
        wrist.set(0);
    }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  

}