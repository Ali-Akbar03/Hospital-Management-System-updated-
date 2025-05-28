🏥 Hospital Management System - Project Explanation
The Hospital Management System GUI is a simple Java-based desktop application developed using Swing, designed to simulate basic hospital administrative functionalities. It provides an interactive graphical interface for staff to manage patient records, process payments, and schedule doctor appointments.
________________________________________
🔐 Login Screen
•	The application starts with a password-protected login.
•	Only users who enter the correct password (24070103) can access the system.
•	This adds a layer of basic authentication to protect sensitive operations.
________________________________________
🧑⚕️ Patient Management
Accessible from the Main Menu, this module allows users to:
•	Add Patient
Enter patient details like ID, name, age, and disease.
•	View Patients
Display a scrollable list of all patient records currently stored.
•	Search Patient
Search for a patient by ID and view their full details.
•	Delete Patient
Remove a patient's record from the system using their ID.
🔸 All patient data is stored in memory using an ArrayList of HospitalPatient objects (no database used).
________________________________________
💳 Payment System
•	Simulates a basic payment process via two mobile financial services:
o	bKash
o	Nagad
•	Users input the amount and choose the payment method.
•	A confirmation message displays upon a successful transaction (simulation only, no real payment processing).
________________________________________
🩺 Doctor Appointment
•	Users can book appointments by providing:
o	Name
o	Preferred doctor's name
o	Date (format: dd-mm-yyyy)
•	Appointment details are stored in a file named appointments.txt.
•	Confirmation is shown on successful booking.
________________________________________
📦 Code Structure
![image](https://github.com/user-attachments/assets/c1d649f1-de4b-40b4-be7b-b3e2b32d6b96)

________________________________________
👨💻 Technologies Used
•	Java
•	Swing (javax.swing) – for GUI components
•	FileWriter – for saving appointment data to a file
•	ArrayList – for storing in-memory patient records
________________________________________
🚀 How to Run
1.	Compile all .java files:
2.	javac *.java
3.	Run the application:
4.	java HospitalManagementSystemGUI
________________________________________
📌 Notes
•	This is a prototype application. Data is stored only in memory during runtime (except for appointments).
•	Demonstrates Object-Oriented Programming, Java Swing GUI, and basic file handling.

                                                                                         


![image](https://github.com/user-attachments/assets/3afc2a16-6ccb-4258-984a-14cceade0c79)
Fig 4- log in page 

![image](https://github.com/user-attachments/assets/64686cef-a715-4c0a-9ca6-ddf817978c5d)
Fig 5– Main home page 

![image](https://github.com/user-attachments/assets/8da7d137-e373-4ec8-a617-befe61d68715)
Fig 6- Patient management system 

![image](https://github.com/user-attachments/assets/868f1cdd-3b5f-4e76-a22b-11785fb40e4e)
Fig 7– Payment method

![image](https://github.com/user-attachments/assets/123533aa-c993-4787-ba1a-69254bea83c3)
Fig 8- Doctor appointment 





S.M. ALI AKBAR KHALED 
CSE student at UNIVARSITY OF SCIENCE AND TECHNOLOGY CHITTAGONG 
![WhatsApp Image 2025-05-22 at 08 48 29_576f648c](https://github.com/user-attachments/assets/2ccd5d36-0998-4e68-84ca-5ce2c6fc7581)




