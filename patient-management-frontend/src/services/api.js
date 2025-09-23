const BASE_URL = "http://localhost:8080";

export const fetchPatients = async () => {
  const res = await fetch(`${BASE_URL}/api/patients`);
  return res.json();
};

// Add this function
export const addPatient = async (patient) => {
  const res = await fetch(`${BASE_URL}/api/patients/add`, {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify(patient),
  });
  return res.json();
};
