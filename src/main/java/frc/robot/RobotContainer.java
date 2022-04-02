// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;


import static edu.wpi.first.wpilibj.XboxController.Button;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.cscore.UsbCamera;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.Constants.ControllerConstants;
import frc.robot.commands.ArmControls.LowerArm;
import frc.robot.commands.ArmControls.StopArm;
import frc.robot.commands.AutonomousCommands.AutoDrive;
import frc.robot.commands.BallControls.IntakeBall;
import frc.robot.commands.BallControls.ShootBall;
import frc.robot.commands.BallControls.StopBall;
import frc.robot.commands.ClimbControls.ClimbUp;
import frc.robot.subsystems.ArmSubsystem;
import frc.robot.subsystems.BallSubsystem;
import frc.robot.subsystems.ClimbSubsystem;
import frc.robot.subsystems.DriveSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;


/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...

  // DriveSubsystem m_robotDrive
  public final DriveSubsystem m_robotDrive = new DriveSubsystem();

  // ArmSubsystem raiser
 public final ArmSubsystem lower = new ArmSubsystem();

  // BallSubsystem shooter
  private final BallSubsystem shooter = new BallSubsystem();

  // ClimbSubsystem climber
  private final ClimbSubsystem climber = new ClimbSubsystem();

  // ShootBall Command
  private final ShootBall shootBall = new ShootBall(shooter);

  // Climbup Command
  private final ClimbUp climbUp = new ClimbUp(climber);

  // IntakeBall Command
 // private final IntakeBall intakeBall = new IntakeBall(shooter);


  

  // Compressor Declared Here
  private final Compressor compressor = new Compressor(0, PneumaticsModuleType.CTREPCM);

  // Main Driver (Xbox) Controller
 XboxController m_driverController = new XboxController(ControllerConstants.DriverControllerPort);

  // Copilot (Xbox) Controller
  XboxController m_copilotController = new XboxController(ControllerConstants.CopilotControllerPort);

  // Camera starts Capturing image and sending it to the Shuffleboard
  UsbCamera camera = CameraServer.startAutomaticCapture();

  // Autonomous Command
  private final Command m_auto = new AutoDrive(m_robotDrive, shooter);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();

    // Main Arcade Drive (Y = fwd) (X = rot)
    /**m_robotDrive.setDefaultCommand(
        new DefaultDrive(
            m_robotDrive, m_driverController::getLeftY, m_driverController::getRightX));
**/
  // Starts the Compressor and Tells it to keep running
  compressor.enableDigital();

  // Getting Compressor Current and pressureSwitch values
 // boolean enabled = compressor.enabled();
  // boolean pressureSwitch = compressor.getPressureSwitchValue();
  // double current = compressor.getCurrent();

  shooter.setDefaultCommand(shootBall);

  climber.setDefaultCommand(climbUp);

  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {

  new JoystickButton(m_copilotController, Button.kA.value)
      .whileHeld(new IntakeBall(shooter));

  new JoystickButton(m_copilotController, Button.kA.value)
      .whenReleased(new StopBall(shooter));


    // Lower the Arm (Hold Button) (Motor 6)
    new JoystickButton(m_copilotController, Button.kB.value)
        .whileHeld(new LowerArm(lower));

    new JoystickButton(m_copilotController, Button.kB.value)
        .whenReleased(new StopArm(lower));


   
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_auto;
  }
}
