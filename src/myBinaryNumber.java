import java.math.BigInteger;

public class myBinaryNumber {

    String binNum = "";

    myBinaryNumber(int n){
        for(int i = 0; i < n; i++)
            binNum += 0;
    }

    myBinaryNumber(String s){
        binNum = s;
    }

    public int getSize(){
        return binNum.length();
    }

    public int getBit(int p){
        return binNum.charAt(binNum.length() - p - 1) - 48;
    }

    public void setBit(int p, int b){
        if(b != 0 && b != 1) throw new IllegalArgumentException("The passed bit should either be 0 or 1");

        binNum = binNum.substring(0, binNum.length() - p - 1) + b + binNum.substring(binNum.length() - p);
    }

    public void printNumber(){
        System.out.println(binNum);
    }

    public void printDecimalNumber(){
        BigInteger decimal = new BigInteger("0");

        char[] bins = binNum.toCharArray();
        for(int i = 0; i < bins.length; i++){
            if(bins[i] != '0')
                decimal = decimal.add((new BigInteger("2")).pow(i));
        }

        System.out.println(decimal);
    }
}
