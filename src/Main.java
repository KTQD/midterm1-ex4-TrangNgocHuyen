import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        int[] numbers = {1, 3, 5, 6, 2, 7, 8, 0, 4, 3, 9, 2, 8, 1, 0, 5, 7, 4, 6, 9, 3, 2, 1, 8, 4, 0, 6, 7, 9, 5, 3, 2, 1, 0, 8, 4, 6, 7, 9, 5, 3, 2, 1, 0, 8, 4, 6, 7, 9, 5, 3, 2, 1, 0, 8, 4, 6, 7, 9, 5, 3, 2, 1, 0};

        SumThread sumThread = new SumThread(numbers);
        MaxThread maxThread = new MaxThread(numbers);

        Thread sumThreadObj = new Thread(sumThread);
        Thread maxThreadObj = new Thread(maxThread);

        sumThreadObj.start();
        maxThreadObj.start();

        sumThreadObj.join();
        maxThreadObj.join();

        System.out.println("Phần tử lớn nhất trong mảng là: " + maxThread.getMax());
        System.out.println("Tổng của các phần tử trong mảng là: " + sumThread.getSum());
    }
}

class SumThread implements Runnable {
    private int[] numbers;
    private int sum;

    public SumThread(int[] numbers) {
        this.numbers = numbers;
    }

    @Override
    public void run() {
        sum = Arrays.stream(numbers).sum();
    }
}
