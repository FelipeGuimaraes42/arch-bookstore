import styled from 'styled-components';
import IconButton from '@mui/material/IconButton';

export const Wrapper = styled.div`
  margin: 40px;
`;

export const StyledButton = styled(IconButton)`
  position: fixed;
  z-index: 100;
  right: 16px;
  bottom: 20px;
  color: #FFFFFF;
  background-color: #0D6EFD;
  width: 70px;
  height: 70px;
  box-shadow: 0 5px 4px rgba(0, 0, 0, 0.2);

  .cart-icon {
    transform: scale(1.5);
  }

  &:hover {
    color: #0D6EFD;
    background-color: #FFFFFF;
  }
`;
