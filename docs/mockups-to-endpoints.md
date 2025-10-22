# Mockups ↔ Endpoints (Milestone 1)

## Purpose
This document maps the current UI mockups (or planned screens) to their corresponding backend API endpoints.  
For **Milestone 1**, the goal is to verify that all routes are reachable and responding, even though the business logic has not yet been implemented.

---

## Endpoint Overview

| Mockup / UI Screen             | Description / Purpose                         | Endpoint                   | Method | Current Status |
|--------------------------------|------------------------------------------------|----------------------------|---------|----------------|
| **Events List (Home)**         | Displays a list of upcoming events.            | `/api/events`              | `GET`   | ✅ Reachable — Returns `501 (Not Implemented)` placeholder JSON |
| **Event Detail → Attendees**   | Shows attendees for a specific event.          | `/api/attendees?eventId=`  | `GET`   | ✅ Reachable — Returns `501 (Not Implemented)` placeholder JSON |
| **Event Detail → Check-ins**   | Displays check-in records or statuses.         | `/api/checkins?eventId=`   | `GET`   | ✅ Reachable — Returns `501 (Not Implemented)` placeholder JSON |

---

## Notes
- **HTTP 501 (Not Implemented)** is used intentionally to indicate that each route is defined and responsive, even though the logic is not yet completed.
- This verifies successful routing and frontend-backend communication, satisfying the **Milestone 1 connectivity goal**.
- Full business logic and data integration will be implemented in **Milestone 2**.

---

## Screenshots
Screenshots showing browser and `mock-fetch.html` test results are stored in:

