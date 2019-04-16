package utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class CommonUtils {
	private static final String ddMMYYFormat = "dd-MM-yyyy";

	private static final String ddMMYYYYHHMMSSFormat = "dd-MM-yyyy hh:mm:ss";

	private static final SimpleDateFormat dateFormatter = new SimpleDateFormat(ddMMYYFormat);
	private static final DateFormat timeStampFormatter = new SimpleDateFormat(ddMMYYYYHHMMSSFormat);

	public static Date getDate(String property) 
	{
		try
		{
			return dateFormatter.parse(property);
		}
		catch(Exception e)
		{
			return null;
		}
	}
	public static Date getDateTime(String property) 
	{
		try
		{
			return timeStampFormatter.parse(property);
		}
		catch(Exception e)
		{
			return null;
		}
	}

}
