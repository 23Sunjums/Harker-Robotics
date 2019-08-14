package frc.robot.Commands;

import edu.wpi.first.wpilibj.DoubleSolenoid;

    
public class SetArm extends InstantCommand{

    private DoubleSolenoid.Value value;

    private SetArm(DoubleSolenoid.Value value) {
        
        requires (Arm.getInstance());

        this.value = value;
        
    }

    @Override
    protected void initialize() {
        
        Arm.getInstance().setSolenoid(value);
        
        
    
    }    
} 