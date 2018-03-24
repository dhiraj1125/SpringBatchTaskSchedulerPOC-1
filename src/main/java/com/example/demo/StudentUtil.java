package com.example.demo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class StudentUtil {

	private static final Logger logger = LoggerFactory.getLogger(StudentUtil.class);
    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

    // a method to be executed at a fixed interval by using fixedRate parameter in the @Scheduled annotation.
    @Scheduled(fixedRate = 2000)
    public void scheduleTaskWithFixedRate() {
    	logger.info("Fixed Rate Task :: Execution Time - {}", dateTimeFormatter.format(LocalDateTime.now()) );
    }

    //The fixedDelay parameter counts the delay after the completion of the last invocation.
    @Scheduled(fixedDelay = 2000)
    public void scheduleTaskWithFixedDelay() {
    	logger.info("Fixed Delay Task :: Execution Time - {}", dateTimeFormatter.format(LocalDateTime.now()));
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException ex) {
            logger.error("Ran into an error {}", ex);
            throw new IllegalStateException(ex);
        }
    }

    //You can use initialDelay parameter with fixedRate and fixedDelay to delay the first execution of the task with the specified number of milliseconds.
    @Scheduled(fixedRate = 2000, initialDelay = 5000)
    public void scheduleTaskWithInitialDelay() {
    	logger.info("Current Thread : {}", Thread.currentThread().getName());
    	logger.info("Fixed Rate Task with Initial Delay :: Execution Time - {}", dateTimeFormatter.format(LocalDateTime.now()));
    }

    // you can use cron expressions to schedule the execution of your tasks.
    //In the following example, I have scheduled the task to be executed every minute -
    @Scheduled(cron = "0 * * * * ?")
    public void scheduleTaskWithCronExpression() {
    	System.out.println("hello world!!");
    	logger.info("Cron Task :: Execution Time - {}", dateTimeFormatter.format(LocalDateTime.now()));
    }
}
