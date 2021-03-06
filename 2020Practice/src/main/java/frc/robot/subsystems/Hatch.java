package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Hatch extends SubsystemBase
{
    public Solenoid solenoid;
    public Hatch(Solenoid solenoid)
    {
        this.solenoid = solenoid;
    }

    public void moveHatch(boolean up)
    {
        solenoid.set(up);
    }
    

}