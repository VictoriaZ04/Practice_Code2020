package frc.robot;

import edu.wpi.first.wpilibj.PWMVictorSPX;

public class SteelTalonsControllerGroup extends PWMVictorSPX
{
    private final double bias;
    private boolean reverse;

    public SteelTalonsControllerGroup(final int channel, final boolean reverse, final double bias){
        super(channel);
        this.bias = bias;
        this.reverse = reverse;
        setInverted(reverse);
    }

    public void set(final double speed, boolean reverse)
    {        
        if(reverse)
            setInverted(!this.reverse);
        else
            setInverted(this.reverse);
        super.set(speed * bias);
        
    }

}