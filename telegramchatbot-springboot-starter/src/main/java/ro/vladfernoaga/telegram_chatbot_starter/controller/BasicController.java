package ro.vladfernoaga.telegram_chatbot_starter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ro.vladfernoaga.telegram_chatbot_starter.dto.BasicInfoDto;
import ro.vladfernoaga.telegram_chatbot_starter.dto.GeographyDto;
import ro.vladfernoaga.telegram_chatbot_starter.service.BasicService;

@RestController
public class BasicController {

	private BasicService basicService;

	@Autowired
	public BasicController(BasicService basicService) {
		this.basicService = basicService;
	}

//	@RequestMapping(value = "/basicinfo/{name}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
//	public ResponseEntity<BasicInfoDto> getStudent(@PathVariable("name") String name) {
//		return ResponseEntity.ok().body(basicService.addNewOrGetExisting(name));
//	}
	
	@RequestMapping(value = "/towninfo/{place_name}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	public ResponseEntity<GeographyDto> getTown(@PathVariable("place_name") String place_name) {
		GeographyDto rsp = basicService.readTownFromName(place_name);
		return new ResponseEntity<GeographyDto>(rsp, HttpStatus.OK);
	}
}
