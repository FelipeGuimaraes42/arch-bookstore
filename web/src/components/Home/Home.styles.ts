import styled from 'styled-components';
import Button from '@mui/material/Button';
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

export const ButtonContainer = styled.div`
  display: flex;
  justify-content: flex-end;
  margin-left: auto;
`;

export const StyledButtonNav = styled(Button)`
  color: black;
  background-color: #FFFFFF;
  margin-left: 10px;
  &:hover {
    font-weight: bold;
    background-color: #FFFFFF;
  }
`;

export const StyledButtonNavRed = styled(Button)`
  color: black;
  background-color: #D22B2B;
  margin-left: 10px;
  &:hover {
    font-weight: bold;
    background-color: #D2042D;
  }
`;