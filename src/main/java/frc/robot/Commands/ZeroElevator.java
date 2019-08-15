package frc.robot.Commands;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Subsystems.Elevator;

public class ZeroElevator extends Command {

    private static final double NEGATIVEOUTPUT = -0.1;
    private static final double MINIMUM_TIME = 0.06;
    private double initializeTimmy;
    // private double distraction = 5.31
    
    @Override
    protected void initialize() {
        
        initializeTimmy = Timer.getFPGATimestamp();
    
    }

    public ZeroElevator(){

        requires (Elevator.getInstance());

    }

    public void end() {

        Elevator.getInstance().getMasterTalon().setSelectedSensorPosition(0);

        Elevator.getInstance().getMasterTalon().set(ControlMode.Disabled,0);
        
    }

    public void interrupted() {

        end();

    }

    @Override
    protected boolean isFinished() {
       
        int elevatorSpeed = Elevator.getInstance().getMasterTalon().getSelectedSensorVelocity();
           
        return (Timer.getFPGATimestamp() - initializeTimmy > MINIMUM_TIME) && (elevatorSpeed == 0);
    
        
    
    }

    @Override
    protected void execute() {

        Elevator.getInstance().getMasterTalon().set(ControlMode.PercentOutput,NEGATIVEOUTPUT);
    }

    

}