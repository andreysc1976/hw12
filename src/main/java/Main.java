import java.util.Arrays;

public class Main {
    private static final int SIZE = 10000000;
    private static final int HALF = SIZE / 2;

    static void metod1(){
        float[] arr = new float[SIZE];
        Arrays.fill(arr,1f);
        long a = System.currentTimeMillis();
        for (int i = 0; i <arr.length ; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        long b = System.currentTimeMillis();
        System.out.printf("Длительность расчета в один поток (мс)=%d\n",b-a);

    }

    static void metod2() {
        float arr[]=new float[SIZE];
        Arrays.fill(arr,1f);

        float arr_1[] = new float[HALF];
        float arr_2[] = new float[HALF];
        long a = System.currentTimeMillis();
        System.arraycopy(arr,0,arr_1,0,HALF);
        System.arraycopy(arr,HALF,arr_2,0,HALF);
        Calc calc1 = new Calc(arr_1,0);
        Calc calc2 = new Calc(arr_2,HALF);
        calc1.start();
        calc2.start();


        try {
            calc1.join();
            calc2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.arraycopy(arr_1,0,arr,0,HALF);
        System.arraycopy(arr_2,0,arr,HALF,HALF);

        long b = System.currentTimeMillis();

        System.out.printf("Длительность расчета в два потока (мс)=%d\n",b-a);

        //int y=0;


    }

    public static void main(String[] args) {
        metod1();
        metod2();
    }

}
