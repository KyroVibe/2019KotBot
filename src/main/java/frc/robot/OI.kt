package frc.robot

import edu.wpi.first.wpilibj.Joystick
import edu.wpi.first.wpilibj.buttons.JoystickButton

import frc.robot.commands.MoveElevator

object OI {

  val gamepad: Joystick
  val elevatorUp: JoystickButton

  init {
    gamepad = Joystick(0)

    elevatorUp = JoystickButton(gamepad, RobotMap.buttonA)
    elevatorUp.whileHeld(MoveElevator(0.5))
  }

  fun GetAxis(axis: Int): Double {
    return gamepad.getRawAxis(axis)
  }

  //// CREATING BUTTONS
  // One type of button is a joystick button which is any button on a
  //// joystick.
  // You create one by telling it which joystick it's on and which button
  // number it is.
  // val stick: Joystick = Joystick(port)
  // val button: Button = JoystickButton(stick, buttonNumber)

  // There are a few additional built in buttons you can use. Additionally,
  // by subclassing Button you can create custom triggers and bind those to
  // commands the same as any other Button.

  //// TRIGGERING COMMANDS WITH BUTTONS
  // Once you have a button, it's trivial to bind it to a button in one of
  // three ways:

  // Start the command when the button is pressed and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenPressed(ExampleCommand())

  // Run the command while the button is being held down and interrupt it once
  // the button is released.
  // button.whileHeld(ExampleCommand())

  // Start the command when the button is released and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenReleased(ExampleCommand())
}
