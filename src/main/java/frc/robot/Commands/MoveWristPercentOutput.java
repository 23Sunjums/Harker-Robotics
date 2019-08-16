package frc.robot.Commands;
/** */
import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.OI;
import frc.robot.Subsystems.Wrist;
import harkerrobolib.commands.IndefiniteCommand;
import harkerrobolib.util.MathUtil;


public class MoveWristPercentOutput extends IndefiniteCommand {

    public static final double SPEEDMULTIPLIER = 0.22;
    
    public MoveWristPercentOutput() {

        requires (Wrist.getInstance());
    }

    public void end(){

        Wrist.getInstance().getMasterTalonWrist().set(ControlMode.Disabled,0);
        
    }

    public void interrupted(){
        
        end();
    }

    @Override
    protected void execute() {

        double RightX = OI.getInstance().getDriver().getRightX();
        
        RightX = MathUtil.mapJoystickOutput(RightX,0.1);

        Wrist.getInstance().getMasterTalonWrist().set(ControlMode.PercentOutput,(RightX)*(SPEEDMULTIPLIER));

        Wrist.getInstance().getMasterTalonWrist();

        SmartDashboard.putNumber("SetPosition",Wrist.getInstance().getMasterTalonWrist().getSelectedSensorPosition());

        

        
    }

}

