// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.subsystems.DriveSub;
import frc.robot.subsystems.IntakeSubsystem;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class AutonomousTest extends SequentialCommandGroup {
  private final IntakeSubsystem intake;
  private final DriveSub driveSub;
  /** Creates a new AutoMoveArm. */
  public AutonomousTest(IntakeSubsystem m_intake, DriveSub m_drive) {
    intake = m_intake;
    driveSub = m_drive;
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    addCommands(new InstantCommand(() -> driveSub.arcadeDrive(0.1, 0.1)),
    new WaitCommand(1.0),
     new InstantCommand(() -> driveSub.arcadeDrive(0, 0)),
     new InstantCommand(() -> intake.setTargetPosition_deg(15)),
     new WaitCommand(3.0),
     new InstantCommand(() -> intake.setTargetPosition_deg(45)),
     new InstantCommand(() -> driveSub.arcadeDrive(0, 0.1)),
     new WaitCommand(8.0),
     new InstantCommand(() -> driveSub.arcadeDrive(0, 0))
     /*new InstantCommand(() -> driveSub.arcadeDrive(1, 1)),
     new InstantCommand(() -> driveSub.arcadeDrive(1, 1)),
     new InstantCommand(() -> driveSub.arcadeDrive(1, 1)),
     new InstantCommand(() -> driveSub.arcadeDrive(1, 1)),
     new InstantCommand(() -> driveSub.arcadeDrive(1, 1)),
     new InstantCommand(() -> driveSub.arcadeDrive(1, 1))*/);
    
      
      /*
      new InstantCommand(() -> intake.setTargetPosition_deg(15));*/

  }
  
}
