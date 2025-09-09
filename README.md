# IT4045C-group4-project
Group 4 project repo for IT4045C Enterprise Application Development (Fall 2025).

## Project Design Document

**Repo link:** https://github.com/havensir/IT4045C-group4-project

**Design Board Link:** https://github.com/users/havensir/projects/2

# Group PSA: Please **ALWAYS** branch off `dev`, **not** main.

### 1. Introduction
*Section Owner: Isabella (PO / Scrum Master / DevOps / GitHub Admin)* 

[Write a short description of your project here.]  

- **Problem Statement:** What problem are we solving?  
  - [ANSWER HERE]  
- **Tech Stack:** What technologies will we use?  
  - [ANSWER HERE]  
- **Users & Value:** What will the user experience look like?  
  - [ANSWER HERE]  

---

### 2. Storyboard (Screen Mockups)
*Owner: Silas (UI Specialist)*  

- Add mockups/screenshots in `/docs/mockups/`.  
- Each screen should have a short caption explaining its purpose.  
- Tools like PowerPoint, Figma, InVision, or Paint are fine.  

**Screens to include:**  
- **Screen 1 – [Description / Image link]**  
- **Screen 2 – [Description / Image link]**  
- **Screen 3 – [Description / Image link]**  

---

### 3. Functional Requirements
*Owner: Team (**each member contributes one**, total 2–4 stories max per rubric)*

**Format:**
- **As a [User]**  
- **I want [Feature]**  
- **So that I can [Do something]**

Include **Given / When / Then** acceptance criteria for each story (cover good data, bad data, and edge cases).


#### EXAMPLE Starter Stories  
1) **Login Feature (UI focus)**  
- As a user, I want to log in so that I can access my personal dashboard.  
  - **Given** I am on the login page  
  - **When** I enter valid credentials  
  - **Then** I am redirected to the dashboard  
  - **And** I see my name and a success message  
  - **When** I enter invalid credentials  
  - **Then** I remain on the login page with an error message

2) **Data Persistence Feature (BL focus)**  
- As a user, I want my changes saved so that I can see updated data when I log back in.  
  - **Given** I update an item in my list  
  - **When** I refresh or log out/in  
  - **Then** the updated data is still present in my list

** Team Stories (placeholders for now): **
 
*[Isabella's Story]*
- As a **?**, I want **?**, so that I can **?**.
  - **Given** [some context or precondition]
  - **When** [an action is taken]
  - **Then** [the expected outcome happens]

*[Silas' Story]*
- As a **?**, I want **?**, so that I can **?**.
  - **Given** [some context or precondition]
  - **When** [an action is taken]
  - **Then** [the expected outcome happens]

*[Nathan's Story]*
- As a **?**, I want **?**, so that I can **?**.
  - **Given** [some context or precondition]
  - **When** [an action is taken]
  - **Then** [the expected outcome happens]

*[Christopher's Story]*
- As a **?**, I want **?**, so that I can **?**.
  - **Given** [some context or precondition]
  - **When** [an action is taken]
  - **Then** [the expected outcome happens]

---

### 4. Class Diagram
*Owner: Nathan (Business Logic & Persistence Specialist)*  

- Add UML diagram image to `/docs/diagrams/` and link it here.  
  `![Class Diagram](./docs/diagrams/class-diagram.png)`

**Class descriptions (1–2 lines each; replace with actual classes):**
- **User** — id, email, role; owns domain objects and permissions.  
- **Item** — core entity for the app’s main feature (id, name, status, timestamps).  
- **ItemController / ItemService / ItemRepository** — REST endpoints, business rules, persistence.

---

### 5. JSON Schema
*Owner: Christopher (Developer – Support/Flex)*

This project exposes at least one REST endpoint that returns JSON. Draft schema below (can be generated from a Java DTO via [QuickType.io](https://quicktype.io/)).

```json
{
  "title": "Example Item",
  "type": "object",
  "properties": {
    "id": { "type": "integer", "minimum": 1 },
    "name": { "type": "string" },
    "status": { "type": "string", "enum": ["ACTIVE", "ARCHIVED"] },
    "createdAt": { "type": "string", "format": "date-time" },
    "updatedAt": { "type": "string", "format": "date-time" }
  },
  "required": ["id", "name", "status"]
}
```
---

### 6. Scrum Roles
- **PO / Scrum Master / DevOps / GitHub Admin:** Isabella Havens

- **UI Specialist:** Silas Curry

- **Business Logic & Persistence Specialist:** Nathan Dahlquist 

- **Developer (Support/Flex):** Christopher Manzon


---

### 7. GitHub Project & Milestones
*Owner: Isabella (PO / Scrum Master / DevOps)*
- Project Board: https://github.com/users/havensir/projects/2

**Milestones:** (due dates TBD)

- Milestone #1: Design & Sprint 1 *(Sprint 1 tasks and stories will be detailed on the GitHub Project Board.)*
- Milestone #2: Sprint 2
- Milestone #3: Final Release
  
---

### 8. Stand-Up Meetings
- **Chosen schedule (replaces guide’s Sunday 8:00 suggestion): Tuesdays @ 11:00 AM ET**

- **Platform:** Microsoft Teams

- **Notes:** Meeting time is flexible and may shift depending on individual group members’ schedules or events. 
Isabella will send a post-stand-up recap and to-do list after each meeting.