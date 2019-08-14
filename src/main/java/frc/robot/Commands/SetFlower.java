package frc.robot.Commands;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.InstantCommand;
import frc.robot.Subsystems.Flower;

public class SetFlower extends InstantCommand {

    private DoubleSolenoid.Value value;

    public SetFlower(DoubleSolenoid.Value value) {

        requires (Flower.getInstance());

        this.value = value;

    }
    
    @Override
    protected void initialize() {
        
        Flower.getInstance().setSolenoid(value);

    }
}