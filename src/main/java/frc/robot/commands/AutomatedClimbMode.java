// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.subsystems.Climber;
import frc.robot.subsystems.Drive;
import frc.robot.subsystems.Indexer.IndexerState;

public class AutomatedClimbMode extends CommandBase {

  double climbStep = 0;

  Drive drive;
  Climber climb;

  public AutomatedClimbMode(Drive drive, Climber climb) {
    this.drive = drive;
    this.climb = climb;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (climbStep == 0 && RobotContainer.indexer.getState().equals(IndexerState.CLIMBING)) {
    climb.setRightClimberPosition(Constants.Climber.REASONABLE_MINIMUM_RIGHT);
    climb.setLeftClimberPosition(Constants.Climber.EXTENDING_PARTIAL_LIMIT_LEFT);
    climbStep++;
    }
    // if (climbStep == 1 && drive.getRoll() <)


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
