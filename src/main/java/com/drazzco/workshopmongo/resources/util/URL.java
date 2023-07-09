package com.drazzco.workshopmongo.resources.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.time.Instant;

public class URL {

	public static String decodeParam(String text)
	{
		try {
			return URLDecoder.decode(text, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			return "";
		}
	}
	
	public static Instant convertDate(String textDate)
	{
		String date = textDate + "T00:00:00Z";
		return Instant.parse(date);
	}
}
