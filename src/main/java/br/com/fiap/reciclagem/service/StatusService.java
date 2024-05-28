package br.com.fiap.Reciclagem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.HealthEndpoint;
import org.springframework.stereotype.Service;

import java.lang.management.ManagementFactory;
import java.time.Duration;

@Service
public class StatusService {

    @Autowired
    private HealthEndpoint healthEndpoint;

    public String getAppVersion() {
        return "1.0.0";
    }

    public String getUptime() {
        long uptime = ManagementFactory.getRuntimeMXBean().getUptime();
        return Duration.ofMillis(uptime).toString();
    }

    public String getHealthStatus() {
        return healthEndpoint.health().getStatus().toString();
    }
}
