package com.joinup.ui;

import com.joinup.model.Attendee;
import com.joinup.model.Event;
import com.joinup.service.IAttendeeService;
import com.joinup.service.IEventService;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.OutputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Controller
@RequestMapping("/ui/tickets")
public class TicketController {

    private final IAttendeeService attendees;
    private final IEventService events;

    public TicketController(IAttendeeService attendees, IEventService events) {
        this.attendees = attendees;
        this.events = events;
    }

    private Attendee getAttendeeOrThrow(String attendeeId) {
        Attendee a = attendees.getById(attendeeId);
        if (a == null) {
            throw new org.springframework.web.server.ResponseStatusException(
                    org.springframework.http.HttpStatus.NOT_FOUND, "Ticket not found");
        }
        Event e = events.getEventById(a.getEventId());
        if (e == null) {
            throw new org.springframework.web.server.ResponseStatusException(
                    org.springframework.http.HttpStatus.NOT_FOUND, "Event not found");
        }
        return a;
    }

    @GetMapping("/{attendeeId}")
    public String ticket(@PathVariable String attendeeId, Model model) {
        Attendee a = getAttendeeOrThrow(attendeeId);
        Event e = events.getEventById(a.getEventId());

        model.addAttribute("attendee", a);
        model.addAttribute("event", e);
        model.addAttribute("active", "tickets");
        model.addAttribute("hero", "Your Ticket");
        return "ticket-detail";
    }

    /** NEW: generate a minimal PDF version of the ticket */
    @GetMapping("/{attendeeId}/download")
    public void download(@PathVariable String attendeeId, HttpServletResponse res) {
        Attendee a = getAttendeeOrThrow(attendeeId);
        Event e = events.getEventById(a.getEventId());

        res.setContentType("application/pdf");
        res.setHeader("Content-Disposition", "attachment; filename=ticket-" + attendeeId + ".pdf");

        try (PDDocument doc = new PDDocument()) {
            PDPage page = new PDPage(PDRectangle.LETTER);
            doc.addPage(page);

            try (PDPageContentStream cs = new PDPageContentStream(doc, page)) {
                float x = 64, y = page.getMediaBox().getHeight() - 72;

                // Brand header
                cs.beginText();
                cs.setFont(PDType1Font.HELVETICA_BOLD, 22);
                cs.newLineAtOffset(x, y);
                cs.showText("JoinUp Ticket");
                cs.endText();
                y -= 28;

                // Event name
                cs.beginText();
                cs.setFont(PDType1Font.HELVETICA_BOLD, 18);
                cs.newLineAtOffset(x, y);
                cs.showText(e.getName() != null ? e.getName() : "Event");
                cs.endText();
                y -= 20;

                // Meta
                cs.beginText();
                cs.setFont(PDType1Font.HELVETICA, 12);
                cs.newLineAtOffset(x, y);
                cs.showText("Date/Time: " + (e.getDateTime() != null ? e.getDateTime() : "-"));
                cs.endText(); y -= 16;

                cs.beginText();
                cs.setFont(PDType1Font.HELVETICA, 12);
                cs.newLineAtOffset(x, y);
                cs.showText("Location : " + (e.getLocation() != null ? e.getLocation() : "-"));
                cs.endText(); y -= 24;

                // Attendee block
                cs.beginText();
                cs.setFont(PDType1Font.HELVETICA_BOLD, 14);
                cs.newLineAtOffset(x, y);
                cs.showText("Attendee");
                cs.endText(); y -= 16;

                cs.beginText();
                cs.setFont(PDType1Font.HELVETICA, 12);
                cs.newLineAtOffset(x, y);
                String fullName = ((a.getFirstName() != null ? a.getFirstName() : "") + " " +
                                   (a.getLastName()  != null ? a.getLastName()  : "")).trim();
                cs.showText("Name    : " + (fullName.isBlank() ? "-" : fullName));
                cs.endText(); y -= 16;

                cs.beginText();
                cs.setFont(PDType1Font.HELVETICA, 12);
                cs.newLineAtOffset(x, y);
                cs.showText("Email   : " + (a.getEmail() != null ? a.getEmail() : "-"));
                cs.endText(); y -= 24;

                // Ticket code
                cs.beginText();
                cs.setFont(PDType1Font.COURIER_BOLD, 16);
                cs.newLineAtOffset(x, y);
                cs.showText("Ticket Code: " + (a.getId() != null ? a.getId() : "-"));
                cs.endText(); y -= 28;

                // Footer
                cs.beginText();
                cs.setFont(PDType1Font.HELVETICA_OBLIQUE, 10);
                cs.newLineAtOffset(x, 84);
                String ts = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
                cs.showText("Generated by JoinUp · " + ts);
                cs.endText();
            }

            try (OutputStream os = res.getOutputStream()) {
                doc.save(os);
            }
        } catch (Exception ex) {
            throw new org.springframework.web.server.ResponseStatusException(
                org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR, "Could not generate PDF", ex);
        }
    }
}
