package frc.robot.Commands;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.InstantCommand;
import frc.robot.Subsystems.Extender;

public class ToggleExtender extends InstantCommand {
    
    public ToggleExtender(){

        requires(Extender.getInstance());

    }
    
    @Override
    protected void initialize() {
        DoubleSolenoid.Value value = Extender.getInstance().getSolenoid().get();
        
        if (value == Extender.OUT){
         
            Extender.getInstance().setSolenoid(Extender.IN);
        }
        else {
            
            Extender.getInstance().setSolenoid(Extender.OUT;
            
        }        
        
    }
}