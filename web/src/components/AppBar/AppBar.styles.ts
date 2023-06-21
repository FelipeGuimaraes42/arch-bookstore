import styled from 'styled-components';
import Button from '@mui/material/Button';

export const ButtonContainer = styled.div`
  display: flex;
  justify-content: flex-end;
  margin-left: auto;
`;

export const StyledButton = styled(Button)`
  color: black;
  background-color: white;
  margin-left: 10px; /* Add margin between the buttons if desired */
`;