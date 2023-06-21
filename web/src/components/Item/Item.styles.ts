import styled from 'styled-components';

export const Wrapper = styled.div`
  .card {
    display: inline-block;
    width: 80%;
    height: 520px;
    margin: 20px;
    padding: 20px;
    background-color: #f8f9fa;
    border: 1px solid #0096FF;
    border-radius: 20px;
    box-shadow: 0 2px 2px rgba(0, 0, 0, 0.1);
  }

  img {
    width: auto;
    max-width: 350px;
    max-height: 250px;
    object-fit: cover;
    border-radius: 20px;
    margin: 0 auto;
    display: block;
  }

  .item {
    font-family: Arial, Helvetica, sans-serif;
    padding: 0.5rem;
  }  

  button {
    border-radius: 0 0 20px 20px;
    padding-right: 50px;
    padding-left: 50px;
    width: 100%;
    color: #0096FF;
    border-color: #0096FF;
    border: 1px solid #0096FF;
  }
`;