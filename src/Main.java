import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void start(int epoch, double learningRate,Neuron n1,Neuron n2,Neuron n3) throws IOException {
        NeuralNetwork neuralNetwork = new NeuralNetwork(n1,n2,n3);
        double true_Counter = 0.0;
        int counter = 0;
        double i1,i2,i3,i4,t1,t2,t3;
        int row = 150;
        for(int i=0;i<epoch+1;i++){
            FileReader file =  new FileReader("iris.data");
            BufferedReader br = new BufferedReader(file);
            for (int j=0;j<row;j++){
                String[] data = br.readLine().split(",");
                i1 = (Double.parseDouble(data[0])/10.0);
                i2 = (Double.parseDouble(data[1])/10.0);
                i3 = (Double.parseDouble(data[2])/10.0);
                i4 = (Double.parseDouble(data[3])/10.0);
                String true_type = data[4];
                double[] inputs ={i1,i2,i3,i4};
                t1 = n1.multiply(inputs);
                t2 = n2.multiply(inputs);
                t3 = n3.multiply(inputs);
                if (i!=epoch){
                    neuralNetwork.Train(true_type,learningRate,inputs);
                }
                else{
                    counter+=1;
                    if ((true_type.equals("Iris-setosa")&&((t1>t2)&&(t1>t3)))){
                        true_Counter+=1.0;
                    }else if ((true_type.equals("Iris-versicolor"))&&((t2>t1)&&(t2>t3))){
                        true_Counter+=1.0;
                    }else if ((true_type.equals("Iris-virginica"))&&((t3>t2)&&(t3>t1))){
                        true_Counter+=1.0;
                    }
            }
            } if(counter==row) {
                System.out.printf("%s%.2f","%",true_Counter/row*100);
                System.out.println();
            }
        }
        }

    public static void main(String[] args) throws IOException {
        double[] w1 = new double[4];
        double[] w2 = new double[4];
        double[] w3 = new double[4];
        Neuron n1 = new Neuron(w1);
        n1.randomizeWeights(w1);
        Neuron n2 = new Neuron(w2);         //Neuron nesneleri oluşturulup
        n2.randomizeWeights(w2);            //Ağırlıkları random ayarlanır
        Neuron n3 = new Neuron(w3);
        n3.randomizeWeights(w3);
        System.out.println("1. deney: 0.005 learning rate ");
        System.out.println("20 epoch için");
        start(20,0.005,n1,n2,n3);
        System.out.println("50 epoch için");
        start(50,0.005,n1,n2,n3);
        System.out.println("100 epoch için");
        start(100,0.005,n1,n2,n3);
        System.out.println("2. deney: 0.01 learning rate ");
        System.out.println("20 epoch için");
        start(20,0.01,n1,n2,n3);
        System.out.println("50 epoch için");
        start(50,0.01,n1,n2,n3);
        System.out.println("100 epoch için");
        start(100,0.01,n1,n2,n3);
        System.out.println("3. deney: 0.025 learning rate ");
        System.out.println("20 epoch için");
        start(20,0.025,n1,n2,n3);
        System.out.println("50 epoch için");
        start(50,0.025,n1,n2,n3);
        System.out.println("100 epoch için");
        start(100,0.025,n1,n2,n3);
    }
    }