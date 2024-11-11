// src/__tests__/PostComponent.test.tsx
import { render, screen } from '@testing-library/react';
import PostComponent from '../components/PostComponent';
import { QueryClient, QueryClientProvider } from '@tanstack/react-query';

// Create a new query client instance
const queryClient = new QueryClient();

function renderWithQueryClient(component: JSX.Element) {
  return render(
    <QueryClientProvider client={queryClient}>
      {component}
    </QueryClientProvider>
  );
}

test('renders Submit Form heading', () => {
  // Use the helper function to render with QueryClientProvider
  renderWithQueryClient(<PostComponent />);
  
  // Check for the presence of "Submit Form" text
  expect(screen.getByText(/submit form/i)).toBeInTheDocument();
});
