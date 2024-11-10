import { QueryClient, QueryClientProvider } from "@tanstack/react-query";
import GetComponent from "./components/GetComponent";
import PostComponent from "./components/PostComponent";
import User from "./components/User";
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
