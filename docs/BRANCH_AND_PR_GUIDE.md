# 🌿 Git Branching & Pull Request Workflow

This guide explains how to safely contribute to the **JoinUp Event Attendance Tracker** repository using branches and pull requests.  
Following this workflow ensures clean collaboration and prevents accidental commits to the `dev` branch.

---

## 🚫 Do NOT Commit Directly to `dev`

The `dev` branch serves as the shared integration branch.  
All changes must go through **feature branches** and **pull requests** for review before merging.

---

## 🧩 Steps to Create a Branch from Your Issue

1. **Make sure your local `dev` is up to date:**

   ```bash
   git checkout dev
   git pull origin dev
   ```

2. **Create a new branch for your issue:**

   ```bash
   git checkout -b issue-XX-short-description
   ```

   Example:
   ```bash
   git checkout -b issue-28-controller-tests
   ```

3. **Work on your feature or fix.**  
   Commit often with clear messages:
   ```bash
   git add .
   git commit -m "Implemented controller logic tests for /api/events"
   ```

4. **Push your branch to GitHub:**
   ```bash
   git push origin issue-28-controller-tests
   ```

---

## 🧠 Opening a Pull Request (PR)

1. Go to the repository on GitHub.
2. Click **Compare & Pull Request** next to your branch.
3. Fill in PR details:
   - **Base branch:** `dev`
   - **Compare branch:** your feature branch (e.g. `issue-28-controller-tests`)
   - Include a clear description of your changes and testing notes.
4. Submit for review.

Once approved, it will be merged into `dev` by a reviewer or project lead.

---

## 🔁 Keeping Your Branch Updated

If `dev` changes while you are working:

```bash
git checkout dev
git pull origin dev
git checkout issue-28-controller-tests
git merge dev
```

Resolve any merge conflicts before pushing again.

---

## ✅ Summary

✔️ Always branch from `dev`  
✔️ Never commit directly to `dev`  
✔️ Use descriptive branch names (e.g., `issue-28-controller-tests`)  
✔️ Submit PRs for review before merging  

---

**Maintainer:** Silas Curry  
**Last Updated:** October 2025
