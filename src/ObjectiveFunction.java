import java.util.HashMap;

public class ObjectiveFunction {

// add each time only 2 objective functions 1. waiting Time 2. whole inventory cost
    // there are the average of 5 years of running simulation model.

  private String name; // waiting Time & cost
  private Double value;

  HashMap<String,Double> objFunction= new  HashMap<>(2);

    public ObjectiveFunction(){}
    public ObjectiveFunction(String name, Double value) {
        this.name = name;
        this.value = value;
    }


    @Override
 public boolean equals(Object o) {
    //<Code Omitted>
        return true;
     }

 @Override
 public int hashCode() {
    //<Code Omitted>
     return 0;
           }

@Override
 public String toString() {
    //<Code Omitted>
    return "ok";
            }
 }


