import java.io.*;
import java.util.*;
class N_meetings_in_one_room
{
    static class Meeting
    {
        int number;
        int start;
        int end;
        public Meeting(int number, int start, int end)
        {
            this.number=number;
            this.start=start;
            this.end=end;
        }
    }
    static class MeetingComparator implements Comparator<Meeting>
    {
        @Override
        public int compare(Meeting meet1,Meeting meet2)
        {
            if(meet1.end<meet2.end) 
                return -1;
            else if(meet2.end>meet1.end)
                return 1;
            else if(meet1.number<meet2.number)
                return -1;
            return 1; 
        }
    }
    static int maxMeetings(int n, int start[], int end[])
    {
        ArrayList<Meeting> meetings = new ArrayList<>();

        for(int i=0;i<n;i++)
        {
            meetings.add(new Meeting(i+1,start[i],end[i]));
        }

        MeetingComparator mc = new MeetingComparator();
        Collections.sort(meetings,mc);

        int endTime=meetings.get(0).end;
        int count=1;
        for(int i=1;i<n;i++)
        {
            Meeting currMeeting= meetings.get(i);
            if(currMeeting.start>endTime)
            {
                count++;
                endTime=currMeeting.end;
            }
        }
        return count;

    }

    public static void main(String args[])
    {
        int n=6;
        int start[]={1,3,0,5,8,5};
        int end[]={2,4,6,7,9,9};
       System.out.println(maxMeetings(n,start,end));
   }
}
