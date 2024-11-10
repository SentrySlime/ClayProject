import { useState } from "react";
import Statistics from "./Statistics";
import Gallery from "./Gallery";

const Dashboard = () => {
  const [selectedUserId, setSelectedUserId] = useState(null);

  return (
    <div>
      <Statistics userId={selectedUserId} />
      <Gallery onSelectUser={setSelectedUserId} />
    </div>
  );
};

export default Dashboard;
