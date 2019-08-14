package frc.robot.Subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

public class Arm extends Subsystem {

    public void initDefaultCommand(){}

    public static final DoubleSolenoid.Value EXTENDED = DoubleSolenoid.Value.kForward;
    public static final DoubleSolenoid.Value RETRACED = DoubleSolenoid.Value.kReverse;
    
    private DoubleSolenoid solenoid;

    private static Arm instance;

    public static Arm getInstance(){
        if(instance==null){
            instance = new Arm();
        }
        return instance;      
          
    }

    private Arm(){
    
       solenoid = new DoubleSolenoid(RobotMap.FORWARD_ARM, RobotMap.REVERSE_ARM);
       
    }

    public void setSolenoid(DoubleSolenoid.Value Value){

       solenoid.set(Value);

               
    }

    public DoubleSolenoid getSolenoid() {

        return solenoid;     
        
        

    }
}



