import * as React from 'react';

import AppBar from '@mui/material/AppBar';
import Toolbar from '@mui/material/Toolbar';
import IconButton from '@mui/material/IconButton';
import Avatar from '@mui/material/Avatar';
import Button from '@mui/material/Button';
import CssBaseline from '@mui/material/CssBaseline';
import TextField from '@mui/material/TextField';
import Link from '@mui/material/Link';
import Grid from '@mui/material/Grid';
import Box from '@mui/material/Box';
import Alert from '@mui/material/Alert';
import LockOutlinedIcon from '@mui/icons-material/LockOutlined';
import Typography from '@mui/material/Typography';
import Container from '@mui/material/Container';
import { createTheme, ThemeProvider } from '@mui/material/styles';

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
            <Box sx={{ flexGrow: 1 }}>
                <AppBar position="static">
                    <Toolbar>
                        <IconButton
                            size="large"
                            edge="start"
                            color="inherit"
                            sx={{ mr: 2 }}
                            href="/"
                        >
                            <Typography variant="h6" component="div" sx={{ flexGrow: 1, ml: 2 }}>
                                Arch Bookstore
                            </Typography>
                        </IconButton>
                    </Toolbar>
                </AppBar>
            </Box>
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
                            <Button
                                type="submit"
                                fullWidth
                                variant="contained"
                                name="submit"
                                id="submit"
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
                </Container>
            </ThemeProvider>
        </>
    );
}