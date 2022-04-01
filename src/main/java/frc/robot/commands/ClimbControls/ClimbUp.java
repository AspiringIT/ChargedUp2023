// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.ClimbControls;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants.ControllerConstants;
import frc.robot.subsystems.ClimbSubsystem;

public class ClimbUp extends CommandBase {
  
  // Declare ClimbSubsystem as climber
  ClimbSubsystem climber;

  private XboxController m_copilotController;
  
  public ClimbUp(ClimbSubsystem subsystem) {
  
    // Establish climber as name of ClimbSubsystem
    climber = subsystem;

    // addRequirements makes the ClimbSubsystem a requirement to use
    addRequirements(climber);

    m_copilotController = new XboxController(ControllerConstants.CopilotControllerPort);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    if (m_copilotController.getRightBumperPressed()) {
      climber.climbUp();
    }
    
    if (m_copilotController.getLeftBumperPressed()) {
      climber.climbDown();
    }
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
