package org.usfirst.frc.team5427.robot.subsystems;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class DriveTrain extends Subsystem{
    SpeedControllerGroup driveLeft;
    SpeedControllerGroup driveRight;
    DifferentialDrive drive;
    public void driveTrain(SpeedControllerGroup drive_Left, SpeedControllerGroup drive_Right, DifferentialDrive drive){
        this.driveLeft = drive_Left;
        this.driveRight = drive_Right;
    }


    @Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
    }
    public void joystick(Joystick joy){
        drive.tankDrive(joy.getY() * .70, -joy.getZ() * 0.75;
    }
    public void tankDrive(double left_speed, double right_speed){
        drive_Left.set(left_speed);
        drive_Right.set(right_speed);
    }
    public void stopMotor(){
        drive.stopMotor();
    }
}