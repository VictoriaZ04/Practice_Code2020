/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants.  This class should not be used for any other purpose.  All constants should be
 * declared globally (i.e. public static).  Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    public static int LEFT_TOP_MOTOR = 0;
    public static int LEFT_BOTTOM_MOTOR = 0;
    public static int RIGHT_TOP_MOTOR = 0;
    public static int RIGHT_BOTTOM_MOTOR = 0;
    public static int ARM_MOTOR_PORT = 0;
    public static int ARM_POT_PORT = 0;
    public static int WRIST_MOTOR_PORT = 0;
    public static int WRIST_POT_PORT = 0;
    public static int INTAKE_MOTOR_LEFT_PORT = 0;
    public static int INTAKE_MOTOR_RIGHT_PORT = 0;
    public static int SOLENOID_PORT = 0;

    public static double ARM_UPPER_LIMIT = 69;
    public static double ARM_LOWER_LIMIT = 109.5;
    public static double WRIST_UPPER_LIMIT = 5.5;
    public static double WRIST_LOWER_LIMIT = 56.4;

    public static final int ARM_UP_BUTTON = 0;
    public static final int ARM_DOWN_BUTTON = 0;
    public static final int WRIST_UP_BUTTON = 0;
    public static final int WRIST_DOWN_BUTTON = 0;
    public static final int INTAKE_IN_BUTTON = 0;
    public static final int INTAKE_OUT_BUTTON = 0;
    public static final int HATCH_BUTTON = 0;

    public static double ARM_SPEED = 0.0;
    public static double WRIST_SPEED = 0.0;
    public static double INTAKE_SPEED_IN = 0.0;
    public static double INTAKE_SPEED_OUT = 0.0;

}
