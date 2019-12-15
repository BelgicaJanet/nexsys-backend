package com.cbolije.nexsysbackend.service;


import com.cbolije.nexsysbackend.model.dto.GraphAttendee;
import com.cbolije.nexsysbackend.model.dto.GraphEvent;
import com.cbolije.nexsysbackend.model.entity.Attendance;
import com.cbolije.nexsysbackend.model.entity.Event;
import com.cbolije.nexsysbackend.model.entity.Partner;
import com.google.gson.Gson;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service
public class EventService {

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

        }

    }

}
