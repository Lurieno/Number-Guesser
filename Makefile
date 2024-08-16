run: 
	javac -d target/Guesser src/org/lurien/Guesser.java;
	java -cp target/Guesser Guesser;

clean:
	rm -rf target/Guesser

rm_stats:
	rm target/stat.csv