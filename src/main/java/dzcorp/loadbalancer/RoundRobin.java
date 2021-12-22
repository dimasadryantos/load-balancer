package dzcorp.loadbalancer;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class RoundRobin implements LoadBalance {

    private static Integer position = 0;

    public String getServer(String clientIp) {
        Set<String> servers = IpPool.ipMap.keySet();
        List<String> serverList = new ArrayList<String>();
        serverList.addAll(servers);

        String target;

        synchronized (position) {
            if (position > servers.size() - 1) {
                position = 0;
            }
            target = serverList.get(position);
            position++;
        }
        return target;
    }
}
