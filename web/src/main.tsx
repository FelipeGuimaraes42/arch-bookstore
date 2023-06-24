import React from 'react';
import ReactDOM from 'react-dom/client'
import App from './App.tsx'
import './index.css'
import { QueryClient, QueryClientProvider } from 'react-query';
import { AuthProvider } from './contexts/Auth/AuthProvider.tsx';

const client = new QueryClient();

ReactDOM.createRoot(document.getElementById('root') as HTMLElement).render(
  <React.StrictMode>
    <AuthProvider>
      <QueryClientProvider client={client}>
        <App />
      </QueryClientProvider>
    </AuthProvider>
  </React.StrictMode>,
);