package frc.robot.Subsystems;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import frc.robot.RobotMap;
import frc.robot.Commands.DriveWithPercentOutput;
import harkerrobolib.subsystems.HSDrivetrain;
import harkerrobolib.wrappers.HSTalon;

public class Drivetrain extends HSDrivetrain{
    
    private static Drivetrain instance;
    private static final boolean leftVictorInverted = true;
    private static final boolean rightVictorInverted = false;
    private static final boolean leftTalonInverted = true;
    private static final boolean rightTalonInverted = false;
    private static final boolean leftSensorPhase = false;
    private static final boolean rightSensorPhase = false; 
    
    private static final double voltage = 10;        
   
    private static final double rightPositionP = 0;
    private static final double rightPositionI = 0;
    private static final double rightPositionD = 0;
    
    private static final double leftPositionP = 0;
    private static final double leftPositionI = 0;
    private static final double leftPositionD = 0;
    
    public static final int positionSlot = 0;
    
    public static final int ALLOWABLE_ERROR = 300;
    
    public Drivetrain() {
        super(new HSTalon(RobotMap.TALON_L), new HSTalon(RobotMap.TALON_R),
              new VictorSPX(RobotMap.VICTOR_R), new VictorSPX(RobotMap.VICTOR_L));
        talonInit();
    }
    
    public static Drivetrain getInstance() {
        if(instance==null)  {
            instance = new Drivetrain();
        }
        return instance;
    }

    private void talonInit() {
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
        
        getLeftMaster().configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Absolute);
        getRightMaster().configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Absolute);
        
        getLeftMaster().setSensorPhase(leftSensorPhase);
        getRightMaster().setSensorPhase(rightSensorPhase);
        setupVoltageComp();
        setupPositionPID();

    }
    

    private void setupPositionPID() {
    
        getRightMaster().config_kP(positionSlot, rightPositionP);
        getLeftMaster().config_kP(positionSlot,leftPositionP);

        getRightMaster().config_kI(positionSlot, rightPositionI);
        getLeftMaster().config_kI(positionSlot,leftPositionI);

        getRightMaster().config_kD(positionSlot,rightPositionD);
        getLeftMaster().config_kD(positionSlot,leftPositionD);
    }

    private void setupVoltageComp() {
        getLeftMaster().configVoltageCompSaturation(voltage);
        getRightMaster().configVoltageCompSaturation(voltage); 
    
        getLeftMaster().enableVoltageCompensation(true);
        getRightMaster().enableVoltageCompensation(true);
    }
    
    
    
    
    
    
    
    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new DriveWithPercentOutput());

    }
}

















