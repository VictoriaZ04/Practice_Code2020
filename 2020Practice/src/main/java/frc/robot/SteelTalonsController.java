package frc.robot;

import edu.wpi.first.wpilibj.PWMVictorSPX;

public class SteelTalonsController extends PWMVictorSPX
{
    private final double bias;
    private boolean reverse;

    public SteelTalonsController(final int channel, final boolean reverse, final double bias){
        super(channel);
        this.bias = bias;
        this.reverse = reverse;
        setInverted(reverse);
    }

    public void set(final double speed)
    {        

        super.set(speed * bias);
        
    }

}