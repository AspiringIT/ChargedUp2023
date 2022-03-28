// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.ClimbControls;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ClimbSubsystem;

public class ClimbDown extends CommandBase {
  
  // Declare ClimbSubsystem as climber
  ClimbSubsystem climber;

  public ClimbDown(ClimbSubsystem subsystem) {
    
    // Establish climber as name of ClimbSubsystem
    climber = subsystem;

    // addRequirements makes the ClimbSubsystem a requirement to use
    addRequirements(climber);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    // Command Cylinders to go down
    climber.climbDown();
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
