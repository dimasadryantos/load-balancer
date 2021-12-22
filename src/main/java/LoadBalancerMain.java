import dzcorp.loadbalancer.LoadBalance;
import dzcorp.loadbalancer.RandomLoadBalance;
import dzcorp.loadbalancer.RoundRobin;

public class LoadBalancerMain {


    public static void main(String[] args) {
        run();
    }

    public static void run() {
        loadBalance();
    }

    public static void loadBalance() {
        doGetServer(new RoundRobin());
        doGetServer(new RandomLoadBalance());
    }

    public static void doGetServer(LoadBalance loadBalance) {
        doGetServer(loadBalance, 10);
        doGetServer(loadBalance,10);
    }

    public static void doGetServer(LoadBalance loadBalance, int queryTime) {
        for (int i = 0; i < queryTime; i++) {
            String serverId = loadBalance.getServer(String.valueOf(i));

            System.out.println(String.format("[%s] index:%s,%s",
                    loadBalance.getClass().getSimpleName(), i, serverId));
        }
    }


}
