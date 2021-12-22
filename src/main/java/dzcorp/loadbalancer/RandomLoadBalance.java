package dzcorp.loadbalancer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class RandomLoadBalance implements LoadBalance {


    public String getServer(String clientIp) {
        Set<String> servers = IpPool.ipMap.keySet();
        List<String> allServers = new ArrayList<String>(servers);
        int randomIndex = new Random().nextInt(allServers.size());
        return allServers.get(randomIndex);
    }
}
