package threads.example2hoeflichstoppen;

public class Worker implements Runnable {
    private boolean isRunning = true;

    private char sign;

    public Worker(char sign){
        this.sign = sign;
    }

    public void requestShutDown(){
        isRunning = false;
    }

    public void run(){
        for(int i = 0; i < 1000; i++){
            if(isRunning){
                try{
                    Thread.sleep(1000);
                } catch (Exception e){
                    e.printStackTrace();
                }
                System.out.println(i + " " + Thread.currentThread().getName() + " " + sign);
            }
            if(!isRunning){
                break;
            }
        }
    }
}
