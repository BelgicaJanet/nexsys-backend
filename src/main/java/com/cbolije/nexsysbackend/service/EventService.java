package com.cbolije.nexsysbackend.service;


import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cbolije.nexsysbackend.dao.EventDao;
import com.cbolije.nexsysbackend.model.dto.GraphAttendee;
import com.cbolije.nexsysbackend.model.dto.GraphEvent;
import com.cbolije.nexsysbackend.model.dto.RestResponse;
import com.cbolije.nexsysbackend.model.entity.Meeting;
import com.google.gson.Gson;

@Service
public class EventService {
	
	private EventDao eventDao;
	
	@Autowired
	public EventService(EventDao eventDao) {
		this.eventDao = eventDao;
	}

    public void processEventData(List<GraphEvent> graphEvents) {

        Gson gson = new Gson();

        for (GraphEvent gEvent : graphEvents) {

            if (gEvent.getAttendees() == null || gEvent.getAttendees().isEmpty()) {
                continue;
            }

            for (GraphAttendee attendee : gEvent.getAttendees()) {
                String email = attendee.getEmailAddress().getAddress();
                String domain = email.substring(email.indexOf("@") + 1 );

                if (!Objects.equals(domain, "nexsys.com")) {
                    gEvent.setPartnerDomain(domain);
                    break;
                }
            }

            gEvent.setEventDate(gEvent.getStart().getDateTime());

            String eventJson = gson.toJson(gEvent);
            this.eventDao.processData(eventJson);

        }

    }

    public RestResponse<List<Meeting>> getEventsByUser(long id) {
    	RestResponse<List<Meeting>> response = new RestResponse<List<Meeting>>();
    	List<Meeting> meetings = eventDao.getEventsByUser(id);

    	if (meetings == null || meetings.isEmpty()) {
            return response.returnError("No se encontraron reuniones para el usuario " + id);
        }
    	return response.returnSuccess("Se encontraron reuniones", meetings);
    }
    
}
