package frc.robot.Commands;

import com.ctre.phoenix.motorcontrol.ControlFrame;
import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.RobotMap;
import frc.robot.Subsystems.Drivetrain;

public class DriveToPosition extends Command {

    private int goToPosition;

    public DriveToPosition(int goToPosition) {
        
            requires(Drivetrain.getInstance());
            this.goToPosition = goToPosition;
        
    }
    
    @Override
    protected boolean isFinished() {
        return Math.abs( Drivetrain.getInstance().getLeftMaster().getClosedLoopError()) < Drivetrain.ALLOWABLE_ERROR;
        
    }

    @Override
    protected void initialize() {
        
        

        Drivetrain.getInstance().getLeftMaster().selectProfileSlot(Drivetrain.positionSlot, RobotMap.PRIMARY_INDEX);
        Drivetrain.getInstance().getRightMaster().selectProfileSlot(Drivetrain.positionSlot, RobotMap.PRIMARY_INDEX);
    }
/** 1 rotation = 4096 units
 * 1 rotation = 1 foot */
    @Override
    protected void execute() {
        Drivetrain.getInstance().getLeftMaster().set(ControlMode.Position, goToPosition);
        Drivetrain.getInstance().getRightMaster().set(ControlMode.Position, goToPosition);



    }
}

