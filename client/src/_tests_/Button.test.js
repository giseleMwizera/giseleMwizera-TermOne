import { render, screen } from "@testing-library/react";
import Button from "../components/Button";

test("Button can be clicked", async () => {
  const handleClick = jest.fn();
  render(<Button onClick={handleClick}>=</Button>);
  fireEvent.click(screen.getByText(/=/i));
  expect(handleClick).toHaveBeenCalledTimes(1);
});
