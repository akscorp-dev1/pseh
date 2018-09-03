/**
 * 
 */
package com.pseh.footballeague.service;

import org.json.simple.parser.ParseException;

public interface FootballLeagueService {

	public String getCountryList();

	public String getLeagueList(String countryId);

	public String getLeagueTeams(String leagueId);

	public String getTeamStandings(String countryId, String leagueId, String teamId) throws ParseException;
}
