package frc.robot.Subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

public class Flower extends Subsystem {

    public void initDefaultCommand(){}


    public static final DoubleSolenoid.Value OPEN = DoubleSolenoid.Value.kForward;
    public static final DoubleSolenoid.Value CLOSE = DoubleSolenoid.Value.kReverse;
    
    private static Flower instance;
    
    private DoubleSolenoid solenoid;

    public static Flower getInstance(){
        if(instance==null){
            instance = new Flower();
        
        }
        return instance;
    }

    private Flower(){

        solenoid = new DoubleSolenoid(RobotMap.FORWARD_FLOWER, RobotMap.REVERSE_FLOWER);
       

    }

    public void setSolenoid(DoubleSolenoid.Value value){


        solenoid.set(value);
    }

    public DoubleSolenoid getSolenoid(){

        return solenoid;
            
    }

    

}