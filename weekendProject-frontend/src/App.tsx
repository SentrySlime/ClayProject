import { QueryClient, QueryClientProvider } from '@tanstack/react-query'
import GetComponent from './components/GetComponent'
import PostComponent from './components/PostComponent';

const queryClient = new QueryClient();

function App() {
  

  return (
    <QueryClientProvider client={queryClient} >
      <GetComponent/>

      <PostComponent/>
    </QueryClientProvider>

  )
}

export default App
