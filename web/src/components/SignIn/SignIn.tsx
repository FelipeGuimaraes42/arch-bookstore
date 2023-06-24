import React, { useState, ChangeEvent, useContext } from 'react';
import { useNavigate } from "react-router-dom";

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
import LockOutlinedIcon from '@mui/icons-material/LockOutlined';
import Typography from '@mui/material/Typography';
import Container from '@mui/material/Container';
import Alert from '@mui/material/Alert';

import { AuthContext } from "../../contexts/Auth/AuthContext";

export const SignIn: React.FC = () => {
    const auth = useContext(AuthContext);
    const navigate = useNavigate();

    const [isSignInError, setActiveErrorMessage] = React.useState(false);
    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');

    const handleUsernameInput = (event: ChangeEvent<HTMLInputElement>) => {
        setUsername(event.target.value);
    };

    const handlePasswordInput = (event: ChangeEvent<HTMLInputElement>) => {
        setPassword(event.target.value);
    };

    const handleSubmit = async () => {
        if (username && password) {
            const isLogged = await auth.signin(username, password);
            if (!isLogged) {
                console.log('Wrong login');
                setActiveErrorMessage(true);
            } else {
                console.log('Client logged in');
                setActiveErrorMessage(false);
                navigate('/');
            }
        }
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
                        Sign in
                    </Typography>
                    <Box component="form" onSubmit={handleSubmit} noValidate sx={{
                        alignItems: 'center'
                    }}>
                        <TextField
                            label="Username *"
                            value={username}
                            onChange={handleUsernameInput}
                            margin="normal"
                            fullWidth
                        />
                        <>
                            {
                                isSignInError ? (
                                    <Container component="main" maxWidth="xs">
                                        <Alert variant="filled" severity="error">
                                            Wrong username or password!
                                        </Alert>
                                    </Container>) :
                                    <></>
                            }
                        </>
                        <TextField
                            label="Password *"
                            type="password"
                            value={password}
                            onChange={handlePasswordInput}
                            margin="normal"
                            fullWidth
                        />
                        <Button variant="contained" color="primary" onClick={handleSubmit} fullWidth sx={{ mt: 3, mb: 2 }}>
                            Sign In
                        </Button>
                        <Grid container>
                            <Grid item>
                                <Link href="/signup" variant="body2">
                                    {"Don't have an account? Sign Up"}
                                </Link>
                            </Grid>
                        </Grid>
                    </Box>
                </Box>
            </Container>
        </>
    );
};
