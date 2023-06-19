import AppBar from '@mui/material/AppBar';
import Box from '@mui/material/Box';
import Toolbar from '@mui/material/Toolbar';
import Typography from '@mui/material/Typography';
import IconButton from '@mui/material/IconButton';
import HomeIcon from '@mui/icons-material/Home';
import Button from '@mui/material/Button';

export function ButtonAppBar() {
    return (
        <Box sx={{ flexGrow: 1 }}>
            <AppBar position="static">
                <Toolbar>
                    <IconButton
                        size="large"
                        edge="start"
                        aria-label="show 0 new notifications"
                        color="inherit"
                        sx={{ mr: 2 }}
                        href="/"
                    >
                        <HomeIcon />
                        <Typography variant="h6" component="div" sx={{ flexGrow: 1, ml: 2 }}>
                            Architecture Hortifruti
                        </Typography>
                    </IconButton>
                    <Button color="inherit" href="/signin">Login</Button>
                </Toolbar>
            </AppBar>
        </Box>
    );
}
