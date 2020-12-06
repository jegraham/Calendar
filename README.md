# Calendar

Inspiration from Interview Cake "Your company built an in-house calendar tool called HiCal. You want to add a feature to see the times in a day when everyone is available" https://www.interviewcake.com/question/python/merging-ranges?course=fc1&amp;section=array-and-string-manipulation

Your company built an in-house calendar tool called HiCal. You want to add a feature to see the times in a day when everyone is available.

To do this, you’ll need to know when any team is having a meeting. In HiCal, a meeting is stored as an object of a Meeting class with integer variables startTime and endTime. These integers represent the number of 30-minute blocks past 9:00am.

  public class Meeting {

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



For Example:

new Meeting(2, 3);  // meeting from 10:00 – 10:30 am
new Meeting(6, 9);  // meeting from 12:00 – 1:30 pm


Write a method mergeRanges() that takes a list of multiple meeting time ranges and returns a list of condensed ranges.

For example, given:

  [Meeting(0, 1), Meeting(3, 5), Meeting(4, 8), Meeting(10, 12), Meeting(9, 10)]


your method would return:

  [Meeting(0, 1), Meeting(3, 8), Meeting(9, 12)]


Do not assume the meetings are in order. The meeting times are coming from multiple teams.

Write a solution that's efficient even when we can't put a nice upper bound on the numbers representing our time ranges. Here we've simplified our times down to the number of 30-minute slots past 9:00 am. But we want the method to work even for very large numbers, like Unix timestamps. In any case, the spirit of the challenge is to merge meetings where startTime and endTime don't have an upper bound.

Questions about the Questions
------------------------------------------
- Will the meeting times always start at 9am? What happens if we have a meeting at 8am? 
- When do meetings end? 5pm? Midnight?
- How will we receive the meeting times?


Assumptions
------------------------------------------
- Will need to order the meetings
- Meetings will always start at 9:00am (1) 
- Values will be between 9am and 5pm (no end time, assuming business day)
- Every meeting is a minimum of 30 minutes
- Array of meetings

Ideas 
-------------------------------------------
1. Read the inputted meeting times and create an array (quick insertion and traversal) and then iterate through the array again to find overlaps.. The default size of the array should be large enough for the 9 to 5pm. (Array Size 16 by my math). This will be Memory of O(1) and Time of O(n^2). 

2. Add the meetings and adjust the meetings list (in-place) until we hit the end of the list. We know worst, case we have to go to the end of the list and there are no changes. If there is a change we will need to adjust the previous list... Still thinking on how to accomplish this in a better time and memory.

3. Iterate through the list one at a time to see if there is a match (similar to dominos or anomia) and just modify the existing list as needed. Memory is O(Constant) and Time will be O(n^2). 
    

Test Cases 
--------------------------------------------
- Empty set 
- negative values or after 5pm 



