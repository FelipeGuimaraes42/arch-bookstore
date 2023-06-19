import * as React from 'react';
import Avatar from '@mui/material/Avatar';
import Button from '@mui/material/Button';
import CssBaseline from '@mui/material/CssBaseline';
import TextField from '@mui/material/TextField';
import FormControlLabel from '@mui/material/FormControlLabel';
import Checkbox from '@mui/material/Checkbox';
import Link from '@mui/material/Link';
import Grid from '@mui/material/Grid';
import Box from '@mui/material/Box';
import Alert from '@mui/material/Alert';
import LockOutlinedIcon from '@mui/icons-material/LockOutlined';
import Typography from '@mui/material/Typography';
import Container from '@mui/material/Container';
import { createTheme, ThemeProvider } from '@mui/material/styles';
import { ButtonAppBar } from '../AppBar/HomeAppBar'

function Copyright(props: any) {
    return (
        <Typography variant="body2" color="text.secondary" align="center" {...props}>
            {'Copyright © '}
            <Link color="inherit" href="https://mui.com/" target="_blank">
                Your Website
            </Link>{' '}
            {new Date().getFullYear()}
            {'.'}
        </Typography>
    );
}

const theme = createTheme();

function getSignUpStatus(step: number) {
    switch (step) {
        case 0:
            return <></>;
        case 1:
            return <Container component="main" maxWidth="xs">
                <Alert variant="filled" severity="error">
                    Username not available!
                </Alert>
            </Container>;
        case 2:
            return <Container component="main" maxWidth="xs">
                <Alert variant="filled" severity="success">
                    Successfully saved!
                </Alert>
            </Container>;
        default:
            throw new Error('Unknown step');
    }
}

export function SignUp() {
    const [isSignUpError, setActiveErrorMessage] = React.useState(0);

    const handleSubmit = (event: React.FormEvent<HTMLFormElement>) => {
        event.preventDefault();
        const data = new FormData(event.currentTarget);
        const user = { username: data.get('username'), password: data.get('password') }
        fetch("http://localhost:8080/customer/register", {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify(user)
        })
            .then((response) => {
                if (!response.ok) {
                    setActiveErrorMessage(1);
                    console.log("Username already exists");
                }
                else {
                    setActiveErrorMessage(2);
                    console.log("Client signed up");
                }
            });
    };

    return (
        <>
            <ButtonAppBar />
            <ThemeProvider theme={theme}>
                <Container component="main" maxWidth="xs">
                    <CssBaseline />
                    <Box
                        sx={{
                            marginTop: 8,
                            display: 'flex',
                            flexDirection: 'column',
                            alignItems: 'center',
                        }}
                    >
                        <Avatar sx={{ m: 1, bgcolor: 'secondary.main' }}>
                            <LockOutlinedIcon />
                        </Avatar>
                        <Typography component="h1" variant="h5">
                            Sign Up
                        </Typography>
                        <Box component="form" onSubmit={handleSubmit} noValidate sx={{ mt: 1 }}>
                            <TextField
                                margin="normal"
                                required
                                fullWidth
                                id="username"
                                label="Username"
                                name="username"
                                autoComplete="username"
                                autoFocus
                            />
                            <TextField
                                margin="normal"
                                required
                                fullWidth
                                name="password"
                                label="Password"
                                type="password"
                                id="password"
                                autoComplete="current-password"
                            />
                            <React.Fragment>
                                {getSignUpStatus(isSignUpError)}
                            </React.Fragment>
                            <FormControlLabel
                                control={<Checkbox value="remember" color="primary" />}
                                label="Remember me"
                            />
                            <Button
                                type="submit"
                                fullWidth
                                variant="contained"
                                sx={{ mt: 3, mb: 2 }}
                            >
                                Create
                            </Button>
                            <Grid container>
                                <Grid item>
                                    <Link href="/signin" variant="body2">
                                        {"Already have an account? Sign In"}
                                    </Link>
                                </Grid>
                            </Grid>
                        </Box>
                    </Box>
                    <Copyright sx={{ mt: 8, mb: 4 }} />
                </Container>
            </ThemeProvider>
        </>
    );
}