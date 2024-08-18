package com.jarl.eventbus.app.events;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@Configuration
@EnableAsync
public class AsyncConfig {

    @Bean(name = "taskExecutor")
    public Executor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        // Configuración del pool de hilos
        executor.setCorePoolSize(5);   // Número de hilos básicos
        executor.setMaxPoolSize(10);   // Número máximo de hilos
        executor.setQueueCapacity(100); // Capacidad de la cola
        executor.setThreadNamePrefix("AsyncEventThread-"); // Prefijo para los nombres de los hilos
        executor.initialize();
        return executor;
    }
}
