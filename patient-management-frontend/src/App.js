import React, { useEffect, useState } from "react";
import { fetchPatients } from "./services/api";

function App() {
  const [patients, setPatients] = useState([]);

  useEffect(() => {
    fetchPatients().then(data => setPatients(data));
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
