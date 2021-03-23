import java.util.HashMap;
import java.util.Map;

/**
 * The type Winner count race.
 */
public class WinnerCountRace {

    /**
     * Main.
     *
     * @param args the args
     */
    public static void main(String[] args){
        /*{4,7,4,1}
        {10,20,30,40,50}
        123,456,123,456,456,123
        1,2,2,3,3,3,4,4,4,4
        */
        System.out.println(win(new int[]{4,7,4,1}));
        System.out.println(win(new int[]{10,20,30,40,50}));
        System.out.println(win(new int[]{123,456,123,456,456,123}));
        System.out.println(win(new int[]{1,2,2,3,3,3,4,4,4,4}));
    }

    /**
     * Win int.
     *
     * @param arr the arr
     * @return the int
     */
    public  static int win(final int[] arr){
        if(arr.length ==0){
            throw new IllegalArgumentException();
        }
        int winner =arr[0];
        final Map<Integer, Integer> map = new HashMap();

        for (int i = 0; i < arr.length; i++){
            if (arr[i]==winner) {
                incrementCounts(winner, map);
            } else if (map.get(winner) > (map.get(arr[i]) != null ? map.get(arr[i]) :0 ) ) {
                incrementCounts(arr[i], map);
            } else {
                incrementCounts(arr[i], map);
                winner = arr[i];
            }
        }
        return winner;
    }

    /**
     * Incrementing counts in map
     *
     * @param winner the int
     * @param map the Map<Integer, Integer>
     * @return the int
     */
    private static void incrementCounts(final int winner, final Map<Integer, Integer> map) {
        if (map.containsKey(winner)) {
            map.put(winner, map.get(winner) + 1);
        } else {
            map.put(winner, 1);
        }
    }
}
