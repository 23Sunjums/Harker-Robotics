package frc.robot.Subsystems;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.Commands.MoveElevatorPercentOutput;
import harkerrobolib.wrappers.HSTalon;

public class Elevator extends Subsystem {

    
    private static final boolean masterTalonInverted = true;
    private static final boolean followerTalonInverted = true;
    private static final boolean lFollowerVictorInverted = true;
    private static final boolean rFollowerVictorIneverted = true;
    
    public static final double FF = 0;

    private static Elevator instance;

    private HSTalon masterTalon;
    private HSTalon followerTalon;
    private VictorSPX lFollowerVictor;
    private VictorSPX rFollowerVictor;

    public void initDefaultCommand(){

        setDefaultCommand(new MoveElevatorPercentOutput());
    }
    
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
    
    public HSTalon getMasterTalon() {
        
        return masterTalon;
    }

    public HSTalon getFollowerTalon() {

        return followerTalon;
    }
    
    public VictorSPX getLFollowerVictor() {

        return lFollowerVictor;
    }
        
    public VictorSPX getRFollowerVictor() {
        
        return rFollowerVictor;

    }
    
    private void talonInit() {
        
        setDefaultCommand();

        getMasterTalon().configFactoryDefault();
        getFollowerTalon().configFactoryDefault();
        getLFollowerVictor().configFactoryDefault();
        getRFollowerVictor().configFactoryDefault();

        getFollowerTalon().follow(getMasterTalon());
        getLFollowerVictor().follow(getMasterTalon());
        getRFollowerVictor().follow(getMasterTalon());
        
        getMasterTalon().setInverted(masterTalonInverted);
        getFollowerTalon().setInverted(followerTalonInverted);
        getLFollowerVictor().setInverted(lFollowerVictorInverted);
        getRFollowerVictor().setInverted(rFollowerVictorIneverted);
                                    
        getMasterTalon().configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Absolute);
        
        getMasterTalon().setSelectedSensorPosition(0);

        

        
    }

    private void setDefaultCommand() {}

}
