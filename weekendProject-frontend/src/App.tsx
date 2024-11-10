import { QueryClient, QueryClientProvider } from "@tanstack/react-query";
import PostComponent from "./components/PostComponent";
import Gallery from "./components/Gallery";
import Statistics from "./components/Statistics";

const queryClient = new QueryClient();

function App() {
  return (
    <QueryClientProvider client={queryClient}>
      <div>
        <Statistics />
      </div>

      <div>
        <PostComponent />
      </div>

      <div>
        <Gallery />
      </div>
    </QueryClientProvider>
  );
}

export default App;
