# Content Moderation & Analytics Platform

This project is a web app where users can enter a bit of personal info (like their name, age, gender, and a larger text entry) and get a look at some interesting stats based on what everyone’s shared. This app has built-in content moderation, so it checks any text users submit to keep things appropriate. After they submit, users can see how their info looks compared to the community, like where they fall in the age range and the overall gender distribution. All this gets shown through simple charts!

## Quick Summary

This app does two main things:
1. **Data Submission**: Users fill out a form with their info, which goes through a content check (so nothing inappropriate sneaks through).
2. **Community Insights**: Users get to see where they fit into the bigger picture, like age distribution and gender breakdown, all in one place.
3. **Admin Page**: If time allows, the analytics would only be visible to an Admin.

It’s designed to keep everything in one interface, so users don’t have to jump between different places.

## Features

1. **Submit Your Info**:
   - Form includes:
     - Full Name
     - Age
     - Gender
     - A large text field for free-form input
   - The text gets checked by OpenAI’s Moderation API to make sure it’s suitable.

2. **Community Analytics**:
   - **Age Distribution**: Shows a bell curve of user ages.
   - **Gender Split**: Simple pie chart of gender distribution.
   - Some personalized feedback to show how each user’s info fits in the community data.

3. **One Unified Interface**:
   - Both submission and analytics are accessible together, so users can submit data and check out stats in the same place.

---



## Time Estimate & Planning

This is a rough time estimate of how long the project could/should take.

### Day 1: Backend

#### 1. Project Setup (1 hour)
   - Set up Spring Boot for the backend and connect to the PostgreSQL database.
   - Set up a basic React app with necessary libraries for the frontend.

#### 2. Database and Models (1.5 hours)
   - Define the database schema in PostgreSQL for storing user info (Full Name, Age, Gender, Text Input).
   - Create entity classes in Spring Boot to map to these tables (e.g., User, Submission).

#### 3. Connect Frontend to Backend (1.5 hours)
   - Set up Axios (or `fetch`) to make calls from the frontend to backend endpoints.
   - Test form submission end-to-end, ensuring data flows from the frontend to the backend and back.

#### 4. OpenAI Moderation API Integration (2 hours)
   - Create a service in Spring Boot to handle calls to the OpenAI Moderation API (Check if possible)
   - Implement logic in the backend to handle flagged content and send moderation results to the frontend.

#### 5. User Data Submission API (1.5 hours)
   - Create API endpoints for the frontend to submit user info to the backend.
   - Add validation checks (e.g., required fields like name, age) and ensure that all data gets properly stored in the database.

#### 6. Basic Analytics API (2 hours)
   - Implement endpoints to calculate basic analytics like:
     - Bell curve data for age distribution (Or different chart)
     - Gender breakdown data (Of different input)
   - Write methods to generate and return this data in a format the frontend can display.

---

### Day 2: Frontend and Data Visualization

#### 1. Build User Input Form (1.5 hours)
   - Design and implement a form in React for users to input their data (Full Name, Age, Gender, Large Text).
   - Add simple validation to make sure fields like age and text are filled out correctly.

#### 3. Data Visualization (2.5 hours)
   - Use a charting library (like Chart.js) to display:
     - Bell curve for age distribution
     - Pie chart for gender breakdown
   - Ensure that charts update based on data returned from the backend.

#### 4. Display Moderation Feedback (1 hour)
   - Show users a simple message if their content is flagged by the OpenAI Moderation API.
   - Allow users to edit and resubmit their text if flagged, cycling through the moderation process again.

#### 5. Polish UI and Add Final Touches (1.5 hours)
   - Add simple styling and organize the page layout for a clean, user-friendly interface.
   - Ensure users can easily navigate between the data submission form and community insights (e.g., using tabs or sections).

---
### Total Estimated Time: 16 hours // BUT About a third of this plan is already finished, before the start of the weekend