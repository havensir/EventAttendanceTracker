# 🌿 Git Branching & Pull Request Workflow (GitHub Web UI)

This guide explains how to safely contribute to the **JoinUp Event Attendance Tracker** repository using **GitHub’s web interface**.  
Following this workflow ensures clean collaboration and prevents accidental commits directly to the `dev` branch.

---

## 🚫 Do NOT Commit Directly to `dev`

The `dev` branch is the shared development branch used by all contributors.  
You should **always create your own feature branch** before making any edits or commits.  
This helps maintain a clean history and prevents overwriting teammates’ work.

---

## 🧩 Creating a New Branch from Your Issue

1. **Open the repository** on GitHub (e.g., `github.com/havensir/EventAttendanceTracker`).

2. In the top left corner, click the **branch dropdown** (usually says `dev`).

3. In the text box that appears, **type a new branch name** using the issue number and description, then press **Enter**:  
   ```
   issue-28-controller-tests
   ```
   This creates your branch **based on the current `dev` branch**.

4. You will now see GitHub automatically switch you to your new branch.

---

## ✏️ Making Changes in the GitHub UI

1. Navigate to the file you want to edit (for example, a `.java`, `.md`, or `.html` file).  
2. Click the **pencil (✏️) icon** in the top-right corner of the file to edit it.  
3. Make your changes and scroll to the bottom of the page.  
4. In the “Commit changes” section:
   - Add a short and clear **commit message** (e.g., `Add controller logic tests for events API`).
   - Select **“Commit directly to the `issue-28-controller-tests` branch.”**
   - Click **Commit changes**.

Repeat this for any additional files you need to update.

---

## 🧠 Opening a Pull Request (PR)

Once your changes are complete:

1. At the top of the repository, click the **Pull Requests** tab.  
2. Click **New pull request**.  
3. Under **base branch**, select `dev`.  
4. Under **compare branch**, select your branch (e.g., `issue-28-controller-tests`).  
5. Review the file changes to confirm everything looks correct.  
6. Click **Create pull request**.  
7. Fill in:
   - A **title** summarizing your changes (e.g., “Add Event Controller Tests”).
   - A **description** explaining what you changed, why, and how it was tested.
8. Click **Create pull request** again to submit it for review.

A maintainer or reviewer will review your PR before merging it into `dev`.

---

## 🔁 Keeping Your Branch Updated (Optional)

If someone else has merged updates into `dev` while you were working:

1. Go to your Pull Request page.
2. GitHub may show a message like “This branch is out of date with the base branch.”
3. Click **Update branch** (GitHub will automatically merge the latest `dev` changes into your branch).

If there are **merge conflicts**, GitHub will guide you through resolving them online before the PR can be merged.

---

## ✅ Summary

✔️ Always create a branch from `dev`  
✔️ Never commit directly to `dev`  
✔️ Use descriptive branch names like `issue-28-controller-tests`  
✔️ Commit changes directly to your feature branch  
✔️ Open a Pull Request targeting `dev` for review  

---

**Maintainer:** Silas Curry  
**Last Updated:** October 2025
