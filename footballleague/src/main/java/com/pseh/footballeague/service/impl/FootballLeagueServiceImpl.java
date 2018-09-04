/**
 * 
 */
package com.pseh.footballeague.service.impl;

import static com.pseh.footballeague.constant.FootballLeagueConstants.ACTION;
import static com.pseh.footballeague.constant.FootballLeagueConstants.API_KEY;
import static com.pseh.footballeague.constant.FootballLeagueConstants.EQUALS;
import static com.pseh.footballeague.constant.FootballLeagueConstants.QUERY_APPENDER;
import static com.pseh.footballeague.constant.FootballLeagueConstants.QUERY_PARAM_KEY;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.pseh.footballeague.service.FootballLeagueService;

@Service
public class FootballLeagueServiceImpl implements FootballLeagueService {

	@Value("${api.url}")
	private String apiUrl;
	
	@Value("${api.countryaction}")
	private String countryAction;

	
	@Value("${api.apikey}")
	private String apiKey;

	
	@Override
	public String getCountryList() {

		RestTemplate restTemplate = new RestTemplate();
		StringBuilder url = new StringBuilder();
		url.append(apiUrl);
		url.append(QUERY_PARAM_KEY);
		url.append(ACTION);
		url.append(EQUALS);
		url.append(countryAction);
		url.append(QUERY_APPENDER);
		url.append(API_KEY);
		url.append(EQUALS);
		url.append(apiKey);
		System.out.println(url.toString());
		String result = restTemplate.getForObject(url.toString(), String.class);

		System.out.println(result);
		return result;
	}


	@Override
	public String getLeagueList(String countryId) {
		RestTemplate restTemplate = new RestTemplate();
		/*StringBuilder url = new StringBuilder();
		url.append(apiUrl);
		url.append(QUERY_PARAM_KEY);
		url.append(ACTION);
		url.append(EQUALS);
		url.append(countryAction);
		url.append(QUERY_APPENDER);
		url.append(API_KEY);
		url.append(EQUALS);
		url.append(apiKey);
		System.out.println(url.toString());*/
		String url = "https://apifootball.com/api/?action=get_leagues&country_id=";
		url = url + countryId;
		url = url + "&APIkey=";
		url = url + apiKey;
		String result = restTemplate.getForObject(url, String.class);

		System.out.println(result);
		return result;
	}


	@Override
	public String getLeagueTeams(String leagueId) {
		RestTemplate restTemplate = new RestTemplate();
		/*StringBuilder url = new StringBuilder();
		url.append(apiUrl);
		url.append(QUERY_PARAM_KEY);
		url.append(ACTION);
		url.append(EQUALS);
		url.append(countryAction);
		url.append(QUERY_APPENDER);
		url.append(API_KEY);
		url.append(EQUALS);
		url.append(apiKey);
		System.out.println(url.toString());*/
		String url = "https://apifootball.com/api/?action=get_standings&league_id=";
		url = url + leagueId;
		url = url + "&APIkey=";
		url = url + apiKey;
		
		System.out.println(url);
		String result = restTemplate.getForObject(url, String.class);

		System.out.println(result);
		return result;
	}


	@Override
	public String getTeamStandings(String countryId, String leagueId, String teamId) throws ParseException {
		RestTemplate restTemplate = new RestTemplate();
		/*StringBuilder url = new StringBuilder();
		url.append(apiUrl);
		url.append(QUERY_PARAM_KEY);
		url.append(ACTION);
		url.append(EQUALS);
		url.append(countryAction);
		url.append(QUERY_APPENDER);
		url.append(API_KEY);
		url.append(EQUALS);
		url.append(apiKey);
		System.out.println(url.toString());*/
		String url = "https://apifootball.com/api/?action=get_standings&league_id=";
		url = url + leagueId;
		url = url + "&APIkey=";
		url = url + apiKey;
		
		String result = restTemplate.getForObject(url, String.class);
		JSONParser parser = new JSONParser();
		JSONObject returnObj = new JSONObject();
		JSONArray ja = (JSONArray)parser.parse(result);
		for(int i =0; i <ja.size();i++){
			JSONObject obj = (JSONObject)ja.get(i);
			if(teamId.equals(obj.get("team_name"))){
				returnObj.put("country_name", obj.get("country_name"));
				returnObj.put("country_id", countryId);
				returnObj.put("league_id", obj.get("league_id"));
				returnObj.put("league_name", obj.get("league_name"));
				returnObj.put("team_name", obj.get("team_name"));
				returnObj.put("overall_league_position", obj.get("overall_league_position"));	
				break;
			}
		}
		
		return returnObj.toJSONString();
	}

}
