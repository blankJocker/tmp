package problem;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * The prime 41, can be written as the sum of six consecutive primes:
 * 				41 = 2 + 3 + 5 + 7 + 11 + 13
 * This is the longest sum of consecutive primes that adds to a prime below one-hundred.
 * The longest sum of consecutive primes below one-thousand that adds to a prime, contains 21 terms, and is equal to 953.
 * Which prime, below one-million, can be written as the sum of the most consecutive primes?
 * @author Administrator
 *
 */
public class Problem50 {
	//private static Map<String,Integer> map=new HashMap<String, Integer>();
	private static int length=0;
	private static int result=0;
	private static String conStr=null;
	private static List<Integer> listCache = new ArrayList<Integer>();
	
	public static void main(String[] args) {
		long begin=System.currentTimeMillis();
		int num=1000000;
		
		List<Integer> list2 = new ArrayList<Integer>();
		
		for (int i = 2; i < num; i++) {
			if(isPrimeNumber(i)){
				listCache.add(i);
			}
		}
		
		for (Integer prime : listCache) {
			if(isPrimeNumber(num , prime)){
				list2.add(prime);
			}
			if(isSumOfConsecutivePrimes(prime)){
				System.out.println(prime);
			}
		}
		//System.out.println(Arrays.toString(list2.toArray()));
		//System.out.println(Arrays.toString(map.entrySet().toArray()));
		
//		Entry<String, Integer> target=(Entry<String, Integer>) map.entrySet().toArray()[0];
//		for (Entry<String, Integer> entry : map.entrySet()) {
//			
//			if(entry.getValue()>target.getValue()){
//				target=entry;
//			}
//		}
//		System.out.println(target.toString());
		System.out.println(result+" 长 " +length+":"+conStr);
		long end=System.currentTimeMillis();
		System.out.println("cost:"+(end-begin));
		
	}
	
	/**
	 * 判断一个数是否是素数
	 * @param num
	 * @return
	 */
	public static boolean isPrimeNumber(int num){
		if(num <= 1){
			return false;
		}
		if(num==2){
			return true;
		}
		for (int i = 2; i <= Math.sqrt(num); i++) {
			if(num%i == 0){
				return false;
			}
		}
		return true;
	}
	
	public static boolean isPrimeNumber(int target , int primeNumber){
		return isPrimeNumber(target - primeNumber);
	}
	
	public static List<Integer> getPrimesBlewValue(int value){
		
		int index=listCache.indexOf(value);
		
		return listCache.subList(0, index+1);
	}
	
	public static boolean isSumOfConsecutivePrimes(int sum){
		List<Integer> list = getPrimesBlewValue(sum);
		int temp=0;
		int j=0;
		for (int i = 0; i < list.size(); i++) {
			temp+=list.get(i);
			if(temp==sum){
				//System.out.println(Arrays.toString(list.subList(j, i+1).toArray()));
				if(i-j+1>length){
					length=i-j+1;
					result=sum;
					conStr=Arrays.toString(list.subList(j, i+1).toArray());
				}
				return true;
			}
			if(temp>sum){
				j++;
				temp=0;
				i=j-1;
			}
		}
		return false;
	}
}
