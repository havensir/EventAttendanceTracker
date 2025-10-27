# 🎟️ Event Attendance Tracker: *JoinUp*
This is the Group 4 project repo for IT4045C Enterprise Application Development (Fall 2025).

## 🚨 Group 4 PSA 🚨

### Please *ALWAYS* **branch** off of `dev`, **not** `main`!

The `dev` branch is our shared development environment — **never commit directly to `dev`**.  
Each contributor must create a **new branch for their issue or feature** before making changes.

### ✅ Correct Workflow

1. **Start from `dev`**
   - On GitHub, select the `dev` branch from the branch dropdown.
2. **Create your own branch**
   - Name it after your issue or task (e.g., `issue-28-controller-tests`).
3. **Make your edits**
   - Commit directly to *your branch only* — not to `dev`.
4. **Open a Pull Request (PR)**
   - Compare your branch → `dev`.
   - Add a clear title and description of what you changed.
   - Wait for review and approval before merging.

➡️ See full directions in [`/docs/BRANCH_AND_PR_GUIDE_UI.md`](./docs/BRANCH_AND_PR_GUIDE_UI.md).

---

### 🧩 Project Setup Reminder

If you haven’t set up the project yet, follow the step-by-step instructions here:  
📘 [`/docs/SETUP_AND_RUN.md`](./docs/SETUP_AND_RUN.md)

This includes:
- Installing Java 17+ and Maven 3.8+
- Running the Spring Boot app on `localhost:8080`
- Using the mock UI tester for endpoint validation
- Generating and viewing test reports

Let’s keep our workflow clean and consistent — this helps everyone avoid merge conflicts, broken builds, and lost work.  
Thank you for branching responsibly! 🙌

## 📝 Introduction

Our EventAttendanceTracker, also known as *JoinUp*, is a web application to be used by event organizers and attendees to streamline event check-in and attendance tracking.

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


## 🚀 Startup Notes
### 🌐 Application Navigation Guide

Below are the key URLs for navigating through the JoinUp web application once it’s running locally (`http://localhost:8080`):

| **Page / Feature** | **URL** | **Description** |
|---------------------|----------|------------------|
| 🔐 **Login Page** | [`/login`](http://localhost:8080/login) | Default login screen for users to sign in. |
| 🏠 **Home Dashboard** | [`http://localhost:8080/`](http://localhost:8080/) | Displays personalized overview and navigation links after logging in. |
| 🎟️ **Events List** | [`/ui/events`](http://localhost:8080/ui/events) | Lists all upcoming events with location filters and RSVP options. |
| 🗓️ **Event Details & RSVP** | [`/ui/events/E-001`](http://localhost:8080/ui/events/E-001) | Event info page with RSVP form for attendees. |
| ✅ **RSVP Confirmation** | [`/ui/events/E-001/rsvp/confirm?attendeeId=A-50482CE2`](http://localhost:8080/ui/events/E-001/rsvp/confirm?attendeeId=A-50482CE2) | Confirmation screen **after** RSVP submission. |
| 🎫 **Ticket View** | [`/ui/tickets/A-50482CE2`](http://localhost:8080/ui/tickets/A-50482CE2) | Displays attendee’s ticket with event and user info. |
| 🧾 **All Tickets** | [`/ui/tickets`](http://localhost:8080/ui/tickets) | Lists all tickets registered by the current user. |
| 🧠 **API Route Tester** | [`/ui/api-tester`](http://localhost:8080/ui/api-tester) | Internal testing tool for API endpoints and JSON data validation. |
| 👥 **User Directory** | [`/users`](http://localhost:8080/users) | Admin page showing all users, roles, and contact info. |
| ✏️ **Edit User Profile** | [`/users/6/edit`](http://localhost:8080/users/6/edit) | Edit screen for updating user details, roles, or deleting accounts. |
| 📤 **Host Event Hub** | [`/ui/host`](http://localhost:8080/ui/host) | (Planned feature) Hub for creating and publishing events as an organizer. |

---

### 🧩 Requirements
- Java 17 or higher
- Maven (or use VS Code Spring Boot Extension Pack)
- VS Code or IntelliJ installed  

### ▶️ Running the Application (Using Code)

If you’re using **VS Code** or **IntelliJ**, open the integrated terminal and run:

```bash
mvn spring-boot:run
```
Once the app starts successfully, you’ll see:

```bash
Tomcat started on port(s): 8080
Started JoinUpApplication in [x.xxx] seconds
```


## 🖼️ Storyboard (Screen Mockups)
*→ Mockups can be found in `/docs/mockups/`*

### JoinUp Wireframes & Flows

This describes the user experience for the JoinUp app, focusing on what the user sees and does at each step. Screens are described by their function and user-facing content, not by internal names.

### A. Check-In Flow

- The user is greeted personally and prompted to check in to an event.
- The user views a list of events and tickets, each with details.
- After checking in, the user receives confirmation and encouragement, plus a list of other events to explore.

### B. Host Flow

- The user is welcomed and prompted to host an event.
- The user fills out event details (name, description, location, time, image).
- The user enters contact information, which is auto-filled but editable.
- The user previews how guests will see the event.
- The user publishes the event and receives confirmation that it’s live and ready to share.

### C. RSVP Flow

- The user searches for events by city.
- The user browses a list of events, each with details and a button to view more.
- The user is prompted to register for an event.
- The user fills out a registration form with personal details, auto-filled but editable.
- The user receives confirmation of ticket purchase, with event and attendee details.
- The user is instructed on how to present the ticket at check-in (QR code/manual code).
- The user has the option to print the ticket.


### 🔗 Flow Links

 ***Note:*** These frames are not set up with prototyping logic. You must use the arrow keys to progress through them.

- [Check-In Flow](https://www.figma.com/proto/Rb01LyZV0CP1YWRNN7Lal8/Untitled?node-id=65-1301&p=f&t=8ZFl9UUuSKDKGZCa-1&scaling=contain&content-scaling=fixed&page-id=)
- [Host Flow](https://www.figma.com/proto/Rb01LyZV0CP1YWRNN7Lal8/Untitled?node-id=65-1569&p=f&t=75spmTPWToZqb3fH-1&scaling=contain&content-scaling=fixed&page-id=65%3A1375)
- [RSVP Flow](https://www.figma.com/proto/Rb01LyZV0CP1YWRNN7Lal8/Untitled?node-id=65-1789&p=f&t=xrycxG5dpdJhCWfK-1&scaling=contain&content-scaling=fixed&page-id=65%3A1573)


## ⚙️ Functional Requirements
 
### 🎫 1. Organizer – Check-In
- As an **Organizer**, I want **to check in attendees using either a QR code or their 9-digit code**, so that I can **quickly check them in and confirm attendance**.

    - ✅ **Valid Data**
      - **Given** a valid QR code or 9-digit code,
      - **When** I scan it or enter it on the Check-In page,
      - **Then** the attendee is marked present and a confirmation is shown.
      - **Given** an attendee has not yet checked in,
      - **When** I scan their valid QR code or enter their valid 9-digit code,
      - **Then** their status updates to “Checked In” and the total attendance count increases by one.

    - ❌ **Invalid Data**
      - **Given** a duplicate code,
      - **When** I scan it or enter it on the Check-In page,
      - **Then** I see an error message and no new record is created.
      - **Given** an invalid code not found in the system,
      - **When** I attempt to scan or enter it,
      - **Then** I see an error message “Invalid Ticket” and the system does not update any records.

     - ⚠️ **Edge Case**
        - **Given** the scanner fails to read a QR code,
        - **When** I enter the attendee’s 9-digit code manually,
        - **Then** the attendee is successfully checked in and a confirmation is shown.

### 🙋 2. Attendee – Check-In
- As an **Attendee**, I want **to check in by scanning my QR code or providing my 9-digit code**, so that **entry is quick and seamless**.

    - ✅ **Valid Data**
      - **Given** I have a valid registration and a unique QR/9-digit code,
      - **When** I scan my QR code or provide my 9-digit code at the check-in station,
      - **Then** the system marks me as checked in, records the timestamp and method, and allows me entry.

    - ❌ **Invalid Data**
      - **Given** I present an invalid or duplicate QR code or 9-digit code,
      - **When** I attempt to check in,
      - **Then** I should see an error message and not be marked as checked-in.

    - ⚠️ **Edge Case**
      - **Given** the QR scanner fails to read my code,
      - **When** the organizer manually enters my 9-digit code,
      - **Then** the system still marks me as checked in, records the timestamp, and notes that the method was manual.


### 3. 🖼️ Attendee – Browse & RSVP (UI)
- As an **Attendee**, I want **to browse events in my city and RSVP easily**, so that **I can quickly find and register for local events that interest me**.

    - ✅ **Valid Data**
      - **Given** I am on the events page,
      - **When** I select my city from the search or filter options,
      - **Then** I see a list of upcoming events in my city, each with details (name, location, date/time) and a clear RSVP button.
      - **When** I click RSVP for an event,
      - **Then** I am prompted to fill out a registration form and, upon successful submission, receive a confirmation email with both a QR code and a 9-digit code for check-in.

    - ❌ **Invalid Data**
      - **Given** I am on the events page,
      - **When** I select a city with no upcoming events,
      - **Then** I see a friendly message indicating there are no events available in my city.
      - **Given** I am filling out the RSVP form,
      - **When** I leave required fields empty or enter an invalid email,
      - **Then** I see a clear error message prompting me to correct my input before submitting.

    - ⚠️ **Edge Cases**
      - **Given** I am on the events page,
      - **When** I attempt to RSVP for an event that is already full,
      - **Then** I see a message that registration is closed for that event.
      - **Given** I have RSVP’d to multiple events,
      - **When** I return to the events page,
      - **Then** I can easily view and manage my upcoming RSVPs and tickets.


### 4. 💾 Organizer – Event & Session Management (Business Logic & Persistence)
- As an **Organizer**, I want **the system to validate event times and session overlaps**, so that **scheduling conflicts are prevented**.

    - ✅ **Valid Data**
      - **Given** I schedule a session fully within the event’s start and end times,
      - **When** I save the session,
      - **Then** the system should accept it without conflict warnings.

    - ❌ **Invalid Data**
      - **Given** I am creating or updating an event with multiple sessions,
      - **When** I enter start and end times for a session that overlap with another,
      - **Then** I should see a validation error preventing me from saving until I resolve the conflict.

    - ⚠️ **Edge Case**
      - **Given** I attempt to create a session outside the main event’s time range,
      - **When** I try to save it,
      - **Then** I should see an error indicating that the session must occur within the event’s scheduled duration.

### 5. 🛠️ Attendee – Registration (Support/Flex)
- As an **Attendee**, I want **to register for an event online by filling out a simple form or scanning a shared link**, so that **I can secure my spot at the event without needing to register on-site**.

    - ✅ **Valid Data**
      - **Given** I open the event registration page,
      - **When** I provide my name, email, and required details,
      - **Then** I receive a confirmation email with a unique QR code and a 9-digit code for event check-in.

    - ❌ **Invalid Data**
      - **Given** I mistype my email,
      - **When** I try to submit the form,
      - **Then** I should see a validation error and be prompted to correct my input.
      - **Given** I leave a required (such as name or email) field empty,
      - **When** I try to submit the form,
      - **Then** I should see an error prompting me to complete all required fields before submission.

    - ⚠️ **Edge Case**
      - **Given** the event has reached the maximum capacity,
      - **When** I attempt to register,
      - **Then** I should see a message that the event is full and cannot accept more registrations.

## 📊 Class Diagram
*→ Diagrams can be found in `/docs/diagrams/`*  

![UML_Class_Diagram](/docs/diagrams/EventAttendanceTracker_UML.png)

## 🧾 JSON Schema

```json
{
"title": "CheckIn",
"type": "object",
"description": "Represents a single attendee check-in at an event or session.",
"properties":{
  "checkInId":{
    "type": "string",
    "description": "Unique ID for the check-in record(system generated)."
},
"anttendeeId": {
  "type": "string",
  "description": "Unique identifier for the attendee who is checking in."
},
"eventId": {
  "type": "string",
  "description": "Identifier of the event or session being attended."
},
"timestamp": {
  "type": "string",
  "format": "date-time",
  "description": "The exact time when the attendee checked in."
},
"status": {
  "type": "string",
  "enum": ["success", "duplicate", "invalid"],
  "description": "Result of the check-in attempt: success, duplicate scan, or invalid entry."
},
"method": {
  "type": "string",
  "enum": ["QR", "manual"],
  "description": "How the attendee checked in: by scanning QR code or manual lookup."
  }
},
"required": ["checkinId", "attendeeId", "eventId", "timestamp", "status", "method"]
}
```

**Examples of JSON Objects:**
  - QR Example:
```json
    {
      "checkinId": "CHK12345",
      "attendeeId": "ATT67890",
      "eventId": "EVT2025SPRING",
      "timestamp": "2025-09-16T14:05:00Z",
      "status": "success",
      "method": "QR"
    }
```

  - Manual Check-In Example:
```json
    {
      "checkinId": "CHK54321",
      "attendeeId": "ATT98765",
      "eventId": "EVT2025SPRING",
      "timestamp": "2025-09-16T14:10:00Z",
      "status": "success",
      "method": "manual"
    }
```

## 👥 Scrum Roles
- **PO / Scrum Master / DevOps / GitHub Admin:** Isabella Havens
- **UI Specialist:** Silas Curry
- **Business Logic & Persistence Specialist:** Nathan Dahlquist 
- **Developer (Support/Flex):** Christopher Manzon

## 🔗 GitHub Links
- [Event Attendance Tracker](https://github.com/havensir/EventAttendanceTracker) 
- [Design Board](https://github.com/users/havensir/projects/2)
- [Milestones](https://github.com/havensir/EventAttendanceTracker/milestones)


## 📅 Group Stand-Up Meetings
- **Schedule:** Tuesdays @ 11:00 AM ET
- **Platform:** Microsoft Teams
- **Notes:** Isabella will send recaps and task lists after each meeting.
