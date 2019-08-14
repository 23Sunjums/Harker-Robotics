package main.java.frc.robot.Subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;

public class Arm extends Subsystems {

    private static final DoubleSolenoid.Value EXTENDED = DoubleSolenoid.Value.kForward;
    private static final DoubleSolenoid.Value RETRACED = DoubleSolenoid.Value.kReverse;
    
    private DoubleSolenoid solenoid;

    private static Arm instance;

    public static Arm getInstance(){
        if(instance==null){
            instance = new Arm();
        }
        return instance;      
          
    }

    private Arm(){
    
       solenoid = new DoubleSolenoid(RobotMap.SOLENOID_EXTEND, RobotMap.SOLENOID_RETRACT);
       
    }

    public void setSolenoid(DoubleSolenoid.Value Value){

       solenoid.set(Value);

               
    }

    public DoubleSolenoid getSolenoid() {

        return solenoid;     
        
        

    }
}


/*







*/