import { useState, useContext } from "react";
import { useQuery } from 'react-query';
// Components MUI
import Drawer from '@mui/material/Drawer';
import LinearProgress from '@mui/material/LinearProgress';
import Grid from '@mui/material/Grid';
import ShoppingCart from '@mui/icons-material/ShoppingCart';
import Badge from '@mui/material/Badge';
import AppBar from '@mui/material/AppBar';
import Box from '@mui/material/Box';
import Toolbar from '@mui/material/Toolbar';
import Typography from '@mui/material/Typography';
import IconButton from '@mui/material/IconButton';
// Components
import Item from '../Item/Item';
import Cart from '../Cart/Cart'
// Context
import { RequireAuth } from '../../contexts/Auth/RequireAuth';
import { AuthContext } from "../../contexts/Auth/AuthContext";
// Styles
import { Wrapper, StyledButton, StyledButtonNav, StyledButtonNavRed, ButtonContainer } from './Home.styles';

// Types
export type CartItemType = {
    id: number,
    title: string,
    author: string,
    synopsis: string,
    category: string,
    image: string;
    price: number,
    amount: number;
};

const getProducts = async (): Promise<CartItemType[]> =>
    await (await fetch('http://localhost:8080/book/')).json();

export function Home() {
    const [cartOpen, setCartOpen] = useState(false);
    const [cartItems, setCartItems] = useState([] as CartItemType[]);
    const { data, isLoading, error } = useQuery<CartItemType[]>(
        'products',
        getProducts
    );
    const { user, signout } = useContext(AuthContext);
    console.log(data);

    const getTotalItems = (items: CartItemType[]) =>
        items.reduce((ack: number, item) => ack + item.amount, 0);

    const handleAddToCart = (clickedItem: CartItemType) => {
        setCartItems(prev => {
            // 1. Is the item already added in the cart?
            const isItemInCart = prev.find(item => item.id === clickedItem.id);

            if (isItemInCart) {
                return prev.map(item =>
                    item.id === clickedItem.id
                        ? { ...item, amount: item.amount + 1 }
                        : item
                );
            }
            // First time the item is added
            return [...prev, { ...clickedItem, amount: 1 }];
        });
    };

    const handleRemoveFromCart = (id: number) => {
        setCartItems(prev =>
            prev.reduce((ack, item) => {
                if (item.id === id) {
                    if (item.amount === 1) return ack;
                    return [...ack, { ...item, amount: item.amount - 1 }];
                } else {
                    return [...ack, item];
                }
            }, [] as CartItemType[])
        );
    };

    if (isLoading) return <LinearProgress />;
    if (error) return <div>Something went wrong ...</div>;

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
                        <ButtonContainer>
                            {user ? (
                                <StyledButtonNavRed onClick={signout}>LOGOUT</StyledButtonNavRed>
                            ) : (
                                <>
                                    <StyledButtonNav href="/signin">SIGN IN</StyledButtonNav>
                                    <StyledButtonNav href="/signup">SIGN UP</StyledButtonNav>
                                </>
                            )}
                        </ButtonContainer>
                    </Toolbar>
                </AppBar>
            </Box>
            <Wrapper>
                <Drawer anchor='right' open={cartOpen} onClose={() => setCartOpen(false)}>
                    <Cart
                        cartItems={cartItems}
                        addToCart={handleAddToCart}
                        removeFromCart={handleRemoveFromCart}
                    />
                </Drawer>
                <RequireAuth>
                    <StyledButton onClick={() => setCartOpen(true)}>
                        <Badge badgeContent={getTotalItems(cartItems)} color='error'>
                            <ShoppingCart className="cart-icon" />
                        </Badge>
                    </StyledButton>
                </RequireAuth>
                <Grid container spacing={3}>
                    {data?.map(item => (
                        <Grid item key={item.id} xs={12} sm={4}>
                            <Item item={item} handleAddToCart={handleAddToCart} />
                        </Grid>
                    ))}
                </Grid>
            </Wrapper>
        </>
    );
};
