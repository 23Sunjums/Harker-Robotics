package frc.robot.Commands;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Subsystems.Elevator;

public class ZeroElevator extends Command {

    private static final double NEGATIVEOUTPUT = -0.1;
     
    
    public ZeroElevator(){

        requires (Elevator.getInstance());

    }

    public void end() {

        Elevator.getInstance().getMasterTalon().set(ControlMode.Disabled,0);
        
    }

    public void interrupted() {

        end();

    }

    @Override
    protected boolean isFinished() {
       
        int elevatorSpeed = Elevator.getInstance().getMasterTalon().getSelectedSensorVelocity();

        Elevator.getInstance().getMasterTalon().getSelectedSensorVelocity();
           
        return elevatorSpeed == 0;
    }

    @Override
    protected void execute() {

        Elevator.getInstance().getMasterTalon().set(ControlMode.PercentOutput,NEGATIVEOUTPUT);
    }

    

}