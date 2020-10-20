import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DistributionFunctions {

    private DistributionFunctionType distributionFunctionType;
    private List<Double> distributionFunctionInput = new ArrayList<Double>();;

    private static Random rand = new Random(); //reuse this if you are generating many

    public DistributionFunctions(){

    }
    public DistributionFunctions(DistributionFunctionType distributionFunctionType,
                                 List<Double> distributionFunctionInput) {
        this.setDistributionFunctionType(distributionFunctionType);
        this.setDistributionFunctionInput(distributionFunctionInput);
    }

    public static double triangleDF (double a, double b, double c) {
            double F = (c - a) / (b - a);
            double rand = Math.random();
            if (rand < F) {
                return a + Math.sqrt(rand * (b - a) * (c - a));
            } else {
                return b - Math.sqrt((1 - rand) * (b - a) * (b - c));
            }
        }

    public static double uniformDistrubution(double min, double max) {
       // Random rand = new Random();
        return Math.random() * max + min;
    }

    /**
     *  public static double NormalRand()
     *         {
     *             double u1 = Rand();
     *             double u2 = Rand();
     *             return Math.Sqrt(-2 * Math.Log(u1) * Math.Cos(2 * Math.PI * u2));
     *
     *         }
     * @param mean
     * @param std
     * @return
     * Random rand = new Random(); //reuse this if you are generating many
     * double u1 = 1.0-rand.NextDouble(); //uniform(0,1] random doubles
     * double u2 = 1.0-rand.NextDouble();
     * double randStdNormal = Math.Sqrt(-2.0 * Math.Log(u1)) *
     *              Math.Sin(2.0 * Math.PI * u2); //random normal(0,1)
     * double randNormal =
     *              mean + stdDev * randStdNormal; //random normal(mean,stdDev^2)
     */
    public static double normalDistrubution(double mu, double sigma) {
        //Random rng = new Random();
        //return mean + std * Math.random().nextGaussian();
        //return Math.Sqrt(-2 * Math.Log(u1) * Math.Cos(2 * Math.PI * u2));
        double u1 = 1.0-rand.nextDouble(); //uniform(0,1] random doubles
        double u2 = 1.0-rand.nextDouble();
        double randStdNormal = Math.sqrt(-2.0 * Math.log(u1)) *
                  Math.cos(2.0 * Math.PI * u2); //random normal(0,1)
        double randNormal =
                  mu + sigma * randStdNormal; //random normal(mean,stdDev^2)
        return randNormal;
    }

   public DistributionFunctionType getDistributionFunctionType() {
        return distributionFunctionType;
    }

    public List<Double> getDistributionFunctionInput() {
        return distributionFunctionInput;
    }

    public void setDistributionFunctionType(DistributionFunctionType distributionFunctionType) {
        this.distributionFunctionType = distributionFunctionType;
    }

    public void setDistributionFunctionInput(List<Double> distributionFunctionInput) {
        this.distributionFunctionInput = distributionFunctionInput;
    }
}


