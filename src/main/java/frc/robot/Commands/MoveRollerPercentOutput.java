package frc.robot.Commands;

import com.ctre.phoenix.motorcontrol.ControlMode;
import frc.robot.Subsystems.Roller;
import harkerrobolib.commands.IndefiniteCommand;
import frc.robot.OI;

public class MoveRollerPercentOutput extends IndefiniteCommand {


    private static final double armRollerSpeed = 0.4;
    private static final double wristRollerSpeed = 0.51;

    public MoveRollerPercentOutput(){

        requires (Roller.getInstance());
    } 
    
    public void end(){

        Roller.getInstance().getTalonWristRoller().set(ControlMode.Disabled,0);

    }

    public void interrupted(){

        end();

    }

    @Override
    protected void execute() {
        
        double output;

        double LeftTrigger = OI.getInstance().getDriver().getLeftTrigger();
        double RightTrigger = OI.getInstance().getDriver().getRightTrigger();
        
        if(LeftTrigger != 0 && RightTrigger != 0) {

            output = 0;
        }
        else if (LeftTrigger != 0){

            output = LeftTrigger;
            
        }
        
        else {
            
            output = -RightTrigger;

        }

        Roller.getInstance().getTalonWristRoller().set(ControlMode.PercentOutput,(output)*(wristRollerSpeed));

        Roller.getInstance().getVictorArmRoller().set(ControlMode.PercentOutput, (output)*(armRollerSpeed));        
    
    }

}