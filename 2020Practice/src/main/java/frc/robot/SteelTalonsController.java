package frc.robot;

import edu.wpi.first.wpilibj.PWMVictorSPX;

public class SteelTalonsController extends PWMVictorSPX
{
    private final double bias;

    public SteelTalonsController(final int channel, final boolean reverse, final double bias){
        super(channel);
        this.bias = bias;
        setInverted(reverse);
    }

    public void set(final int speed)
    {        
            super.set(speed * bias);
    }

}