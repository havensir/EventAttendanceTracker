# 🎟️ Event Attendance Tracker
This is the Group 4 project repo for IT4045C Enterprise Application Development (Fall 2025).

## Group PSA 🚨
Please **ALWAYS** branch off `dev`, **not** main.

## 📑 Project Design Document
### 📝 Introduction 

EventAttendanceTracker is a web application used by event organizers and attendees to streamline event check-in and attendance tracking.

- **Organizers** can: 
  - create/manage events
  - register/import attendees
  - Check in attendees (via QR code or manually)
  - View live dashboards
  - Export reports

- **Attendees** can:
  - Register for events
  - Receive a QR ticket
  - Quickly check in

This system replaces manual sign-in sheets with a faster, more accurate digital workflow that provides real-time insights.

---

### 🚀 Startup Notes
*Key startup notes will eventually go here*

---

### 🖼️ Storyboard (Screen Mockups)
*Owner: **Silas (UI Specialist)** → mockups in `/docs/mockups/`*
## JoinUp Wireframes & Flows

This describes the user experience for the JoinUp app, focusing on what the user sees and does at each step. Screens are described by their function and user-facing content, not by internal names.

### Check-In Flow

- The user is greeted personally and prompted to check in to an event.
- The user views a list of events and tickets, each with details.
- After checking in, the user receives confirmation and encouragement, plus a list of other events to explore.


### Host Flow

- The user is welcomed and prompted to host an event.
- The user fills out event details (name, description, location, time, image).
- The user enters contact information, which is auto-filled but editable.
- The user previews how guests will see the event.
- The user publishes the event and receives confirmation that it’s live and ready to share.



### RSVP Flow

- The user searches for events by city.
- The user browses a list of events, each with details and a button to view more.
- The user is prompted to register for an event.
- The user fills out a registration form with personal details, auto-filled but editable.
- The user receives confirmation of ticket purchase, with event and attendee details.
- The user is instructed on how to present the ticket at check-in (QR code/manual code).
- The user has the option to print the ticket.



## Flow Links

These frames are not set up with prototyping logic. You must use the arrow keys to progress through them.
- [Check-In Flow](https://www.figma.com/proto/Rb01LyZV0CP1YWRNN7Lal8/Untitled?node-id=65-1301&p=f&t=8ZFl9UUuSKDKGZCa-1&scaling=contain&content-scaling=fixed&page-id=)
- [Host Flow](https://www.figma.com/proto/Rb01LyZV0CP1YWRNN7Lal8/Untitled?node-id=65-1569&p=f&t=75spmTPWToZqb3fH-1&scaling=contain&content-scaling=fixed&page-id=65%3A1375)
- [RSVP Flow](https://www.figma.com/proto/Rb01LyZV0CP1YWRNN7Lal8/Untitled?node-id=65-1789&p=f&t=xrycxG5dpdJhCWfK-1&scaling=contain&content-scaling=fixed&page-id=65%3A1573)



---

### ⚙️ Functional Requirements
*Owner: **Team** (each member contributes one; total 2–4 stories max per rubric)*

Each story must use the format:
- As a **[User]**, I want **[Feature]** so that **[Benefit]**
- Include acceptance criteria using **Given / When / Then**. Cover at least:
  - Valid data
  - Invalid data
  - Edge cases
 
✅ Isabella’s Story (Organizer – QR Check-In)
  - As an **Organizer**, I want **to scan attendee QR codes**, so that I can **quickly check them in**.
    - **Given** a valid ticket QR code
    - **When** I scan it on the Check-In page
    - **Then** the attendee is marked present and a confirmation is shown
    - **When** I scan an invalid/duplicate code
    - **Then** I see an error message

🖼️ Silas’ Story (UI)
- *Example idea: “As an Attendee, I want to register online so I can receive a QR ticket.”*
- 👉 Fill in your user story below.
  -  As a **?**, I want **?**, so that I can **?**.
      - **Given** [some context or precondition]
      - **When** [an action is taken]
      - **Then** [the expected outcome happens]

💾 Nathan’s Story (Business Logic & Persistence)
- *Example idea: “As an Organizer, I want check-in data saved in the database so that it persists after refresh.”*
- 👉 Fill in your user story below.
  -  As a **?**, I want **?**, so that I can **?**.
      - **Given** [some context or precondition]
      - **When** [an action is taken]
      - **Then** [the expected outcome happens]

🛠️ Christopher’s Story (Support/Flex)
  -  As an **Attendee**, I want **to register for an event online by filling out a simple form or scanning a shared link**, so that I can **can secure my spot at the event without needing to register on-site**.
      - **Given** I open the event registration page,
      - **When** I provide my name, email, and required details,
      - **Then** I receive a confirmation email and a unique QR code for event check-in.
      - **Given** I mistype my email,
      - **When** I try to submit the form,
      - **Then** I should see a validation error and be prompted to correct my input.
      - **Given** I leave a required (such as name or email )field empty,
      - **When** I try to submit the form,
      - **Then** I should see an error prompting me to complete all required fields before submission.
      - **Given** the event has reached the maximum capacity,
      - **When** I attempt to register,
      - **Then** I should see a message that the event is full and cannot accept more registrations.
---

### 📊 Class Diagram
*Owner: **Nathan (Business Logic & Persistence Specialist)** → add diagram to `/docs/diagrams/`*  

👉 Nathan, please create a UML class diagram for the core system entities. Save it to `/docs/diagrams/`.

**Starter entities to include (refine/expand as needed):**
- Event — id, name, location, start/end times
- Session — id, eventId, name, start/end times
- Attendee — id, name, email, ticketCode
- Registration — links attendee to event, holds status (pending/confirmed/canceled)
- CheckIn — id, registrationId, sessionId, timestamp, method (QR/manual)
- User (Organizer) - id, email, role

---

### 🧾 JSON Schema
*Owner: **Christopher (Developer – Support/Flex)** → refine this schema & expand for other endpoints*

👉 Christopher, please use the starter CheckIn schema below as a base. Expand it to include **Event, Attendee, and Registration objects** so our API returns consistent, structured JSON. 

```json
{
  "title": "CheckIn",
  "type": "object",
  "properties": {
    "checkInId": { "type": "integer", "minimum": 1 },
    "registrationId": { "type": "integer" },
    "ticketCode": { "type": "string" },
    "checkInTime": { "type": "string", "format": "date-time" },
    "method": { "type": "string", "enum": ["QR", "MANUAL"] }
  },
  "required": ["checkInId", "registrationId", "ticketCode", "checkInTime", "method"]
}
```

---

### 👥 Scrum Roles
- **PO / Scrum Master / DevOps / GitHub Admin:** Isabella Havens
- **UI Specialist:** Silas Curry
- **Business Logic & Persistence Specialist:** Nathan Dahlquist 
- **Developer (Support/Flex):** Christopher Manzon

---

### 🔗 GitHub Links
- [Event Attendance Tracker](https://github.com/havensir/EventAttendanceTracker) 
- [Design Board](https://github.com/users/havensir/projects/2)
- [Milestones](https://github.com/havensir/EventAttendanceTracker/milestones)

---

### 📅 Group Stand-Up Meetings
- **Schedule:** Tuesdays @ 11:00 AM ET
- **Platform:** Microsoft Teams
- **Notes:** Isabella will send recaps and task lists after each meeting.
