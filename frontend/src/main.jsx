import ReactDOM from 'react-dom/client'
import { QueryClient, QueryClientProvider } from '@tanstack/react-query'
import App from './App'
import { BrowserRouter as Router} from 'react-router-dom'
import 'react-toastify/dist/ReactToastify.css'
import { UserContextProvider } from './components/context/userContext'
import { ToastContainer } from 'react-toastify'

const queryClient = new QueryClient()

ReactDOM.createRoot(document.getElementById('root')).render(
    <UserContextProvider>
        <QueryClientProvider client={queryClient}>
            <Router>
                <ToastContainer />
                <App />
            </Router>
        </QueryClientProvider>
    </UserContextProvider>
)