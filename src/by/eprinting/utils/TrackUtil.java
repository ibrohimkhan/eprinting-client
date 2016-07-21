package by.eprinting.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

import by.eprinting.beans.Payment;
import by.eprinting.beans.Track;
import by.eprinting.services.db.TrackDBService;

public class TrackUtil {
	public static final String IN_QUEUE 				= "In queue";
	public static final String PREPEARING_FOR_PRINTING 	= "Prepearing for printing";
	public static final String PRINTING 				= "Printing";
	public static final String PREPEARING_FOR_DELIVERY 	= "Prepearing for delivery";
	public static final String DELIVERIED 				= "Deliveried";
	
	public static Track creatTrack(Payment payment) {
		Track track = new Track();
		track.setPayment(payment);
		track.setState(IN_QUEUE);
		
		String serial = payment.getOrder().getEmail() + payment.getDate();

		track.setTrackNumber(generateSerialTrackNumber(serial));
		track.setStartDate(new Date().getTime());
		
		long id = TrackDBService.creatTrack(track);
		track.setId(id);
		
		return track;
	}

	private static String generateSerialTrackNumber(String serial) {
		String hexMessageEncode = "";
		MessageDigest msg = null;
		
		try {
			msg = MessageDigest.getInstance("SHA1");
			
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		msg.update(serial.getBytes());
		byte[] msgBytes = msg.digest();

		for (int index = 0; index < msgBytes.length; index++) {
			int countEncode = msgBytes[index] & 0xff;
			if (Integer.toHexString(countEncode).length() == 1) hexMessageEncode = hexMessageEncode + "0";
			hexMessageEncode = hexMessageEncode + Integer.toHexString(countEncode);
		}
		
		return hexMessageEncode;
	}
}
