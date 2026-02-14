package frc.robot.revconfigs;

import com.revrobotics.spark.config.SparkMaxConfig;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;

public class IntakeConfig {
    public static final SparkMaxConfig intakeConfig = new SparkMaxConfig();

    static {
        intakeConfig
            .inverted(false)
            .idleMode(IdleMode.kBrake);
    }
}
