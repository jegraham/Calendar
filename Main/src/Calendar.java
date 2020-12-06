public class Calendar {
    /***
     * Input: [Meeting(0, 1), Meeting(3, 5), Meeting(4, 8), Meeting(10, 12), Meeting(9, 10)]
     * Output: [Meeting(0, 1), Meeting(3, 8), Meeting(9, 12)]
     *
     * Solution Description:
     * Iterate through the originally provided list and add to a new array.
     * Once the array has been generated, iterate through and find the overlaps.
     * Return the overlaps and print out (return).
     *
     * Other Variations:
     * - This could be used to see a years worth of schedules or longer perhaps by days busy in a year. Someting that can grow exponentially
     * - Iterate through the list one at a time to see if there is a match (similar to dominos or anomia) and just modify the existing list as needed.
     ***/

    public static void main(String[] args) {
        boolean [] isBooked = new boolean [16]; //Reinder 9am to 5pm/17hr
        Meeting [] meeting = new Meeting [5]; //Creating Meeting array
        meeting[0] = new Meeting(0, 1);
        meeting[1] = new Meeting(3, 5);
        meeting[2] = new Meeting(4, 8);
        meeting[3] = new Meeting(10, 12);
        meeting[4] = new Meeting(9, 10);

        /*
        00 = 09:00 - 09:30
        01 = 09:30 - 10:00
        02 = 10:00 - 10:30
        03 = 10:30 - 11:00
        04 = 11:00 - 11:30
        05 = 11:30 - 12:00
        06 = 12:00 - 12:30
        07 = 12:30 - 13:00
        08 = 13:00 - 13:30
        09 = 13:30 - 14:00
        10 = 14:00 - 14:30
        11 = 14:30 - 15:00
        12 = 15:00 - 15:30
        13 = 15:30 - 16:00
        14 = 16:00 - 16:30
        15 = 16:30 - 17:00
         */


        //Iterating through the meeting list in half hour blocks
        for (int i = 0; i <= meeting.length-1; i++) {
            isBooked[(meeting[i].getStartTime())] = true;

            //If it is greater then a difference of one then we need to iterate through the others of the list
            if ((meeting[i].getStartTime() + 1) < meeting[i].getEndTime() ){
               for (int end = meeting[i].getStartTime()+1; end <= meeting[i].getEndTime()-1; end++ ){
                   isBooked[end] = true;
               }// End of Inner For Loop
            }// End of If
        }// End of Outer For Loop

        int pointer = 0;//will point to the next block of meetings scheduled
        int ended = 0;

        //Reading the list
        for (int x = 0; x <= isBooked.length-1; x++){
            //find the start then go to the end of the block.

            if (isBooked[x] == true) {
                //Is this one block or more then one?
                if (isBooked[x+1] == true) {
                    // add and continue
                    inner: for (int last = x; last <= isBooked.length-1; last++) {
                        if (isBooked[last] == false){
                            ended = last - 1;
                            break inner;
                        }
                    }//End Inner For Loop
                }//End Inner If

                meeting[pointer] = new Meeting(x, (ended+1));
                System.out.println("Start: " + x + " End " + (ended+1));
                pointer = pointer +1;
                x = ended; //moving the pointer for start

            }// End Outer If
        }//End Outer For Loop

    }

}
