public class ShutdownConnectivityThread extends Thread {
    @Override
    public void run() {
        System.out.println("CONNECTION SHUTDOWN : " + Connectivity.stopConnection());
    }
}
