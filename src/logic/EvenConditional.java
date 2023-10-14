package logic;
/**
 * @author Esther Romero Aguilar
 * */

public class EvenConditional extends ConditionalBet{
    public EvenConditional(int amount){
        super(amount, v -> {
            int value = v.getValue();
            return value % 2 == 0;
        });
    }
  
    @Override
    public boolean validConditionalBet(Pocket pocket) {
        return condition.apply(pocket);
    }
}
