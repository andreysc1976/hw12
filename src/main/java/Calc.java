public class Calc extends Thread{
    private float[] arr;
    private int seek;

    public Calc(float[] arr, int seek) {
        this.arr = arr;
        this.seek = seek;
    }


    @Override
    public void run() {
        for (int i = 0; i <arr.length-1 ; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + (i+seek) / 5) * Math.cos(0.2f + (i+seek) / 5) * Math.cos(0.4f + (i+seek) / 2));
        }
        super.run();
    }

    public float[] getArr() {
        return arr;
    }
}
