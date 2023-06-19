import Button from '@mui/material/Button';
// Types
import { CartItemType } from '../Home/Home';
// Styles
import { Wrapper } from './Item.styles';

type Props = {
  item: CartItemType;
  handleAddToCart: (clickedItem: CartItemType) => void;
};

const Item: React.FC<Props> = ({ item, handleAddToCart }) => (
  <Wrapper>
    <img src={item.image} alt={item.title} />
    <div>
      <h3>{item.title}</h3>
      <h3>{item.author}</h3>
      <p>{item.synopsis}</p>
      <h3>R$ {item.price.toFixed(2)}</h3>
    </div>
    <Button onClick={() => handleAddToCart(item)}>Add to cart</Button>
  </Wrapper>
);

export default Item;
