package org.usfirst.frc.team5427.robot.subsystems;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveTrain extends SubsystemBase {
    SpeedControllerGroup driveLeft;
    SpeedControllerGroup driveRight;
    DifferentialDrive drive;
    public void driveTrain(SpeedControllerGroup drive_Left, SpeedControllerGroup drive_Right, DifferentialDrive drive){
        this.driveLeft = drive_Left;
        this.driveRight = drive_Right;
    }

    public void joystick(Joystick joy){
        drive.tankDrive(joy.getY() * .70, -joy.getZ() * 0.75);
    }
    public void tankDrive(double left_speed, double right_speed){
        driveLeft.set(left_speed);
        driveRight.set(right_speed);
    }
    public void stopMotor(){
        drive.stopMotor();
    }
}