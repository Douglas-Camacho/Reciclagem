package br.com.fiap.Reciclagem.controller;

import br.com.fiap.Reciclagem.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ApiStatusController {

    @Autowired
    private StatusService statusService;

    @GetMapping("/status")
    public Map<String, Object> getStatus() {
        Map<String, Object> statusMap = new HashMap<>();
        statusMap.put("status", "API is running!");
        statusMap.put("version", statusService.getAppVersion());
        statusMap.put("uptime", statusService.getUptime());
        statusMap.put("health", statusService.getHealthStatus());
        return statusMap;
    }
}