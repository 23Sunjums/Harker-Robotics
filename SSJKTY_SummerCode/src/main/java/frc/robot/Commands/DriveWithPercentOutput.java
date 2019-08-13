
package frc.robot.Commands;

import com.ctre.phoenix.motorcontrol.ControlMode;

import frc.robot.OI;
import frc.robot.Subsystems.Drivetrain;
import harkerrobolib.commands.IndefiniteCommand;

public class DriveWithPercentOutput extends IndefiniteCommand {

    public DriveWithPercentOutput(){
        
        requires(Drivetrain.getInstance());
    }



@Override
protected void execute() {
    
    double LeftX = OI.getInstance().getDriver().getLeftX();
    double LeftY = OI.getInstance().getDriver().getLeftY();
    
    Drivetrain.getInstance().getRightMaster().set(ControlMode.PercentOutput,LeftY-LeftX);
    Drivetrain.getInstance().getLeftMaster().set(ControlMode.PercentOutput,LeftY+LeftX);


}

}