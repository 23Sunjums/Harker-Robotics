package frc.robot.Commands;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.InstantCommand;
import frc.robot.Subsystems.Extender;

public class SetExtender extends InstantCommand {

    private DoubleSolenoid.Value value;
    
    public SetExtender(DoubleSolenoid.Value value) {

        requires (Extender.getInstance());

        this.value = value;

    }
    
    @Override
    protected void initialize() {
        
        Extender.getInstance().setSolenoid(value);

    }
}