package by.eprinting.services;

import java.util.Date;
import java.util.List;

import org.apache.commons.fileupload.FileItem;
import by.eprinting.beans.Order;
import by.eprinting.utils.FileUtil;

public class OrderService {
	public static Order createOrder(List<FileItem> items) {

		Order order = new Order();
		for (FileItem item : items) {

			if (item.getContentType() == null) {
				switch (item.getFieldName()) {
					case "fullname":
						order.setFullName(FileUtil.toUTF8(item.getString()));
						break;
						
					case "email":
						order.setEmail(item.getString());
						break;
						
					case "phone":
						order.setPhone(item.getString());
						break;
						
					case "address":
						order.setAddress(FileUtil.toUTF8(item.getString()));
						break;
				}
			}
		}
		
		order.setDate(new Date());
		return order;
	}
}