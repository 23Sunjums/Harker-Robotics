package frc.robot.Subsystems;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import harkerrobolib.wrappers.HSTalon;
import frc.robot.Commands.MoveWristPercentOutput;

public class Wrist extends Subsystem {

    private HSTalon masterTalonWrist;
    private VictorSPX followerVictorWrist;

    private static Wrist instance;
    
    private static final boolean masterTalonWristInverted = false;
    private static final boolean followerVictorWristInverted = false;

    private static final boolean SensorPhase = false;
    
    public static Wrist getInstance(){

        if (instance == null){

            instance = new Wrist();            

        }

        return instance; 
    }
  
    private Wrist() {

        masterTalonWrist = new HSTalon(RobotMap.MASTER_TALON_WRIST);
        followerVictorWrist = new VictorSPX(RobotMap.FOLLOWER_TALON_WRIST);
    }
  
    public HSTalon getMasterTalonWrist() {
        
        return masterTalonWrist;
        
    }

    public VictorSPX getFollowerVictorWrist() {


        return followerVictorWrist;
    }

    private void taloninit() {
        getMasterTalonWrist().configFactoryDefault();
        getFollowerVictorWrist().configFactoryDefault();
        getMasterTalonWrist().setInverted(masterTalonWristInverted);
        getFollowerVictorWrist().setInverted(followerVictorWristInverted);
        getFollowerVictorWrist().follow(getMasterTalonWrist());
        getMasterTalonWrist().configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Absolute);
        getMasterTalonWrist().setSensorPhase(SensorPhase);
        getMasterTalonWrist().setSelectedSensorPosition(0);
    }
    


    public void initDefaultCommand() {

       setDefaultCommand(new MoveWristPercentOutput());

    }
}