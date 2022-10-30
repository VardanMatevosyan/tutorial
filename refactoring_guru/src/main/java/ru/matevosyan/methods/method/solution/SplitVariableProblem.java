package ru.matevosyan.methods.method.solution;

public class SplitVariableProblem {
    private double primaryForce;
    private double secondaryForce;
    private double mass;
    private int delay;

    public double getDistanceTravelled(int time) {
        double result;
        final double primaryAcceleration = primaryForce / mass;
        int primaryTime = Math.min(time, delay);
        result = 0.5 * primaryAcceleration * primaryTime * primaryTime;

        int secondaryTime = time - delay;
        if (secondaryTime > 0) {
            double primaryVel = primaryAcceleration * delay;
            final double secondaryAcceleration = (primaryForce + secondaryForce) / mass;
            result +=  primaryVel * secondaryTime + 0.5 * secondaryAcceleration * secondaryTime * secondaryTime;
        }
        return result;
    }
}
