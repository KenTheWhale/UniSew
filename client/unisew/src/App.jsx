import {createBrowserRouter, Navigate, RouterProvider} from "react-router-dom";
import {Login} from "./pages/Login.jsx";
import {SnackbarProvider} from "notistack";

const router = createBrowserRouter([
    {
        path:"/login",
        element: <Login />
    },
    {
        path: "*",
        element: <Login />
    }
])

function App() {
    return (
        <SnackbarProvider maxSnack={4} anchorOrigin={{horizontal: "right", vertical: "top"}} autoHideDuration={3000}>
            <RouterProvider router={router}/>
        </SnackbarProvider>
    )
}

export default App
