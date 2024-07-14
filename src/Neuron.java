import java.util.Arrays;
import java.util.Random;

public class Neuron {
    private double[] weights;
    private double total =0;                    //Değişkenler oluşturulur.
    private int expected_result = 0;

    Neuron(double[] weights){
        this.weights=weights;
    }
    public void randomizeWeights(double[] weights) {
        this.weights = weights;
        for (int p = 0; p < 4; p++) {                   //Ağırlıkları random şekilde atamak için kullanılan metod.
            Random r = new Random();
            weights[p] = r.nextDouble(0.0,1.0);
        }
    }

    @Override
    public String toString() {
        return "Neuron{" +
                "weights=" + Arrays.toString(weights) +         //toString
                ", total=" + this.getTotal() +
                ", expected_result=" + this.getExpected_result() +
                '}';
    }

    public int getExpected_result() {
        return expected_result;
    }

    public double getTotal() {
        return total;
    }
    public void setExpected_result(int expected_result) {
        this.expected_result = expected_result;
    }

    public double multiply(double[] inputs){
        total = 0;
        for (int i=0;i<inputs.length;i++){              //Girdiler ve ağırlıkların çarpımlarının toplamlarını döndürür.
            total +=inputs[i]*weights[i];
        }
        return total;
    }
    public void increaseWeights(double[] inputs,double learningRate){
        for (int k = 0; k<inputs.length ; k++) {
            this.weights[k] += learningRate*inputs[k];
        }
    }
    public void decreaseWeights(double[] inputs,double learningRate){
        for (int p = 0; p<inputs.length ; p++) {
            this.weights[p] -= learningRate*inputs[p];
        }
    }
}
