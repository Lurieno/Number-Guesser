cli_game: 
	javac -d target src/guesser/GuesserCLI.java;
	java -cp target guesser.GuesserCLI;

gui_game:
	javac -d target -sourcepath src src/guesser/Launcher.java;
	java -cp target guesser.Launcher;

server:
	javac -d target -sourcepath src src/guesser/utils/multiplayer/Client.java src/guesser/utils/multiplayer/Server.java;

clean:
	rm -rf target/guesser

rm_stats:
	rm target/stat.csv