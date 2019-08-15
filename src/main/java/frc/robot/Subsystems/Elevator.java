package frc.robot.Subsystems;

import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import harkerrobolib.wrappers.HSTalon;

public class Elevator extends Subsystem {

    
    private static final boolean masterTalonInverted = false;
    private static final boolean followerTalonInverted = false;
    private static final boolean lFollowerVictorInverted = false;
    private static final boolean rFollowerVictorIneverted = false;
    
    
    
    private static Elevator instance;

    private HSTalon masterTalon;
    private HSTalon followerTalon;
    private VictorSPX lFollowerVictor;
    private VictorSPX rFollowerVictor;

    public void initDefaultCommand() {
    
    public static Elevator getInstance() {
        if(instance==null) {
            instance = new Elevator();
        }
        return instance;
    }

    private Elevator() {

        masterTalon = new HSTalon(RobotMap.MASTER_TALON);
        followerTalon = new HSTalon(RobotMap.FOLLOWER_TALON);
        lFollowerVictor = new VictorSPX(RobotMap.LEFT_FOLLOWER_VICTOR);
        rFollowerVictor = new VictorSPX(RobotMap.RIGHT_FOLLOWER_VICTOR);
        talonInit();
        
    }  
    
    private void talonInit() {

        
        

        






    }

}

