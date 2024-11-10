import { QueryClient, QueryClientProvider } from "@tanstack/react-query";
import PostComponent from "./components/PostComponent";
import Gallery from "./components/Gallery";

const queryClient = new QueryClient();

function App() {
  return (
    <QueryClientProvider client={queryClient}>


      <PostComponent />

      <Gallery/>

    </QueryClientProvider>
  );
}

export default App;
