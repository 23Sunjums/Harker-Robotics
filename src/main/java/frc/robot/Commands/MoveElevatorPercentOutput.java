package frc.robot.Commands;

import com.ctre.phoenix.motorcontrol.ControlMode;

import frc.robot.OI;
import frc.robot.Subsystems.Elevator;
import harkerrobolib.commands.IndefiniteCommand;
import harkerrobolib.util.MathUtil;

public class MoveElevatorPercentOutput extends IndefiniteCommand {

    
    public static final double SPEEDMULTIPLIER = 0.3;
    
    public MoveElevatorPercentOutput(){

        requires (Elevator.getInstance());
        
    } 

    public void end() {
        
        Elevator.getInstance().getMasterTalon().set(ControlMode.Disabled,0);
    }
    
    
    public void interrupted(){
        
        end();
    }

    @Override
    protected void execute() {
        
        double RightY = OI.getInstance().getDriver().getRightY();
        
        MathUtil.mapJoystickOutput(RightY,0.1);
        
        Elevator.getInstance().getMasterTalon().set(ControlMode.PercentOutput,(RightY)*(SPEEDMULTIPLIER));
    }

}