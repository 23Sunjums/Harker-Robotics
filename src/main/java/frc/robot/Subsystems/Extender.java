package frc.robot.Subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.Subsystems.Extender;

public class Extender extends Subsystem {

    public void initDefaultCommand(){}


    public static final DoubleSolenoid.Value OUT = DoubleSolenoid.Value.kForward;
    public static final DoubleSolenoid.Value IN = DoubleSolenoid.Value.kReverse;
    

    private static Extender instance;

    private DoubleSolenoid solenoid;

    public static Extender getInstance(){

        if(instance == null){
            instance = new Extender();
        }
            return instance;
    }
    
    private Extender(){

        solenoid = new DoubleSolenoid(RobotMap.FORWARD_EXTENDER, RobotMap.REVERSE_EXTENDER);
        
    }

    public void setSolenoid(DoubleSolenoid.Value value){

        solenoid.set(value);

    }

    
    public DoubleSolenoid getSolenoid(){

        return solenoid;
        
    }
}
