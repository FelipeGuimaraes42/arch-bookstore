import { useState } from 'react';
import { useQuery } from 'react-query';
// Components
import { ButtonAppBar } from '../AppBar/HomeAppBar';
import Item from '../Item/Item';
import Cart from '../Cart/Cart'

import Drawer from '@mui/material/Drawer';
import LinearProgress from '@mui/material/LinearProgress';
import Grid from '@mui/material/Grid';
import ShoppingCart from '@mui/icons-material/ShoppingCart';
import Badge from '@mui/material/Badge';
// Styles
import { Wrapper, StyledButton } from './Home.styles';
// Types
export type CartItemType = {
    id: number,
    name: string,
    description: string,
    price: number,
    category: string,
    image: string;
    amount: number;
};

const getProducts = async (): Promise<CartItemType[]> =>
    await (await fetch('http://localhost:8080/hortifruti/')).json();

export function Home() {
    const [cartOpen, setCartOpen] = useState(false);
    const [cartItems, setCartItems] = useState([] as CartItemType[]);
    const { data, isLoading, error } = useQuery<CartItemType[]>(
        'products',
        getProducts
    );
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
            {/* {
                isClientLoggedIn ? <PrimarySearchAppBar /> : <ButtonAppBar />
            } */}
            <ButtonAppBar />
            <Wrapper>
                <Drawer anchor='right' open={cartOpen} onClose={() => setCartOpen(false)}>
                    <Cart
                        cartItems={cartItems}
                        addToCart={handleAddToCart}
                        removeFromCart={handleRemoveFromCart}
                    />
                </Drawer>
                <StyledButton onClick={() => setCartOpen(true)}>
                    <Badge badgeContent={getTotalItems(cartItems)} color='error'>
                        <ShoppingCart />
                    </Badge>
                </StyledButton>
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
