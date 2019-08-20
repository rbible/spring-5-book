/**
 * Welcome to https://waylau.com
 */
package com.waylau.spring.quartz.configuration;

import org.quartz.JobDetail;
import org.quartz.SimpleTrigger;
import org.quartz.spi.JobFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.scheduling.quartz.SimpleTriggerFactoryBean;

import com.waylau.spring.quartz.job.WeatherDataSyncJob;

/**
 * Quartz 配置类.
 *
 * @author <a href="https://waylau.com">Way Lau</a>
 * @since 1.0.0 2017年10月23日
 */
@Configuration
public class QuartzConfiguration {

	@Bean
	public JobDetailFactoryBean jobDetailFactoryBean() {
		JobDetailFactoryBean factory = new JobDetailFactoryBean();
		factory.setJobClass(WeatherDataSyncJob.class);
		return factory;
	}

	@Bean
	public SimpleTriggerFactoryBean simpleTriggerFactoryBean() {
		JobDetail jobDetail = jobDetailFactoryBean().getObject();

		SimpleTriggerFactoryBean stFactory = new SimpleTriggerFactoryBean();
		stFactory.setJobDetail(jobDetail);
		stFactory.setStartDelay(3000);  // 延迟3秒
		stFactory.setRepeatInterval(30000); // 间隔30秒
		return stFactory;
	}

	@Bean
	public JobFactory jobFactory() {
		return new QuartzJobFactory();
	}

	@Bean
	public SchedulerFactoryBean schedulerFactoryBean() {
		SimpleTrigger trigger = simpleTriggerFactoryBean().getObject();
		JobFactory jobFactory = jobFactory();

		SchedulerFactoryBean scheduler = new SchedulerFactoryBean();
		scheduler.setTriggers(trigger);
		scheduler.setJobFactory(jobFactory);
		return scheduler;
	}

}