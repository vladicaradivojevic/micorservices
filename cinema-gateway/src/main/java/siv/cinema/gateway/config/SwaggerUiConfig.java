package siv.cinema.gateway.config;

import java.util.HashMap;
import java.util.Map;

import org.springdoc.core.properties.AbstractSwaggerUiConfigProperties.SwaggerUrl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SwaggerUiConfig {
	
    @Value("${server.public.ip}")
    private String serverPublicIp;
    
    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/swagger-config.json")
    public Map<String, Object> swaggerConfig() {
        Map<String, SwaggerUrl> urls = new HashMap<>();
        discoveryClient.getServices().forEach(serviceName -> 
                        discoveryClient.getInstances(serviceName).forEach(serviceInstance -> {
                        		if (!serviceName.equals("gateway")) {
                        			urls.put(serviceName, new SwaggerUrl(serviceName, serviceInstance.getScheme() + "://" + serverPublicIp + ":" + serviceInstance.getPort() + "/v3/api-docs", serviceName));
                        		}
                        	}
                        )
        );
        return Map.of("urls", urls.values());
    }
}