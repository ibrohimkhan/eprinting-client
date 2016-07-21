package by.eprinting.services.db;

import by.eprinting.beans.Track;
import by.eprinting.dao.BaseDAO;
import by.eprinting.dao.TrackJdbcImpl;

public class TrackDBService {
	private static BaseDAO track = new TrackJdbcImpl();
	
	public static long creatTrack(Track item) {
		return track.insert(item);
	}
	
	public static Track findTrackById(long id) {
		return track.selectById(id);
	}
	
	public static void deleteTrack(Track item) {
		DocumentDBService.deleteDocument(item.getPayment().getOrder().getDocument());
	}
	
	public static void updateTrack(Track item) {
		track.update(item);
	}
	
	public static Track findBy(String serial) {
		return track.findBy(serial);
	}
}
