package frc.robot.subsystems

import edu.wpi.first.wpilibj.command.Subsystem;

import frc.robot.RobotMap

import com.revrobotics.CANSparkMax
import com.revrobotics.CANSparkMaxLowLevel.MotorType
import com.revrobotics.ControlType
import com.revrobotics.CANPIDController;
import com.revrobotics.CANEncoder;

object Elevator: Subsystem() {

  private val elevatorMotor1: CANSparkMax
  private val elevatorMotor2: CANSparkMax

  private val controller: CANPIDController
  private val internalEncoder: CANEncoder

  init {
    elevatorMotor1 = CANSparkMax(RobotMap.elevatorMotor1, MotorType.kBrushless)
    elevatorMotor2 = CANSparkMax(RobotMap.elevatorMotor2, MotorType.kBrushless)

    controller = elevatorMotor1.getPIDController()
    internalEncoder = elevatorMotor1.getEncoder()

    controller.setP(0.02, 0)
    controller.setI(0.0, 0)
    controller.setD(0.0, 0)
    controller.setFF(0.0, 0)

    elevatorMotor2.follow(elevatorMotor1, true)
  }

  public fun GetPosition(): Double {
    return internalEncoder.getPosition()
  }

  public fun GetVelocity(): Double {
    return internalEncoder.getVelocity()
  }

  public fun SetPosition(pos: Double) {
    controller.setReference(pos, ControlType.kPosition)
  }

  public fun SetVelocity(vel: Double) {
    controller.setReference(vel, ControlType.kVelocity)
  }

  public fun SetSpeed(speed: Double) {
    elevatorMotor1.set(speed)
  }

  override fun initDefaultCommand() {

  }

}