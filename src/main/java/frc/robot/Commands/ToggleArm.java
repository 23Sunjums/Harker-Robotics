package frc.robot.Commands;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.InstantCommand;
import frc.robot.Subsystems.Arm;

public class ToggleArm extends InstantCommand {
    
    public ToggleArm() {
        
        requires(Arm.getInstance());

    }   

    @Override
    protected void initialize() {
        DoubleSolenoid.Value value = Arm.getInstance().getSolenoid().get();

        if (value == Arm.EXTENDED){
        
            Arm.getInstance().setSolenoid(Arm.RETRACED);
        
        }

        else {
        
            Arm.getInstance().setSolenoid(Arm.EXTENDED);
    
        }
}

}