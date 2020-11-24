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
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.Button;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.commands.ExampleCommand;
import frc.robot.commands.MoveArm;
import frc.robot.commands.MoveHatch;
import frc.robot.commands.MoveIntake;
import frc.robot.commands.MoveWrist;
import frc.robot.commands.auto.ForwardDrop;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.Hatch;
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
  private static SteelTalonsController leftTop,leftBottom,rightTop,rightBottom; //SpeedController
  private static DifferentialDrive drive;
  private static SteelTalonsControllerGroup left, right;

  private static SteelTalonsController arm_motor;
  public static AnalogPotentiometer armpot;

  private static SteelTalonsController wrist_motor;
  public static AnalogPotentiometer wristpot;

  private static SteelTalonsController intake_motor_left;
  private static SteelTalonsController intake_motor_right;

  private static Solenoid solenoid;

  private static DriveTrain driveTrain;
  private static Arm arm;
  private static Wrist wrist;
  private static Hatch hatch;
  private static Intake intake;
  // The robot's subsystems and commands are defined here...


  /**
   * The container for the robot. Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    leftTop = new SteelTalonsController(Constants.LEFT_TOP_MOTOR, false, 1);
    leftBottom = new SteelTalonsController(Constants.LEFT_BOTTOM_MOTOR,false,1);
    rightTop = new SteelTalonsController(Constants.RIGHT_TOP_MOTOR,false,1);
    rightBottom = new SteelTalonsController(Constants.RIGHT_BOTTOM_MOTOR,false,1);

    left = new SteelTalonsControllerGroup(0,false,leftTop, leftBottom);
    right = new SteelTalonsControllerGroup(0,false,rightTop, rightBottom);
    drive = new DifferentialDrive(left, right);

    //initialize drive train

    arm_motor = new SteelTalonsController(Constants.ARM_MOTOR_PORT, false, 1);
    armpot = new AnalogPotentiometer(Constants.ARM_POT_PORT);

    //initialize arm 

    wrist_motor = new SteelTalonsController(Constants.WRIST_MOTOR_PORT, false, 1);
    wristpot = new AnalogPotentiometer(Constants.WRIST_POT_PORT);

    //initialize wrist
    
    intake_motor_left = new SteelTalonsController(Constants.INTAKE_MOTOR_LEFT_PORT, false, 1);
    intake_motor_right = new SteelTalonsController(Constants.INTAKE_MOTOR_RIGHT_PORT, false, 1);

    //initalize wrist

    solenoid = new Solenoid(Constants.SOLENOID_PORT);

    //initalize hatch
    driveTrain = new DriveTrain(left, right, drive);
    arm = new Arm(arm_motor);
    wrist = new Wrist(wrist_motor);
    hatch = new Hatch(solenoid);
    intake = new Intake(intake_motor_left, intake_motor_right);
    

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
    Button armButton_Up = new JoystickButton(getJoy(), Constants.ARM_UP_BUTTON);
    Button armButton_Down = new JoystickButton(getJoy(), Constants.ARM_DOWN_BUTTON);
    Button wristButton_Up = new JoystickButton(getJoy(), Constants.WRIST_UP_BUTTON);
    Button wristButton_Down = new JoystickButton(getJoy(), Constants.WRIST_DOWN_BUTTON);
    Button intakeButton_In = new JoystickButton(getJoy(), Constants.INTAKE_IN_BUTTON);
    Button intakeButton_Out = new JoystickButton(getJoy(), Constants.INTAKE_OUT_BUTTON);
    Button hatchButton = new JoystickButton(getJoy(), Constants.HATCH_BUTTON);

    armButton_Up.whileHeld(new MoveArm(Constants.ARM_SPEED,false));
    armButton_Down.whileHeld(new MoveArm(-Constants.ARM_SPEED,true));
    wristButton_Up.whileHeld(new MoveWrist(Constants.WRIST_SPEED,false));
    wristButton_Down.whileHeld(new MoveWrist(-Constants.WRIST_SPEED,true));
    intakeButton_In.whileHeld(new MoveIntake(Constants.INTAKE_SPEED_IN,true));
    intakeButton_Out.whileHeld(new MoveIntake(-Constants.INTAKE_SPEED_OUT,false));//add boolean parameters
    hatchButton.whenPressed(new MoveHatch());

  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    return new ForwardDrop();
  }

  public static Joystick getJoy() {return joy;}
  public static Arm getArm() {return arm;}
  public static Wrist getWrist() {return wrist;}
  public static Intake getIntake() {return intake;}
  public static Hatch getHatch() {return hatch;}
  public static DriveTrain geDriveTrain(){return driveTrain;}

}
