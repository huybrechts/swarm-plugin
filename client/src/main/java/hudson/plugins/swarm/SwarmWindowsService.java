package hudson.plugins.swarm;

import com.agfa.hap.win32.winsvc.Win32Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * Created by AWPYV on 17/02/2017.
 */
public class SwarmWindowsService extends Win32Service {

    Logger logger = LoggerFactory.getLogger(SwarmWindowsService.class);

    String[] args;

    public SwarmWindowsService(String serviceName, String[] args) {
        super(serviceName);
        this.args = args;
    }

    @Override
    public int getStartWaitHint() {
        return 15_000;
    }

    @Override
    public int getStopWaitHint() {
        return 15_000;
    }

    @Override
    public void onStart() {
    }

    @Override
    public void onRun() {
        try {
            Client.runMain(args);
        } catch (InterruptedException|IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onStop() {
    }

    @Override
    public Logger getLogger() {
        return logger;
    }
}
