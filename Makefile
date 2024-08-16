run: 
	javac -d Guesser Guesser.java;
	java -cp Guesser Guesser;

clean:
	rm -rf Guesser

rm_stats:
	rm stat.csv