import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import { SignIn } from './components/SignIn/SignIn'
import { SignUp } from './components/SignUp/SignUp'
import { Home } from './components/Home/Home';
import { NotFound } from './components/NotFound/NotFound';

function App() {
  return (
    <>
      <Router>
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/signin" element={<SignIn />} />
          <Route path="/signup" element={<SignUp />} />
          <Route path="*" element={<NotFound />} />
        </Routes>
      </Router>
    </>
  );
}

export default App