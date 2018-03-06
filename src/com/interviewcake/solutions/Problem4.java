package com.interviewcake.solutions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Comparator;
import java.util.Collections;

class Problem4 {

    public static class Meeting {

        private int startTime;
        private int endTime;

        public Meeting(int startTime, int endTime) {
            // number of 30 min blocks past 9:00 am
            this.startTime = startTime;
            this.endTime   = endTime;
        }

        public int getStartTime() {
            return startTime;
        }

        public void setStartTime(int startTime) {
            this.startTime = startTime;
        }

        public int getEndTime() {
            return endTime;
        }

        public void setEndTime(int endTime) {
            this.endTime = endTime;
        }
    }

    public static List<Meeting> mergeRanges(List<Meeting> meetings) {

        // merge meeting ranges
        // Make a copy so that we dont destroy the input.
        List<Meeting> sortedMeetings = new ArrayList<Meeting>();
        for(Meeting meeting : meetings){
            Meeting copy = new Meeting(meeting.getStartTime(), meeting.getEndTime());   
            sortedMeetings.add(copy);
        }
        
        Collections.sort(sortedMeetings,new Comparator<Meeting>() {
           @Override
           public int compare(Meeting m1, Meeting m2){
               return m1.getStartTime()-m2.getStartTime();
           }
        });
        
        List<Meeting> mergedMeetings = new ArrayList<>();
        mergedMeetings.add(sortedMeetings.get(0));

        for(Meeting meeting: sortedMeetings){
            Meeting lastMerged = mergedMeetings.get(mergedMeetings.size()-1);
            if(meeting.getStartTime() <= lastMerged.getEndTime()){
                lastMerged.setEndTime(Math.max(lastMerged.getEndTime(),meeting.getEndTime()));
            }   
            else{
                mergedMeetings.add(meeting);
            }
        }

        return mergedMeetings;
    }

    public static void main(String[] args) {
        Meeting[] meetings = {
            new Meeting(0, 1),
            new Meeting(3, 5),
            new Meeting(4, 8),
            new Meeting(10, 12),
            new Meeting(9, 10)
        };

        List<Meeting> result = mergeRanges(Arrays.asList(meetings));
        for (Meeting meeting: result) {
            System.out.printf("(%d, %d) ", meeting.getStartTime(),
                                meeting.getEndTime());
        }
        System.out.println();
    }
}