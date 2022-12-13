import { render, screen,fireEvent } from "@testing-library/react";
import Screen from "../components/Screen";

test("If button is clicked the result should be cleared and a new result should be displayed", async () => {

  render(
    <Screen/>
    );
    
 
    render(<Button onClick={handleClick}>=</Button>);
  fireEvent.click(screen.getByText(/=/i));
  expect(handleClick).toHaveBeenCalledTimes(1);

  expect(await screen.findByRole("button", { name: /pay/i })).toBeEnabled();
});
