package com.shabir.problemsolving.random;
/*

We have a catalog of song titles (and their lengths) that we play at a local radio station.  We have been asked to play two of those songs in a row, and they must add up to exactly seven minutes long.

Given a list of songs and their durations, write a function that returns the names of any two distinct songs that add up to exactly seven minutes.  If there is no such pair, return an empty collection.

Example:
song_times_1 = [
    ("Stairway to Heaven", "8:05"), ("Immigrant Song", "2:27"),
    ("Rock and Roll", "3:41"), ("Communication Breakdown", "2:29"),
    ("Good Times Bad Times", "2:48"), ("Hot Dog", "3:19"),
    ("The Crunge", "3:18"), ("Achilles Last Stand", "10:26"),
    ("Black Dog", "4:55")
]
find_pair(song_times_1) => ["Rock and Roll", "Hot Dog"] (3:41 + 3:19 = 7:00)

Additional Input:
song_times_2 = [
    ("Stairway to Heaven", "8:05"), ("Immigrant Song", "2:27"),
    ("Rock and Roll", "3:41"), ("Communication Breakdown", "2:29"),
    ("Good Times Bad Times", "2:48"), ("Black Dog", "4:55"),
    ("The Crunge", "3:18"), ("Achilles Last Stand", "10:26"),
    ("The Ocean", "4:31"), ("Hot Dog", "3:19"),
]
song_times_3 = [
    ("Stairway to Heaven", "8:05"), ("Immigrant Song", "2:27"),
    ("Rock and Roll", "3:41"), ("Communication Breakdown", "2:29"),
    ("Hey Hey What Can I Do", "4:00"), ("Poor Tom", "3:00"),
    ("Black Dog", "4:55")
]
song_times_4 = [
    ("Hey Hey What Can I Do", "4:00"), ("Rock and Roll", "3:41"),
    ("Communication Breakdown", "2:29"), ("Going to California", "3:30"),
    ("Black Mountain Side", "2:00"), ("Black Dog", "4:55")
]
song_times_5 = [("Celebration Day", "3:30"), ("Going to California", "3:30")]
song_times_6 = [
  ("Rock and Roll", "3:41"), ("If I lived here", "3:59"),
  ("Day and night", "5:03"), ("Tempo song", "1:57")
]


Complexity Variable:
n = number of song/time pairs

All Test Cases - snake_case:
find_pair(song_times_1) => ["Rock and Roll", "Hot Dog"]
find_pair(song_times_2) => ["Rock and Roll", "Hot Dog"] or ["Communication Breakdown", "The Ocean"]
find_pair(song_times_3) => ["Hey Hey What Can I Do", "Poor Tom"]
find_pair(song_times_4) => []
find_pair(song_times_5) => ["Celebration Day", "Going to California"]
find_pair(song_times_6) => ["Day and night", "Tempo song"]

All Test Cases - camelCase:
findPair(songTimes1) => ["Rock and Roll", "Hot Dog"]
findPair(songTimes2) => ["Rock and Roll", "Hot Dog"] or ["Communication Breakdown", "The Ocean"]
findPair(songTimes3) => ["Hey Hey What Can I Do", "Poor Tom"]
findPair(songTimes4) => []
findPair(songTimes5) => ["Celebration Day", "Going to California"]
findPair(songTimes6) => ["Day and night", "Tempo song"]


*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SongLength {

  public static void main(String[] argv) {
    String[][] songTimes1 = {
        {"Stairway to Heaven", "8:05"}, {"Immigrant Song", "2:27"},
        {"Rock and Roll", "3:41"}, {"Communication Breakdown", "2:29"},
        {"Good Times Bad Times", "2:48"}, {"Hot Dog", "3:19"},
        {"The Crunge", "3:18"}, {"Achilles Last Stand", "10:26"},
        {"Black Dog", "4:55"}
    };
    String[][] songTimes2 = {
        {"Stairway to Heaven", "8:05"}, {"Immigrant Song", "2:27"},
        {"Rock and Roll", "3:41"}, {"Communication Breakdown", "2:29"},
        {"Good Times Bad Times", "2:48"}, {"Black Dog", "4:55"},
        {"The Crunge", "3:18"}, {"Achilles Last Stand", "10:26"},
        {"The Ocean", "4:31"}, {"Hot Dog", "3:19"}
    };
    String[][] songTimes3 = {
        {"Stairway to Heaven", "8:05"}, {"Immigrant Song", "2:27"},
        {"Rock and Roll", "3:41"}, {"Communication Breakdown", "2:29"},
        {"Hey Hey What Can I Do", "4:00"}, {"Poor Tom", "3:00"},
        {"Black Dog", "4:55"}
    };
    String[][] songTimes4 = {
        {"Hey Hey What Can I Do", "4:00"}, {"Rock and Roll", "3:41"},
        {"Communication Breakdown", "2:29"}, {"Going to California", "3:30"},
        {"Black Mountain Side", "2:00"}, {"Black Dog", "4:55"}
    };
    String[][] songTimes5 = {
        {"Celebration Day", "3:30"}, {"Going to California", "3:30"}
    };
    String[][] songTimes6 = {
        {"Rock and Roll", "3:41"}, {"If I lived here", "3:59"},
        {"Day and night", "5:03"}, {"Tempo song", "1:57"}
    };

    List<String> result = findPair(songTimes1);
    System.out.println(result);
    result = findPair(songTimes2);
    System.out.println(result);
    result = findPair(songTimes3);
    System.out.println(result);
    result = findPair(songTimes4);
    System.out.println(result);
    result = findPair(songTimes5);
    System.out.println(result);
    result = findPair(songTimes6);
    System.out.println(result);
  }

  private static List<String> findPair(String[][] songTimes) {
    Map<String, List<String>> songTimeMap = new HashMap<>();
    List<String> songPair = new ArrayList<>();
    for (String[] songTime : songTimes) {
      String time = songTime[1];
      if (!checkEligibleTime(time)) {
        continue;
      }
      String timeDiff = calculateTimeDifference(time);
      if (songTimeMap.containsKey(timeDiff)) {
        List<String> eligibleSongNames = songTimeMap.get(timeDiff);
        eligibleSongNames = eligibleSongNames.stream().filter(songName ->
            !songName.equals(songTime[0])).collect(Collectors.toList());
        if (eligibleSongNames != null && eligibleSongNames.size() > 0) {
          int randomSongIndex = (int) (Math.random() * eligibleSongNames.size());
          songPair.add(songTime[0]);
          songPair.add(eligibleSongNames.get(randomSongIndex));
          break;
        }
      }
      List<String> songNames;
      if (songTimeMap.containsKey(time)) {
        songNames = songTimeMap.get(time);
        songNames.add(songTime[0]);
        continue;
      }
      songNames = new ArrayList<>();
      songNames.add(songTime[0]);
      songTimeMap.put(time, songNames);
    }
    return songPair;
  }

  private static boolean checkEligibleTime(String time) {
    String[] timeArray = time.split(":");
    int minutes = Integer.valueOf(timeArray[0]);
    if (minutes > 6) {
      return false;
    }
    return true;
  }

  private static String calculateTimeDifference(String time) {
    String[] timeArray = time.split(":");
    int minutes = Integer.valueOf(timeArray[0]);
    int seconds = Integer.valueOf(timeArray[1]);

    String minuteDiff = String.valueOf(6 - minutes);
    String secondDiff = String.valueOf(60 - seconds);
    if (secondDiff.equals("60")) {
      minuteDiff = String.valueOf(Integer.parseInt(minuteDiff) + 1);
      secondDiff = "00";
    }
    secondDiff = secondDiff.length() == 1 ? ("0" + secondDiff) : secondDiff;
    String timeDiff = minuteDiff + ":" + secondDiff;
    return timeDiff;
  }
}

