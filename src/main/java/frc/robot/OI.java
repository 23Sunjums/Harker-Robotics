package frc.robot;

import frc.robot.Commands.DriveToPosition;
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

        getDriver().getButtonY().whenPressed(new DriveToPosition(12288));

        
        
    }
    
}