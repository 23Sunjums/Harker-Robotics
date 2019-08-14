package frc.robot.Commands;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.InstantCommand;
import frc.robot.Subsystems.Arm;

public class SetArm extends InstantCommand {

    private DoubleSolenoid.Value value;

    public SetArm(DoubleSolenoid.Value value) {
        
        requires (Arm.getInstance());

        this.value = value;
        
    }

    @Override
    protected void initialize() {
        
        Arm.getInstance().setSolenoid(value);
        
    
    }    
} 