/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {

  private Joystick m_stick;
  private static final int deviceID = 2;
  private CANSparkMax m_motor;
  private CANEncoder m_encoder;
  /**
   * This function is run when the robot is first started up and should be used
   * for any initialization code.
   */
  @Override
  public void robotInit() {
    m_motor = new CANSparkMax(deviceID, MotorType.kBrushless);

    /**

     * The RestoreFactoryDefaults method can be used to reset the configuration parameters

     * in the SPARK MAX to their factory default state. If no argument is passed, these

     * parameters will not persist between power cycles

     */
    m_motor.restoreFactoryDefaults();
    /**

    * In order to read encoder values an encoder object is created using the 

    * getEncoder() method from an existing CANSparkMax object

    */

    m_encoder = m_motor.getEncoder();
    m_stick = new Joystick(0);
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
    m_motor.set(m_stick.getY());

    SmartDashboard.putNumber("encoder value", m_encoder.getPosition());
  }

  @Override
  public void testInit() {
  }

  @Override
  public void testPeriodic() {
  }

}
