import React, { useState } from 'react';
import { AuthContext, AuthContextType } from './AuthContext';
import { Customer } from '../../types/Customer';

type AuthProviderProps = {
    children: React.ReactNode;
};

export const AuthProvider: React.FC<AuthProviderProps> = ({ children }) => {
    const [user, setUser] = useState<Customer | null>(null);

    const signin = async (username: string, password: string): Promise<boolean> => {
        try {
            const response = await fetch('http://localhost:8080/customer/login', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify({
                    username,
                    password,
                }),
            });
            console.log('Response from fetch: ', response);
            if (response.ok) {
                const data = await response.json();

                const authenticatedUser: Customer = {
                    username: data.username,
                };

                setUser(authenticatedUser);
                console.log('User: ', authenticatedUser);
                return true;
            } else {
                console.log('Login error:', response);
                return false;
            }
        } catch (error) {
            console.log('Login error:', error);
            return false;
        }
    };

    const signout = () => {
        setUser(null);
    };

    const authContextValue: AuthContextType = {
        user,
        signin,
        signout,
    };

    return <AuthContext.Provider value={authContextValue}>{children}</AuthContext.Provider>;
};