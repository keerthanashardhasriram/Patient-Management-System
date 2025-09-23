import React, { useEffect, useState } from "react";
import { fetchPatients, addPatient } from "./services/api";

function App() {
  const [patients, setPatients] = useState([]);
  const [name, setName] = useState("");

  // Fetch patients on load
  useEffect(() => {
    fetchPatients()
      .then(data => setPatients(data))
      .catch(err => console.error(err));
  }, []);

  // Add patient handler
  const handleAddPatient = async () => {
    if (!name) return;
    try {
      const newPatient = await addPatient({ name });
      setPatients(prev => [...prev, newPatient]);
      setName(""); // clear input
    } catch (err) {
      console.error(err);
    }
  };

  return (
    <div>
      <h1>Patient List</h1>
      <input
        type="text"
        value={name}
        onChange={e => setName(e.target.value)}
        placeholder="Enter patient name"
      />
      <button onClick={handleAddPatient}>Add Patient</button>
      <ul>
        {patients.map((p, index) => (
          <li key={index}>{p.name}</li>
        ))}
      </ul>
    </div>
  );
}

export default App;
