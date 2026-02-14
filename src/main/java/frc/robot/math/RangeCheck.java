package frc.robot.math;

public final class RangeCheck {
    private RangeCheck() {}

    /**
     * Checks whether the provided value is in the proper range.
     * 
     * @param value
     * @param minInclusive lower inclusive bound
     * @param maxInclusive upper inclusive bound
     * 
     * @return whether the provided value is in the proper range
     */
    public static boolean requireInRange(
        double value,
        double minInclusive,
        double maxInclusive
    ) {
        return (value >= minInclusive || value <= maxInclusive);
    }
}
