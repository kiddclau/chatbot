package ro.vladfernoaga.telegram_chatbot_starter.service;


import ro.vladfernoaga.telegram_chatbot_starter.dto.BasicInfoDto;
import ro.vladfernoaga.telegram_chatbot_starter.dto.GeographyDto;

public interface BasicService {

	//BasicInfoDto addNewOrGetExisting(String name);
	GeographyDto readTownFromName(String place_name);
}
