/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.XboxController.Button;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.commands.ExampleCommand;
import frc.robot.commands.MoveArm;
import frc.robot.commands.MoveIntake;
import frc.robot.commands.MoveWrist;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Wrist;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  static Joystick joy = new Joystick(0);
  private static SpeedController leftTop,leftBottom,rightTop,rightBottom;
  private static DifferentialDrive drive;
  private static SpeedControllerGroup left, right;

  private static SpeedController arm_motor;
  public static AnalogPotentiometer armpot;

  private static SpeedController wrist_motor;
  public static AnalogPotentiometer wristpot;

  private static SpeedController intake_motor_left;
  private static SpeedController intake_motor_right;



  // The robot's subsystems and commands are defined here...


  /**
   * The container for the robot. Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    leftTop = new WPI_VictorSPX(Constants.LEFT_TOP_MOTOR);
    leftBottom = new WPI_VictorSPX(Constants.LEFT_BOTTOM_MOTOR);
    rightTop = new WPI_VictorSPX(Constants.RIGHT_TOP_MOTOR);
    rightBottom = new WPI_VictorSPX(Constants.RIGHT_BOTTOM_MOTOR);

    left = new SpeedControllerGroup(leftTop, leftBottom);
    right = new SpeedControllerGroup(rightTop, rightBottom);
    drive = new DifferentialDrive(left, right);

    arm_motor = new WPI_VictorSPX(Constants.ARM_MOTOR_PORT);
    armpot = new AnalogPotentiometer(Constants.ARM_POT_PORT);
    wrist_motor = new WPI_VictorSPX(Constants.WRIST_MOTOR_PORT);
    wristpot = new AnalogPotentiometer(Constants.WRIST_POT_PORT);
    
    intake_motor_left = new WPI_VictorSPX(Constants.INTAKE_MOTOR_LEFT_PORT);
    intake_motor_right = new WPI_VictorSPX(Constants.INTAKE_MOTOR_RIGHT_PORT);

    
  
    

    // Configure the button bindings
    configureButtonBindings();
    
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be
   * created by instantiating a {@link GenericHID} or one of its subclasses
   * ({@link edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then
   * passing it to a {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    //Joystick joy = new Joystick(0);
    DriveTrain driveTrain = new DriveTrain(left, right, drive);
    JoystickButton armButton_Up = new JoystickButton(getJoy(), Constants.ARM_UP_BUTTON);
    JoystickButton armButton_Down = new JoystickButton(getJoy(), Constants.ARM_DOWN_BUTTON);
    JoystickButton wristButton_Up = new JoystickButton(getJoy(), Constants.WRIST_UP_BUTTON);
    JoystickButton wristButton_Down = new JoystickButton(getJoy(), Constants.WRIST_DOWN_BUTTON);
    JoystickButton intakeButton_In = new JoystickButton(getJoy(), Constants.INTAKE_IN_BUTTON);
    JoystickButton intakeButton_Out = new JoystickButton(getJoy(), Constants.INTAKE_OUT_BUTTON);

    armButton_Up.whileHeld(new MoveArm(Constants.ARM_SPEED));
    armButton_Down.whileHeld(new MoveArm(-Constants.ARM_SPEED));
    wristButton_Up.whileHeld(new MoveWrist(Constants.WRIST_SPEED));
    wristButton_Down.whileHeld(new MoveWrist(-Constants.WRIST_SPEED));
    intakeButton_In.whileHeld(new MoveIntake(Constants.INTAKE_SPEED_IN));
    intakeButton_Out.whileHeld(new MoveIntake(-Constants.INTAKE_SPEED_OUT));

  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_autoCommand;
  }

  public static Joystick getJoy() {return joy;}
  public static Arm getArm() {return new Arm(arm_motor);}
  public static Wrist getWrist() {return new Wrist(wrist_motor);}
  public static Intake getIntake() {return new Intake(intake_motor_left, intake_motor_right);}

}
