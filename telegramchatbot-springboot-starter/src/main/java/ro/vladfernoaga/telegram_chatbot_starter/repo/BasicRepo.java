package ro.vladfernoaga.telegram_chatbot_starter.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

//import ro.vladfernoaga.telegram_chatbot_starter.model.BasicInfo;
import ro.vladfernoaga.telegram_chatbot_starter.model.Geography;

public interface BasicRepo extends JpaRepository<Geography, Long>{

	//Optional<BasicInfo> findById(Long name);
	
	//Optional<BasicInfo>	findByName(String name);
	
	Optional<Geography> findPlaceByName(String name);

}
