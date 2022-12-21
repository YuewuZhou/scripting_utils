package java_script;


import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import javax.print.PrintService;
import javax.print.attribute.HashAttributeSet;


public class Test{
    /**
     * @param args
     */

    public static void print(String s){
        System.out.println(s);
    }

    public static boolean isPrime(long n) {  

        // HashSet<Long> checked= new HashSet<>();
        for (int i = 2; i < Math.sqrt(n); i++) { 
            // print("checking: "+i);

            if (n % i == 0 ) {  
                return false;  
            } 
   
        }  
        return true;  
    }  

    static int smallestMultiple(){

        int index=1;
        while(true){
            boolean isMultiple=true;
            for(int i=1;i<=20;i++){
                if(index%i!=0){
                    isMultiple=false;
                    break;
                }
            }
            if(isMultiple)return index;

            index++;
        }
    }

    static int sumSquareDifference(){
        int sum=0;
        int sqrsum=0;
        for(int i=1;i<=100;i++){
            sum+=i;
            sqrsum+=i*i;
        }
        sum=sum*sum;
        return sum-sqrsum;
    }

    static boolean isPythagoreanTriplet(int a, int b, int c){
        if(a*a+b*b==c*c)return true;
        return false;
    }

    static ArrayList<ArrayList<Integer>> listOfTriplets (){
        ArrayList<ArrayList<Integer>> triplets=new ArrayList<>();

        int max=500;
        for(int i=1;i<=max;i++){
            for(int j=1;j<=max;j++){
                for(int k=1;k<=max;k++){
                    if(isPythagoreanTriplet(i, j, k)){
                        ArrayList<Integer> triplet=new ArrayList<>();
                        triplet.add(i);
                        triplet.add(j);
                        triplet.add(k);
                        triplets.add(triplet);
                    }
                }
            }
        }
        return triplets;
    }


    static void printTriplets(){
        for(ArrayList<Integer> triplet:listOfTriplets()){
            // print(triplet.toString());
            if(triplet.get(0)+triplet.get(1)+triplet.get(2)==1000){
                print(triplet.toString());
                print(triplet.get(0)*triplet.get(1)*triplet.get(2)+"");
            }
        }
    }

    static ArrayList<Long> findPrimes(long num){

        ArrayList<Long> shortenedList = new ArrayList<>();
        
        for(long i=4;i<num;i++){
            // if(i%100000==0)print(""+i);
            if(i%2==0||i%3==0||i%5==0){
                
            }else{
                shortenedList.add(i);
            }
        }

        // print(shortenedList.toString());

        ArrayList<Long> primes=new ArrayList<>();
        primes.add(2L);
        primes.add(3L);
        primes.add(5L);

        for(Long possPrime:shortenedList){
            if(isPrime(possPrime)){
                primes.add(possPrime);
                print(""+possPrime);
            }
        }
        return primes;
    }

    static ArrayList<Integer> efficientPrimes(int num){
        try{

            int[] nums = new int[num-1];
            ArrayList<Integer> primes=new ArrayList<>();
            for(int i=2;i<num;i++){
                nums[i-2]=i;
            }
    
            for(int i=0;i<nums.length;i++){
                if(nums[i]!=0){
                    if(isPrime(nums[i])){
                        if(i<nums.length){
                            for(int j=i+nums[i];j<nums.length;j+=nums[i]){
                                nums[j]=0;
                            }
                        }
                    }
                }
            }
            print("breakpoint 2");
            for (int i=0;i<nums.length;i++){
                if(nums[i]!=0){
                    primes.add(nums[i]);
                    print("adding prime: "+i);
                }
            }
            // print(primes.toString());
            return primes;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    static void recursivePrime(ArrayList<Long> nums,ArrayList<Long> primes){

        if(nums.size()==0){
            return;
        } else{

            long num=nums.get(0);
            print(""+num);

            if(isPrime(num)){
                primes.add(num);
            }
            ArrayList<Integer> remove= new ArrayList<>();
            for(int j=0;j<nums.size();j++){
                if(nums.get(j)%num==0)remove.add(j);
            }
            for(int j:remove){
                print("removing :" + j);
                nums.remove(j);
            }

            recursivePrime(nums, primes);
        }
    }

    static void sumPrimes(){
        
        ArrayList<Long> primes = findPrimes(2000000);
        long sum=0;
        for(long prime:primes){
            sum+=prime;
        }
        print("sum of primes below 2 mil is: "+sum);
        print("number of primes below 2 mil "+primes.size());
        print(142913828922L - 143042032078L + "");

    }
    public static void main(String[] args) {

        // print("smallest multiple is: " + smallestMultiple());
        // print("sum square diff is: "+sumSquareDifference());
        // print("triplet product is: " + printTriplets());
        
        // sumPrimes();
        // print(efficientPrimes(2000000).toString());
        print("" + "moon".compareTo("sun"));

        List<String> list=new ArrayList<>();

        list.add("d");
        list.add("c");
        list.add("a");
        list.add("b");
        Arrays.sort(a, c);
        print(list.toString());
        
    }   
}


        // HashSet<Integer> set = new HashSet<>();

        // for (int i = 0; i<1000;i++){
        //     if(i%3 == 0 || i%5 == 0){
        //         set.add(i);
        //     }
        // }

        // System.out.print("There are "+set.size()+" number of multiples of 3 or 5 below 1000");

        // int sum = 0;
        // for(Integer number:set){
        //     sum += number;
        // }
        // System.out.print("There sum of the multiples of 3 or 5 below 1000 is " + sum);
        

                // ArrayList<Integer> list = new ArrayList<>();

        // list.add(1);
        // list.add(2);

        // int sum;
        // while(true){
        //     sum = list.get(list.size()-1) + list.get(list.size()-2);
        //     if(sum<4000000){
        //         list.add(sum);
        //     }else{
        //         break;
        //     }
        // }

        // print(list.toString());

        // sum = 0;
        // for(Integer i:list){
        //     if(i%2==0) sum+=i;
        // }
        // print("sum: "+sum);


        // ArrayList<Long> primes = new ArrayList<>();
        // primes.add(2L);
        // primes.add(3L);
        // long num = 600851475143L;

        // for(long i=4;i<=num;i++){
        //     if(i%1000==0)print(""+i);
        //     if(isPrime(i)) primes.add(i);
        // }
        // print(primes.toString());
        // print("number of primes: "+primes.size());



    //     long onum = 600851475143L;

    //     long sqrt = (long )Math.sqrt(onum);
    //     long num = sqrt;

    //     ArrayList<Long> shortenedList = new ArrayList<>();
    //     for(long i=4;i<num;i++){
    //         if(i%100000==0)print(""+i);
    //         if(i%2==0||i%3==0){

    //         }else{
    //             shortenedList.add(i);
    //         }
    //     }

    //     print(shortenedList.toString());

    //     ArrayList<Long> primes=new ArrayList<>();
    //     ArrayList<Long> primeFactors=new ArrayList<>();

    //     for(Long possPrime:shortenedList){
    //         if(isPrime(possPrime)){
    //             primes.add(possPrime);
    //         }
    //     }
    //     for(Long prime:primes){
    //         if(onum%prime==0)primeFactors.add(prime);
    //     }

    //     print(primeFactors.toString());

            // ArrayList<String> sums = new ArrayList<>();
        // for(int i = 100;i<1000;i++){
        //     for(int j = 100;j<1000;j++){
        //         sums.add("" + i*j);
        //     }
        // }

        // ArrayList<String> palindromes=new ArrayList<>();
        // for(String sum:sums){
        //     int i=0;
        //     int j=sum.length()-1;
        //     boolean isPalindrome=true;
        //     while(i<j){
        //         if(sum.charAt(i)==sum.charAt(j)){
        //             i++;
        //             j--;
        //         }else{
        //             isPalindrome=false;
        //             break;
        //         }
        //     }
        //     if(isPalindrome)palindromes.add(sum);
        // }

        // print(palindromes.toString());

        // int max = 0;
        // for(String palindrome:palindromes){
        //     if(Integer.parseInt(palindrome)>max)max=Integer.parseInt(palindrome);
        // }
        // print(""+max);