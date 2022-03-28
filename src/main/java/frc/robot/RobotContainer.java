// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;


import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.XboxController.Button;
//import frc.robot.Constants.ArmConstants;
import frc.robot.Constants.ControllerConstants;
//import frc.robot.commands.ArmControls.TiltArm;
import frc.robot.commands.BallControls.IntakeBall;
import frc.robot.commands.BallControls.ShootBall;
import frc.robot.commands.BallControls.StopBall;
import frc.robot.commands.BallControls.WindupBall;
import frc.robot.commands.ClimbControls.ClimbDown;
import frc.robot.commands.ClimbControls.ClimbUp;
import frc.robot.subsystems.ArmSubsystem;
import frc.robot.subsystems.BallSubsystem;
import frc.robot.subsystems.ClimbSubsystem;
import frc.robot.subsystems.DriveSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;
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
  private final DriveSubsystem m_robotDrive = new DriveSubsystem();

  // ArmSubsystem raiser
  private final ArmSubsystem raiser = new ArmSubsystem();

  // BallSubsystem shooter
  private final BallSubsystem shooter = new BallSubsystem();

  // ClimbSubsystem climber
  private final ClimbSubsystem climber = new ClimbSubsystem();
  

  // Compressor Declared Here
  private final Compressor compressor = new Compressor(0, PneumaticsModuleType.CTREPCM);

  // Main Driver (Xbox) Controller
  XboxController m_driverController = new XboxController(ControllerConstants.DriverControllerPort);

  // Copilot (Joystick) Controller
  Joystick m_copilotController =  new Joystick(ControllerConstants.CopilotControllerPort);


  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();

    // Main Arcade Drive (Y = fwd) (X = rot)
    m_robotDrive.setDefaultCommand(

      new RunCommand(() -> m_robotDrive
      .arcadeDrive(m_driverController.getLeftY(),
                   m_driverController.getRightX()), m_robotDrive));

  // Starts the Compressor and Tells it to keep running
  compressor.enableDigital();
  compressor.disable();

  // Getting Compressor Current and pressureSwitch values
  boolean enabled = compressor.enabled();
  boolean pressureSwitch = compressor.getPressureSwitchValue();
  double current = compressor.getCurrent();

  // Arm Tilting Controls
  raiser.tiltArm();



  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {

    // Pickup the Ball
    new JoystickButton(m_copilotController, ControllerConstants.INTAKE_BUTTON)
        .whileHeld(new IntakeBall(shooter));

    new JoystickButton(m_copilotController, ControllerConstants.INTAKE_BUTTON)
        .whenReleased(new StopBall(shooter));

    
    // Windup the Ball
    new JoystickButton(m_copilotController, ControllerConstants.WINDUP_BUTTON)
        .whileHeld(new WindupBall(shooter));

    new JoystickButton(m_copilotController, ControllerConstants.WINDUP_BUTTON)
        .whenReleased(new StopBall(shooter));


    // Shoot the Ball
    new JoystickButton(m_copilotController, ControllerConstants.TRIGGER_BUTTON)
        .whileHeld(new ShootBall(shooter));

    new JoystickButton(m_copilotController, ControllerConstants.TRIGGER_BUTTON)
        .whenReleased(new StopBall(shooter));


    // Extend Climbers
    new JoystickButton(m_driverController, Button.kLeftBumper.value)
        .whenPressed(new ClimbUp(climber));

    // Lower CLimbers
    new JoystickButton(m_driverController, Button.kRightBumper.value)
        .whenPressed(new ClimbDown(climber));
  
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return null;
  }
}
