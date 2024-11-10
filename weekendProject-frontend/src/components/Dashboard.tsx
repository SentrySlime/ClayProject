import { useState } from "react";
import Statistics from "./Statistics";
import Gallery from "./Gallery";

const Dashboard = () => {
  const [selectedUserId, setSelectedUserId] = useState(null);

  return (
    <div>
      <Gallery onSelectUser={setSelectedUserId} />
      <Statistics userId={selectedUserId} />
    </div>
  );
};

export default Dashboard;
