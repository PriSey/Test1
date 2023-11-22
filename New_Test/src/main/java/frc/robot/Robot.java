// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.I2C.Port;

import java.lang.ModuleLayer.Controller;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.motorcontrol.Victor;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj.Timer;

/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  Joystick myController = new Joystick(0);
  Victor driveLeftSpark = new Victor (3);
  Victor driveRightSpark = new Victor (2);
  Victor driveLeftVictor = new Victor (4);
  Victor driveRightVictor = new Victor (1);

  double autonomousStartTime;
  double timeElapsed;
  double leftspeed;
  double rightspeed;
  @Override
  public void robotInit() {}

  @Override
  public void robotPeriodic() {}

  @Override
  public void autonomousInit() {
    autonomousStartTime = Timer.getFPGATimestamp();
  }

  @Override
  public void autonomousPeriodic() {
    timeElapsed = Timer.getFPGATimestamp() - autonomousStartTime;
    if(timeElapsed < 5){
        driveLeftSpark.set(1.0);
        driveLeftVictor.set(1.0);
        driveRightSpark.set(-1.0);
        driveRightVictor.set(-1.0);

    }
    else if(timeElapsed < 5+2){
      driveLeftSpark.set(1.0);
      driveLeftVictor.set(1.0);
      driveRightSpark.set(1.0);
      driveRightVictor.set(1.0);
    }
  }

  @Override
  public void teleopInit() {
  }

  @Override
  public void teleopPeriodic() {
    leftspeed = myController.getRawAxis(5);
    rightspeed = myController.getRawAxis(2);
    driveLeftVictor.set(leftspeed);
    driveLeftSpark.set(leftspeed);
    driveRightVictor.set(rightspeed);
    driveRightSpark.set(rightspeed);
  }

  @Override
  public void disabledInit() {}

  @Override
  public void disabledPeriodic() {}

  @Override
  public void testInit() {}

  @Override
  public void testPeriodic() {}

  @Override
  public void simulationInit() {}

  @Override
  public void simulationPeriodic() {}
}
