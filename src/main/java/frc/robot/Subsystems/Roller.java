package frc.robot.Subsystems;

import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.Commands.MoveWristPercentOutput;
import harkerrobolib.wrappers.HSTalon;

public class Roller extends Subsystem {
    
    private static Roller instance;
    
    private static HSTalon talonWristRoller;
    private static VictorSPX victorArmRoller;

    private static final boolean talonWristRollerInverted = false;
    private static final boolean victorArmRollerInverted = false;

    public static Roller getInstance() {

        if (instance == null) {

            instance = new Roller();
        }        
        return instance;
    }

    private Roller(){

        talonWristRoller = new HSTalon(RobotMap.TALON_WRIST_ROLLER);
        victorArmRoller = new VictorSPX(RobotMap.VICTOR_ARM_ROLLER);
    }


    public HSTalon getTalonWristRoller(){

        return talonWristRoller;
    }

    public VictorSPX getVictorArmRoller(){

        return victorArmRoller;
    }

    private void taloninit(){

        getTalonWristRoller().configFactoryDefault();
        getVictorArmRoller().configFactoryDefault();
        getTalonWristRoller().setInverted(talonWristRollerInverted);
        getVictorArmRoller().setInverted(victorArmRollerInverted);
    }

    public void initDefaultCommand(){

        setDefaultCommand(new MoveWristPercentOutput());
    }
    

}