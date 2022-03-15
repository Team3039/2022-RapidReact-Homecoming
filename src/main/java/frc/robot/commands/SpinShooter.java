// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.Shooter.ShooterState;
import frc.robot.subsystems.Turret.TurretState;

public class SpinShooter extends CommandBase {
  /** Creates a new SpinShooter. */
  public SpinShooter() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(RobotContainer.shooter);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() { 
    RobotContainer.shooter.setState(ShooterState.SPIN_UP);
    if (!RobotContainer.turret.getState().equals(TurretState.MANUAL)) {
      RobotContainer.turret.setState(TurretState.TRACKING);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    RobotContainer.shooter.setState(ShooterState.IDLE);
    if (!RobotContainer.turret.getState().equals(TurretState.MANUAL)) {
      RobotContainer.turret.setState(TurretState.DRIVE);
    }
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
