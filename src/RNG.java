import org.academiadecodigo.acarena.Field;

/**
 * Created by codecadet on 16/11/16.
 */
public class RNG {


    public static int getNumberBetween (int min, int max){

        int rdmNumber = (int) Math.floor(Math.random()*(max-min+1)+min);
        return rdmNumber;
    }
}
