import Avatar from '@mui/material/Avatar';
import Button from '@mui/material/Button';
import CssBaseline from '@mui/material/CssBaseline';
import Box from '@mui/material/Box';
import ErrorIcon from '@mui/icons-material/Error';
import Typography from '@mui/material/Typography';
import Container from '@mui/material/Container';
import { createTheme, ThemeProvider } from '@mui/material/styles';

import AppBar from '@mui/material/AppBar';
import Toolbar from '@mui/material/Toolbar';
import IconButton from '@mui/material/IconButton';

const theme = createTheme();

export function NotFound() {
    return (
        <>
            <ThemeProvider theme={theme}>
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
                            <ErrorIcon />
                        </Avatar>
                        <Typography component="h1" variant="h5">
                            404 - Not found
                        </Typography>
                        <Box component="body" sx={{ mt: 1 }}>
                            <Button
                                type="submit"
                                fullWidth
                                variant="contained"
                                href="/"
                                sx={{ mt: 3, mb: 2 }}
                            >
                                Return Home
                            </Button>
                        </Box>
                    </Box>
                </Container>
            </ThemeProvider >
        </>
    );
}