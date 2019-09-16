package frc.robot.subsystems
      
import edu.wpi.first.wpilibj.command.Subsystem

import frc.robot.commands.ArcadeMixer
import frc.robot.RobotMap

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX
import com.ctre.phoenix.motorcontrol.FeedbackDevice
import com.ctre.phoenix.motorcontrol.NeutralMode
import com.ctre.phoenix.motorcontrol.StatusFrameEnhanced
import com.ctre.phoenix.motorcontrol.ControlMode

object Drivetrain: Subsystem() {

  private val leftTalon: WPI_TalonSRX
  private val rightTalon: WPI_TalonSRX
  private val leftVictor1: WPI_VictorSPX
  private val leftVictor2: WPI_VictorSPX
  private val rightVictor1: WPI_VictorSPX
  private val rightVictor2: WPI_VictorSPX

  init {
    leftTalon = WPI_TalonSRX(RobotMap.leftTalon)
    rightTalon = WPI_TalonSRX(RobotMap.rightTalon)
    leftVictor1 = WPI_VictorSPX(RobotMap.leftVictor1)
    leftVictor2 = WPI_VictorSPX(RobotMap.leftVictor2)
    rightVictor1 = WPI_VictorSPX(RobotMap.rightVictor1)
    rightVictor2 = WPI_VictorSPX(RobotMap.rightVictor2)

    leftTalon.setInverted(false)
    leftVictor1.setInverted(false)
    leftVictor2.setInverted(false)
    rightTalon.setInverted(true)
    rightVictor1.setInverted(true)
    rightVictor2.setInverted(true)

    leftVictor1.follow(leftTalon)
    leftVictor2.follow(leftTalon)
    rightVictor1.follow(rightTalon)
    rightVictor2.follow(rightTalon)

    leftTalon.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 10);
    leftTalon.setSensorPhase(true);
    rightTalon.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 10);
    rightTalon.setSensorPhase(true);

    leftTalon.setNeutralMode(NeutralMode.Coast);
    rightTalon.setNeutralMode(NeutralMode.Coast);

    leftTalon.configNominalOutputForward(0.0, 10);
    leftTalon.configNominalOutputReverse(0.0, 10);
    leftTalon.configPeakOutputForward(1.0, 10);
    leftTalon.configPeakOutputReverse(-1.0, 10);
    rightTalon.configNominalOutputForward(0.0, 10);
    rightTalon.configNominalOutputReverse(0.0, 10);
    rightTalon.configPeakOutputForward(1.0, 10);
    rightTalon.configPeakOutputReverse(-1.0, 10);

    leftTalon.configPeakCurrentLimit(40, 10);
    leftTalon.configPeakCurrentDuration(100, 10);
    leftTalon.configContinuousCurrentLimit(30, 10);
    leftTalon.enableCurrentLimit(true);
    rightTalon.configPeakCurrentLimit(40, 10);
    rightTalon.configPeakCurrentDuration(100, 10);
    rightTalon.configContinuousCurrentLimit(30, 10);
    rightTalon.enableCurrentLimit(true);

    leftTalon.setStatusFramePeriod(StatusFrameEnhanced.Status_2_Feedback0, 40, 10);
    rightTalon.setStatusFramePeriod(StatusFrameEnhanced.Status_2_Feedback0, 40, 10);
  }

  public fun ArcadeMixer(forward: Double, turn: Double) {
    SetSpeed(forward + turn, forward - turn)
  }

  public fun SetSpeed(left: Double, right: Double) {
    leftTalon.set(ControlMode.PercentOutput, left)
    rightTalon.set(ControlMode.PercentOutput, right)
  }

  override fun initDefaultCommand() {
    setDefaultCommand(ArcadeMixer())
  }
}
