import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class nsga2 {

    public static void main(String[] args) {

        var gamma = 0.205;
        var mu = 0.02;                           //  % mutation rate
        var sigmaR = 0.1 * (DecisionVariable.upperBoundOFReorderpoint - DecisionVariable.lowerBoundOFReorderpoint);         //  % mutation step size
        var sigmaQ1 = 0.1 * (DecisionVariable.upperBoundOFQuantityA - DecisionVariable.lowerBoundOFQuantityA);
        var sigmaQ2 = 0.1 * (DecisionVariable.upperBoundOFQuantityB - DecisionVariable.lowerBoundOFQuantityB);
        var sigmaQ3 = 0.1 * (DecisionVariable.upperBoundOFQuantityC - DecisionVariable.lowerBoundOFQuantityC);
        var sigmaQ4 = 0.1 * (DecisionVariable.upperBoundOFQuantityD - DecisionVariable.lowerBoundOFQuantityD);
        var sigmaQ5 = 0.1 * (DecisionVariable.upperBoundOFQuantityE - DecisionVariable.lowerBoundOFQuantityE);

//%% NSGA_II parameters

        var MaxIt = 50;           //  %  maximam number of iteration 20  30  0.75    0.05  Pop= 30; maxit=50;pc=0.8;pm=0.15
        System.out.println("MaxIt=  " + MaxIt);

        var npop = 30;           //  %  population size
        System.out.println("npop= " + npop);

        var pCrossover = 0.8;       //  %  crossover percentage- 16
        var nCrossover = 2 * Math.round(pCrossover * npop / 2);        //      % number of parents--offsprings
        System.out.println(" pCrossover= " + pCrossover + ", ncrossover =  " + nCrossover);

        var pMutation = 0.15;                         //   %  mutation percentage
        var nMutation = Math.round(pMutation * npop);      // %  number of mutants- 1 or 2
        System.out.println(" pMutation=  " + pMutation + ", nmutation =  " + nMutation);

        System.out.println("initialization of NSGA_II Algoritms ");

        var Position = new ArrayList<>();
        var Cost = new ArrayList<Double>();
        var Rank = new ArrayList<>();
        var DominationSet = new ArrayList<>();
        var DominatedCount = new ArrayList<>();
        var CrowdingDistance = new ArrayList<>();
        //  hash_function.Position = containers.Map();
        // hash_function.Position = [];

        var decisionVariableClass = new DecisionVariable();
        for (var i = 1; i <= npop; i++) {

            // HashMap<String,Double> decisionVariables = new  HashMap<>();
            var decisionVariables = List.of(
                    new DecisionVariable("ReorderPointA", null),
                    new DecisionVariable("ReorderPointB", null),
                    new DecisionVariable("ReorderPointC", null),
                    new DecisionVariable("ReorderPointD", null),
                    new DecisionVariable("ReorderPointE", null),
                    new DecisionVariable("QuantityA", null),
                    new DecisionVariable("QuantityB", null),
                    new DecisionVariable("QuantityC", null),
                    new DecisionVariable("QuantityD", null),
                    new DecisionVariable("QuantityE", null),
                    new DecisionVariable("WatingTime", null),
                    new DecisionVariable("WholeInventoryCost", null));

            //  decisionVariables.stream()
            //         .map(k -> decisionVariableClass.addDecisionVariable(k.getName(),k.getValue()));

            for (var j = 0; j < decisionVariables.size(); j++){
                decisionVariableClass.addDecisionVariable(decisionVariables.get(i).getName());

        }
    }
       // pop(i).Position.R1  = abs(ceil( unifrnd (VarMinR,  VarMaxR,1) ));
      //  pop(i).Position.R2  = abs(ceil( unifrnd (VarMinR,  VarMaxR,1) ));
      //  pop(i).Position.R3  = abs(ceil( unifrnd (VarMinR,  VarMaxR,1) ));
      //  pop(i).Position.R4  = abs(ceil( unifrnd (VarMinR,  VarMaxR,1) ));
      //  pop(i).Position.R5  = abs(ceil( unifrnd (VarMinR,  VarMaxR,1) ));



    }
}
/**

 gamma=0.205;
 mu = 0.02;                             % mutation rate

 sigmaR  = 0.1* (VarMaxR - VarMinR);           % mutation step size
 sigmaQ1 = 0.1* (VarMaxq1 - VarMinq1);
 sigmaQ2 = 0.1* (VarMaxq2 - VarMinq2);
 sigmaQ3 = 0.1* (VarMaxq3 - VarMinq3);
 sigmaQ4 = 0.1* (VarMaxq4 - VarMinq4);
 sigmaQ5 = 0.1* (VarMaxq5 - VarMinq5);
*/