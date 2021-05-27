package com.shms.map;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shms.wearlog.WearLog;

@RestController
public class MapController {
	@Autowired
	private MapServiceImpl mapService;
	
	@GetMapping("/") //http://localhost:8080  aws = http://15.164.67.165/
	public ModelAndView Monitoring() {
		ModelAndView mav = new ModelAndView("/map/monitoring");
		List<WearLog> rows = null;
		try {
			rows = mapService.listWearLog();
			mav.addObject("rows", rows);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return mav;
	}
	
	@GetMapping("/personal") //http://localhost:8080/map/personal
	public ModelAndView Personal() {
		ModelAndView mav = new ModelAndView("/map/personal");
		
		List<WearLog> rows = null;
		try {
			rows = mapService.personalWearLog();
			mav.addObject("rows", rows);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return mav;
	}
	
	@GetMapping("/monitoring") //http://localhost:8080/map/monitoring
	public String monitoring() {
		
		List<WearLog> rows = null;
		String result = null;
		
		try {
			ObjectMapper mapper = new ObjectMapper();
			rows = mapService.renewalWearLog();
			if (rows != null) {
				result = mapper.writeValueAsString(rows);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
}
