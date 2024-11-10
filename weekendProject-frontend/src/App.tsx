import { QueryClient, QueryClientProvider } from "@tanstack/react-query";
import PostComponent from "./components/PostComponent";
import "./App.css";
import { useState } from "react";
import Gallery from "./components/Gallery";
import Statistics from "./components/Statistics";

const queryClient = new QueryClient();

function App() {
  const [selectedUserId, setSelectedUserId] = useState(null);

  return (
    <QueryClientProvider client={queryClient}>
      <div className="grid-container">
        <div className="item1">
          <PostComponent />
        </div>
        <div className="item2">
          <Gallery onSelectUser={setSelectedUserId} />
        </div>
        <div className="item3">
          <Statistics userId={selectedUserId} />
        </div>
      </div>
    </QueryClientProvider>
  );
}

export default App;
