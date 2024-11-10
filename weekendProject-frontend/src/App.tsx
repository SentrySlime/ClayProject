// App.js
import { QueryClient, QueryClientProvider } from "@tanstack/react-query";
import PostComponent from "./components/PostComponent";
import Dashboard from "./components/Dashboard";

const queryClient = new QueryClient();

function App() {
  return (
    <QueryClientProvider client={queryClient}>
      <div>
        <Dashboard />
      </div>

      <div>
        <PostComponent />
      </div>
    </QueryClientProvider>
  );
}

export default App;
