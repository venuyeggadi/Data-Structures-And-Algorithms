import java.util.Scanner;
import java.util.Arrays;


//O(n*log(log n)), O(n)
class SieveOfEratosthenes {
	public static void main(String[] args) {
		System.out.print("Enter a number: ");
		int n = new Scanner(System.in).nextInt();
		boolean[] isPrime = getPrimes(n);
		for(int i = 0; i <= n; i++)
			if(isPrime[i])
				System.out.println(i);
	}

	static boolean[] getPrimes(int n) {
		boolean[] isPrime = new boolean[n + 1];
		Arrays.fill(isPrime, true);
		isPrime[0] = false;
		isPrime[1] = false;

		for(int i = 2; i * i <= n; i++) {
			if(!isPrime[i])
				continue;
			for(int j = i * i; j <= n; j = j + i)
				isPrime[j] = false;
		}

		return isPrime;
	}
}

/*
We start off with a table of n numbers. Let's look at the first number, 2.
We know all multiples of 2 must not be primes, so we mark them off as non-primes.
Then we look at the next number, 3. Similarly, all multiples of 3 such as
3 × 2 = 6, 3 × 3 = 9, ... must not be primes, so we mark them off as well.
Now we look at the next number, 4, which was already marked off. What does
this tell you? Should you mark off all multiples of 4 as well?

4 is not a prime because it is divisible by 2, which means all multiples of 4
must also be divisible by 2 and were already marked off. So we can skip 4
immediately and go to the next number, 5. Now, all multiples of 5 such as
5 × 2 = 10, 5 × 3 = 15, 5 × 4 = 20, 5 × 5 = 25, ... can be marked off. There
is a slight optimization here, we do not need to start from 5 × 2 = 10. Where
should we start marking off?

In fact, we can mark off multiples of 5 starting at 5 × 5 = 25, because
5 × 2 = 10 was already marked off by multiple of 2, similarly 5 × 3 = 15 was
already marked off by multiple of 3. Therefore, if the current number is i,
we can always mark off multiples of i starting at i*i, then in increments of
i: i*i + i, i*i + 2i, ... Now what should be the terminating loop condition?

The terminating loop condition can be i <= √n, as all non-primes > √n must have
already been marked off. When the loop terminates, all the numbers in the table
that are non-marked are prime.

The Sieve of Eratosthenes uses an extra O(n) memory and its runtime complexity
is O(n log log n). For the more mathematically inclined readers, you can read more
about its algorithm complexity on Wikipedia.
*/


/* Why only util i <= sqrt(n)
Let's write down all of 12's factors:

2 × 6 = 12
3 × 4 = 12
4 × 3 = 12
6 × 2 = 12
As you can see, calculations of 4 × 3 and 6 × 2 are not necessary. Therefore,
we only need to consider factors up to √n because, if n is divisible by some
number p, then n = p × q and since p <= q, we could derive that p <= √n.
*/