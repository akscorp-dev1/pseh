/**
 * 
 */
package com.pseh.footballeague.endpoint;

import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pseh.footballeague.service.FootballLeagueService;

/**
 * @author shisaxen
 *
 */
@RestController
public class FootballLeagueEndPoint {
	
	@Autowired
	FootballLeagueService footballLeagueService;
	
	@RequestMapping(value = "/countries",method = RequestMethod.GET)
	public String getCountryList(){
		return footballLeagueService.getCountryList();
	}
	
	
	@RequestMapping(value = "/countries/{countryId}/leagues",method = RequestMethod.GET)
	public String getLeaugesList(@PathVariable String countryId){
		return footballLeagueService.getLeagueList(countryId);
	}
	
	
	@RequestMapping(value = "/leagues/{leagueId}/teams",method = RequestMethod.GET)
	public String getLeaugeTeams(@PathVariable String leagueId){
		return footballLeagueService.getLeagueTeams(leagueId);
	}
	
	@RequestMapping(value = "countries/{countryId}/leagues/{leagueId}/teams/{teamId}/standing",method = RequestMethod.GET)
	public String getTeamStanding(@PathVariable String countryId,@PathVariable String leagueId,@PathVariable String teamId) throws ParseException{
		return footballLeagueService.getTeamStandings(countryId,leagueId,teamId);
	}
}
