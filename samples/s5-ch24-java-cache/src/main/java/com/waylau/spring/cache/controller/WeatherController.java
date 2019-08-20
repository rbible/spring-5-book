package com.waylau.spring.cache.controller;

import com.waylau.spring.cache.vo.Weather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.waylau.spring.cache.service.WeatherDataService;
import com.waylau.spring.cache.vo.WeatherResponse;

/**
 * 天气控制器.
 *
 * @author <a href="https://waylau.com">Way Lau</a>
 * @since 1.0.0 2017年9月2日
 */
@RestController
@RequestMapping("/weather")
public class WeatherController {

	@Autowired
	private WeatherDataService weatherDataService;

	@GetMapping("/cityId/{cityId}")
	public WeatherResponse getReportByCityId(@PathVariable("cityId") String cityId) {
		return weatherDataService.getDataByCityId(cityId);
	}

	@GetMapping("/cityName/{cityName}")
	public WeatherResponse getReportByCityName(@PathVariable("cityName") String cityName) {
		return weatherDataService.getDataByCityName(cityName);
	}

	@GetMapping("/clean/{cityId}")
	public WeatherResponse clean(@PathVariable("cityId") String cityId) {
		Boolean result = weatherDataService.cleanCache(cityId);

		WeatherResponse weatherResponse = new WeatherResponse();
		weatherResponse.setData(null);
		weatherResponse.setStatus(result + "");
		weatherResponse.setDesc("缓存清理完成");
		return weatherResponse;
	}
}
