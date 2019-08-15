package frc.robot.Subsystems;

import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import harkerrobolib.wrappers.HSTalon;

public class Wrist extends Subsystem{

    private HSTalon masterTalonWrist;
    private VictorSPX followerVictorWrist;

    private static Wrist instance;
    
    private static final boolean masterTalonWristInverted = false;
    private static final boolean followerVictorWristInverted = false;
    
    public static Wrist getInstance(){

        if (instance == null){

            instance = new Wrist();            

        }

        return instance; 
    }
  
    private Wrist(){

        masterTalonWrist = new HSTalon(RobotMap.MASTER_TALON_WRIST);
        followerVictorWrist = new VictorSPX(RobotMap.FOLLOWER_TALON_WRIST);
    }
  
    public HSTalon getMasterTalonWrist(){
        
        return masterTalonWrist;
        
    }

    public VictorSPX getFollowerVictorWrist(){


        return followerVictorWrist;
    }



    private void taloninit() {
        getMasterTalonWrist().configFactoryDefault();
        getFollowerVictorWrist().configFactoryDefault();
        getMasterTalonWrist().setInverted(masterTalonWristInverted);
        getFollowerVictorWrist().setInverted(followerVictorWristInverted);
        
        
    }
    
    public void initDefaultCommand(){

   //     setDefaultCommand();

    }
}