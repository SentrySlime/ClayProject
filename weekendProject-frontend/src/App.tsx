import { QueryClient, QueryClientProvider } from "@tanstack/react-query";
import GetComponent from "./components/GetComponent";
import PostComponent from "./components/PostComponent";
import User from "./components/User";

const queryClient = new QueryClient();

function App() {
  return (
    <QueryClientProvider client={queryClient}>
      <div>
        <GetComponent />
      </div>

      <PostComponent />

      <div>
        <User/>
      </div>
    </QueryClientProvider>
  );
}

export default App;
