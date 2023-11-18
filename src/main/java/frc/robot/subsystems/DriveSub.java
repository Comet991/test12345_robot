// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.AbsoluteEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.math.kinematics.DifferentialDriveOdometry;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import com.revrobotics.SparkMaxAbsoluteEncoder;

public class DriveSub extends SubsystemBase {

  private CANSparkMax m_leftFront = new CANSparkMax(Constants.kLeftMotor1Port, MotorType.kBrushless);
  private CANSparkMax m_leftBack = new CANSparkMax(Constants.kLeftMotor2Port, MotorType.kBrushless);
  private CANSparkMax m_rightFront = new CANSparkMax(Constants.kRightMotor1Port, MotorType.kBrushless);
  private CANSparkMax m_rightBack = new CANSparkMax(Constants.kRightMotor2Port, MotorType.kBrushless);
  DifferentialDriveOdometry m_odometry = new DifferentialDriveOdometry(null, m_leftFront.getEncoder(), 0);
  

  private MotorControllerGroup m_left;
  private MotorControllerGroup m_right;
  private DifferentialDrive m_robotDrive;
  private RelativeEncoder m_driveEncoder;

  /** Creates a new ExampleSubsystem. */
  public DriveSub() {

    m_leftFront.setIdleMode(IdleMode.kBrake);
    m_rightFront.setIdleMode(IdleMode.kBrake);
    m_leftBack.setIdleMode(IdleMode.kBrake);
    m_rightBack.setIdleMode(IdleMode.kBrake);
    m_leftFront.setInverted(false);
    m_leftBack.setInverted(false);
    m_rightFront.setInverted(true);
    m_rightBack.setInverted(true);
    m_left  = new MotorControllerGroup(m_leftFront, m_leftBack);
    m_right = new MotorControllerGroup(m_rightFront, m_rightBack);
    m_robotDrive = new DifferentialDrive(m_left, m_right);
    m_robotDrive.setDeadband(0.05);
    m_robotDrive.setSafetyEnabled(false);
  }

  /**
   * Example command factory method.
   *
   * @return a command
   */
  public CommandBase exampleMethodCommand() {
    // Inline construction of command goes here.
    // Subsystem::RunOnce implicitly requires `this` subsystem.
    return runOnce(
        () -> {
          /* one-time action goes here */
        });
  }

  public void arcadeDrive(double fwd, double rot) {
    m_robotDrive.arcadeDrive(fwd, rot, false);
  }

  /**
   * An example method querying a boolean state of the subsystem (for example, a digital sensor).
   *
   * @return value of some boolean subsystem state, such as a digital sensor.
   */
  public boolean exampleCondition() {
    // Query some boolean state, such as a digital sensor.
    return false;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run

  }


  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
