import os
import numpy as np
import pandas as pd
import random
import scipy.linalg
from datetime import datetime, timedelta

# User Input for All 4 Years (With Defaults)
years = {}
for i in range(1, 5):
    year_students = f"Year {i}"
    students = int(input(f"Enter number of students in {year_students}: ") or [400, 450, 500, 350][i-1])
    courses = int(input(f"Enter total number of courses for {year_students} (default: 8): ") or 8)
    years[year_students] = {"students": students, "courses": courses}

# User Input for Facilities (With Defaults)
classrooms = int(input("Enter number of normal classrooms (default: 20): ") or 20)
labs = int(input("Enter number of ICT labs (default: 10): ") or 10)
classroom_capacity = int(input("Enter classroom capacity (default: 250): ") or 250)
lab_capacity = int(input("Enter ICT lab capacity (default: 60): ") or 60)

# Generate Exam Days (4 Weeks, Monday-Friday)
exam_days = pd.date_range(start="2025-04-07", periods=20, freq="B").to_list()

# Time Slots and Room Labels
time_slots = ["8:00 AM - 10:00 AM", "10:30 AM - 12:30 PM", "1:00 PM - 3:00 PM", "3:30 PM - 5:30 PM", "6:00 PM - 8:00 PM"]
room_labels = [f"Classroom {i+1}" for i in range(classrooms)] + [f"Lab {i+1}" for i in range(labs)]

# Generate Congestion Matrix (20 days x 20 slots to make it square)
congestion_matrix = np.zeros((len(exam_days), len(exam_days)))  # 20 x 20

# Generate Exam Schedule for All Years
all_schedules = {}
for year, details in years.items():
    num_batches = -(-details["students"] // classroom_capacity)  # Calculate batches
    course_prefix = f"{year.replace(' ', '')}-Course"
    course_names = [f"{course_prefix}{chr(65 + i)}" for i in range(details["courses"])]
    
    exam_schedule = []
    for batch in range(1, num_batches + 1):
        assigned_days = random.choices(exam_days, k=len(course_names))  # Repeated days to increase congestion
        for i, course in enumerate(course_names):
            room = random.choice(room_labels)
            day_index = exam_days.index(assigned_days[i])
            time_index = random.randint(0, len(time_slots) - 1)  
            congestion_matrix[day_index, time_index] += 3  # Force high congestion
            exam_schedule.append({"Date": assigned_days[i], "Batch": f"Batch {batch}", "Course": course, "Time": time_slots[time_index], "Room": room})

    all_schedules[year] = pd.DataFrame(exam_schedule)

# Select a Random Year to Print
random_year = random.choice(list(all_schedules.keys()))
schedule_df = all_schedules[random_year]
schedule_df.sort_values(by=["Date", "Time"], inplace=True)  # Sort by Date and Time

# Compute Eigenvalues
eigenvalues = np.linalg.eigvals(congestion_matrix)
max_eigenvalue = max(eigenvalues)

# LU Decomposition
P, L, U = scipy.linalg.lu(congestion_matrix)

# Generate Congestion Warning Message
if max_eigenvalue > 3:
    congestion_message = f"HIGH CONGESTION DETECTED! (Max Eigenvalue: {max_eigenvalue:.2f})\n" \
                         "Consider increasing exam gaps or adding more rooms."
else:
    congestion_message = f"No major congestion detected. (Max Eigenvalue: {max_eigenvalue:.2f})"

# Print the Selected Year's Timetable
print(f"\nExam Schedule for {random_year}:\n")
for date, group in schedule_df.groupby("Date"):
    formatted_date = date.strftime("%d %B")  # e.g., 07 April
    print(f"{formatted_date}:")
    for _, row in group.iterrows():
        print(f"- {row['Batch']} | {row['Course']} | {row['Time']} | {row['Room']}")
    print("")

# Print Congestion Results
print("\n Eigenvalues for Congestion Detection:", eigenvalues)
print("\n Max Eigenvalue:", max_eigenvalue)
print("\n" + congestion_message)

# Save the Timetable & Congestion Report to a File
filename = "exam_timetable_with_congestion.txt"
with open(filename, "w") as f:
    f.write(f"Exam Schedule for {random_year}:\n\n")
    for date, group in schedule_df.groupby("Date"):
        formatted_date = date.strftime("%d %B")
        f.write(f"{formatted_date}:\n")
        for _, row in group.iterrows():
            f.write(f"- {row['Batch']} | {row['Course']} | {row['Time']} | {row['Room']}\n")
        f.write("\n")

    f.write("\n Max Eigenvalue: " + str(max_eigenvalue) + "\n\n")
    f.write(congestion_message + "\n\n")


print(f"\n Timetable and congestion report saved as {filename}.")

