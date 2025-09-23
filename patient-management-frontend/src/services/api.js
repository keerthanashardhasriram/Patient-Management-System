// src/services/api.js

const BASE_URL = "http://localhost:8080"; // backend URL

// Fetch all patients
export const fetchPatients = async () => {
  try {
    const response = await fetch(`${BASE_URL}/api/patients`);
    if (!response.ok) {
      throw new Error("Failed to fetch patients");
    }
    return response.json();
  } catch (error) {
    console.error(error);
    return [];
  }
};

// You can add more API functions here, e.g., addPatient, deletePatient
