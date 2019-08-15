package frc.robot;

import frc.robot.Commands.DriveToPosition;
import frc.robot.Commands.SetArm;
import frc.robot.Commands.ToggleArm;
import frc.robot.Commands.ToggleExtender;
import frc.robot.Commands.ToggleFlower;
import frc.robot.Subsystems.Arm;
import harkerrobolib.wrappers.XboxGamepad;

public class OI {

    private XboxGamepad driverGamepad;
    private XboxGamepad operatorGamepad;
    private static OI instance;

    public static final int driverPort = 0;
    public static final int operatorPort = 1;

    public OI() {

        driverGamepad = new XboxGamepad(driverPort);
        operatorGamepad = new XboxGamepad(operatorPort);
        initBinding();
        
    }
      
    public static OI getInstance() {
        if (instance==null){
            instance = new OI();
        }
        return instance;
    }

    public XboxGamepad getDriver() {
        return driverGamepad;
    }

    public XboxGamepad getOperator() {
        return operatorGamepad;
    }
    
    private void initBinding() {

        // getDriver().getButtonY().whenPressed(new DriveToPosition(12288));
        getDriver().getButtonBumperLeft().whenPressed(new SetArm(Arm.RETRACED));
        getDriver().getButtonBumperRight().whenPressed(new SetArm(Arm.EXTENDED));
        getDriver().getButtonA().whenPressed(new ToggleArm());
        getDriver().getButtonX().whenPressed(new ToggleFlower());
        getDriver().getButtonB().whenPressed(new ToggleExtender());
        
    }
}





























































/**    DOODLE ZONE
 <o/
 \o>
 <o/
 \o>
 <o/
 \o>
 <o/
 \o>
 <o/
 \o>
 <o/
 \o>
 <o/
 \o>
 <o/
 \o>               
 <o/
 \o>
 <o/
 \o>
 <o/
 \o>
 <o/
       ____________
     /|  o    o   |\
    /_|    /\     |_\
      | \_______/ |_____________________________
      |___________|                             \
           \                                  |\ \            __
            \             bruh                | \ \          / /
             \                                |  \ \        / /
              \_______________________________|   \ \______/ /
                                    \  \  /  /     \________/
                                     \  \/  /
                                      \  \ /
                                      /\  \
 \o>                                 /  \  \
 <o/                                     \__\
 \o>
 <o/
 \o>
 <o/
 \o>
 <o/
 \o>
 <o/
 \o>
 <*/