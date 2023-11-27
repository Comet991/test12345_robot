// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.subsystems.IntakeSubsystem;

public class microArmCMD extends CommandBase {
private IntakeSubsystem m_subsystem;
private final XboxController testController;

  /** Creates a new microArmCMD. */
  public microArmCMD(IntakeSubsystem subsystem, XboxController m_XboxControler) {
    // Use addRequirements() here to declare subsystem dependencies.
     m_subsystem = subsystem;
     testController = m_XboxControler;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(subsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    
    if (testController.getPOV() == 0){
      m_subsystem.addPosition(2.0);
    }

    else if (testController.getPOV() == 180) {m_subsystem.minusPosition(2.0); }
      
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
