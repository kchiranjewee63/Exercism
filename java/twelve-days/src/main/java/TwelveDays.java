/*  Entire lyrics is generated first and stored in verseArray. Methods 
	verse(int verseNumber), verse(int startVerse, int endVerse), and sing()
	just use verseArray and return the expected outputs.*/
	
class TwelveDays {
	private static final String[] days = {"first", "second", "third", "fourth", "fifth", "sixth", "seventh", "eighth", "ninth", "tenth", "eleventh", "twelfth"};
	private static final String[] gifts = {"a Partridge in a Pear Tree", "two Turtle Doves", "three French Hens", "four Calling Birds", "five Gold Rings", "six Geese-a-Laying", "seven Swans-a-Swimming", "eight Maids-a-Milking", "nine Ladies Dancing", "ten Lords-a-Leaping", "eleven Pipers Piping", "twelve Drummers Drumming"};
	private static final String leftTemplate = "On the %s day of Christmas my true love gave to me: ";
	private static StringBuffer[] verseArray = new StringBuffer[12]; // Array for storing the entire lyrics
	
	static
	{
		//Generating the complete lyrics
		String leftText;
		StringBuffer rightText = new StringBuffer(); 
		for(int i = 0; i < 12; i++)
		{
			verseArray[i] = new StringBuffer();
			leftText = String.format(leftTemplate, days[i]);
			if (i == 0)
			{
				rightText.append(gifts[i]);
				verseArray[i].append(leftText).append(rightText).append(".\n");
				rightText.insert(0, "and ");
			}
			else
			{
				rightText.insert(0, gifts[i] + ", ");
				verseArray[i].append(leftText).append(rightText).append(".\n");
			}
		}
	}
	
    String verse(int verseNumber) {
        return verseArray[verseNumber -1].toString();
    }

    String verses(int startVerse, int endVerse) {
        StringBuffer allText = new StringBuffer();
		for(int i = startVerse; i <= endVerse; i++)
		{
			if(i != endVerse)
				allText.append(verseArray[i-1]).append("\n");
			else
				allText.append(verseArray[i-1]);
		}
		return allText.toString();
    }
    
    String sing() {
        return this.verses(1, 12);
    }
}
