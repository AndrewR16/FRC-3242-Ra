package frc.robot.revconfigs;

import com.revrobotics.spark.config.SparkFlexConfig;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;

public class IntakeConfig {
    public static final SparkFlexConfig intakeConfig = new SparkFlexConfig();

    static {
        intakeConfig
            .inverted(false)
            .idleMode(IdleMode.kBrake);
    }
}
