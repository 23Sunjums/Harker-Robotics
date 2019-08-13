package frc.robot.Subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import frc.robot.RobotMap;
import harkerrobolib.subsystems.HSDrivetrain;
import harkerrobolib.wrappers.HSTalon;

public class Drivetrain extends HSDrivetrain{
    
    private static Drivetrain instance;
    private static final boolean leftVictorInverted = true;
    private static final boolean rightVictorInverted = false;
    private static final boolean leftTalonInverted = false;
    private static final boolean rightTalonInverted = false;
    
    public Drivetrain() {
        super(new HSTalon(RobotMap.talonL), new HSTalon(RobotMap.talonR),
              new VictorSPX(RobotMap.victorR), new VictorSPX(RobotMap.victorL));
        talonInit();
    }
    
    public static Drivetrain getInstance() {
        if(instance==null)  {
            instance = new Drivetrain();
        }
        return instance;
    }

    private void talonInit(){
        getLeftMaster().configFactoryDefault();
        getRightMaster().configFactoryDefault();
        getLeftMaster().setInverted(leftTalonInverted);
        getRightMaster().setInverted(rightTalonInverted);
        getLeftFollower().setInverted(leftVictorInverted);
        getRightFollower().setInverted(rightVictorInverted);
        getLeftFollower().follow(getLeftMaster());
        getRightFollower().follow(getRightMaster());
        getLeftMaster().setNeutralMode(NeutralMode.Brake);
        getRightMaster().setNeutralMode(NeutralMode.Brake);
     }

    

    @Override
    protected void initDefaultCommand() {

    }
}