// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.SparkMaxPIDController;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class moveArmSub extends SubsystemBase {

  //INSTANCE VARIABLES
  private CANSparkMax armMotor = new CANSparkMax(7, MotorType.kBrushless);
  private SparkMaxPIDController pidController = armMotor.getPIDController();
  private RelativeEncoder encoder = armMotor.getEncoder();

  //METHODS
  public void moveArm(double pos){
    pidController.setReference(pos, CANSparkMax.ControlType.kPosition);
    SmartDashboard.putNumber("position", encoder.getPosition());
    SmartDashboard.putNumber("velocity", encoder.getVelocity());
    SmartDashboard.putNumber("out", armMotor.getAppliedOutput());
    //armMotor.set(pos);
  } //END METHOD

  /** Creates a new moveArmSub. */
  public moveArmSub() {
    armMotor.setIdleMode(IdleMode.kBrake);
    pidController.setP(2);
    pidController.setI(0);
    pidController.setD(0);
    pidController.setIZone(0);
    pidController.setFF(0);
    pidController.setOutputRange(-0.5, 0.5);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
