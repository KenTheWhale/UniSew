import {createBrowserRouter, Navigate} from "react-router-dom";

const route = createBrowserRouter([
    {
        path:"/login",
        element: <h1>Login</h1>
    },
    {
        path: "*",
        element: <Navigate to={"/login"}/>
    }
])

function App() {

}

export default App
