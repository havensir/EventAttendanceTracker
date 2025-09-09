# IT4045C-group4-project
Group 4 project repo for IT4045C Enterprise Application Development (Fall 2025).

## Project Design Document

### 1. Introduction
[Write a short description of your project here.]  
- What problem does it solve?  
- What technologies will you use?  
- What will the user experience look like?  

---

### 2. Storyboard (Screen Mockups)
Include mockups/screens here (link images or describe). Tools like PowerPoint, Paint, Figma, InVision, etc. are fine.  

- Screen 1: [Description / Image link]  
- Screen 2: [Description / Image link]  
- Screen 3: [Description / Image link]  

---

### 3. Functional Requirements
Write user stories in this format:  
- **As a [User]**  
- **I want [Feature]**  
- **So that I can [Do something]**

#### Example Starter Stories
1. As a user, I want to log in so that I can access my personal dashboard.  
   - **Given** I am on the login page  
   - **When** I enter valid credentials  
   - **Then** I am redirected to the dashboard  

2. As a user, I want to add items to a list so that I can track them later.  
   - **Given** I am on the main page  
   - **When** I click “Add Item” and enter text  
   - **Then** the item appears in my list  

[Add 2–4 stories of your own here, each with Given/When/Then examples.]

---

### 4. Class Diagram
[Insert a simple UML diagram here or link to it in `/docs/`.]

#### Class Descriptions
- **User**: [Description]  
- **Item**: [Description]  
- **GameEngine**: [Description]  
[Add/replace with your actual classes.]

---

### 5. JSON Schema
Your project must expose a REST endpoint returning JSON. Show a draft schema here.  
You can generate one from a Java class using [QuickType.io](https://quicktype.io/).

```json
{
  "title": "Example Item",
  "type": "object",
  "properties": {
    "id": { "type": "integer" },
    "name": { "type": "string" },
    "createdAt": { "type": "string", "format": "date-time" }
  },
  "required": ["id", "name"]
}
```
---

### 6. Scrum Roles
- Product Owner: [Name]  
- Scrum Master: [Name]  
- DevOps: [Name]  
- Developers: [Names]  

---

### 7. GitHub Project Link
- UPDATE WITH ACTUAL LINK LATER ON: [Project Board]()
  
---

### 8. Stand-Up Meetings
- Weekly Meeting: [Day/Time]
- Platform: [Teams/Zoom/etc.]
- Notes: [Any extra info about your stand-ups]

---
