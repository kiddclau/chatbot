package ro.vladfernoaga.telegram_chatbot_starter.handler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.model.request.ForceReply;
import com.pengrad.telegrambot.model.request.ParseMode;
import com.pengrad.telegrambot.request.SendMessage;

import ro.vladfernoaga.telegram_chatbot_starter.dto.GeographyDto;

@Service
public class SimpleUpdateHandler implements UpdatesListener {

	/** The Constant LOGGER. */
	 private static final Logger LOGGER = LogManager.getLogger();
	
	@Autowired
	private TelegramBot bot;
	private GeographyDto city;
	ArrayList<String> list = new ArrayList<String>();
	//db
	
	DatabaseMethod db = new DatabaseMethod();
	
	public void request(String oras) {
	
		city = db.getOrasDetails(oras);
	}
	
	
	@Override
	public int process(List<Update> updates) {
	
		
		for (Update update : updates) {
			Integer chatId = update.message().from().id();
			String messageText = update.message().text();
			String messageText1 = update.message().text();
			Integer messageId = update.message().messageId();
			this.list=db.getOrase();

			
			
			if (messageText.toLowerCase().equals("orase")) {
				this.list = db.getOrase();
				int counter = 0;
				for (String oras: list) {
					counter++;
					SendMessage request2 = new SendMessage(chatId, String.format("We have following cities in the app: " + counter+". "+oras))
							.parseMode(ParseMode.HTML)
							.disableNotification(false)
							;
					bot.execute(request2);
				}
			}
			
			//clau
			    for (String search : list) {
			    if (search.contains(messageText)) {
				request(messageText);
				SendMessage request2 = new SendMessage(chatId, String.format("The choosen city is "+ messageText+". "+" We can offer the following details: " +" 1.Climate-> " +city.getClimate()+" 2.Population-> "+city.getPopulation()+" 3.History-> "+city.getHistory()))
						.parseMode(ParseMode.HTML)
						.disableNotification(false)

						;
				bot.execute(request2);
				
				
				}
			    
			   /* String climate="climate";
			    if (search.contains(messageText))  {
			    	request(messageText);
					SendMessage request2 = new SendMessage(chatId, String.format(city.getClimate()))
							.parseMode(ParseMode.HTML)
							.disableNotification(false)

							;
					bot.execute(request2);
				
				
				}*/   
			     
			}
			    for (String search : list) {
			    	 if (search.contains(messageText))  {
					    	request(messageText);
							SendMessage request2 = new SendMessage(chatId, String.format(city.getClimate()))
									.parseMode(ParseMode.HTML)
									.disableNotification(false)

									;
							bot.execute(request2);
						
						
						}
				}
			    
			    //just climate 
			   /* for (String search : list) {
				    if ((search.contains(messageText)) && (messageText1.contains("climate"))) {
				    	request(messageText);
						SendMessage request2 = new SendMessage(chatId, String.format(city.getClimate()))
								.parseMode(ParseMode.HTML)
								.disableNotification(false)

								;
						bot.execute(request2);
					
					
					}
				}
			*/
			
			//
			/*
			else { 
				if (list.size() != 0) {
							request(messageText);
							SendMessage request2 = new SendMessage(chatId, String.format(city.getClimate()))
									.parseMode(ParseMode.HTML)
									.disableNotification(false)

									;
							bot.execute(request2);
							SendMessage request3 = new SendMessage(chatId, String.format(city.getHistory()))
									.parseMode(ParseMode.HTML)
									.disableNotification(false)

									;
							bot.execute(request3);
							SendMessage request4 = new SendMessage(chatId, String.format(city.getPopulation().toString()))
									.parseMode(ParseMode.HTML)
									.disableNotification(false)

									;
							bot.execute(request4);
							SendMessage request5 = new SendMessage(chatId, String.format(city.getOther_details()))
									.parseMode(ParseMode.HTML)
									.disableNotification(false)

									;
							bot.execute(request5);
				}
		
			}
			*/
			
		
//			if (messageText.toLowerCase().equals("brasov")) {
//				request(messageText);
//	
//				
//				
//			//	break;
//			}
			
//			if (messageText.toLowerCase().contains("clima brasov")) {
//				
//				SendMessage request1 = new SendMessage(chatId, String.format(db.climate))
//						.parseMode(ParseMode.HTML)
//						.disableNotification(false)
//						.replyToMessageId(messageId)
//						.replyMarkup(new ForceReply())
//						;
//				bot.execute(request1);
//							}
//			
//			
//			if (messageText.toLowerCase().contains("istorie brasov")) {
//				
//				SendMessage request1 = new SendMessage(chatId, String.format(db.history))
//						.parseMode(ParseMode.HTML)
//						.disableNotification(false)
//						.replyToMessageId(messageId)
//						.replyMarkup(new ForceReply())
//						;
//				bot.execute(request1);
//							}
			
			
			if (messageText.toLowerCase().contains("sal")) {
				
				SendMessage request1 = new SendMessage(chatId, String.format("Salut si tie. Cum te-as putea ajuta?"))
						.parseMode(ParseMode.HTML)
						.disableNotification(false)
						.replyToMessageId(messageId)
						.replyMarkup(new ForceReply())
						;
				bot.execute(request1);
			}
			
			if (messageText.toLowerCase().contains("ce faci")) {
				
				SendMessage request1 = new SendMessage(chatId, String.format("Sunt putin cam obosit, tu ce faci?"))
						.parseMode(ParseMode.HTML)
						.disableNotification(false)
						.replyToMessageId(messageId)
						.replyMarkup(new ForceReply())
						;
				bot.execute(request1);
			}
			
               if (messageText.toLowerCase().contains("informatii")) {
				
				SendMessage request1 = new SendMessage(chatId, String.format("Despre ce loc vrei informatii?"))
						.parseMode(ParseMode.HTML)
						.disableNotification(false)
						.replyToMessageId(messageId)
						.replyMarkup(new ForceReply())
						;
				bot.execute(request1);
				
				
				
				if (messageText.toLowerCase().contains("informatii")) {
					
				}
				
			}
			
			
			
			/*DBtest*/
			/*switch(messageText) { 
			case "Ce faci?" : 
					SendMessage request3 = new SendMessage(chatId, String.format("Sunt putin cam obosit, tu ce faci?"))
					.parseMode(ParseMode.HTML)
					.disableNotification(false)
					.replyToMessageId(messageId)
					.replyMarkup(new ForceReply())
					;
			bot.execute(request3);
			        break; 
			    case "Ma poti ajuta?" : 
					SendMessage request4 = new SendMessage(chatId, String.format("Desigur, te pot ajuta. Spune-mi doar ce ai vrea sa stii despre un anumit loc"))
					.parseMode(ParseMode.HTML)
					.disableNotification(false)
					.replyToMessageId(messageId)
					.replyMarkup(new ForceReply())
					;
			bot.execute(request4); 
			        break; 
			    case "Multumesc" : 
					SendMessage request5 = new SendMessage(chatId, String.format("Mersi si eu pentru timpul acordat, mai vorbim. Salut!"))
					.parseMode(ParseMode.HTML)
					.disableNotification(false)
					.replyToMessageId(messageId)
					.replyMarkup(new ForceReply())
					;
			bot.execute(request5);
			        break; 
			    default: 
			    	SendMessage request6 = new SendMessage(chatId, String.format("Foarte interesant omule!"))
					.parseMode(ParseMode.HTML)
					.disableNotification(false)
					.replyToMessageId(messageId)
					.replyMarkup(new ForceReply())
					;
			bot.execute(request6);
			}*/
			
		}
		
		return UpdatesListener.CONFIRMED_UPDATES_ALL;
	}

}