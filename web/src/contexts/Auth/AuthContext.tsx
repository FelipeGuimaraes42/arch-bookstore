import { createContext } from 'react';
import { Customer } from '../../types/Customer';

export type AuthContextType = {
    user: Customer | null;
    signin: (username: string, password: string) => Promise<boolean>;
    signout: () => void;
};

export const AuthContext = createContext<AuthContextType>({
    user: null,
    signin: () => Promise.resolve(false),
    signout: () => { },
});
