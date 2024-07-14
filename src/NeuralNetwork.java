public class NeuralNetwork {
    private final Neuron n1;
    private final Neuron n2;
    private final Neuron n3;
    public NeuralNetwork(Neuron n1, Neuron n2, Neuron n3) {
        this.n1 = n1;
        this.n2 = n2;                           //Neuron parametreleri ile constructor oluşturulur.
        this.n3 = n3;
    }
    //Dosyadaki çiçek türünü, öğrenme katsayısını ve girdileri parametre olarak alır.
    public void Train(String real_type, double learningRate, double[] input) {
        switch (real_type) {
            case "Iris-setosa" -> {
                n1.setExpected_result(1);
                n2.setExpected_result(0);
                n3.setExpected_result(0);
            }
            case "Iris-versicolor" -> {
                n1.setExpected_result(0);
                n2.setExpected_result(1);                    //Beklenen değerler dosyadaki çiçek türüne göre ayarlanır.
                n3.setExpected_result(0);
            }
            case "Iris-virginica" -> {
                n1.setExpected_result(0);
                n2.setExpected_result(0);
                n3.setExpected_result(1);
            }
        }

        if ((real_type.equals("Iris-setosa")) && ((n1.getTotal() < n2.getTotal()) || (n1.getTotal() < n3.getTotal()))) {
            n1.increaseWeights(input, learningRate);
            if ((n2.getTotal() > n1.getTotal()) && (n2.getTotal() > n3.getTotal())) {
                n2.decreaseWeights(input, learningRate);
            }                                                           //Eğer çiçek türü Iris-setosa iken en büyük
            else if ((n3.getTotal() > n1.getTotal()) && (n3.getTotal() > n2.getTotal())) {       //çarpım n1'den değilse n1'in ağırlıkları
                n3.decreaseWeights(input, learningRate);         //arttırılır diğerleri azaltılır.
            }
        } else if ((real_type.equals("Iris-versicolor")) && ((n2.getTotal() < n1.getTotal()) || (n2.getTotal() < n3.getTotal()))) {
            n2.increaseWeights(input, learningRate);
            if ((n1.getTotal() > n2.getTotal()) && (n1.getTotal() > n3.getTotal())) {        //Eğer çiçek türü Iris-versicolor iken en büyük
                n1.decreaseWeights(input, learningRate);
            }                                                       //çarpım n2'den değilse n2'in ağırlıkları
            else if (n3.getTotal() > n1.getTotal()) {
                //arttırılır diğerleri azaltılır.
                n3.decreaseWeights(input, learningRate);
            }
        } else if ((real_type.equals("Iris-virginica")) && ((n3.getTotal() < n2.getTotal()) || (n3.getTotal() < n1.getTotal()))) {
            n3.increaseWeights(input, learningRate);
            if ((n2.getTotal() > n1.getTotal()) && (n2.getTotal() > n3.getTotal())) {        //Eğer çiçek türü Iris-virginica iken en büyük
                n2.decreaseWeights(input, learningRate);
            }                                                           //çarpım n3'den değilse n3'in ağırlıkları
            else if ((n1.getTotal() > n2.getTotal()) && (n1.getTotal() > n3.getTotal())) {       //arttırılır diğerleri azaltılır.
                n1.decreaseWeights(input, learningRate);
            }
        }

    }
}