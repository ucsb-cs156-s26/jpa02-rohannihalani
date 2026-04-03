package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TeamTest {

    Team team;

    @BeforeEach
    public void setup() {
        team = new Team("test-team");    
    }

    @Test
    public void getName_returns_correct_name() {
       assertTrue(team.getName().equals("test-team"));
    }

    @Test
    public void toString_returns_correct_string() {
        assertEquals("Team(name=test-team, members=[])", team.toString());
    }

    @Test
    public void equals_returns_true_for_same_team() {
        Team team2 = new Team("test-team");
        assertTrue(team.equals(team2));
        
    }

    @Test
    public void equals_returns_false_for_different_name() {
        Team team2 = new Team("new-team");
        assertFalse(team.equals(team2));
    }

    @Test
    public void equals_returns_false_for_different_members() {
        Team team2 = new Team("test-team");
        team2.addMember("Alice");
        assertFalse(team.equals(team2));
    }

    @Test
    public void equals_returns_false_for_non_team_object() {
        assertFalse(team.equals("not a team"));
    }

    @Test
    public void equals_returns_true_for_same_teamObject() {
        assertTrue(team.equals(team));
    }

    @Test
    public void hashCode_same_for_equal_teams() {
        int result = team.hashCode();
        int expectedResult = -1226298695;
        assertEquals(expectedResult, result);
    }

   
}
