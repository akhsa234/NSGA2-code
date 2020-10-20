import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class DecisionVariable {

    public  static final Integer upperBoundOFReorderpoint= 1500;
    public  static final Integer upperBoundOFQuantityA= 750;
    public  static final Integer upperBoundOFQuantityB= 650;
    public  static final Integer upperBoundOFQuantityC= 750;
    public  static final Integer upperBoundOFQuantityD= 650;
    public  static final Integer upperBoundOFQuantityE= 650;

    public  static final Integer lowerBoundOFReorderpoint= 900;
    public  static final Integer lowerBoundOFQuantityA= 200;
    public  static final Integer lowerBoundOFQuantityB= 200;
    public  static final Integer lowerBoundOFQuantityC= 200;
    public  static final Integer lowerBoundOFQuantityD= 200;
    public  static final Integer lowerBoundOFQuantityE= 200;

    private String name;
    private Double value;


    // private Integer initialCapacity = npop(1+pc+pm);
    HashMap<String,Double> decisionVariables = new  HashMap<>();

    DecisionVariable(){}
    DecisionVariable(String name, Double value){
        this.name =name;
        this.value = value;
    }
    public void addDecisionVariable(String name) {
        System.out.println("we are going to fill the hasmap.!!!");
        // The boundrary must be checked!!!

        decisionVariables.put(name, setDecisionVariables());

        System.out.println("I am in method addDecisionVariable class " +decisionVariables.entrySet());
        decisionVariables.forEach((k,v) -> System.out.println("key: "+k+" value:"+v));
    }

    public double setDecisionVariables() {
        var destributionFunction = new DistributionFunctions();

        if (decisionVariables.keySet().equals("ReorderPointA") &
                decisionVariables.keySet().equals("ReorderPointB") &
                decisionVariables.keySet().equals("ReorderPointC") &
                decisionVariables.keySet().equals("ReorderPointD") &
                decisionVariables.keySet().equals("ReorderPointE")) {
            destributionFunction.setDistributionFunctionType(DistributionFunctionType.Uniform);
            List<Double> list = List.of(900.0, 1500.0);
            destributionFunction.setDistributionFunctionInput(list);

          var  checkingTheReorderPointBoundery= true;
            while(checkingTheReorderPointBoundery) {
                Double result = DistributionFunctions.uniformDistrubution(destributionFunction.getDistributionFunctionInput().get(1),
                        destributionFunction.getDistributionFunctionInput().get(2));
                if (result <= lowerBoundOFReorderpoint && result >= upperBoundOFReorderpoint) return result;
                else checkingTheReorderPointBoundery = false;

            }
        }

            else if (decisionVariables.keySet().equals("QuantityA")) {
            destributionFunction.setDistributionFunctionType(DistributionFunctionType.Triangle);
            List<Double> list = List.of(24.0, 380.0, 526.0);
            destributionFunction.setDistributionFunctionInput(list);
            return DistributionFunctions.triangleDF(destributionFunction.getDistributionFunctionInput().get(1),
                    destributionFunction.getDistributionFunctionInput().get(2), destributionFunction.getDistributionFunctionInput().get(3));

        } else if (decisionVariables.keySet().equals("QuantityB")) {
            destributionFunction.setDistributionFunctionType(DistributionFunctionType.Normal);
            List<Double> list = List.of(330.0, 96.6);
            destributionFunction.setDistributionFunctionInput(list);
            return DistributionFunctions.normalDistrubution(destributionFunction.getDistributionFunctionInput().get(1),
                    destributionFunction.getDistributionFunctionInput().get(2));


        } else if (decisionVariables.keySet().equals("QuantityC")) {
            destributionFunction.setDistributionFunctionType(DistributionFunctionType.Normal);
            List<Double> list = List.of(345.0, 152.0);
            destributionFunction.setDistributionFunctionInput(list);
            return DistributionFunctions.normalDistrubution(destributionFunction.getDistributionFunctionInput().get(1),
                    destributionFunction.getDistributionFunctionInput().get(2));

        } else if (decisionVariables.keySet().equals("QuantityD")) {
            destributionFunction.setDistributionFunctionType(DistributionFunctionType.Normal);
            List<Double> list = List.of(324.0, 106.0);
            destributionFunction.setDistributionFunctionInput(list);
            return DistributionFunctions.normalDistrubution(destributionFunction.getDistributionFunctionInput().get(1),
                    destributionFunction.getDistributionFunctionInput().get(2));

        } else
            destributionFunction.setDistributionFunctionType(DistributionFunctionType.Normal);
        List<Double> list = List.of(341.0, 104.0);
        destributionFunction.setDistributionFunctionInput(list);
        return DistributionFunctions.normalDistrubution(destributionFunction.getDistributionFunctionInput().get(1),
                destributionFunction.getDistributionFunctionInput().get(2));

    }





      @Override
 public boolean equals(Object o) {
       // <Code Omitted>
          return true;
    }

         @Override
 public int hashCode() {
       // <Code Omitted>
             return 0;
    }

         @Override
 public String toString() {
       // <Code Omitted>
             return "true";
    }

    public String getName() {
        return name;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }
}


