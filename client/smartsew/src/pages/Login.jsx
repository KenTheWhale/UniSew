import {SignInPage} from '@toolpad/core/SignInPage';
import {AppProvider} from "@toolpad/core";
import {ReactRouterAppProvider} from "@toolpad/core/react-router";
import {Button, Divider, InputAdornment, TextField} from "@mui/material";
import axios from "axios";
import {useGoogleLogin} from "@react-oauth/google";

const providers = [{id: 'credentials', name: 'Email and password'}];

const signIn = async (provider, formData) => {
    const promise = new Promise((resolve) => {
        setTimeout(() => {
            const email = formData?.get('email');
            const password = formData?.get('password');
            alert(
                `Signing in with "${provider.name}" and credentials: ${email}, ${password}`,
            );
            // preview-start
            resolve({
                type: 'CredentialsSignin',
                error: 'Invalid credentials.',
            });
            // preview-end
        }, 300);
    });
    return promise;
};

function CustomEmailField() {
    return (
        <TextField
            id="input-with-icon-textfield"
            label="Username"
            name="username"
            type="text"
            size="small"
            required
            fullWidth
            variant="outlined"
        />
    );
}

function CustomButton() {
    return (
        <Button
            type="submit"
            variant="outlined"
            color="info"
            size="small"
            disableElevation
            fullWidth
            sx={{my: 2}}
        >
            Sign In
        </Button>
    );
}

function CustomRememberMe() {
    return (
        <></>
    )
}

function Subtitle() {
    return (
        <></>
    );
}

//
const googleLogin = useGoogleLogin({
    flow: 'auth-code',
    onSuccess: async (codeResponse) => {
        console.log(codeResponse);
        const tokens = await axios.post(
            'http://localhost:5173/auth/google', {
                code: codeResponse.code,
            });

        console.log(tokens);
    },
    onError: errorResponse => console.log(errorResponse),
});

function RenderLoginPage() {
    return (
        <>
            <ReactRouterAppProvider>
                <SignInPage
                    signIn={signIn}
                    providers={providers}
                    slots={{
                        emailField: CustomEmailField,
                        form: {noValidate: true},
                        submitButton: CustomButton,
                        rememberMe: CustomRememberMe,
                        subtitle: Subtitle,
                    }}
                />
            </ReactRouterAppProvider>

        </>

    );
}

export function Login() {
    return (
        <RenderLoginPage/>
    )
}