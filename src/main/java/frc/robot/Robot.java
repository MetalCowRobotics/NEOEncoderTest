/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.lib14.XboxControllerMetalCow;
import edu.wpi.first.wpilibj.TimedRobot;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  /**
   * This function is run when the robot is first started up and should be used
   * for any initialization code.
   */

  private CANSparkMax leftMotor;
  private CANSparkMax rightMotor;
  private DifferentialDrive m_myRobot;
  private static final int leftDeviceID = 1;
  private static final int rightDeviceID = 2;
  private static final XboxControllerMetalCow driver = new XboxControllerMetalCow(0);

  @Override
  public void robotInit() {
    // leftMotor = new CANSparkMax(1, MotorType.kBrushless);
    // rightMotor = new CANSparkMax(2, MotorType.kBrushless);
    // m_myRobot = new DifferentialDrive(leftMotor, rightMotor);
    leftMotor = new CANSparkMax(leftDeviceID, MotorType.kBrushless);
    rightMotor = new CANSparkMax(rightDeviceID, MotorType.kBrushless);
  }

  @Override
  public void autonomousInit() {
  }

  @Override
  public void autonomousPeriodic() {
  }

  @Override
  public void teleopInit() {
    
  }

  @Override
  public void teleopPeriodic() {

  }

  @Override
  public void testInit() {
  }

  @Override
  public void testPeriodic() {
    double speed = driver.getLT();
    leftMotor.set(speed);
    rightMotor.set(speed);
    if (driver.getAButton()){
      leftMotor.stopMotor();
      rightMotor.stopMotor();
    }
  }

}
