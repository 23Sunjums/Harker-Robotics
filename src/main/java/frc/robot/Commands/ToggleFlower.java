package frc.robot.Commands;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.InstantCommand;
import frc.robot.Subsystems.Flower;

public class ToggleFlower extends InstantCommand{

    public ToggleFlower(){

        requires(Flower.getInstance());

    }    

    @Override
    protected void initialize() {
    
        DoubleSolenoid.Value value = Flower.getInstance().getSolenoid().get();

        if (value == Flower.OPEN){
        
            Flower.getInstance().setSolenoid(Flower.OPEN);
        
        }

        else {
        
            Flower.getInstance().setSolenoid(Flower.CLOSE);
    
        }

    }

}