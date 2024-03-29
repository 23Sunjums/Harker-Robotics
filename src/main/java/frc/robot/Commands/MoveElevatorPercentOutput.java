package frc.robot.Commands;

import com.ctre.phoenix.motorcontrol.ControlMode;
import frc.robot.OI;
import frc.robot.Subsystems.Elevator;
import harkerrobolib.commands.IndefiniteCommand;
import harkerrobolib.util.MathUtil;
import com.ctre.phoenix.motorcontrol.DemandType;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

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
        
        RightY = MathUtil.mapJoystickOutput(RightY,0.1);
        
        Elevator.getInstance().getMasterTalon().set(ControlMode.PercentOutput,
        (RightY)*(SPEEDMULTIPLIER),DemandType.ArbitraryFeedForward,Elevator.FF);

        SmartDashboard.putNumber("Elevator", Elevator.getInstance().getMasterTalon().getSelectedSensorPosition());

    }

}