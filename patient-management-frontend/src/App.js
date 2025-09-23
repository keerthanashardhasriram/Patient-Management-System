import React, { useEffect, useState } from "react";
import { fetchPatients, addPatient } from "./services/api";

function App() {
  const [patients, setPatients] = useState([]);

  useEffect(() => {
    // Test API connection
    fetch("http://localhost:8080/api/patients")  // <-- backend API
      .then(res => res.json())
      .then(data => {
        console.log(data);   // see data in browser console
        setPatients(data);   // save data in state to display
      })
      .catch(err => console.error(err));
  }, []);

  return (
    <div>
      <h1>Patient List</h1>
      <ul>
        {patients.map((p, index) => (
          <li key={index}>{p.name}</li>
        ))}
      </ul>
    </div>
  );
}

export default App;
