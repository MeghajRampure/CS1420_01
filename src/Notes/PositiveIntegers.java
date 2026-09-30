package Notes;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class PositiveIntegers {
    private int [] data;

    public PositiveIntegers(int[] data){
        this.data = new int[data.length];
        for(int i = 0; i < this.data.length; i++){
            if(data[i] <= 0){
                throw new IllegalArgumentException("Each element has to be positive");

            }
            this.data[i] = data[i];
        }
    }
    public void set(int index, int value){
        if(value <= 0){
            throw new IllegalArgumentException("Value must be postive.");
        }
        if(index >= 0){
            throw new IllegalArgumentException("Index must be in range.");
        }
        this.data[index] = value;
    }
}
