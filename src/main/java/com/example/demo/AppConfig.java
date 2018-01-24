package com.example.demo;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

/**
 * 
 * @author NISUM
 *Description: We can schedule @Scheduled methods using JavaConfig with the help of @EnableScheduling annotation. 
 */

@Configuration
@EnableScheduling
//Running @Scheduled Tasks in a Custom Thread Pool. 
//By default, all the @Scheduled tasks are executed in a default thread pool of size one created by Spring.
//But hey, You can create your own thread pool and configure Spring to use that thread pool for executing all the scheduled tasks.
public class AppConfig implements SchedulingConfigurer{
	private final int POOL_SIZE = 10;

	@Scheduled(fixedRate = 1000)
	public void doTask() {
		System.out.println("Do task...");
	}

	@Override
	public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {
		ThreadPoolTaskScheduler threadPoolTaskScheduler = new ThreadPoolTaskScheduler();
		threadPoolTaskScheduler.setPoolSize(POOL_SIZE);
        threadPoolTaskScheduler.setThreadNamePrefix("my-scheduled-task-pool-");
        threadPoolTaskScheduler.initialize();
        
        scheduledTaskRegistrar.setTaskScheduler(threadPoolTaskScheduler);
	}
}
